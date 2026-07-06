# Evidencia de Entrega Tecnica

## Repositorio GitHub

- URL del repositorio: https://github.com/JOURT1/PROYECTO-INTEGRADOR-Calidad
- Rama principal: `main`
- Proyecto: Sistema de Registro de Estudiantes
- Tecnologia: Java 17 + Maven

## Historial de commits

El repositorio contiene cambios separados para evidenciar el proceso de trabajo:

- `Implement quality student registry project`: implementacion inicial del proyecto Java, pruebas, herramientas de calidad y CI/CD.
- `Add quality analysis documentation`: evidencia de analisis inicial, plan de accion e informe final base.
- `Add delivery evidence summary`: evidencia de repositorio, pipeline, comandos y reportes.

## Pipeline CI/CD

- Workflow: `Quality Pipeline`
- Archivo: `.github/workflows/quality.yml`
- Evento configurado: `push` y `pull_request` hacia `main`
- Comando principal ejecutado: `mvn clean verify`
- URL de ejecucion verificada: https://github.com/JOURT1/PROYECTO-INTEGRADOR-Calidad/actions/runs/28759543099
- Estado observado: `Success`
- Artifact generado: `quality-reports`

## Comandos de verificacion local

Se ejecutaron los siguientes comandos:

```bash
mvn test
mvn clean verify
mvn checkstyle:check
mvn pmd:check
mvn spotbugs:check
mvn jacoco:report
```

Resultados observados:

- Pruebas: 16 ejecutadas, 0 fallos, 0 errores.
- Checkstyle: 0 violaciones.
- PMD: ejecucion exitosa sin violaciones bloqueantes.
- SpotBugs: 0 bugs, 0 errores.
- JaCoCo: cobertura validada con umbral minimo del 80%.

## Reportes generados

Los reportes locales se generan en:

- `target/site/jacoco/index.html`
- `target/checkstyle-result.xml`
- `target/pmd.xml`
- `target/spotbugsXml.xml`
- `target/surefire-reports/`

En GitHub Actions, estos reportes se publican como artifact `quality-reports`.

## Checklist contra instrucciones

| Requisito | Estado |
| --- | --- |
| Proyecto Java base seleccionado | Cumplido con Proyecto 2: Sistema de Registro de Estudiantes. |
| Analisis inicial de problemas | Cumplido en `docs/plan-accion.md`. |
| Clean Code y SOLID | Cumplido mediante separacion de clases y responsabilidades. |
| Validaciones | Cumplido con `StudentValidator`. |
| Pruebas unitarias | Cumplido con JUnit 5. |
| JaCoCo | Cumplido y configurado con minimo 80%. |
| Checkstyle | Cumplido. |
| PMD | Cumplido. |
| SpotBugs | Cumplido como herramienta adicional de reporte. |
| GitHub Actions CI/CD | Cumplido. |
| Reportes generados | Cumplido localmente y como artifact de CI. |
| Plan de accion | Fuente editable incluida en `docs/plan-accion.md`. |
| Informe final | Fuente editable incluida en `docs/informe-final.md`. |
| PDF y PPT | Pendiente de convertir/preparar por el grupo segun indicacion del estudiante. |
| Nombres reales y evidencias de reuniones | Pendiente de completar por el grupo con informacion real. |
