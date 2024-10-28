/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuentabancaria;

/**
 *
 * @author h
 */
import javax.swing.JOptionPane;

public class GestionCuentas {
    // Método para iniciar el programa
    public static void iniciarPrograma() {
        // Ingresar datos de la primera cuenta
        String nombres1 = JOptionPane.showInputDialog("Ingrese los nombres del titular de la cuenta 1:");
        String apellidos1 = JOptionPane.showInputDialog("Ingrese los apellidos del titular de la cuenta 1:");
        String numeroCuenta1 = JOptionPane.showInputDialog("Ingrese el número de la cuenta 1:");
        String tipoCuenta1 = JOptionPane.showInputDialog("Ingrese el tipo de cuenta 1 (Ahorros o Corriente):");

        // Ingresar datos de la segunda cuenta
        String nombres2 = JOptionPane.showInputDialog("Ingrese los nombres del titular de la cuenta 2:");
        String apellidos2 = JOptionPane.showInputDialog("Ingrese los apellidos del titular de la cuenta 2:");
        String numeroCuenta2 = JOptionPane.showInputDialog("Ingrese el número de la cuenta 2:");
        String tipoCuenta2 = JOptionPane.showInputDialog("Ingrese el tipo de cuenta 2 (Ahorros o Corriente):");

        // Crear dos cuentas bancarias con los datos ingresados
        CuentaBancaria cuenta1 = new CuentaBancaria(nombres1, apellidos1, numeroCuenta1, tipoCuenta1);
        CuentaBancaria cuenta2 = new CuentaBancaria(nombres2, apellidos2, numeroCuenta2, tipoCuenta2);

        boolean salir = false;

        // Bucle de menú de opciones
        while (!salir) {
            String opcion = JOptionPane.showInputDialog("Seleccione una operación:\n"
                    + "1. Imprimir Datos\n"
                    + "2. Consultar Saldo\n"
                    + "3. Consignar\n"
                    + "4. Retirar\n"
                    + "5. Comparar Saldos\n"
                    + "6. Transferir\n"
                    + "7. Salir");

            switch (opcion) {
                case "1": // Imprimir Datos
                    cuenta1.imprimirDatos();
                    cuenta2.imprimirDatos();
                    break;
                case "2": // Consultar Saldo
                    JOptionPane.showMessageDialog(null, "Saldo cuenta 1: $" + cuenta1.consultarSaldo() 
                                                + "\nSaldo cuenta 2: $" + cuenta2.consultarSaldo());
                    break;
                case "3": // Consignar
                    String cuentaConsignar = JOptionPane.showInputDialog("¿En qué cuenta desea consignar? (1 o 2)");
                    double valorConsignar = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor a consignar:"));
                    if (cuentaConsignar.equals("1")) {
                        cuenta1.consignar(valorConsignar);
                    } else if (cuentaConsignar.equals("2")) {
                        cuenta2.consignar(valorConsignar);
                    }
                    break;
                case "4": // Retirar
                    String cuentaRetirar = JOptionPane.showInputDialog("¿De qué cuenta desea retirar? (1 o 2)");
                    double valorRetirar = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor a retirar:"));
                    if (cuentaRetirar.equals("1")) {
                        cuenta1.retirar(valorRetirar);
                    } else if (cuentaRetirar.equals("2")) {
                        cuenta2.retirar(valorRetirar);
                    }
                    break;
                case "5": // Comparar Saldos
                    JOptionPane.showMessageDialog(null, cuenta1.compararSaldo(cuenta2));
                    break;
                case "6": // Transferir
                    String transferirDe = JOptionPane.showInputDialog("¿Desde qué cuenta desea transferir? (1 o 2)");
                    double montoTransferir = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a transferir:"));
                    if (transferirDe.equals("1")) {
                        cuenta1.transferir(cuenta2, montoTransferir);
                    } else if (transferirDe.equals("2")) {
                        cuenta2.transferir(cuenta1, montoTransferir);
                    }
                    break;
                case "7": // Salir
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar la gestión de cuentas bancarias.");
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción del menú.");
                    break;
            }
        }
    }

    // Método principal
    public static void main(String[] args) {
        iniciarPrograma();
    }
}