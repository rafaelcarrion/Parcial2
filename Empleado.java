class Empleado { 
    private String nombre;
    private String cargo;
    private double salario;

    public Empleado(String nombre, String cargo, double salario) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        // usa constantes para evitar textos fijos
        return Constantes.ETQ_EMPLEADO +
                Constantes.ETQ_NOMBRE + "='" + nombre + '\'' +
                ", " + Constantes.ETQ_CARGO + "='" + cargo + '\'' +
                ", " + Constantes.ETQ_SALARIO + "=" + salario +
                Constantes.ETQ_CIERRE;
    }
}
