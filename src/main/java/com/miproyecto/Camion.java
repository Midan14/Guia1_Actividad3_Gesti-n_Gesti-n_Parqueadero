package com.miproyecto;

// La clase Camion extiende la clase abstracta Vehiculo
public class Camion extends Vehiculo {

    // Atributo que indica la capacidad de carga del camión en toneladas
    private double capacidadCarga;

    /**
     * Constructor de la clase Camion.
     *
     * @param placa         La placa del camión (e.g., LMN456).
     * @param marca         La marca del camión (e.g., Volvo).
     * @param modelo        El modelo del camión (e.g., FH16).
     * @param capacidadCarga La capacidad de carga en toneladas (e.g., 20.0).
     */
    public Camion(String placa, String marca, String modelo, double capacidadCarga) {
        super(placa, marca, modelo); // Llama al constructor de la clase padre Vehiculo
        this.capacidadCarga = capacidadCarga; // Asigna la capacidad de carga al atributo
    }
}
