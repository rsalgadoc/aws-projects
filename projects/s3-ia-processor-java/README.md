# s3-ia-processor-java

Procesador automático de imágenes y documentos con IA usando Java 21.

Al subir un archivo a un bucket de S3 (input), se activa una Lambda que:
- Usa **Rekognition** si es imagen
- Usa **Textract** si es documento (PDF, PNG, JPG, TIFF)
- Guarda el resultado en JSON en el bucket de output

## Tecnologías
- Java 21
- AWS SDK for Java 2.x
- Maven + Shade Plugin
- CloudFormation
- Amazon S3, Lambda, Rekognition, Textract

## Cómo compilar el JAR

```bash
mvn clean package
```

El archivo generado estará en:
target/s3-ia-processor-1.0.0-aws-lambda.jar

## Cómo desplegar

1. Compila el proyecto (mvn clean package)
2. Sube el JAR a un bucket S3 o úsalo localmente
3. Despliega la plantilla CloudFormation:

    ```bash
    aws cloudformation create-stack --stack-name s3-ia-processor-java \
    --template-body file://template.yaml \
    --capabilities CAPABILITY_IAM
    ```
## Estructura del proyecto

- pom.xml
- template.yaml
- src/main/java/io/github/rsalgadoc/lambda/S3EventProcessor.java