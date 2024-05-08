package com.javam4.main;

import java.util.Scanner;

import com.javam4.entidades.Usuario;
import com.javam4.interfaces.OperacionesWallet;
import com.javam4.implementaciones.Wallet;

public class Main {
    private static Usuario clienteCLP;
    private static Usuario clienteUSD;
    private static Usuario clienteEUR;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        OperacionesWallet walletCLP = new Wallet();
        OperacionesWallet walletUSD = new Wallet();
        OperacionesWallet walletEUR = new Wallet();

        clienteCLP = new Usuario("Luciano", "Zambrano", "lucza123@alkemy.com", walletCLP);
        clienteUSD = new Usuario("Jorge", "Carmona", "jorge123@alkemy.com", walletUSD);
        clienteEUR = new Usuario("Fernando", "González", "fergo567@alkemy.cl", walletEUR);

        int opcion;
        do {
            System.out.println("¡Bienvenido a tu billetera digital! \n"
            		+ " Selecciona una opción");
            System.out.println("1. Ver saldo");
            System.out.println("2. Detalle de la cuenta");
            System.out.println("3. Depositar");
            System.out.println("4. Transferir");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Saldo de Luciano Zambrano (CLP): ");
                    clienteCLP.getWallet().verSaldo();
                    System.out.println("Saldo de Jorge Carmona (USD): ");
                    clienteUSD.getWallet().verSaldo();
                    System.out.println("Saldo de Fernando González (EUR): ");
                    clienteEUR.getWallet().verSaldo();
                    break;
                case 2:
                    // Implementar detalle de cuenta
                    System.out.println("Detalle de la cuenta de Luciano Zambrano (CLP): ");
                    detalleCuenta(clienteCLP);
                    System.out.println("Detalle de la cuenta de Jorge Carmona (USD): ");
                    detalleCuenta(clienteUSD);
                    System.out.println("Detalle de la cuenta de Fernando González (EUR): ");
                    detalleCuenta(clienteEUR);
                    break;
                case 3:
                    System.out.println("Ingrese el monto a depositar: ");
                    double montoDeposito = scanner.nextDouble();
                    System.out.println("Ingrese la moneda (CLP, USD, EUR): ");
                    String monedaDeposito = scanner.next();
                    switch (monedaDeposito) {
                        case "CLP":
                            clienteCLP.getWallet().depositar(montoDeposito, monedaDeposito);
                            break;
                        case "USD":
                            clienteUSD.getWallet().depositar(montoDeposito, monedaDeposito);
                            break;
                        case "EUR":
                            clienteEUR.getWallet().depositar(montoDeposito, monedaDeposito);
                            break;
                        default:
                            System.out.println("Moneda no válida.");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el monto a transferir: ");
                    double montoTransferencia = scanner.nextDouble();
                    clienteCLP.getWallet().retirar(montoTransferencia, "CLP");
                    clienteUSD.getWallet().depositar(montoTransferencia, "USD");
                    System.out.println("Transferencia realizada de Luciano Zambrano (CLP) a Jorge Carmona (USD)");
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void detalleCuenta(Usuario usuario) {
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Apellido: " + usuario.getApellido());
        System.out.println("Email: " + usuario.getCorreo());
        System.out.println("Saldo:");
        usuario.getWallet().verSaldo();
    }
}
