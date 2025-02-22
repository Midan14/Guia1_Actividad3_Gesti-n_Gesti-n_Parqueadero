package com.miproyecto;

// La clase Automovil extiende la clase abstracta Vehiculo
public class Automovil extends Vehiculo {

    // Atributo que indica el tipo de combustible del automóvil
    private String combustible;

    /**
     * Constructor de la clase Automovil.
     *
     * @param placa      La placa del vehículo (e.g., ABC123).
     * @param marca      La marca del vehículo (e.g., Toyota).
     * @param modelo     El modelo del vehículo (e.g., Corolla).
     * @param combustible El tipo de combustible utilizado (e.g., Gasolina).
     */
    public Automovil(String placa, String marca, String modelo, String combustible) {
        super(placa, marca, modelo); // Llama al constructor de la clase padre Vehiculo
        this.combustible = combustible; // Asigna el tipo de combustible al atributo
    }
}
