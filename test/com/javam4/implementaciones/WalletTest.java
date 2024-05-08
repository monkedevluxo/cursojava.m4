package com.javam4.implementaciones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.javam4.implementaciones.Wallet;

public class WalletTest {

    private Wallet wallet;

    @BeforeEach
    public void setUp() {
        wallet = new Wallet();
    }

    @Test
    public void depositarTest() {
        wallet.depositar(100, "USD");
        assertEquals(100, wallet.getSaldo("USD"));
    }

    @Test
    public void depositarCantidadNegativaTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            wallet.depositar(-50, "USD");
        });
    }

    @Test
    public void retirarTest() {
        wallet.depositar(200, "EUR");
        wallet.retirar(100, "EUR");
        assertEquals(100, wallet.getSaldo("EUR"));
    }

    @Test
    public void retirarMontoMayorAlSaldoTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            wallet.retirar(500, "USD");
        });
    }

    @Test
    public void verSaldoTest() {
        wallet.depositar(1000, "CLP");
        wallet.depositar(200, "EUR");
        wallet.depositar(300, "USD");
        assertEquals(1000, wallet.getSaldo("CLP"));
        assertEquals(200, wallet.getSaldo("EUR"));
        assertEquals(300, wallet.getSaldo("USD"));
    }

    @Test
    public void convertirMonedaTest() {
        wallet.depositar(1000, "CLP");
        double cantidadConvertida = wallet.convertirMoneda(100, "CLP", "USD");
        assertEquals(0.106836672, cantidadConvertida); // Ajusta el valor esperado según la tasa de cambio actual
    }

    @Test
    public void convertirMonedaMonedaInvalidaTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            wallet.convertirMoneda(100, "CLP", "JPY");
        });
    }
}

