# **S3 Image & Document Processor - Python**

Procesador automático de imágenes y documentos con Inteligencia Artificial usando **AWS Lambda + Python**.

Al subir un archivo a un bucket de S3 (`input`), se activa automáticamente una función Lambda que:
- Si es una **imagen** (.jpg, .jpeg, .png, etc.) → usa **Amazon Rekognition** para detectar etiquetas.
- Si es un **documento** (.pdf, .png, .jpg, .jpeg, .tiff) → usa **Amazon Textract** para extraer texto, tablas y formularios.
- Guarda el resultado del análisis en formato JSON en el bucket de salida (`output`).

**Características:**
- 🐍 Implementación limpia en Python 3.12+
- 🖼️ Análisis visual con Rekognition
- 📄 OCR y extracción con Textract
- 🔄 Procesamiento asincrónico
- 📊 Logging y monitoreo

**Stack:**
- **Runtime:** Python 3.12+
- **Compute:** AWS Lambda
- **Storage:** Amazon S3
- **AI Services:** Amazon Rekognition, AWS Textract
- **Infrastructure:** AWS CloudFormation (SAM)
- **Build:** pip

**Requisitos:**
- AWS CLI v2
- AWS SAM CLI



