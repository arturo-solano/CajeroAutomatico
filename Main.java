public class Main {
    public static void main(String[] args) {
        try {
            Cajero cajero = new Cajero(100000);

            // Crear cuentas
            Cuenta cuenta1 = new Cuenta("12345", 5000);
            Cuenta cuenta2 = new Cuenta("67890", 10000);

            // Agregar cuentas al cajero
            cajero.agregarCuenta(cuenta1);
            cajero.agregarCuenta(cuenta2);

            // Crear cuentahabientes
            Cuentahabiente cuentahabiente1 = new Cuentahabiente("Juan Perez", cuenta1, cajero);

            // Mostrar menú
            cuentahabiente1.mostrarMenu();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}