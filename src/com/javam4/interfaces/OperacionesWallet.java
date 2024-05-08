package com.javam4.interfaces;

import com.javam4.entidades.Usuario;

public interface OperacionesWallet {
    // Aquí se definen las operaciones disponibles en la wallet
    void depositar(double monto, String moneda);
    void retirar(double monto, String moneda);
    void verSaldo();
    double convertirMoneda(double monto, String monedaOrigen, String monedaDestino);
}

