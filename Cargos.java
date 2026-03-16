public class Cargos {
    // lista pública de cargos para usar directamente: Cargos.lista
    public static final String[] lista = {
        "Directora",
        "Programador",
        "Analista",
        "Administrador",
        "Recepcionista",
        "Contable",
        "Soporte"
    };

    // imprime la lista de cargos (usa constante)
    public static void mostrarCargos() {
        System.out.println(Constantes.CARGOS_DISPONIBLES);
        for (int i = 0; i < lista.length; i++) {
            System.out.printf("%d: %s%n", i, lista[i]);
        }
    }

    // valida si un cargo existe en la lista
    public static boolean existeCargo(String cargo) {
        if (cargo == null) return false;
        for (String c : lista) {
            if (c.equalsIgnoreCase(cargo)) return true;
        }
        return false;
    }

    // obtener cargo por índice (devuelve null si índice fuera de rango)
    public static String obtener(int index) {
        if (index < 0 || index >= lista.length) return null;
        return lista[index];
    }
}