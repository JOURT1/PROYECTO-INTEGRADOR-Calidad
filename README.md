# Sistema de Registro de Estudiantes

Proyecto Java creado para el trabajo practico de **SWZ3208 - Calidad de Software**.
El objetivo es demostrar mejoras de calidad sobre un sistema simple de registro y listado de estudiantes.

## Problemas identificados en el codigo inicial

- Uso de listas sin genericos, lo que reducia la seguridad de tipos.
- Nombres poco descriptivos como `s`, `g` y `sm`.
- Baja cohesion: la clase inicial mezclaba registro, almacenamiento y salida por consola.
- Falta de validaciones para nombres vacios y calificaciones fuera de rango.
- Ausencia de pruebas unitarias y metricas automatizadas.
- Ausencia de analisis estatico y pipeline CI/CD.

## Mejoras implementadas

- Separacion de responsabilidades:
  - `Student`: modelo inmutable.
  - `StudentValidator`: reglas de validacion.
  - `StudentRegistry`: registro y listado de estudiantes.
  - `StudentFormatter`: formato de salida.
  - `StudentApplication`: punto de entrada de consola.
- Validaciones para nombres no vacios y notas entre `0.0` y `100.0`.
- Pruebas unitarias con JUnit 5.
- Cobertura con JaCoCo, con umbral minimo del 80%.
- Analisis de estilo con Checkstyle.
- Analisis de defectos y mantenibilidad con PMD.
- Analisis adicional de bugs con SpotBugs.
- Pipeline CI/CD con GitHub Actions.

## Requisitos

- Java 17.
- Maven 3.9 o superior.

## Comandos principales

Ejecutar pruebas:

```bash
mvn test
```

Ejecutar compilacion, pruebas, cobertura y analisis estatico:

```bash
mvn clean verify
```

Ejecutar herramientas por separado:

```bash
mvn checkstyle:check
mvn pmd:check
mvn spotbugs:check
mvn jacoco:report
```

Ejecutar la aplicacion:

```bash
mvn -q exec:java -Dexec.mainClass=ec.edu.udla.calidad.estudiantes.StudentApplication
```

## Reportes generados

Despues de ejecutar `mvn clean verify`, Maven genera reportes en:

- `target/site/jacoco/index.html`
- `target/checkstyle-result.xml`
- `target/pmd.xml`
- `target/spotbugsXml.xml`
- `target/surefire-reports/`

Estos reportes tambien se publican como artifacts en GitHub Actions.
