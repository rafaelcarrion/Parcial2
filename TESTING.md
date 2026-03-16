# TESTING — Análisis de caja negra para Empleado

Resumen: Validar las restricciones sobre los atributos de la clase Empleado:
- nombre: no puede estar vacío ni sólo espacios; admite varias palabras.
- cargo: debe pertenecer a la lista definida en Cargos.lista.
- salario: no vacío (valor numérico obligatorio), no negativo, no cero y no por debajo del convenio salarial (valor de referencia: CONVENIO = 1200.0 EUR). Ajustar CONVENIO según la constante del proyecto si existe.

---

## 1) Análisis de parámetros

| Parámetro | Tipo | Dominio válido | Restricciones / Regla | Fuente |
|---|---:|---|---|---|
| nombre | String | Cadena no nula, longitud >=1, puede contener espacios y letras acentuadas | No vacío, no sólo espacios | Requisito funcional |
| cargo | String | Uno de los valores en Cargos.lista (p.ej. "Directora", "Programador", ...) | Debe existir en Cargos.lista (comparación case-insensitive) | Requisito funcional / Cargos.java |
| salario | double | Número real positivo | Debe ser >= CONVENIO (1200.0), > 0; no negativo ni 0 | Requisito funcional / convenio salarial |

---

## 2) Casos válidos (deben ser aceptados / creación correcta)

| ID | nombre | cargo | salario | Resultado esperado | Observaciones |
|---:|---|---|---:|---|---|
| V1 | "Ana" | "Directora" | 3000.0 | OK: Empleado creado | Caso básico |
| V2 | "Luis Fernández" | "Programador" | 2000.0 | OK: Empleado creado | Nombre con espacio y acento |
| V3 | "María" | "Analista" | 2500.0 | OK: Empleado creado | Cargo existe en Cargos.lista |
| V4 | "Juan" | "Soporte" | 1200.0 | OK: Empleado creado | Salario en el límite del convenio (>= CONVENIO) |
| V5 | "Óscar López" | "CONTADOR" (si Cargos tiene "Contable", usar equivalente) | 1500.5 | OK: Empleado creado si existe cargo (comparación case-insensitive) | Prueba de mayúsculas/minúsculas |

---

## 3) Casos no válidos (deben ser rechazados / producir error de validación)

| ID | nombre | cargo | salario | Resultado esperado | Motivo de fallo |
|---:|---|---|---:|---|---|
| N1 | "" (cadena vacía) | "Programador" | 2000.0 | Rechazado | Nombre vacío |
| N2 | "   " (sólo espacios) | "Analista" | 2200.0 | Rechazado | Nombre sólo espacios |
| N3 | "Ana" | "GerenteX" | 3000.0 | Rechazado | Cargo no está en Cargos.lista |
| N4 | "Luis" | null | 2000.0 | Rechazado | Cargo nulo (no válido) |
| N5 | "María" | "Analista" | -100.0 | Rechazado | Salario negativo |
| N6 | "Pedro" | "Soporte" | 0.0 | Rechazado | Salario igual a 0 (no permitido) |
| N7 | "Lucía" | "Contable" | 800.0 | Rechazado | Salario por debajo del convenio (800 < 1200) |
| N8 | null | "Programador" | 2000.0 | Rechazado | Nombre nulo |

---

## Notas de ejecución y verificación
- Implementar una rutina de validación (por ejemplo en Empleados.altaEmpleado o en un validador separado) que revise cada regla y devuelva/registre mensajes claros:
  - "Nombre vacío"
  - "Nombre inválido"
  - "Cargo no válido"
  - "Salario negativo/0"
  - "Salario por debajo del convenio"
- CONVENIO: usar la constante del proyecto si existe (p.ej. Constantes.CONVENIO_SALARIAL). En este documento se asume CONVENIO = 1200.0 EUR para las pruebas; adaptar según el valor real.
- Para pruebas automatizadas unitarias:
  - Verificar que altaEmpleado lanza excepción o devuelve false / error si falla la validación.
  - Comprobar mensajes de error esperados.
- Pruebas adicionales recomendadas:
  - Valores límite cercanos al convenio (ej. CONVENIO - 0.01, CONVENIO + 0.01).
  - Nombres con caracteres especiales y longitud extrema.
  - Cargo con distinto casing