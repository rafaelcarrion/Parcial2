/**
 * Utilidad para validar objetos {@link Empleado}.
 *
 * <p>Proporciona métodos estáticos para validar nombre, cargo y salario de un empleado.
 * Lanza {@link IllegalArgumentException} con mensajes definidos en {@link Constantes}
 * cuando una validación falla.</p>
 */
public final class EmpleadoValidator {
    private EmpleadoValidator() {}

    /**
     * Valida el nombre de un empleado.
     *
     * @param nombre el nombre a validar; no puede ser nulo ni estar compuesto sólo por espacios
     * @throws IllegalArgumentException si el nombre es nulo o vacío
     */
    public static void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(Constantes.ERR_NOMBRE_VACIO);
        }
    }

    /**
     * Valida que el cargo exista en la lista de cargos disponibles.
     *
     * @param cargo el cargo a validar; no puede ser nulo y debe existir en {@link Cargos#lista}
     * @throws IllegalArgumentException si el cargo es nulo o no válido
     */
    public static void validarCargo(String cargo) {
        if (cargo == null || !Cargos.existeCargo(cargo)) {
            throw new IllegalArgumentException(Constantes.ERR_CARGO_INVALIDO);
        }
    }

    /**
     * Valida el salario de un empleado.
     *
     * <p>Reglas:
     * <ul>
     *   <li>No puede ser NaN.</li>
     *   <li>No puede ser negativo.</li>
     *   <li>No puede ser igual a 0.0.</li>
     *   <li>No puede estar por debajo de {@link Constantes#CONVENIO_SALARIAL}.</li>
     * </ul></p>
     *
     * @param salario el salario a validar
     * @throws IllegalArgumentException si el salario no cumple las reglas especificadas
     */
    public static void validarSalario(double salario) {
        if (Double.isNaN(salario)) {
            throw new IllegalArgumentException(Constantes.ERR_SALARIO_INVALIDO);
        }
        if (salario < 0) {
            throw new IllegalArgumentException(Constantes.ERR_SALARIO_NEGATIVO);
        }
        if (salario == 0.0) {
            throw new IllegalArgumentException(Constantes.ERR_SALARIO_CERO);
        }
        if (salario < Constantes.CONVENIO_SALARIAL) {
            throw new IllegalArgumentException(Constantes.ERR_SALARIO_DEBAJO_CONVENIO);
        }
    }

    /**
     * Valida un objeto {@link Empleado} completo aplicando las validaciones
     * de nombre, cargo y salario.
     *
     * @param e el empleado a validar; no puede ser null
     * @throws IllegalArgumentException si el empleado es null o cualquiera de sus campos es inválido
     */
    public static void validarEmpleado(Empleado e) {
        if (e == null) {
            throw new IllegalArgumentException("Empleado nulo");
        }
        validarNombre(e.getNombre());
        validarCargo(e.getCargo());
        validarSalario(e.getSalario());
    }
}