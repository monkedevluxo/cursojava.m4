package com.javam4.entidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.javam4.implementaciones.Wallet;
import com.javam4.interfaces.OperacionesWallet;

public class UsuarioTest {

    private Usuario usuario;
    private OperacionesWallet wallet;

    @BeforeEach
    public void setUp() {
        wallet = new Wallet();
        usuario = new Usuario("Nombre", "Apellido", "email@example.com", wallet);
    }

    @Test
    public void getNombreTest() {
        assertEquals("Nombre", usuario.getNombre());
    }

    @Test
    public void getApellidoTest() {
        assertEquals("Apellido", usuario.getApellido());
    }

    @Test
    public void getEmailTest() {
        assertEquals("email@example.com", usuario.getCorreo());
    }
}

