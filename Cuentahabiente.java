/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

public class Cuentahabiente {
    private final String nombre;
    private final Cuenta cuenta;
    private final Cajero cajero;

    public Cuentahabiente(String nombre, Cuenta cuenta, Cajero cajero) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.cajero = cajero;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nBienvenido, " + nombre);
            System.out.println("1. Consultar datos de cuenta");
            System.out.println("2. Consultar saldo");
            System.out.println("3. Depósito en cuenta propia");
            System.out.println("4. Depósito en otra cuenta");
            System.out.println("5. Transferencia a otra cuenta");
            System.out.println("6. Retiro de efectivo");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> consultarDatosCuenta();
                case 2 -> consultarSaldo();
                case 3 -> depositarEnCuentaPropia();
                case 4 -> depositarEnOtraCuenta();
                case 5 -> transferirAOtraCuenta();
                case 6 -> retirarEfectivo();
                case 7 -> System.out.println("Gracias por usar el cajero. Adiós.");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 7);
    }

    private void consultarDatosCuenta() {
        System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Saldo: " + cuenta.getSaldo());
    }

    private void consultarSaldo() {
        System.out.println("Saldo: " + cuenta.getSaldo());
    }

    private void depositarEnCuentaPropia() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el monto a depositar: ");
        double monto = scanner.nextDouble();
        cajero.depositarEnCuentaPropia(cuenta, monto);
        System.out.println("Depósito exitoso. Saldo actual: " + cuenta.getSaldo());
    }

    private void depositarEnOtraCuenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de cuenta destino: ");
        String numeroCuentaDestino = scanner.next();
        System.out.print("Ingrese el monto a depositar: ");
        double monto = scanner.nextDouble();

        try {
            cajero.depositarEnOtraCuenta(cuenta, numeroCuentaDestino, monto);
            System.out.println("Depósito exitoso. Saldo actual: " + cuenta.getSaldo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void transferirAOtraCuenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de cuenta destino: ");
        String numeroCuentaDestino = scanner.next();
        System.out.print("Ingrese el monto a transferir: ");
        double monto = scanner.nextDouble();

        try {
            cajero.transferirAOtraCuenta(cuenta, numeroCuentaDestino, monto);
            System.out.println("Transferencia exitosa. Saldo actual: " + cuenta.getSaldo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void retirarEfectivo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el monto a retirar: ");
        double monto = scanner.nextDouble();

        try {
            cajero.retirarEfectivo(cuenta, monto);
            System.out.println("Retiro exitoso. Saldo actual: " + cuenta.getSaldo());
        } catch (SaldoEfectivoInsuficiente | SaldoCuentaInsuficiente e) {
            System.out.println(e.getMessage());
        }
    }
}
