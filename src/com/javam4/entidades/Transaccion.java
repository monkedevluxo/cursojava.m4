package com.javam4.entidades;

public class Transaccion {
	 private String tipo;
	 private double monto;
	 private String moneda;

	 //Constructor que inicializa una transacción con su tipo, monto y moneda.
	 public Transaccion(String tipo, double monto, String moneda) {
		 this.tipo = tipo;
	     this.monto = monto;
	     this.moneda = moneda;
	    }

	 public String getTipo() {
	     return tipo;
	    }

	 public double getMonto() {
	     return monto;
	    }

	 public String getMoneda() {
	     return moneda;
	    }
}
