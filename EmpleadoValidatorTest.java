}// ...existing code...
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias JUnit 5 para {@link EmpleadoValidator}.
 *
 * <p>Incluye los casos válidos y no válidos definidos en el análisis de caja negra:
 * V1..V5 casos válidos; N1..N8 casos no válidos. Cada método de prueba documenta
 * el escenario verificado.</p>
 */
public class EmpleadoValidatorTest {

    // ----- Casos válidos -----

    /** V1: Empleado sencillo con nombre, cargo válido y salario superior al convenio. */
    @Test
    void V1_Ana_Directora_3000_ok() {
        Empleado e = new Empleado("Ana", "Directora", 3000.0);
        assertDoesNotThrow(() -> EmpleadoValidator.validarEmpleado(e));
    }

    /** V2: Nombre con espacio y acento; cargo válido; salario aceptable. */
    @Test
    void V2_LuisFernandez_Programador_2000_ok() {
        Empleado e = new Empleado("Luis Fernández", "Programador", 2000.0);
        assertDoesNotThrow(() -> EmpleadoValidator.validarEmpleado(e));
    }

    /** V3: Nombre con acento; cargo válido; salario aceptable. */
    @Test
    void V3_Maria_Analista_2500_ok() {
        Empleado e = new Empleado("María", "Analista", 2500.0);
        assertDoesNotThrow(() -> EmpleadoValidator.validarEmpleado(e));
    }

    /** V4: Salario exactamente en el límite del convenio debe ser aceptado. */
    @Test
    void V4_Juan_Soporte_1200_limite_convenio_ok() {
        Empleado e = new Empleado("Juan", "Soporte", Constantes.CONVENIO_SALARIAL);
        assertDoesNotThrow(() -> EmpleadoValidator.validarEmpleado(e));
    }

    /** V5: Cargo en mayúsculas (case-insensitive) se admite si existe en Cargos.lista. */
    @Test
    void V5_Oscar_CONTABLE_caseInsensitive_ok() {
        Empleado e = new Empleado("Óscar López", "CONTABLE", 1500.5);
        assertDoesNotThrow(() -> EmpleadoValidator.validarEmpleado(e));
    }

    // ----- Casos no válidos -----

    /** N1: Nombre vacío debe producir error de validación. */
    @Test
    void N1_nombre_vacio_rechazado() {
        Empleado e = new Empleado("", "Programador", 2000.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> EmpleadoValidator.validarEmpleado(e));
        assertTrue(ex.getMessage().contains(Constantes.ERR_NOMBRE_VACIO));
    }

    /** N2: Nombre compuesto sólo por espacios debe producir error. */
    @Test
    void N2_nombre_solo_espacios_rechazado() {
        Empleado e = new Empleado("   ", "Analista", 2200.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> EmpleadoValidator.validarEmpleado(e));
        assertTrue(ex.getMessage().contains(Constantes.ERR_NOMBRE_VACIO));
    }

    /** N3: Cargo que no existe en la lista debe ser rechazado. */
    @Test
    void N3_cargo_no_existente_rechazado() {
        Empleado e = new Empleado("Ana", "GerenteX", 3000.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> EmpleadoValidator.validarEmpleado(e));
        assertTrue(ex.getMessage().contains(Constantes.ERR_CARGO_INVALIDO));
    }

    /** N4: Cargo nulo debe ser rechazado. */
    @Test
    void N4_cargo_nulo_rechazado() {
        Empleado e = new Empleado("Luis", null, 2000.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> EmpleadoValidator.validarEmpleado(e));
        assertTrue(ex.getMessage().contains(Constantes.ERR_CARGO_INVALIDO));
    }

    /** N5: Salario negativo debe ser rechazado. */
    @Test
    void N5_salario_negativo_rechazado() {
        Empleado e = new Empleado("María", "Analista", -100.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> EmpleadoValidator.validarEmpleado(e));
        assertTrue(ex.getMessage().contains(Constantes.ERR_SALARIO_NEGATIVO));
    }

    /** N6: Salario igual a 0 debe ser rechazado. */
    @Test
    void N6_salario_cero_rechazado() {
        Empleado e = new Empleado("Pedro", "Soporte", 0.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> EmpleadoValidator.validarEmpleado(e));
        assertTrue(ex.getMessage().contains(Constantes.ERR_SALARIO_CERO));
    }

    /** N7: Salario por debajo del convenio debe ser rechazado. */
    @Test
    void N7_salario_por_debajo_convenio_rechazado() {
        Empleado e = new Empleado("Lucía", "Contable", 800.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> EmpleadoValidator.validarEmpleado(e));
        assertTrue(ex.getMessage().contains(Constantes.ERR_SALARIO_DEBAJO_CONVENIO));
    }

    /** N8: Nombre nulo debe ser rechazado. */
    @Test
    void N8_nombre_nulo_rechazado() {
        Empleado e = new Empleado(null, "Programador", 2000.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> EmpleadoValidator.validarEmpleado(e));
        assertTrue(ex.getMessage().contains(Constantes.ERR_NOMBRE_VACIO));
    }
}
// ...existing