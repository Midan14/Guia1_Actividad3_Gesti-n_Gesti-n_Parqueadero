package com.miproyecto;

// La clase Motocicleta extiende la clase abstracta Vehiculo
public class Motocicleta extends Vehiculo {

    private int cilindraje; // Cilindraje de la motocicleta en cc

    public Motocicleta(String placa, String marca, String modelo, int cilindraje) {
        super(placa, marca, modelo); // Constructor de la clase padre Vehiculo
        this.cilindraje = cilindraje;
    }
}
