# Informe Final - Sistema de Registro de Estudiantes

## 1. Proceso de implementacion

El proyecto partio de una clase base llamada `StudentManager`, ubicada como referencia en `docs/proyecto-base/StudentManager.java`. Esa version inicial permitia registrar y listar estudiantes, pero mezclaba responsabilidades, usaba nombres ambiguos y no tenia validaciones ni pruebas.

La implementacion final se organizo como un proyecto Maven Java 17 con paquete `ec.edu.udla.calidad.estudiantes`. Se separaron responsabilidades en clases pequenas:

- `Student`: representa un estudiante con nombre y calificacion.
- `StudentValidator`: valida reglas de negocio.
- `StudentRegistry`: registra y lista estudiantes.
- `StudentFormatter`: convierte estudiantes a texto.
- `StudentApplication`: ejecuta un ejemplo minimo por consola.

Luego se agregaron pruebas unitarias con JUnit 5 y herramientas de calidad en Maven: JaCoCo, Checkstyle, PMD y SpotBugs. Finalmente, se configuro GitHub Actions para ejecutar automaticamente `mvn clean verify` y publicar reportes como artifacts.

## 2. Comparativa antes y despues

| Aspecto | Antes | Despues |
| --- | --- | --- |
| Estructura | Una sola clase con varias responsabilidades. | Varias clases con responsabilidades separadas. |
| Nombres | Variables `s`, `g`, `sm`. | Nombres como `studentName`, `grade`, `registry`. |
| Datos | Dos listas paralelas sin genericos. | Entidad `Student` inmutable y lista tipada. |
| Validaciones | No existian validaciones. | Nombre obligatorio y nota entre `0.0` y `100.0`. |
| Pruebas | Sin pruebas unitarias. | Pruebas para registro, validacion, listado y formato. |
| Cobertura | No medida. | Medida con JaCoCo y minimo 80%. |
| Estilo | No automatizado. | Checkstyle configurado. |
| Defectos | No automatizado. | PMD y SpotBugs configurados. |
| CI/CD | No existia pipeline. | GitHub Actions ejecuta calidad en cada push/PR. |

## 3. Resultados obtenidos

Validacion local ejecutada:

- `mvn test`: 16 pruebas ejecutadas, 0 fallos.
- `mvn clean verify`: compilacion, pruebas, cobertura y analisis estatico exitosos.
- `mvn checkstyle:check`: 0 violaciones.
- `mvn pmd:check`: exitoso.
- `mvn spotbugs:check`: 0 bugs.
- `mvn jacoco:report`: reporte generado.

Reportes generados:

- `target/site/jacoco/index.html`
- `target/checkstyle-result.xml`
- `target/pmd.xml`
- `target/spotbugsXml.xml`
- `target/surefire-reports/`

## 4. Reflexion individual

El trabajo permitio comprobar que la calidad de software no depende solo de que el programa funcione. Al separar responsabilidades, agregar validaciones y automatizar pruebas, el codigo se volvio mas facil de entender, mantener y verificar. El trabajo colaborativo tambien aporta valor porque obliga a discutir decisiones, revisar cambios y justificar metricas, reduciendo errores que pueden pasar desapercibidos cuando una sola persona trabaja sin revision.

## 5. Evidencia de cumplimiento

El repositorio contiene el codigo mejorado, configuracion Maven, workflow de GitHub Actions y documentacion tecnica. El pipeline ejecuta las herramientas requeridas y genera artifacts con los reportes.
