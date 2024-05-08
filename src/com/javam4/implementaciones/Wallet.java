package com.javam4.implementaciones;

import com.javam4.interfaces.OperacionesWallet;
import java.util.HashMap;
import java.util.Map;

public class Wallet implements OperacionesWallet{
	 // Implementación de la interfaz OperacionesWallet que representa una wallet digital.
	    private Map<String, Double> saldo;
	 //Constructor que inicializa la billetera con un saldo de cero para cada moneda.
	    public Wallet() {
	        this.saldo = new HashMap<>();
	        this.saldo.put("CLP", 0.0);
	        this.saldo.put("EUR", 0.0);
	        this.saldo.put("USD", 0.0);
	    }

	    @Override
	    public void depositar(double monto, String moneda) {
	        double saldoActual = saldo.get(moneda);
	        saldo.put(moneda, saldoActual + monto);
	        System.out.println("Depósito de " + monto + " " + moneda + " realizado.");
	    }

	    @Override
	    public void retirar(double monto, String moneda) {
	        double saldoActual = saldo.get(moneda);
	        if (monto <= saldoActual) {
	            saldo.put(moneda, saldoActual - monto);
	            System.out.println("Retiro de " + monto + " " + moneda + " realizado.");
	        } else {
	            System.out.println("Saldo insuficiente para realizar el retiro.");
	        }
	    }

	    @Override
	    public void verSaldo() {
	        System.out.println("Saldo actual:");
	        for (String moneda : saldo.keySet()) {
	            System.out.println(moneda + ": " + saldo.get(moneda));
	        }
	    }

	    @Override
	    public double convertirMoneda(double monto, String monedaOrigen, String monedaDestino) {
	        double tasaCambio = obtenerTasaCambio(monedaOrigen, monedaDestino);
	        return monto * tasaCambio;
	    }

	    private double obtenerTasaCambio(String monedaOrigen, String monedaDestino) {
	        // Lógica para obtener la tasa de cambio
	    	double tasaCambio = 1.0;
	        if (monedaOrigen.equals("USD") && monedaDestino.equals("CLP")) {
	            tasaCambio = 937.0;
	        } else if (monedaOrigen.equals("USD") && monedaDestino.equals("EUR")) {
	            tasaCambio = 0.93;
	        } else if (monedaOrigen.equals("EUR") && monedaDestino.equals("CLP")) {
	            tasaCambio = 1007.0;
	        } else if (monedaOrigen.equals("CLP") && monedaDestino.equals("USD")) {
	            tasaCambio = 1 / 937.0;
	        } else if (monedaOrigen.equals("EUR") && monedaDestino.equals("USD")) {
	            tasaCambio = 1 / 0.93;
	        } else if (monedaOrigen.equals("CLP") && monedaDestino.equals("EUR")) {
	            tasaCambio = 1 / 1007.0;
	        }
	        return tasaCambio;
	    	
	    }
	    
	    public double getSaldo(String moneda) {
	        return saldo.get(moneda);
	    }
	}
	

