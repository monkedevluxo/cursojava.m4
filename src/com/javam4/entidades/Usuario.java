package com.javam4.entidades;

import com.javam4.interfaces.OperacionesWallet;

//Clase de usuario o cliente con sus atributos
public class Usuario {
	private String nombre;
	private String apellido;
	private String correo;
    private OperacionesWallet wallet;
    
    public Usuario(String nombre, String apellido, String correo,OperacionesWallet wallet) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.wallet = wallet;
    }
    
    //getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public OperacionesWallet getWallet() {
		return wallet;
	}

	public void setWallet(OperacionesWallet wallet) {
		this.wallet = wallet;
	}
    
    
}
