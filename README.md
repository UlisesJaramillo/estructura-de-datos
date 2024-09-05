# Proyecto de Estructuras de Datos - Mundial Rusia 2018

## Descripción del Proyecto

El objetivo de este proyecto es desarrollar un sistema que brinde información sobre el Mundial de Fútbol 2018 a disputarse en Rusia. El sistema está diseñado para ayudar a los simpatizantes a obtener información sobre el evento y sugerir rutas de viaje entre las sedes del mundial.

El sistema almacena un mapa de ciudades y rutas terrestres en Rusia, incluyendo sedes de partidos y otras ciudades importantes. Además, se gestiona la información sobre los equipos, los resultados de los partidos y permite realizar varias consultas y operaciones relacionadas con estas entidades.

## Estructuras de Datos Utilizadas

1. **Grafo**: Representa el mapa de ciudades, donde las ciudades son vértices y las rutas entre ellas son aristas con distancias en kilómetros.
2. **Árbol AVL**: Almacena la información de los equipos de fútbol, ordenados alfabéticamente por nombre del país. Permite operaciones eficientes de búsqueda, inserción y eliminación.
3. **HashMap**: Utilizado para almacenar los partidos. La clave es una combinación de los nombres de los equipos, y el valor contiene los datos del partido, como goles, ronda y ciudad.
4. **Lista Dinámica**: Almacena los equipos contra los cuales cada equipo ha jugado, permitiendo un acceso eficiente a esta información.

## Funcionalidades del Sistema

### Menú Principal

El sistema ofrece las siguientes opciones en el menú principal:

1. **ABM de Ciudades**:
   - Agregar, eliminar y modificar ciudades.
2. **ABM de Equipos**:

   - Agregar, eliminar y modificar equipos.

3. **Altas de Partidos**:

   - Ingresar información sobre partidos jugados.

4. **Consulta sobre Equipos**:

   - Mostrar toda la información de un equipo, incluyendo puntos, goles y resultados de partidos.
   - Listar equipos cuyo nombre está en un rango alfabético dado.
   - Listar equipos con diferencia de goles negativa.

5. **Consulta sobre Ciudades**:

   - Mostrar toda la información de una ciudad dada.

6. **Consulta sobre Viajes**:

   - Obtener el camino de menor distancia entre dos ciudades.
   - Obtener el camino con la mínima cantidad de ciudades intermedias.
   - Obtener todos los caminos posibles entre dos ciudades.
   - (Opcional) Obtener el camino más corto entre dos ciudades pasando por una ciudad intermedia.

7. **Tabla de Posiciones**:

   - Mostrar la tabla de posiciones de los equipos, ordenados por puntaje.

8. **Mostrar Sistema**:
   - Mostrar la estructura del sistema para verificar que los datos están cargados correctamente.

## Requisitos del Sistema

- **Ejecución Independiente**: Cada operación especificada debe poder ejecutarse por separado.
- **Eficiencia**: El sistema debe recorrer las estructuras solo lo necesario y hacer buen uso de la memoria.
- **Estructuras Genéricas**: Las estructuras deben estar implementadas de manera genérica para elementos de tipo `Object` o `Comparable` de Java.
- **Carga Inicial**: La información debe cargarse desde un archivo de texto con formato específico. Ejemplos:

  - `E: ARGENTINA; SAMPAOLI; D; 0; 0; 0`
  - `P: ARGENTINA; ISLANDIA; GRUPO; 0; 0`
  - `C: MOSCU; 2511; 12500123; TRUE`
  - `R: MOSCU; TOLYATTI; 989`

- **Archivo de LOG**:
  - Estado del sistema al finalizar la carga inicial.
  - Listado de operaciones de ABM realizadas durante la ejecución.
  - Estado del sistema al finalizar la ejecución, incluyendo la tabla de posiciones.

## Implementación

La clase principal del sistema es `Mundial2018`, la cual proporciona un menú para interactuar con las funcionalidades del sistema. A través de este menú, se pueden realizar todas las operaciones especificadas y consultar la información almacenada.

## Entrega y Presentación

- **Entrega**: El proyecto debe ser presentado personalmente a un docente y luego subido a la plataforma PEDCO.
- **Defensa**: Presentar un dibujo del mapa de ciudades (grafo) y la tabla de equipos (AVL) cargada desde el archivo de texto.
- **Fechas de Entrega**:
  - **Estudiantes que promocionan**: Hasta el 3 de agosto.
  - **Estudiantes que no promocionan**: Dos semanas antes del final regular.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un _issue_ para reportar errores o sugerir mejoras.

## Licencia

Este proyecto está bajo la Licencia [MIT](LICENSE).

---

Gracias por revisar este proyecto. Si tienes alguna pregunta o sugerencia, no dudes en contactarme.
