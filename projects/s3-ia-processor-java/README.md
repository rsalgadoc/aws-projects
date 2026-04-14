# **S3 Image & Document Processor - Java**

Procesador de imágenes y documentos con **IA nativa** usando tecnología **Java 17** y arquitectura serverless.

**Características:**
- 🖼️ Análisis de imágenes con Amazon Rekognition
- 📄 Extracción de texto con AWS Textract
- 📦 Paquete optimizado para Lambda

**Stack:**
- **Compute:** AWS Lambda (Java 17)
- **Storage:** Amazon S3
- **AI Services:** Amazon Rekognition, AWS Textract
- **Infrastructure:** AWS CloudFormation
- **Build:** Maven

**Requisitos:**
- Java 17+
- Maven 3.8+

---

## Cómo compilar el JAR:

Desde la línea de comandos, clone y compile el proyecto:

```bash
# Clone this repository
git clone https://github.com/rsalgadoc/aws-projects.git

# Go into the repository
cd projects\s3-ia-processor-java


# Cleans the build directory and packages the compiled code into a distributable format
mvn clean package
```

El archivo generado estará en:
target/s3-ia-processor-1.0.0-aws-lambda.jar

## Cómo desplegar

1. Crear un bucket llamado: **s3-ia-processor-java-artifacts**
2. Sube el JAR(s3-ia-processor-1.0.1-aws-lambda.jar) a el bucket S3 recien creado.
3. Despliega la plantilla [template.yaml](template.yaml) CloudFormation por por Consola, en la opcion: **CloudFormation > Stacks > Create stack**
4. **Choose an existing template > Upload a template file > Choose file**
5. En la seccion Specify stack details, asegurate de que el nombre del parametro LambdaCodeBucket corresponda al nombre del bucket donde subiste el jar.
6. Una vez que el estado del stack este en CREATE_COMPLETE, revisa la seccion Resources y asegurate que este creado 4 recursos: 
    - InputBucket
    - LambdaExecutionRole
    - OutputBucket
    - ProcesadorIAFunction
7. Ahora ir a:  **Amazon S3 > Buckets > s3-ia-processor-java-input** 
8. En la pestaña de Properties ir a la seccion : **Event notifications > Create event notification**, con el nombre de s3-ia-processor-java-event
9. Selecciona All object create events, y en Lambda function selcciona la funcion Lambda recien creada, s3-ia-processor-java, y hacer click en **Save changes**

## Cómo probar

Al subir un archivo a un bucket de S3 (`input`), se activa automáticamente una función Lambda que:
- Si es una **imagen** (.jpg, .jpeg, .png, etc.) → usa **Amazon Rekognition** para detectar etiquetas.
- Si es un **documento** (.pdf, .png, .jpg, .jpeg, .tiff) → usa **Amazon Textract** para extraer texto, tablas y formularios.
- Guarda el resultado del análisis en formato JSON en el bucket de salida (`output`).

Ejemplo de resultado : [m_26JM3_8628.jpg.txt](examples/resultados/m_26JM3_8628.jpg.txt)
