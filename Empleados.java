public class Empleados {
    // array público para poder usar empleados.lista según lo solicitado
    public Empleado[] lista;

    public Empleados() {
        this.lista = new Empleado[0];
    }

    // alta de un nuevo empleado (redimensiona el array)
    public void altaEmpleado(Empleado e) {
        Empleado[] nueva = new Empleado[this.lista.length + 1];
        System.arraycopy(this.lista, 0, nueva, 0, this.lista.length);
        nueva[this.lista.length] = e;
        this.lista = nueva;
    }

    // mostrar listado de empleados (usa constante)
    public void mostrarListado() {
        System.out.println(Constantes.LISTADO_EMPLEADOS);
        for (Empleado e : lista) {
            System.out.println(e);
        }
    }

    // aumentar salarios en porcentaje (usa lógica igual, número por defecto en main si aplica)
    public void aumentarSalarios(double porcentaje) {
        for (Empleado e : lista) {
            double nuevo = e.getSalario() * (1 + porcentaje / 100.0);
            e.setSalario(nuevo);
        }
    }
}
