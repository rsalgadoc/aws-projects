# AWS Serverless Projects

[![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk)](https://openjdk.java.net/)
[![Python](https://img.shields.io/badge/Python-3.12+-green?logo=python)](https://python.org)
[![AWS](https://img.shields.io/badge/AWS-Lambda-FF9900?logo=amazon-aws)](https://aws.amazon.com/lambda/)
[![AWS S3](https://img.shields.io/badge/AWS-S3-569A31?logo=amazon-s3)](https://aws.amazon.com/s3/)
[![AWS Rekognition](https://img.shields.io/badge/AI-Rekognition-FF9900?logo=amazon-aws)](https://aws.amazon.com/rekognition/)
[![AWS Textract](https://img.shields.io/badge/AI-Textract-FF9900?logo=amazon-aws)](https://aws.amazon.com/textract/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

<br />

> 🚀 Monorepo con proyectos de **AWS Serverless** e **Inteligencia Artificial** para procesamiento de imágenes y documentos con **Amazon Rekognition** y **AWS Textract**.

---

## 📋 Tabla de Contenidos

- [Descripción General](#-descripción-general)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Proyectos](#-proyectos)
- [Stack Tecnológico](#-stack-tecnológico)
- [Contribución](#-contribución)
- [Licencia](#-licencia)

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

Cada proyecto contiene su propio README con detalles específicos:

- [S3 IA Processor - FE - Next.js](projects/s3-ia-processor-fe-nextjs/README.md)
- [S3 IA Processor - Java](projects/s3-ia-processor-java/README.md)
- [S3 IA Processor - Python](projects/s3-ia-processor-python/README.md)

---

## 🏗 Stack Tecnológico

| Servicio | Propósito | Estado |
|----------|-----------|--------|
| **AWS Lambda** | Compute serverless | ✅ Activo |
| **Amazon S3** | Almacenamiento de objetos | ✅ Activo |
| **Amazon Rekognition** | Análisis visual / IA | ✅ Activo |
| **AWS Textract** | Extracción de texto OCR | ✅ Activo |
| **CloudFormation** | Infrastructure as Code | ✅ Activo |
| **CloudWatch** | Monitoreo y logs | ✅ Activo |

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
**LinkedIn:** [rodrigo-salgado-cordova](https://www.linkedin.com/in/rodrigo-salgado-cordova)  
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
