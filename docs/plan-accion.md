# Plan de Accion - Sistema de Registro de Estudiantes

## 1. Roles y responsabilidades

| Rol | Responsable | Responsabilidad principal |
| --- | --- | --- |
| Lider del equipo | Integrante 1 | Coordinar tareas, revisar integracion final y validar entregables. |
| Responsable de analisis de metricas | Integrante 2 | Definir metricas, revisar cobertura JaCoCo y resultados del pipeline. |
| Responsable de revision manual | Integrante 3 | Aplicar Clean Code, revisar nombres, cohesion y responsabilidades. |
| Responsable de analisis estatico | Integrante 4 | Configurar Checkstyle, PMD, SpotBugs y GitHub Actions. |
| Responsable de documentacion | Integrante 5 | Consolidar evidencias, comparativa antes/despues y reflexiones. |

> Nota: reemplazar "Integrante 1-5" por los nombres reales del grupo antes de generar el PDF final.

## 2. Problemas de calidad identificados

El codigo base se encuentra en `docs/proyecto-base/StudentManager.java`. Durante la revision inicial se detectaron:

- Nombres poco descriptivos: variables como `s`, `g` y `sm` no comunican su intencion.
- Uso de listas sin genericos: `List students` y `List grades` reducen seguridad de tipos.
- Baja cohesion: una sola clase registra estudiantes, guarda datos, imprime mensajes y contiene `main`.
- Mezcla de entrada/salida con logica de negocio: `addStudent` imprime en consola y modifica datos.
- Falta de validaciones: se aceptan nombres nulos, vacios y calificaciones fuera de rango.
- Riesgo de inconsistencia: nombres y notas viven en listas separadas.
- Cobertura insuficiente: el codigo inicial no contiene pruebas unitarias.
- Sin analisis automatizado: no existian Checkstyle, PMD, JaCoCo ni CI/CD.

## 3. Estrategias propuestas

- Aplicar Clean Code usando nombres claros y clases con una sola responsabilidad.
- Aplicar principios SOLID, principalmente responsabilidad unica y separacion entre dominio, validacion y presentacion.
- Reemplazar listas paralelas por una entidad `Student` inmutable.
- Centralizar validaciones en `StudentValidator`.
- Separar registro de estudiantes en `StudentRegistry`.
- Separar formato de salida en `StudentFormatter`.
- Mantener `StudentApplication` como punto de entrada minimo.
- Automatizar validacion con Maven y GitHub Actions.

## 4. Metricas y herramientas

| Herramienta | Objetivo | Criterio usado |
| --- | --- | --- |
| JUnit 5 | Pruebas unitarias | Validar registro, listado, formato y errores. |
| JaCoCo | Cobertura | Minimo 80% de instrucciones cubiertas. |
| Checkstyle | Estilo | 0 violaciones de estilo configuradas. |
| PMD | Defectos y mantenibilidad | 0 violaciones bloqueantes. |
| SpotBugs | Bugs potenciales | 0 errores o advertencias. |
| GitHub Actions | CI/CD | Ejecutar `mvn clean verify` en cada push o pull request. |

## 5. Objetivo de cumplimiento

El producto final debe compilar, ejecutar pruebas, generar reportes y pasar el pipeline CI/CD. La evidencia tecnica se entrega mediante el repositorio GitHub, el historial de commits, el workflow ejecutado y los artifacts de reportes.
