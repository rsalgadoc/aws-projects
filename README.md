# AWS Serverless Projects

[![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)](https://openjdk.java.net/)
[![Python](https://img.shields.io/badge/Python-3.7+-green?logo=python)](https://python.org)
[![AWS](https://img.shields.io/badge/AWS-Lambda-FF9900?logo=amazon-aws)](https://aws.amazon.com/lambda/)
[![AWS S3](https://img.shields.io/badge/AWS-S3-569A31?logo=amazon-s3)](https://aws.amazon.com/s3/)
[![AWS Rekognition](https://img.shields.io/badge/AI-Rekognition-FF9900?logo=amazon-aws)](https://aws.amazon.com/rekognition/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

<br />

> 🚀 Monorepo con proyectos de **AWS Serverless** e **Inteligencia Artificial** para procesamiento de imágenes y documentos con **Amazon Rekognition** y **AWS Textract**.

---

## 📋 Tabla de Contenidos

- [Descripción General](#descripción-general)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Proyectos](#proyectos)
- [Requisitos Previos](#requisitos-previos)
- [Stack Tecnológico](#stack-tecnológico)
- [Instalación y Configuración](#instalación-y-configuración)
- [Contribución](#contribución)
- [Licencia](#licencia)

---

## 🎯 Descripción General

Este monorepo contiene soluciones **serverless** en AWS para procesamiento inteligente de imágenes y documentos. Utilizamos servicios como **AWS Lambda**, **Amazon S3**, **Amazon Rekognition** y **AWS Textract** para crear pipelines de IA escalables y rentables.

**Objetivos:**
- ✅ Procesamiento de imágenes con IA usando Rekognition
- ✅ Extracción de texto de documentos con Textract
- ✅ Implementación serverless para máxima escalabilidad
- ✅ Ejemplos en múltiples lenguajes (Java, Python)

---

## 📁 Estructura del Proyecto

```
aws-projects/
├── projects/                          # Proyectos independientes
│   ├── s3-ia-processor-java/          # Procesador en Java 21
│   │   ├── src/
│   │   ├── pom.xml
│   │   ├── template.yaml              # SAM Template
│   │   └── README.md
│   │
│   └── s3-ia-processor-python/        # Procesador en Python 3.7+
│       ├── src/
│       ├── template.yaml              # SAM Template
│       └── README.md
│
├── shared/                            # Recursos compartidos (próximamente)
│   ├── layers/                        # Lambda Layers reutilizables
│   ├── templates/                     # CloudFormation templates comunes
│   └── utils/                         # Utilidades compartidas
│
├── infrastructure/                    # IaC y configuración
└── README.md
```

---

## 🛠 Proyectos

### 1. **S3 Image & Document Processor - Java**

Procesador de imágenes y documentos con **IA nativa** usando tecnología **Java 21** y arquitectura serverless.

**Características:**
- 🖼️ Análisis de imágenes con Amazon Rekognition
- 📄 Extracción de texto con AWS Textract
- 🚀 Deployment serverless con SAM
- 📦 Paquete optimizado para Lambda

**Stack:**
- **Compute:** AWS Lambda (Java 21)
- **Storage:** Amazon S3
- **AI Services:** Amazon Rekognition, AWS Textract
- **Infrastructure:** AWS CloudFormation (SAM)
- **Build:** Maven

**Requisitos:**
- Java 21+
- Maven 3.8+
- AWS CLI v2
- AWS SAM CLI

**Instalación:**
```bash
cd projects/s3-ia-processor-java

# Instalar dependencias
mvn clean install

# Deploy con SAM
sam deploy --guided
```

**Uso:**
```bash
# Procesar una imagen desde S3
aws lambda invoke \
  --function-name s3-ia-processor \
  --payload '{"bucket":"my-bucket","key":"image.jpg"}' \
  response.json
```

---

### 2. **S3 Image & Document Processor - Python**

Versión en **Python** del procesador con AWS Rekognition y Textract. Útil para comparación entre implementaciones y para usuarios que prefieren Python.

**Características:**
- 🐍 Implementación limpia en Python 3.7+
- 🖼️ Análisis visual con Rekognition
- 📄 OCR y extracción con Textract
- 🔄 Procesamiento asincrónico
- 📊 Logging y monitoreo

**Stack:**
- **Runtime:** Python 3.7+
- **Compute:** AWS Lambda
- **Storage:** Amazon S3
- **AI Services:** Amazon Rekognition, AWS Textract
- **Infrastructure:** AWS CloudFormation (SAM)
- **Build:** pip

**Requisitos:**
- Python 3.7+
- pip / virtualenv
- AWS CLI v2
- AWS SAM CLI

**Instalación:**
```bash
cd projects/s3-ia-processor-python

# Crear entorno virtual
python -m venv venv
source venv/bin/activate  # En Windows: venv\Scripts\activate

# Instalar dependencias
pip install -r requirements.txt

# Deploy con SAM
sam deploy --guided
```

---

## 📋 Requisitos Previos

Antes de comenzar, asegúrate de tener instalados:

### Global
- **AWS CLI v2** — [Descargar](https://aws.amazon.com/cli/)
- **AWS SAM CLI** — `pip install aws-sam-cli` o [Descargar](https://aws.amazon.com/serverless/sam/)
- **Git** — [Descargar](https://git-scm.com/)

### Para Java
- **Java 21+** — [Descargar](https://openjdk.java.net/)
- **Maven 3.8+** — [Descargar](https://maven.apache.org/)

### Para Python
- **Python 3.7+** — [Descargar](https://www.python.org/)
- **pip** / **virtualenv** — Incluidos con Python

### Credenciales AWS
```bash
aws configure
# Ingresa: Access Key ID, Secret Access Key, Region, Output Format
```

---

## 🏗 Stack Tecnológico

| Servicio | Propósito | Estado |
|----------|-----------|--------|
| **AWS Lambda** | Compute serverless | ✅ Activo |
| **Amazon S3** | Almacenamiento de objetos | ✅ Activo |
| **Amazon Rekognition** | Análisis visual / IA | ✅ Activo |
| **AWS Textract** | Extracción de texto OCR | ✅ Activo |
| **CloudFormation / SAM** | Infrastructure as Code | ✅ Activo |
| **CloudWatch** | Monitoreo y logs | ✅ Activo |

---

## 🚀 Instalación y Configuración

### 1. Clonar el Repositorio

```bash
git clone https://github.com/tu-usuario/aws-projects.git
cd aws-projects
```

### 2. Configurar AWS Credentials

```bash
aws configure
```

### 3. Seleccionar un Proyecto

**Para Java:**
```bash
cd projects/s3-ia-processor-java
mvn clean install
sam build
sam deploy --guided
```

**Para Python:**
```bash
cd projects/s3-ia-processor-python
python -m venv venv
source venv/bin/activate
pip install -r requirements.txt
sam build
sam deploy --guided
```

### 4. Verificar Deployment

```bash
aws lambda list-functions --region us-east-1

# Invocar función
aws lambda invoke \
  --function-name s3-ia-processor-{java|python} \
  --payload '{"test":true}' \
  response.json
```

---

## 📖 Documentación Adicional

Cada proyecto contiene su propio README con detalles específicos:

- [S3 IA Processor - Java](projects/s3-ia-processor-java/README.md)
- [S3 IA Processor - Python](projects/s3-ia-processor-python/README.md)

---

## 🤝 Contribución

¡Las contribuciones son bienvenidas! Para contribuir:

1. **Fork** el repositorio
2. **Crea una rama** para tu feature:
   ```bash
   git checkout -b feature/mi-mejora
   ```
3. **Commit** tus cambios:
   ```bash
   git commit -m "feat: agregar nueva funcionalidad"
   ```
4. **Push** a la rama:
   ```bash
   git push origin feature/mi-mejora
   ```
5. **Abre un Pull Request**

---

## 📝 Licencia

Este proyecto está bajo la licencia **MIT**. Ver [LICENSE](LICENSE) para más detalles.

---

## 📧 Contacto

**Autor:** rsalgadoc  
**Email:** rodrigo.salgado.cordova@gmail.com  
**LinkedIn:** [Tu Perfil](https://www.linkedin.com/in/rodrigo-salgado-cordova)  
**GitHub:** [rsalgadoc](https://github.com/rsalgadoc)

---

## 🔄 Últimas Actualizaciones

| Fecha | Cambio |
|-------|---------|
| **Abril 2026** | Versión inicial - Java y Python |
| **Próximamente** | Shared layers y templates comunes |

<div align="center">

**⭐ Si te resulta útil, ¡dale una estrella!**

</div>