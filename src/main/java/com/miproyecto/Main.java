package com.miproyecto;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que gestiona el flujo del sistema de parqueadero.
 * Permite registrar entradas y salidas de vehículos, mostrar el estado del parqueadero
 * y generar un reporte diario.
 */
public class Main {

    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero(); // Instancia del parqueadero
        Scanner scanner = new Scanner(System.in); // Objeto para leer la entrada del usuario

        // Bucle principal del sistema de gestión del parqueadero
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Registrar entrada");
            System.out.println("2. Registrar salida");
            System.out.println("3. Mostrar estado del parqueadero");
            System.out.println("4. Generar reporte diario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine(); // Lee la opción seleccionada

            switch (opcion) {
                case "1" -> registrarEntrada(parqueadero, scanner); // Registrar la entrada de un vehículo
                case "2" -> registrarSalida(parqueadero, scanner); // Registrar la salida de un vehículo
                case "3" -> mostrarEstado(parqueadero); // Mostrar el estado actual del parqueadero
                case "4" -> generarReporte(parqueadero); // Generar un reporte diario de salidas
                case "5" -> {
                    System.out.println("Saliendo del sistema...");
                    scanner.close(); // Cierra el recurso Scanner
                    return; // Finaliza el programa
                }
                default -> System.out.println("Opción inválida. Intente de nuevo."); // Maneja opciones no válidas
            }
        }
    }

    /**
     * Método para registrar la entrada de un vehículo al parqueadero.
     *
     * @param parqueadero El objeto Parqueadero donde se registrará el vehículo.
     * @param scanner Objeto Scanner para capturar la entrada del usuario.
     */
    private static void registrarEntrada(Parqueadero parqueadero, Scanner scanner) {
        try {
            System.out.print("Tipo (1-Auto, 2-Moto, 3-Camión): ");
            String tipo = scanner.nextLine(); // Tipo de vehículo seleccionado

            System.out.print("Placa: ");
            String placa = scanner.nextLine();

            System.out.print("Marca: ");
            String marca = scanner.nextLine();

            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();

            // Crea una instancia del vehículo según el tipo seleccionado
            Vehiculo vehiculo = switch (tipo) {
                case "1" -> {
                    System.out.print("Combustible: ");
                    yield new Automovil(placa, marca, modelo, scanner.nextLine());
                }
                case "2" -> {
                    System.out.print("Cilindraje: ");
                    yield new Motocicleta(placa, marca, modelo, Integer.parseInt(scanner.nextLine()));
                }
                case "3" -> {
                    System.out.print("Capacidad carga: ");
                    yield new Camion(placa, marca, modelo, Double.parseDouble(scanner.nextLine()));
                }
                default -> throw new IllegalArgumentException("Tipo inválido");
            };

            parqueadero.registrarEntrada(vehiculo); // Registra el vehículo en el parqueadero
            System.out.println("¡Vehículo registrado!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()); // Muestra el error al usuario
        }
    }

    /**
     * Método para registrar la salida de un vehículo del parqueadero.
     *
     * @param parqueadero El objeto Parqueadero del que se retira el vehículo.
     * @param scanner Objeto Scanner para capturar la entrada del usuario.
     */
    private static void registrarSalida(Parqueadero parqueadero, Scanner scanner) {
        System.out.print("Placa del vehículo: ");
        try {
            double costo = parqueadero.registrarSalida(scanner.nextLine()); // Calcula el costo total
            System.out.printf("Costo total: $%.2f%n", costo); // Muestra el costo al usuario
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método para mostrar el estado actual del parqueadero.
     *
     * @param parqueadero El objeto Parqueadero del que se mostrará el estado.
     */
    private static void mostrarEstado(Parqueadero parqueadero) {
        List<Vehiculo> vehiculos = parqueadero.consultarEstado(); // Obtiene la lista de vehículos

        if (vehiculos.isEmpty()) {
            System.out.println("Parqueadero vacío");
            return;
        }

        System.out.println("Vehículos estacionados:");
        vehiculos.forEach(v -> System.out.printf(
                "Placa: %s | %s | Entrada: %s%n",
                v.getPlaca(),
                v.getClass().getSimpleName(), // Muestra el tipo de vehículo
                v.getHoraEntrada() != null ? v.getHoraEntrada().format(DateTimeFormatter.ofPattern("HH:mm")) : "Sin hora"
        ));
    }

    /**
     * Método para generar un reporte diario de las salidas del parqueadero.
     *
     * @param parqueadero El objeto Parqueadero del que se generará el reporte.
     */
    private static void generarReporte(Parqueadero parqueadero) {
        List<Parqueadero.RegistroSalida> reporte = parqueadero.generarReporteDia(); // Obtiene el reporte diario

        if (reporte.isEmpty()) {
            System.out.println("Sin registros de salida");
            return;
        }

        System.out.println("--- Reporte diario ---");
        reporte.forEach(r -> System.out.printf(
                "[%s] %s - Estadia: %d min - Total: $%.2f%n",
                r.getHoraSalida().format(DateTimeFormatter.ofPattern("HH:mm")),
                r.getVehiculo().getPlaca(),
                Duration.between(r.getVehiculo().getHoraEntrada(), r.getHoraSalida()).toMinutes(),
                r.getCosto()
        ));
    }
}
