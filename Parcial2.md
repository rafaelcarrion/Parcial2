# Sistema de Gestión de Empleados

Descripción
- Proyecto sencillo para gestionar empleados: definición de empleados, lista de empleados, cargos, validaciones y pruebas unitarias.
- Objetivo: ejemplificar buenas prácticas (encapsulación, constantes, separación de responsabilidades y tests).

Autor y versión
- Autor: (actualizar con nombre del autor)
- Versión: 1.0.0
- Fecha: 2026-03-16

Estructura del repositorio
- Empleado.java — Clase modelo con atributos privados, getters/setters y toString.
- Empleados.java — Gestión de la colección de empleados (alta, listado, aumento de salarios).
- SistemaGestionEmpleados.java — Clase principal (main) que demuestra uso de Empleados.
- Cargos.java — Lista pública de cargos profesionales reutilizable.
- Constantes.java — Constantes globales (mensajes, etiquetas, convenio salarial, etc.).
- EmpleadoValidator.java — Validaciones de negocio para nombre, cargo y salario.
- src/test/java/EmpleadoValidatorTest.java — Pruebas JUnit 5 para validar casos válidos y no válidos.
- TESTING.md — Análisis de caja negra con tablas de parámetros y casos de prueba.
- README.md — Documentación del proyecto (este fichero).

Requisitos
- JDK 11+.
- Para ejecutar tests con Maven/Gradle: entorno con dependencias de JUnit 5 o usar el soporte de pruebas del IDE (VS Code, IntelliJ, Eclipse).

Compilar y ejecutar (Windows, desde PowerShell o CMD)
1. Abrir terminal en la carpeta del proyecto:
   cd d:\Examen2_Entornos
2. Compilar:
   javac -d out *.java
3. Ejecutar la aplicación:
   java -cp out SistemaGestionEmpleados

Ejecutar tests
- Desde el IDE: usar la vista de pruebas (VS Code/IntelliJ/Eclipse) y ejecutar la suite JUnit.
- Con Maven (si se incorpora pom.xml con JUnit 5):
  mvn test
- Si no usa un sistema de build, ejecutar tests con una distribución de JUnit Platform Console (configuración avanzada).

Explicación rápida del código
- Empleado: modelo con nombre, cargo y salario. toString usa Constantes para etiquetas.
- Empleados: mantiene el array público `lista` (Empleados.lista) y ofrece altaEmpleado, mostrarListado y aumentarSalarios.
- Cargos: lista centralizada de cargos profesionales y utilidades (existeCargo, obtener).
- Constantes: centraliza magic strings y números (mensajes, etiquetas, PORCENTAJE_AUMENTO_POR_DEFECTO, CONVENIO_SALARIAL, mensajes de error).
- EmpleadoValidator: valida reglas de negocio (nombre no vacío, cargo válido, salario >= convenio, no negativo ni cero). Lanza IllegalArgumentException con mensajes en Constantes.
- Tests: EmpleadoValidatorTest cubre casos válidos y no válidos definidos en TESTING.md.

Buenas prácticas y notas
- Actualizar campo Autor en este README.
- Si se desea integración continua, añadir pom.xml (Maven) o build.gradle (Gradle) con dependencia de JUnit 5.
- Para internacionalización futura, extraer cadenas a ficheros de recursos (ResourceBundle).

Referencias
- TESTING.md — análisis de caja negra y tabla de casos de prueba.
- src/test/java/EmpleadoValidatorTest.java — pruebas unitarias JUnit 5.

Contribuciones
- Abrir pull request con descripciones claras de cambios. Mantener estilo de código y JavaDoc ya presentes.

Licencia
- (Indicar licencia del proyecto, p.ej. MIT)