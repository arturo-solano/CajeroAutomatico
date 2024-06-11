/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// Cajero.java
import java.util.HashMap;
import java.util.Map;

public class Cajero {
    private double efectivoDisponible;
    private final Map<String, Cuenta> cuentas;

    public Cajero(double efectivoInicial) {
        this.efectivoDisponible = efectivoInicial;
        this.cuentas = new HashMap<>();
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.put(cuenta.getNumeroCuenta(), cuenta);
    }

    public Cuenta autenticar(String numeroCuenta) throws Exception {
        if (cuentas.containsKey(numeroCuenta)) {
            return cuentas.get(numeroCuenta);
        } else {
            throw new Exception("Cuenta no encontrada.");
        }
    }

    public double mostrarSaldoCuenta(Cuenta cuenta) {
        return cuenta.getSaldo();
    }

    public void depositarEnCuentaPropia(Cuenta cuenta, double monto) {
        cuenta.depositar(monto);
    }

    public void depositarEnOtraCuenta(Cuenta cuentaOrigen, String numeroCuentaDestino, double monto) throws Exception {
        if (cuentas.containsKey(numeroCuentaDestino)) {
            Cuenta cuentaDestino = cuentas.get(numeroCuentaDestino);
            cuentaOrigen.transferir(monto, cuentaDestino);
        } else {
            throw new Exception("Cuenta destino no encontrada.");
        }
    }

    public void transferirAOtraCuenta(Cuenta cuentaOrigen, String numeroCuentaDestino, double monto) throws Exception {
        depositarEnOtraCuenta(cuentaOrigen, numeroCuentaDestino, monto);
    }

    public void retirarEfectivo(Cuenta cuenta, double monto) throws SaldoEfectivoInsuficiente, SaldoCuentaInsuficiente {
        if (efectivoDisponible >= monto) {
            cuenta.retirar(monto);
            efectivoDisponible -= monto;
        } else {
            throw new SaldoEfectivoInsuficiente("El cajero no tiene suficiente efectivo.");
        }
    }

    public double getEfectivoDisponible() {
        return efectivoDisponible;
    }
}
