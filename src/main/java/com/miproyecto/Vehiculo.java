package com.miproyecto;

import java.time.LocalDateTime;

public class Vehiculo {

    private final String placa; // Identificación del vehículo
    private final String marca; // Marca del vehículo
    private final String modelo; // Modelo del vehículo
    private final LocalDateTime horaEntrada; // Fecha y hora de entrada al parqueadero

    public Vehiculo(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.horaEntrada = LocalDateTime.now(); // Registra la hora actual al ingresar
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }
}
