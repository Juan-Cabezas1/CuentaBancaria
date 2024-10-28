/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuentabancaria;

/**
 *
 * @author h
 */
import javax.swing.JOptionPane;

public class CuentaBancaria {
    private String nombres;
    private String apellidos;
    private String numeroCuenta;
    private String tipoCuenta;
    private double saldo;

    // Constructor
    public CuentaBancaria(String nombres, String apellidos, String numeroCuenta, String tipoCuenta) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = 0.0; // Saldo inicial es 0
    }

    // Método para imprimir los datos de la cuenta
    public void imprimirDatos() {
        JOptionPane.showMessageDialog(null, "Titular: " + nombres + " " + apellidos + "\n"
                + "Número de cuenta: " + numeroCuenta + "\n"
                + "Tipo de cuenta: " + tipoCuenta + "\n"
                + "Saldo actual: $" + saldo);
    }

    // Método para consultar el saldo de la cuenta
    public double consultarSaldo() {
        return saldo;
    }

    // Método para consignar dinero en la cuenta
    public void consignar(double valor) {
        if (valor > 0) {
            saldo += valor;
            JOptionPane.showMessageDialog(null, "Consignación exitosa. Nuevo saldo: $" + saldo);
        } else {
            JOptionPane.showMessageDialog(null, "El valor a consignar debe ser mayor a cero.");
        }
    }

    // Método para retirar dinero de la cuenta
    public void retirar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            JOptionPane.showMessageDialog(null, "Retiro exitoso. Nuevo saldo: $" + saldo);
        } else {
            JOptionPane.showMessageDialog(null, "El retiro no es posible. Verifique el saldo o el monto ingresado.");
        }
    }

    // Método para comparar saldos entre cuentas
    public String compararSaldo(CuentaBancaria otraCuenta) {
        if (this.saldo > otraCuenta.consultarSaldo()) {
            return "La cuenta con número " + this.numeroCuenta + " tiene más saldo.";
        } else if (this.saldo < otraCuenta.consultarSaldo()) {
            return "La cuenta con número " + otraCuenta.numeroCuenta + " tiene más saldo.";
        } else {
            return "Ambas cuentas tienen el mismo saldo.";
        }
    }

    // Método para transferir dinero a otra cuenta
    public void transferir(CuentaBancaria destino, double monto) {
        if (monto > 0 && monto <= this.saldo) {
            this.retirar(monto);
            destino.consignar(monto);
            JOptionPane.showMessageDialog(null, "Transferencia exitosa de $" + monto 
                                          + " de la cuenta " + this.numeroCuenta 
                                          + " a la cuenta " + destino.numeroCuenta);
        } else {
            JOptionPane.showMessageDialog(null, "Transferencia no es posible. Verifique el saldo o el monto.");
        }
    }
}