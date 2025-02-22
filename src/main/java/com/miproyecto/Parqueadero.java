package com.miproyecto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Parqueadero {

    private final List<Vehiculo> vehiculos = new ArrayList<>(); // Lista de vehículos en el parqueadero

    /**
     * Registra la entrada de un vehículo al parqueadero.
     *
     * @param vehiculo El vehículo que ingresa.
     */
    public void registrarEntrada(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    /**
     * Registra la salida de un vehículo y calcula el costo.
     *
     * @param placa La placa del vehículo que sale.
     * @return El costo simulado de la estadía.
     * @throws Exception Si el vehículo no se encuentra en el parqueadero.
     */
    public double registrarSalida(String placa) throws Exception {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                vehiculos.remove(v);
                return 5.0; // Simulación de cálculo de costo
            }
        }
        throw new Exception("Vehículo no encontrado");
    }

    /**
     * Consulta el estado actual del parqueadero.
     *
     * @return Una lista de vehículos estacionados.
     */
    public List<Vehiculo> consultarEstado() {
        return vehiculos;
    }

    /**
     * Genera un reporte diario de salidas de vehículos.
     *
     * @return Una lista vacía (pendiente de implementación).
     */
    public List<RegistroSalida> generarReporteDia() {
        return new ArrayList<>();
    }

    // Clase interna para registrar salidas de vehículos
    public static class RegistroSalida {

        private final Vehiculo vehiculo;
        private LocalDateTime horaSalida;
        private final double costo;

        public RegistroSalida(Vehiculo vehiculo, LocalDateTime horaSalida, double costo) {
            this.vehiculo = vehiculo;
            this.horaSalida = (horaSalida != null) ? horaSalida : LocalDateTime.now(); // Asegura valor no nulo
            this.costo = costo;
        }

        public Vehiculo getVehiculo() {
            return vehiculo;
        }

        public LocalDateTime getHoraSalida() {
            return horaSalida;
        }

        /**
         * Asigna la hora de salida si es necesario.
         *
         * @param horaSalida La hora de salida del vehículo.
         */
        public void setHoraSalida(LocalDateTime horaSalida) {
            this.horaSalida = horaSalida;
        }

        public double getCosto() {
            return costo;
        }
    }
}
