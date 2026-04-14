package io.github.rsalgadoc.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;

import software.amazon.awssdk.services.s3.S3Client;

// Importaciones completas para Rekognition
import software.amazon.awssdk.services.rekognition.RekognitionClient;
import software.amazon.awssdk.services.rekognition.model.DetectLabelsRequest;
import software.amazon.awssdk.services.rekognition.model.DetectLabelsResponse;
import software.amazon.awssdk.services.rekognition.model.Image;
import software.amazon.awssdk.services.rekognition.model.Label;

// Importaciones completas para Textract
import software.amazon.awssdk.services.textract.TextractClient;
import software.amazon.awssdk.services.textract.model.AnalyzeDocumentRequest;
import software.amazon.awssdk.services.textract.model.AnalyzeDocumentResponse;
import software.amazon.awssdk.services.textract.model.Block;
import software.amazon.awssdk.services.textract.model.Document;
import software.amazon.awssdk.services.textract.model.FeatureType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S3EventProcessor implements RequestHandler<S3Event, String> {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final Region REGION = Region.US_EAST_1;   // Cambia a sa-east-1 si estás en Chile

    private final S3Client s3Client = S3Client.builder().region(REGION).build();
    private final RekognitionClient rekClient = RekognitionClient.builder().region(REGION).build();
    private final TextractClient textractClient = TextractClient.builder().region(REGION).build();

    @Override
    public String handleRequest(S3Event event, Context context) {
        S3EventNotification.S3EventNotificationRecord record = event.getRecords().get(0);
        String bucket = record.getS3().getBucket().getName();
        String key = record.getS3().getObject().getKey();

        context.getLogger().log("Procesando: s3://" + bucket + "/" + key);

        String extension = key.substring(key.lastIndexOf(".") + 1).toLowerCase();
        Map<String, Object> resultado = new HashMap<>();

        resultado.put("archivo", key);
        resultado.put("bucket", bucket);
        resultado.put("timestamp", record.getEventTime());

        try {
            if (extension.matches("jpg|jpeg|png")) {
                resultado.put("tipo", "imagen");
                resultado.put("analisis", detectLabels(bucket, key, context));
            } 
            else if (extension.matches("pdf|png|jpg|jpeg|tiff")) {
                resultado.put("tipo", "documento");
                resultado.put("analisis", analyzeDocument(bucket, key, context));
            } 
            else {
                resultado.put("tipo", "no_soportado");
                resultado.put("error", "Extensión ." + extension + " no soportada");
            }
        } catch (Exception e) {
            context.getLogger().log("ERROR: " + e.getMessage());
            resultado.put("error", e.getMessage());
        }

        // Guardar resultado
        String outputBucket = bucket.replace("-input-", "-output-");
        String outputKey = "resultados/" + key + ".json";

        String jsonResult = gson.toJson(resultado);

        s3Client.putObject(req -> req.bucket(outputBucket).key(outputKey),
                RequestBody.fromString(jsonResult));

        context.getLogger().log("Resultado guardado: s3://" + outputBucket + "/" + outputKey);
        return "Procesado correctamente";
    }

    private Map<String, Object> detectLabels(String bucket, String key, Context context) {
        DetectLabelsResponse response = rekClient.detectLabels(DetectLabelsRequest.builder()
                .image(Image.builder()
                        .s3Object(software.amazon.awssdk.services.rekognition.model.S3Object.builder()
                                .bucket(bucket)
                                .name(key)
                                .build())
                        .build())
                .maxLabels(20)
                .minConfidence(70f)
                .build());

        List<Map<String, Object>> labels = new ArrayList<>();
        for (Label label : response.labels()) {
            labels.add(Map.of(
                "nombre", label.name(),
                "confianza", Math.round(label.confidence() * 100.0) / 100.0
            ));
        }

        context.getLogger().log("Etiquetas detectadas: " + labels.size());
        return Map.of("etiquetas", labels);
    }

    private Map<String, Object> analyzeDocument(String bucket, String key, Context context) {
        AnalyzeDocumentResponse response = textractClient.analyzeDocument(AnalyzeDocumentRequest.builder()
                .document(Document.builder()
                        .s3Object(software.amazon.awssdk.services.textract.model.S3Object.builder()
                                .bucket(bucket)
                                .name(key)
                                .build())
                        .build())
                .featureTypes(FeatureType.TABLES, FeatureType.FORMS, FeatureType.LAYOUT)
                .build());

        List<String> lines = new ArrayList<>();
        long tableCount = 0;

        for (Block block : response.blocks()) {
            if ("LINE".equals(block.blockTypeAsString())) {
                lines.add(block.text());
            } else if ("TABLE".equals(block.blockTypeAsString())) {
                tableCount++;
            }
        }

        context.getLogger().log("Texto extraído: " + lines.size() + " líneas | Tablas: " + tableCount);

        return Map.of(
            "texto_extraido", String.join(" ", lines),
            "tablas_detectadas", tableCount
        );
    }
}