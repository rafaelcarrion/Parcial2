public class SistemaGestionEmpleados {
    public static void main(String[] args) {
        Empleados empleados = new Empleados();

        // dar de alta los tres empleados del ejemplo usando Cargos para los cargos
        empleados.altaEmpleado(new Empleado("Ana", Cargos.lista[0], 3000.0));
        empleados.altaEmpleado(new Empleado("Luis", Cargos.lista[1], 2000.0));
        empleados.altaEmpleado(new Empleado("María", Cargos.lista[2], 2500.0));

        // mostrar listado inicial
        empleados.mostrarListado();

        // aumentar salarios (usa constante por defecto)
        empleados.aumentarSalarios(Constantes.PORCENTAJE_AUMENTO_POR_DEFECTO);

        System.out.println();
        System.out.println(Constantes.DESPUES_DEL_AUMENTO);
        empleados.mostrarListado();
    }
}

