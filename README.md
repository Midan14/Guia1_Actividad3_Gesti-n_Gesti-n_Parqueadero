
**Guia 1 Actividad 3 Gestión de un Parqueadero** 🚗🚦

Este proyecto es una aplicación en Java para la gestión de un parqueadero de vehículos. Permite el registro de entrada y salida de diferentes tipos de vehículos como automóviles, motocicletas y camiones.

## 📚 Objetivo del Proyecto

El propósito de este proyecto es desarrollar una solución práctica para la administración de un parqueadero utilizando conceptos de programación orientada a objetos en Java. Es ideal para estudiantes universitarios que deseen profundizar en el uso de **Java**, **Gradle** y buenas prácticas de **desarrollo de software**.

## 🚦 Funcionalidad del Proyecto

La aplicación permite:
- Registrar la entrada de vehículos (Automóvil, Motocicleta, Camión).
- Calcular tarifas según el tipo de vehículo y el tiempo de permanencia.
- Gestionar la salida de vehículos y liberar espacios en el parqueadero.
- Generar reportes de ocupación y transacciones realizadas.

## 📂 Estructura de Clases

- `Main.java`: Punto de entrada del programa. Se encarga de iniciar la aplicación y manejar el flujo principal.
- `Vehiculo.java`: Clase abstracta que define las propiedades comunes de todos los vehículos.
- `Automovil.java`, `Motocicleta.java`, `Camion.java`: Clases que heredan de `Vehiculo` y añaden funcionalidades específicas.
- `Parqueadero.java`: Se encarga de gestionar la entrada y salida de vehículos, así como de llevar el registro del parqueadero.
- `ParqueaderoTest.java`: Pruebas unitarias para asegurar el correcto funcionamiento de la clase `Parqueadero`.

## 📦 Instalación

1. Clona el repositorio desde GitHub:
```bash
git clone https://github.com/Midan14/Guia1_Actividad3_Gesti-n_Gesti-n_Parqueadero.git
cd Guia1_Actividad3_Gesti-n_Gesti-n_Parqueadero
```

1. Asegúrate de tener **Java 11** (o superior) y **Gradle** instalados.

2. Para compilar y ejecutar el proyecto, usa los siguientes comandos:
```bash
./gradlew build   # Compilar el proyecto
./gradlew run     # Ejecutar la aplicación
```

## 🚀 Uso

El proyecto se ejecuta desde la clase principal `Main.java`. Al iniciar, permite registrar vehículos en el parqueadero y gestionar su salida.

## 🧪 Pruebas

Puedes ejecutar las pruebas unitarias con el siguiente comando:
```bash
./gradlew test
```

Los resultados de las pruebas estarán disponibles en `build/reports/tests/test/index.html`.

## 👥 Colaboradores

- **Miguel Antonio Moscote**
- **Felipe Martínez Venegas**
- **Jorge Steven Gaitán Barreto**
- **Mariana Ruiz Rubiano**


## 📄 Licencia

Este proyecto está bajo la licencia MIT. ¡Siéntete libre de usarlo y mejorarlo!
