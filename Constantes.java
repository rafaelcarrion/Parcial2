// ...existing code...
/**
 * Clase de constantes utilizadas en la aplicación.
 *
 * <p>Contiene mensajes de interfaz, etiquetas para toString, valores numéricos
 * por defecto (por ejemplo convenio salarial y porcentaje de aumento) y mensajes
 * de validación. Diseñada como una clase utilitaria no instanciable.</p>
 */
public final class Constantes {
    private Constantes() {}

    /** Mensaje para encabezado del listado de empleados. */
    public static final String LISTADO_EMPLEADOS = "Listado de empleados:";

    /** Mensaje que se muestra después de aplicar un aumento salarial. */
    public static final String DESPUES_DEL_AUMENTO = "Después del aumento:";

    /** Mensaje para mostrar la lista de cargos disponibles. */
    public static final String CARGOS_DISPONIBLES = "Cargos disponibles:";

    /** Etiqueta que precede la representación de un Empleado en toString. */
    public static final String ETQ_EMPLEADO = "Empleado{";

    /** Etiqueta usada para el campo nombre en toString. */
    public static final String ETQ_NOMBRE = "nombre";

    /** Etiqueta usada para el campo cargo en toString. */
    public static final String ETQ_CARGO = "cargo";

    /** Etiqueta usada para el campo salario en toString. */
    public static final String ETQ_SALARIO = "salario";

    /** Etiqueta de cierre en la representación de toString. */
    public static final String ETQ_CIERRE = "}";

    /** Porcentaje por defecto para aumento salarial (ej. 10%). */
    public static final double PORCENTAJE_AUMENTO_POR_DEFECTO = 10.0;

    /** Convenio salarial mínimo aceptado en validaciones. */
    public static final double CONVENIO_SALARIAL = 1200.0;

    /** Mensaje genérico para índice fuera de rango. */
    public static final String MSG_INDICE_FUERA_RANGO = "Índice fuera de rango";

    // Mensajes de validación para Empleado

    /** Error cuando el nombre es nulo o vacío. */
    public static final String ERR_NOMBRE_VACIO = "Nombre vacío o nulo";

    /** Error cuando el cargo no existe en la lista de cargos. */
    public static final String ERR_CARGO_INVALIDO = "Cargo no válido";

    /** Error cuando el salario es negativo. */
    public static final String ERR_SALARIO_NEGATIVO = "Salario negativo";

    /** Error cuando el salario es exactamente cero. */
    public static final String ERR_SALARIO_CERO = "Salario igual a 0";

    /** Error cuando el salario está por debajo del convenio. */
    public static final String ERR_SALARIO_DEBAJO_CONVENIO = "Salario por debajo del convenio";

    /** Error cuando el salario no es un número válido. */
    public static final String ERR_SALARIO_INVALIDO = "Salario inválido";
}
// ...existing code...