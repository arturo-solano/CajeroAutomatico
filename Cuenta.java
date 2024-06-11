/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Cuenta {
    private final String numeroCuenta;
    private double saldo;

    public Cuenta(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void retirar(double monto) throws SaldoCuentaInsuficiente {
        if (saldo >= monto) {
            saldo -= monto;
        } else {
            throw new SaldoCuentaInsuficiente("Saldo insuficiente en la cuenta.");
        }
    }

    public void transferir(double monto, Cuenta cuentaDestino) throws SaldoCuentaInsuficiente {
        if (saldo >= monto) {
            saldo -= monto;
            cuentaDestino.depositar(monto);
        } else {
            throw new SaldoCuentaInsuficiente("Saldo insuficiente para transferir.");
        }
    }
}
