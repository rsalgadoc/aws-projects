# s3-ia-processor-python

Procesador automático de imágenes y documentos con Inteligencia Artificial usando **AWS Lambda + Python**.

Al subir un archivo a un bucket de S3 (`input`), se activa automáticamente una función Lambda que:
- Si es una **imagen** (.jpg, .jpeg, .png, etc.) → usa **Amazon Rekognition** para detectar etiquetas.
- Si es un **documento** (.pdf, .png, .jpg, .jpeg, .tiff) → usa **Amazon Textract** para extraer texto, tablas y formularios.
- Guarda el resultado del análisis en formato JSON en el bucket de salida (`output`).

## Arquitectura

- **S3 Bucket Input** → Trigger → **AWS Lambda (Python 3.12)**
- Servicios de IA: **Amazon Rekognition** + **Amazon Textract**
- **S3 Bucket Output** → Resultados en carpeta `resultados/`

## Tecnologías utilizadas

- Python 3.12
- Amazon S3
- Amazon Rekognition
- Amazon Textract
- boto3 (AWS SDK para Python)

