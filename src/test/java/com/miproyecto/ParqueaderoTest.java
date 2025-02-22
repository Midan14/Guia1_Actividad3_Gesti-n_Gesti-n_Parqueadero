package com.miproyecto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase de pruebas unitarias para la clase Parqueadero.
 * Se valida el funcionamiento de las principales funcionalidades del parqueadero.
 */
public class ParqueaderoTest {

    /**
     * Prueba unitaria para registrar la entrada de un vehículo al parqueadero.
     * Se verifica que el vehículo se agregue correctamente a la lista de vehículos.
     */
    @Test
    public void pruebaRegistrarEntrada() {
        Parqueadero parqueadero = new Parqueadero();
        Vehiculo vehiculo = new Vehiculo("ABC123", "Toyota", "Corolla");
        parqueadero.registrarEntrada(vehiculo);

        List<Vehiculo> vehiculos = parqueadero.consultarEstado();
        assertEquals(1, vehiculos.size(), "Debería haber un vehículo en el parqueadero");
        assertEquals("ABC123", vehiculos.get(0).getPlaca(), "La placa del vehículo debería ser ABC123");
    }

    /**
     * Prueba unitaria para registrar la salida exitosa de un vehículo.
     * Se asegura que el vehículo sea removido de la lista y que el costo sea el esperado.
     */
    @Test
    public void pruebaRegistrarSalidaExitosa() throws Exception {
        Parqueadero parqueadero = new Parqueadero();
        Vehiculo vehiculo = new Vehiculo("XYZ789", "Honda", "Civic");
        parqueadero.registrarEntrada(vehiculo);

        double costo = parqueadero.registrarSalida("XYZ789");
        assertEquals(5.0, costo, "El costo de salida debería ser 5.0");

        List<Vehiculo> vehiculos = parqueadero.consultarEstado();
        assertEquals(0, vehiculos.size(), "No debería haber vehículos después de la salida");
    }

    /**
     * Prueba unitaria para manejar la excepción al intentar registrar la salida de un vehículo no encontrado.
     * Se verifica que se lance la excepción esperada con el mensaje correcto.
     */
    @Test
    public void pruebaRegistrarSalidaVehiculoNoEncontrado() {
        Parqueadero parqueadero = new Parqueadero();
        Exception exception = assertThrows(Exception.class, () -> {
            parqueadero.registrarSalida("NO_EXISTE");
        });
        assertEquals("Vehículo no encontrado", exception.getMessage());
    }

    /**
     * Prueba unitaria para consultar el estado del parqueadero.
     * Se valida que la lista de vehículos devuelta sea correcta.
     */
    @Test
    public void pruebaConsultarEstado() {
        Parqueadero parqueadero = new Parqueadero();
        Vehiculo vehiculo1 = new Vehiculo("AAA111", "Nissan", "Versa");
        Vehiculo vehiculo2 = new Vehiculo("BBB222", "Ford", "Fiesta");

        parqueadero.registrarEntrada(vehiculo1);
        parqueadero.registrarEntrada(vehiculo2);

        List<Vehiculo> vehiculos = parqueadero.consultarEstado();
        assertEquals(2, vehiculos.size(), "Debería haber 2 vehículos en el parqueadero");
    }

    /**
     * Prueba unitaria para generar el reporte diario del parqueadero.
     * Se comprueba que el reporte no sea nulo y esté vacío.
     */
    @Test
    public void pruebaGenerarReporteDia() {
        Parqueadero parqueadero = new Parqueadero();
        List<Parqueadero.RegistroSalida> reporte = parqueadero.generarReporteDia();

        assertNotNull(reporte, "El reporte no debería ser null");
        assertTrue(reporte.isEmpty(), "El reporte debería estar vacío");
    }
}
