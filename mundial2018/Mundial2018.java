/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundial2018;

import estructuras.ArbolAVL;
import estructuras.ArbolHeap;
import estructuras.Grafo;
import estructuras.Lista;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import static mundial2018.Dato.cargarSistema;
import static mundial2018.Dato.escribirLog;
import util.TecladoIn;

/************************************************************************************************
 ***                     TRABAJO PRACTICO   ---  ESTRUCTURA DE DATOS                          ***
 ************************************************************************************************
 *                                                                                              *
 *                 Nombre del proyecto : Mundial Rusia 2018                                     *
 *                                                                                              *
 *                  Nombre del Archivo : Mundial2018.java                                       *
 *                                                                                              *
 *                              Alumno : Ulises Jaramillo                                       *
 *                                                                                              *
 *                              Legajo : FAI-1698                                               *
 *                                                                                              *
 *                                                                                              *
 *----------------------------------------------------------------------------------------------*
 * Descripción:                                                                                 *
 *      Esta es la clase principal del trabajo práctico final de estructura 2018.               *
 *                                                                                              *
 *      Se desea desarrollar un sistema que brinde información del Mundial de Fútbol 2018 a     *
 *      disputarse en Rusia. El principal objetivo del sistema es brindar a los simpatizantes   *
 *      información sobre el evento y sugerir caminos para viajar de una sede a otra a ver a su *
 *      equipo favorito.                                                                        *
 * Métodos:                                                                                     *
 *      abmCiudades -- Alta, Baja o Modificación de Ciudades.                                   *
 *      abmEquipos -- Alta, Baja o Modificación de Equipos.                                     *
 *      altaPartidos -- Alta, Baja o Modificación de Partidos.                                  *
 *      consultaEquipos -- Consulta información sobre equipos de fútbol.                        *
 *      consultaCiudades -- Consulta información sobre Ciudades.                                *
 *      consultaViajes -- Consulta información sobre Viajes.                                    *
 *      tablaDePosiciones -- Genera un String con una tabla de posiciones del mundial.          *
 *      mostrarSistema -- Muestra por pantalla todas las estructuras usadas por el sistema.     *
 *      altaCiudad -- Da de alta una nueva ciudad.                                              *
 *      bajaCiudad -- Da de baja una ciudad.                                                    *
 *      modificarCiudad -- Modifica los datos de una ciudad.                                    *
 *      altaEquipo -- Da de alta un nuevo equipo.                                               *
 *      bajaEquipo -- Da de baja un equipo.                                                     *
 *      modificarEquipo -- Modifica la información de un equipo.                                *
 *      mostrarInfoEquipo -- Muestra por pantalla la información de un equipo.                  *
 *      mostrarEquiposEntre -- Muestra todos los equipos ord. alfabeticamente entre dos paises. *
 *      mostrarEquiposGolNeg -- Muestra todos los equipos que tienen goles en negativo.         *
 *      caminoMenorDist -- Muestra el camino entre dos ciudades con la menor distancia.         *
 *      caminoMinimaCantCiudades -- Muestra el camino entre dos ciudades con menos ciud. inter. *
 *      caminosPosibles -- Muestra todos los caminos posibles entre dos ciudades.               *
 *      caminoPasaOtraCiudad -- Camino con men. dist. entre dos ciud. pasando por otra          *
 *      menuViajes -- Muestra el menu de viajes.                                                *
 *      menuPrincipal -- Muestra el menu principal del sistema.                                 *
 *      cartel -- Muesta los datos del trabajo practico.                                        *
 *      menuABMCiudades -- Muestra el menu de Alta, baja, modificación de ciudades.             *
 *      menuABMEquipos -- Muestra el menu de Alta, baja, modificación de Equipos.               *
 *      menuAltaPartidos -- Muestra el menu de Alta Partidos.                                   *
 *      menuConsultaEquipos -- Muestra un menu para consulta de informacion sobre equipos.      *
 *      menuConsultaCiudad -- Muestra un menu para consulta de informacion sobre Ciudades.      *
 *      escribirLogEstructuras -- Escribe en un archivo "LOG", la info. de todas las estructuras*
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - **/
public class Mundial2018 {

    /**
     * @param args the command line arguments
     */
 /***********************************************************************************************
 * main                                                                                         *
 *                                                                                              *
 *              Dentro del main se realizan todas las creaciones de las estructuras necesarias  *
 *      para el funcionamiento del sistema.                                                     *
 *                                                                                              *
 *                                                                                              *                
 *==============================================================================================*/
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Grafo mapa = new Grafo();
        HashMap partidos = new HashMap();
        ArbolAVL equipos = new ArbolAVL();
        BufferedReader archivo = new BufferedReader(new FileReader("datos.txt"));               //carga el archivo con los datos necesarios.
        cargarSistema(mapa, equipos, partidos, archivo);                                        //carga los datos del archivo a las estructuras de datos.
        escribirLogEstructuras(mapa, equipos, partidos);                                        //escribe toda la informacion de las estructuras en su estado inicial en el archivo LOG.

        int opc = 0;

        cartel();                                                                               //cartel de presentación del trabajo práctico.

        do {
            menuPrincipal();                                                                    //muestra el menu principal del sistema.
            System.out.println("Ingrese la opcion deseada:");
            opc = TecladoIn.readLineInt();
            switch (opc) {
                case 1:                                                                         //ABM ciudades
                    abmCiudades(mapa);
                    break;
                case 2:                                                                         //ABM equipos
                    abmEquipos(equipos);
                    break;
                case 3:                                                                         //alta partidos
                    altaPartidos(partidos, equipos, mapa);
                    break;
                case 4:                                                                         //consulta equipos
                    consultaEquipos(equipos);
                    break;
                case 5:                                                                         //consulta ciudades
                    consultaCiudades(mapa);
                    break;
                case 6:                                                                         //consulta viajes
                    consultaViajes(mapa);
                    break;
                case 7:                                                                         //posiciones
                    System.out.println(tablaDePosiciones(equipos));
                    break;
                case 8:                                                                         //mostrar sistema
                    mostrarSistema(mapa, equipos, partidos);
                    break;
            }

        } while (opc != 9);
        escribirLogEstructuras(mapa, equipos, partidos);                                        //al finalizar el uso del sistema, escribe en el archivo LOG el estado final de las est.
    }
 /***********************************************************************************************
 * abmCiudades -- Alta, Baja o Modificación de Ciudades..                                       *
 *                                                                                              *
 *              Este método se encarga de ofrecer las opciones de ABM de las ciudades.          *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     mapa -- Mapa del mundial (grafo).                                               *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void abmCiudades(Grafo mapa) throws IOException {

        int opc = 0;
        do {
            menuABMCiudades();                                                                  //muestra el menu de abm ciudades.
            opc = TecladoIn.readLineInt();
            switch (opc) {
                case 1:
                                                                                                //Alta ciudades
                    altaCiudad(mapa);
                    break;
                case 2:
                                                                                                //baja ciudades
                    bajaCiudad(mapa);
                    break;
                case 3:
                                                                                                //modificacion ciudades
                    modificarCiudad(mapa);
                    break;
            }

        } while (opc != 4);
    }
 /***********************************************************************************************
 * abmEquipos -- Alta, Baja o Modificación de Equipos..                                         *
 *                                                                                              *
 *              Este método se encarga de ofrecer las opciones de ABM de los Equipos.           *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     equipos -- Equipos del mundial (Arbol de auto balance).                         *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void abmEquipos(ArbolAVL equipos) throws IOException {

        int opc = 0;
        do {
            menuABMEquipos();
            opc = TecladoIn.readLineInt();
            switch (opc) {
                case 1:                                                                         //Alta equipos
                    altaEquipo(equipos);
                    break;
                case 2:                                                                         //baja equipos
                    bajaEquipo(equipos);
                    break;
                case 3:                                                                         //modificacion equipo
                    modificarEquipo(equipos);
                    break;
            }

        } while (opc != 4);
    }
 /***********************************************************************************************
 * altaPartidos -- Alta de partidos.                                                            *
 *                                                                                              *
 *              Este método se encarga de la creación de los partidos.                          *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     equipos -- Equipos del mundial (Arbol de auto balance).                         *
 *              partidos -- estructura que almacena a todos los partidos jugados.               *
 *              mapa -- Mapa estructura que almacena las ciudades.                              *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void altaPartidos(HashMap partidos, ArbolAVL equipos, Grafo mapa) throws IOException {
        menuAltaPartidos();
        Partido partido = new Partido();
        System.out.println("Ingrese el equipo 1: ");
        String eq1 = TecladoIn.readLine();
        Equipo eqAux = new Equipo(eq1);                                                         //crea un equipo para poder hacer la busqueda en el arbolAVL
        Equipo equipo1 = null;                                                                  //crea una instancia de equipo para guardar la busqueda del equipo
        do {                                                                                    //verificar que los equipos existan
            equipo1 = (Equipo) equipos.obtenerElemento(eqAux);
            if (equipo1 == null) {
                System.out.println("El equipo no existe, por favor vuelva a intentar: ");
                eq1 = TecladoIn.readLine();
                eqAux.setNombre(eq1);
            }
        } while (equipo1 == null);
        partido.setEquipo1(eq1);
        System.out.println("Ingrese el equipo 2: ");
        String eq2 = TecladoIn.readLine();
        Equipo equipo2 = null;
        do {
            while (eq1.equalsIgnoreCase(eq2)) {                                                 //los dos equipos tienen que ser diferentes.
                System.out.println("Estas ingresando el mismo equipo, por favor vuelva a intentar: ");
                eq2 = TecladoIn.readLine();
            }
            eqAux.setNombre(eq2);
            equipo2 = (Equipo) equipos.obtenerElemento(eqAux);
            if (equipo2 == null) {
                System.out.println("El equipo no existe, por favor vuelva a intentar: ");
                eq2 = TecladoIn.readLine();
                eqAux.setNombre(eq2);
            }
        } while (equipo2 == null);
        partido.setEquipo2(eq2);
        System.out.println("Ingrese la ronda en la que se juega el partido: ");
        partido.setRonda(TecladoIn.readLine());                                                 //ademas los equipos no tienen que haber competido anteriormente en la misma fase.
        
        Ciudad ciudad = new Ciudad();                                                       //crea una ciudad auxiliar para realizar la busqueda en el mapa
        System.out.println("Ingrese la ciudad en la que compiten: ");
        String c = TecladoIn.readLine();
        ciudad.setNombre(c);
        while (!mapa.existeVertice(ciudad)) {                                               //verifica que la ciudad exista.
            System.out.println("La ciudad no existe, por favor intente nuevamente: ");
            c = TecladoIn.readLine();
            ciudad.setNombre(c);
        }

        partido.setCiudad(c);
        int goles = 0;
        do {
            System.out.println("Ingrese goles del equipo 1: ");
            goles = TecladoIn.readLineInt();
            partido.setGolesEq1(goles);
        } while (goles < 0);
        do {
            System.out.println("Ingrese goles del equipo 2: ");
            goles = TecladoIn.readLineInt();
            partido.setGolesEq2(goles);
        } while (goles < 0);
        Clave clave = new Clave();
        String stringClave = clave.generarClave(eq1, eq2);
        if (!partidos.containsKey(stringClave)) {           //verificar si el partido ya existe
            partidos.put(stringClave,partido);              //se genera la clave correspondiente y se almacena el partido
                                                                                                //se asignan los resultaados correspondientes a cada equipo para poder calcular sus puntos

            equipo1.agregarResultado(new Resultado(partido.getGolesEq1(), partido.getGolesEq2(), equipo2.getNombre()));//goles a favor, goles en contra, rival
            equipo2.agregarResultado(new Resultado(partido.getGolesEq2(), partido.getGolesEq1(), equipo1.getNombre()));
            System.out.println("Partido agregado");
            escribirLog("El usuario cargó el siguiente partido" + partido.toString());
        } else {
            System.out.println("Ya existe ese partido");
        }
    }
 /***********************************************************************************************
 * consultaEquipos -- Consulta información sobre equipos de fútbol.                             *
 *                                                                                              *
 *              Dado un país, mostrar toda la información disponible, incluyendo puntos ganados,*
 *          goles a favor y en contra, diferencia de goles y resultado de todos los partidos    *
 *          jugados.                                                                            *
 *          • Dadas dos cadenas (min y max) devolver todos los equipos cuyo nombre está en el   *
 *          rango [min, max]. Los valores de min y max pueden no estar en el árbol.             *
 *          • (*) Listar todos los equipos con diferencia de gol negativa.                      *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     equipos -- Equipos del mundial (Arbol de auto balance).                         *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void consultaEquipos(ArbolAVL equipos) throws IOException {
        int opc = 0;
        do {
            menuConsultaEquipos();
            opc = TecladoIn.readLineInt();
            switch (opc) {
                case 1:
                    mostrarInfoEquipo(equipos);
                    break;
                case 2:
                    mostrarEquiposEntre(equipos);
                    break;
                case 3:
                    mostrarEquiposGolNeg(equipos);
                    break;
            }

        } while (opc != 4);

    }
 /***********************************************************************************************
 * consultaCiudades -- Consulta información sobre ciudades.                                     *
 *                                                                                              *
 *              Dado un nombre de ciudad, mostrar toda su información                           *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     mapa -- Mapa del mundial.                                                       *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void consultaCiudades(Grafo mapa) throws IOException {
        int opc;
        do {
            menuConsultaCiudad();
            opc = TecladoIn.readLineInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingrese una ciudad: ");
                    Ciudad ciudad = null;
                    do {
                        ciudad = (Ciudad) mapa.obtenerVertice(new Ciudad(TecladoIn.readLine()));            //busca la ciudad en el mapa.
                        if (ciudad == null) {
                            System.out.println("La ciudad no existe, intente nuevamente: ");
                        }
                    } while (ciudad == null);
                    System.out.println("Datos de la ciudad: ");
                    System.out.println(ciudad.toString2());                                                 //muestra los datos.
                    escribirLog("El usuario hizo una consulta sobre una ciudad: " + ciudad.toString());
                    break;
                case 2:
                    System.out.println("Salir!");
            }
        } while (opc != 2);

    }
 /***********************************************************************************************
 * consultaViajes -- Consulta información sobre viajes.                                         *
 *                                                                                              *
 *              Consultas sobre viajes: Dada una ciudad A y una ciudad B:                       *
 *       • Obtener el camino que llegue de A a B de menor distancia en km                       *
 *       • Obtener el camino que llegue de A a B pasando por la mínima cantidad de ciudades     *
 *       • Obtener todos los caminos posibles para llegar de A a B                              *
 *       • (*) El camino más corto para llegar de A a B que pase por otra ciudad C              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     mapa -- Mapa del mundial.                                                       *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void consultaViajes(Grafo mapa) {
        int opc = 0;
        do {
            menuViajes();
            opc = TecladoIn.readLineInt();
            switch (opc) {
                case 1:                                                                         //camino con la menor distancia
                    caminoMenorDist(mapa);
                    break;
                case 2:                                                                         //Camino con la minima cantidad de ciudades
                    caminoMinimaCantCiudades(mapa);
                    break;
                case 3:                                                                         //Todos los caminos posibles
                    caminosPosibles(mapa);
                    break;
                case 4:                                                                         //Todos los caminos posibles
                    caminoPasaOtraCiudad(mapa);
                    break;
            }

        } while (opc != 5);

    }
 /***********************************************************************************************
 * tablaDePosiciones -- Genera un String con una tabla de posiciones del mundial.               *
 *                                                                                              *
 *              Obtener y mostrar la tabla de posiciones de los equipos de un momento dado,     *
 *          almacenando los datos de los equipos ordenados de mayor a menor puntaje             *
 *          (puede utilizar alguna estructura de datos auxiliar que considere apropiada,        *
 *          asegurando la eficiencia).                                                          *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     equipos -- Equipos que participan.                                              *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static String tablaDePosiciones(ArbolAVL equipos) throws IOException {
        String cadena = "";
        Lista lista = equipos.listarPreOrden();                                                 //Se crea una lista para después usarla en una tabla.
        ArbolHeap tabla = new ArbolHeap();
        int i;
        for (i = 1; i < lista.longitud(); i++) {                                                //se insertan los equipos en la tabla 
            tabla.insertar(new CapsulaEquipo((Equipo) lista.recuperar(i)));                     //se encapsula para poder ser comparadas por puntos.
        }
        cadena += "Tabla de posiciones\n";
        CapsulaEquipo eq;
        while (!tabla.esVacia()) {
            eq = (CapsulaEquipo) tabla.recuperarCima();                                         //se obtienen los elementos de la tabla para mostrarlas por pantalla.
            cadena += eq.toString();
            tabla.eliminarCima();
        }

        return cadena;
    }
    
 /***********************************************************************************************
 * mostrarSistema -- Muestra por pantalla todas las estructuras usadas por el sistema.          *
 *                                                                                              *
 *              Mostrar sistema: es una operación de debugging que permite ver todas las        *
 *          estructuras utilizadas con su contenido (grafo, AVL y Mapeo) para verificar, en     *
 *          cualquier momento de la ejecución del sistema, que se encuentren cargadas           *
 *          correctamente.                                                                      *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     equipos -- Equipos que participan.                                              *
 *              mapa -- Mapa del mundial.                                                       *
 *              partidos -- Partidos del mundial.                                               *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void mostrarSistema(Grafo mapa, ArbolAVL equipos, HashMap<String, String> partidos) {

        
        System.out.println(mapa.toString());
        System.out.println("************************************************");
        System.out.println(equipos.toString());
        System.out.println("************************************************");
        System.out.println(partidos.toString());

    }
 /***********************************************************************************************
 * altaCiudad -- Da de alta una nueva ciudad.                                                   *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     mapa -- Mapa del mundial.                                                       *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void altaCiudad(Grafo mapa) throws IOException {
        Ciudad ciudad = null;
        String nombre;
        System.out.println("Ingrese el nombre de la ciudad: ");
        do {
            nombre = TecladoIn.readLine();
            ciudad = (Ciudad) mapa.obtenerVertice(new Ciudad(nombre));
            if (ciudad != null) {                                                               //verifica si la ciudad ya existe.
                System.out.println("La ciudad ya existe, intente nuevamente.");
            }
        } while (ciudad != null);
        ciudad = new Ciudad(nombre);
        int cantidad = 0;
        do {
            System.out.println("Ingrese la cantidad de habitantes: ");
            cantidad = TecladoIn.readLineInt();
            if (cantidad < 0) {
                System.out.println("La cantidad de habitantes tiene que ser un numero positivo.");//la cantidad de habiatantes es un numero positivo
            }
        } while (cantidad < 0);
        ciudad.setPoblacion(cantidad);

        do {
            System.out.println("Ingrese la superficie de la ciudad: ");
            cantidad = TecladoIn.readLineInt();
            if (cantidad < 0) {
                System.out.println("La superficie tiene que ser un número positivo.");
            }
        } while (cantidad < 0);
        ciudad.setSuperficie(cantidad);
        char res;
        boolean sede = false;

        do {
            System.out.println("Ingrese S/N, si desea que la ciudad sea una sede del mundial, o no: ");
            res = TecladoIn.readLineNonwhiteChar();
            if (res == 'S'|| res == 's') {
                sede = true;
            }

        } while (res != 'S' && res != 'N' && res != 's' && res != 'n');
        ciudad.setSede(sede);

        if (mapa.insertarVertice(ciudad)) {
            System.out.println("Se ha agregado una nueva ciudad");
            escribirLog("Se ha agregado una nueva ciudad" + ciudad.toString2());
        } else {
            System.out.println("ha ocurrido un error, intente nuevamente.");
        }
        Ciudad ciudad2 = null;
        do {
            System.out.println("Desea agregar rutas a ciudades vecinas S/N?");
            res = TecladoIn.readLineNonwhiteChar();
            if (res == 'S' || res == 's') {
                System.out.println("Ingrese el nombre de la ciudad vecina: ");
                do {
                    nombre = TecladoIn.readLine();
                    ciudad2 = (Ciudad) mapa.obtenerVertice(new Ciudad(nombre));
                    if (ciudad2 == null) {                                                               //verifica si la ciudad ya existe.
                        System.out.println("La ciudad NO existe, intente nuevamente.");
                    }
                } while (ciudad2 == null);
                int longitud;
                do {
                    System.out.println("Ingrese la longitud de la ruta: ");
                    longitud = TecladoIn.readLineInt();
                    if (longitud < 0) {
                        System.out.println("La longitud tiene que ser un número positivo.");
                    }
                } while (cantidad < 0);
                if (mapa.insertarArco(ciudad, ciudad2, longitud)){
                    System.out.println("ruta agregada!");
                    res='x';
                }
                
            }

        } while (res != 'S' && res != 'N' && res != 's' && res != 'n');

    }
 /***********************************************************************************************
 * bajaCiudad -- Da de baja una  ciudad.                                                        *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     mapa -- Mapa del mundial.                                                       *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void bajaCiudad(Grafo mapa) throws IOException {
        Ciudad ciudad = null;
        do {
            System.out.println("Ingrese el nombre de la ciudad: ");
            ciudad = (Ciudad) mapa.obtenerVertice(new Ciudad(TecladoIn.readLine()));
            if (ciudad == null) {
                System.out.println("La ciudad no existe, intente nuevamente: ");
            }
        } while (ciudad == null);
        if (mapa.eliminarVertice(ciudad)) {
            System.out.println("Se ha eliminado la ciudad");
            escribirLog("Se ha eliminado la ciudad " + ciudad.toString());
        } else {
            System.out.println("ha ocurrido un error, intente nuevamente.");
        }

    }
 /***********************************************************************************************
 * modificarCiudad -- Modifica los datos de una ciudad.                                         *
 *                 Este método se encarga de modificar todos los datos de una ciudad, teniendo  *
 *          en cuenta las verificaciones para que la información sea correcta.                  *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     mapa -- Mapa del mundial.                                                       *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void modificarCiudad(Grafo mapa) throws IOException {
        Ciudad ciudad = null;
        System.out.println("Ingrese el nombre de la ciudad: ");
        do {
            ciudad = (Ciudad) mapa.obtenerVertice(new Ciudad(TecladoIn.readLine()));
            if (ciudad == null) {
                System.out.println("La ciudad no existe, intente nuevamente.");
            }
        } while (ciudad == null);
        int cantidad = 0;
        do {
            System.out.println("Ingrese la cantidad de habitantes: ");
            cantidad = TecladoIn.readLineInt();
            if (cantidad < 0) {
                System.out.println("La cantidad de habitantes tiene que ser un numero positivo.");
            }
        } while (cantidad < 0);
        ciudad.setPoblacion(cantidad);

        do {
            System.out.println("Ingrese la superficie de la ciudad: ");
            cantidad = TecladoIn.readLineInt();
            if (cantidad < 0) {
                System.out.println("La superficie tiene que ser un número positivo.");
            }
        } while (cantidad < 0);
        ciudad.setSuperficie(cantidad);
        char res;
        boolean sede = false;

        do {
            System.out.println("Ingrese S/N, si desea que la ciudad sea una sede del mundial, o no: ");
            res = TecladoIn.readLineNonwhiteChar();
            if (res == 'S' && res == 's') {
                sede = true;
            }

        } while (res != 'S' && res != 'N' && res != 's' && res != 'n');
        ciudad.setSede(sede);
        //como la ciudad ya está en el mapa, no hace falta insertarla nuevamente
        System.out.println("Se ha modificado la ciudad");
        escribirLog("Se ha modificado la ciudad " + ciudad.toString());
    }
 /***********************************************************************************************
 * altaEquipo -- Da de alta un nuevo equipo                                                     *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     equipos -- Equipos que participan en el mundial.                                *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void altaEquipo(ArbolAVL equipos) throws IOException {
        Equipo equipo = new Equipo();
        String nombre;
        boolean exito = false;

        do {
            System.out.println("Ingrese un nombre para el equipo: ");
            nombre = TecladoIn.readLine();
            nombre = nombre.toUpperCase();
            equipo.setNombre(nombre);
            while (equipos.existeElemento(equipo)) {
                System.out.println("El equipo ya existe, intente nuevamente: ");
                System.out.println("Ingrese un nombre para el equipo: ");
                nombre = TecladoIn.readLine();
                nombre = nombre.toUpperCase();
                equipo.setNombre(nombre);
            }
            System.out.println("Ingrese un nombre para el Director Técnico: ");
            equipo.setDirector(TecladoIn.readLine());
            exito = equipos.insertar(equipo);
            if (exito) {
                System.out.println("Se ha agregado un nuevo equipo");
                escribirLog("Se ha agregado un nuevo equipo " + equipo.toString2());
            } else {
                System.out.println("El equipo ya existe, intente nuevamente");
            }
        } while (!exito);

    }
 /***********************************************************************************************
 * bajaEquipo -- Da de baja un equipo.                                                          *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     equipos -- Equipos que participan en el mundial.                                *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void bajaEquipo(ArbolAVL equipos) throws IOException {
        Equipo equipo = null;
        System.out.println("Ingrese un nombre para el equipo: ");
        do {
            //equipo.setNombre(TecladoIn.readLine());
            equipo = (Equipo) equipos.obtenerElemento(new Equipo(TecladoIn.readLine()));
            if (equipo == null) {
                System.out.println("El equipo no existe, intente nuevamente");
            }
        } while (equipo == null);
        if (equipos.eliminar(equipo)) {
            System.out.println("Equipo eliminado");
            
            Lista lista = equipos.listarInOrden();                              //obtiene una lista de todos los equipos.
            int i;
            for(i=1;i<=lista.longitud();i++){
                Equipo eq = (Equipo)lista.recuperar(i);
                eq.eliminarResultado(new Resultado(equipo.getNombre()));        //elimina resultados de los equipos que han jugado con el equipo eliminado
                
            }
            
            
            System.out.println("El equipo ha sido eliminado");                                   
            escribirLog("Se ha eliminado equipo " + equipo.toString());                         
        } else {
            System.out.println("ha ocurrido un error, intente nuevamente.");
        }
    }
 /***********************************************************************************************
 * modificarEquipo -- Modifica la información de un equipo.                                     *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     equipos -- Equipos que participan en el mundial.                                *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void modificarEquipo(ArbolAVL equipos) throws IOException {
        Equipo equipo = null;
        String nombre;
        do {
            System.out.println("Ingrese un nombre de equipo: ");
            nombre = TecladoIn.readLine();
            nombre = nombre.toUpperCase();
            equipo = (Equipo) equipos.obtenerElemento(new Equipo(nombre));
            if (equipo == null) {
                System.out.println("El equipo no existe, intente nuevamente");
            }
        } while (equipo == null);
        System.out.println("Ingrese un nuevo nombre para el equipo: ");
        nombre = TecladoIn.readLine();
        nombre = nombre.toUpperCase();
        equipo.setNombre(nombre);
        System.out.println("Ingrese un nuevo Director Técnico: ");
        equipo.setDirector(TecladoIn.readLine());
        equipos.eliminar(equipo);                                               //elimina el equipo a modificar
        equipos.insertar(equipo);                                               //lo agrega nuevamente para poder reordenar la estructura
        escribirLog("Se ha se ha modificado el  equipo " + equipo.toString2());

    }
 /***********************************************************************************************
 * mostrarInfoEquipo -- Muestra por pantalla la información de un equipo.                       *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     equipos -- Equipos que participan en el mundial.                                *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void mostrarInfoEquipo(ArbolAVL equipos) throws IOException {
        System.out.println("Ingrese un equipo");
        Equipo equipo = null;
        do {
            String eq = TecladoIn.readLine();
            eq = eq.toUpperCase();
            equipo = (Equipo) equipos.obtenerElemento(new Equipo(eq));
            if (equipo == null) {
                System.out.println("El equipo no existe, intente nuevamente: ");
            }

        } while (equipo == null);
        System.out.println(equipo.toString2());
        System.out.println("Equipos contra los cuales jugó!:");
        System.out.println(equipo.getResultados().toString());

    }
 /***********************************************************************************************
 * mostrarEquiposEntre -- Muestra todos los equipos ord. alfabeticamente entre dos paises.      *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     equipos -- Equipos que participan en el mundial.                                *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void mostrarEquiposEntre(ArbolAVL equipos) {
        System.out.println("ingrese una palabra:");
        String pais1 = TecladoIn.readLine();
        Equipo eqAux1 = new Equipo(pais1);
        System.out.println("Ingrese otra palabra:");
        String pais2 = TecladoIn.readLine();
        Equipo eqAux2 = new Equipo(pais2);
        System.out.println(equipos.listarRango(eqAux1, eqAux2).toString());
    }
 /***********************************************************************************************
 * mostrarEquiposGolNeg -- Muestra todos los equipos que tienen goles en negativo.              *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     equipos -- Equipos que participan en el mundial.                                *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void mostrarEquiposGolNeg(ArbolAVL equipos) {
        //pedir lista de equipos
        Lista lista = equipos.listarInOrden();
        //recorrer lista teniendo en cuenta los goles negativos
        int i,limite=lista.longitud();
       
        for(i=1;i<= limite;i++){// desapilar lista para mejorar eficiencia
            Equipo eq = (Equipo)lista.recuperar(1);
            lista.eliminar(1);
            if((eq.getGolesFavor() - eq.getGolesContra()) < 0){
                System.out.println(eq.toString());
            }
        }
    }
 /***********************************************************************************************
 * caminoMenorDist -- Muestra el camino entre dos ciudades con la menor distancia.              *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     mapa -- Mapa del mundial.                                                       *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void caminoMenorDist(Grafo mapa) {
        System.out.println("Ingrese una ciudad (Origen): ");
        Ciudad ciudadA = null;
        Ciudad ciudadB = null;
        Camino camino;
        do {
            ciudadA = (Ciudad) mapa.obtenerVertice(new Ciudad(TecladoIn.readLine()));
            if (ciudadA == null) {
                System.out.println("La ciudad no existe, intente nuevamente: ");
            }
        } while (ciudadA == null);
        System.out.println("Ingrese una ciudad (Destino): ");
        do {
            ciudadB = (Ciudad) mapa.obtenerVertice(new Ciudad(TecladoIn.readLine()));
            if (ciudadB == null) {
                System.out.println("La ciudad no existe, intente nuevamente: ");
            }
        } while (ciudadB == null);
        camino = mapa.caminoMasCorto(ciudadA, ciudadB);
        System.out.println(camino.toString());

    }
 /***********************************************************************************************
 * caminoMinimaCantCiudades -- Muestra el camino entre dos ciudades con menos ciud. inter.      *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     mapa -- Mapa del mundial.                                                       *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void caminoMinimaCantCiudades(Grafo mapa) {
        System.out.println("Ingrese una ciudad (Origen): ");
        Ciudad ciudadA = null;
        Ciudad ciudadB = null;
        Camino camino;
        do {
            ciudadA = (Ciudad) mapa.obtenerVertice(new Ciudad(TecladoIn.readLine()));
            if (ciudadA == null) {
                System.out.println("La ciudad no existe, intente nuevamente: ");
            }
        } while (ciudadA == null);
        System.out.println("Ingrese una ciudad (Destino): ");
        do {
            ciudadB = (Ciudad) mapa.obtenerVertice(new Ciudad(TecladoIn.readLine()));
            if (ciudadB == null) {
                System.out.println("La ciudad no existe, intente nuevamente: ");
            }
        } while (ciudadB == null);
        camino = mapa.caminoMenorNodos(ciudadA, ciudadB);
        System.out.println(camino.toString());

    }
 /***********************************************************************************************
 * caminosPosibles -- Muestra todos los caminos posibles entre dos ciudades.                    *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     mapa -- Mapa del mundial.                                                       *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void caminosPosibles(Grafo mapa) {
        System.out.println("Ingrese una ciudad (Origen): ");
        Ciudad ciudadA = null;
        Ciudad ciudadB = null;
        Lista lista;
        do {
            ciudadA = (Ciudad) mapa.obtenerVertice(new Ciudad(TecladoIn.readLine()));
            if (ciudadA == null) {
                System.out.println("La ciudad no existe, intente nuevamente: ");
            }
        } while (ciudadA == null);
        System.out.println("Ingrese una ciudad (Destino): ");
        do {
            ciudadB = (Ciudad) mapa.obtenerVertice(new Ciudad(TecladoIn.readLine()));
            if (ciudadB == null) {
                System.out.println("La ciudad no existe, intente nuevamente: ");
            }
        } while (ciudadB == null);
        lista = mapa.caminosPosibles(ciudadA, ciudadB);
        System.out.println(lista.toString());
    }
 /***********************************************************************************************
 * caminoPasaOtraCiudad -- Camino con men. dist. entre dos ciud. pasando por otra.              *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     mapa -- Mapa del mundial.                                                       *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void caminoPasaOtraCiudad(Grafo mapa) {
        System.out.println("Ingrese una ciudad (Origen): ");
        Ciudad ciudadA = null;
        Ciudad ciudadB = null;
        Ciudad ciudadC = null;
        Camino camino;
        do {
            ciudadA = (Ciudad) mapa.obtenerVertice(new Ciudad(TecladoIn.readLine()));
            if (ciudadA == null) {
                System.out.println("La ciudad no existe, intente nuevamente: ");
            }
        } while (ciudadA == null);
        System.out.println("Ingrese una ciudad (Destino): ");
        do {
            ciudadB = (Ciudad) mapa.obtenerVertice(new Ciudad(TecladoIn.readLine()));
            if (ciudadB == null) {
                System.out.println("La ciudad no existe, intente nuevamente: ");
            }
        } while (ciudadB == null);
        System.out.println("Ingrese una ciudad (ciudad intermedia): ");
        do {
            ciudadC = (Ciudad) mapa.obtenerVertice(new Ciudad(TecladoIn.readLine()));
            if (ciudadC == null) {
                System.out.println("La ciudad no existe, intente nuevamente: ");
            }
        } while (ciudadC == null);
        camino = mapa.caminoMasCortoPorTresNodos(ciudadA, ciudadB, ciudadC);
        System.out.println(camino.toString());
    }
 /***********************************************************************************************
 * menuViajes -- Muestra el menu de viajes.                                                     *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     Ninguno.                                                                        *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void menuViajes() {
        System.out.println("		**Consulta sobre viajes**\n"
                + "1.- Viajes con la menor distancia entre dos ciudades\n"
                + "2.- Viajes con la menor cantidad de ciudades entre dos lugares\n"
                + "3.- Todos los viajes posibles entre dos ciudades\n"
                + "4.- Viajes entre dos ciudades pasando por una ciudad intermedia\n"
                + "5.- Salir");
    }
 /***********************************************************************************************
 * menuPrincipal -- Muestra el menu Principal del sistema.                                      *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     Ninguno.                                                                        *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    public static void menuPrincipal() {
        System.out.println("		**Menu principal**\n"
                + "\n"
                + "1.-Alta baja modificacion de ciudades\n"
                + "2.-Alta baja modificacion de equipos\n"
                + "3.-Alta de partidos\n"
                + "4.-Consultas sobre equipos\n"
                + "5.-Consultas sobre ciudades\n"
                + "6.-Consultas sobre viajes\n"
                + "7.-Tabla de posiciones\n"
                + "8.-Mostrar Sistema\n"
                + "9.-Salir del sistema");
    }
 /***********************************************************************************************
 * cartel -- Muestra el un cartel de presentacion del trabajo práctico.                         *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     Ninguno.                                                                        *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    public static void cartel() {
        System.out.println("************************************************************\n"
                + "**		Trabajo Practico final 2018   		  **\n"
                + "**							  **\n"
                + "**		     Mundial Rusia 2018			  **\n"
                + "**							  **\n"
                + "**Alumno: Ulises Jaramillo				  **\n"
                + "**Legajo: FAI-1698					  **\n"
                + "************************************************************");
    }
 /***********************************************************************************************
 * menuABMCiudades -- Muestra el menu de Alta, baja, modificación de ciudades.                  *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     Ninguno.                                                                        *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    public static void menuABMCiudades() {
        System.out.println("**ABM ciudades**\n"
                + "1.-Agregar Ciudad\n"
                + "2.-Eliminar Ciudad\n"
                + "3.-Modificar Ciudad\n"
                + "4.-Salir");
    }
 /***********************************************************************************************
 * menuABMEquipos -- Muestra el menu de Alta, baja, modificación de Equipos.                    *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     Ninguno.                                                                        *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    public static void menuABMEquipos() {
        System.out.println("		**ABM Equipos**\n"
                + "1.-Agregar Equipos\n"
                + "2.-Eliminar Equipos\n"
                + "3.-Modificar Equipos\n"
                + "4.-Salir");
    }
 /***********************************************************************************************
 * menuAltaPartidos -- Muestra el menu de Alta Partidos.                                        *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     Ninguno.                                                                        *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    public static void menuAltaPartidos() {
        System.out.println("		**Alta Partidos**");
    }
 /***********************************************************************************************
 * menuConsultaEquipos -- Muestra un menu para consulta de informacion sobre equipos.           *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     Ninguno.                                                                        *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void menuConsultaEquipos() {
        System.out.println("		**Consulta sobre equipos**\n"
                + "1.-Mostrar toda la Informacion sobre un equipo.\n"
                + "2.-Dadas dos cadenas (min y max), obtener todos los equipos que estén en ese rango.\n"
                + "3.-Mostrar todos los equipos con diferencia de goles negativa\n"
                + "4.-Salir");
    }
 /***********************************************************************************************
 * menuConsultaCiudad -- Muestra un menu para consulta de informacion sobre Ciudades.           *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     Ninguno.                                                                        *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void menuConsultaCiudad() {
        System.out.println("**Consulta sobre ciudades**\n"
                + "1.-Mostrar toda la informacion de una ciudad.\n"
                + "2.-Salir");
    }
 /***********************************************************************************************
 * escribirLogEstructuras -- Escribe en un archivo "LOG", la info. de todas las estructuras.    *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     mapa --  Mapa del mundial.                                                      *
 *              equipos -- Equipos del mundial.                                                 *
 *              partidos -- que participan.                                                     *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private static void escribirLogEstructuras(Grafo mapa, ArbolAVL equipos, HashMap<String, String> partidos) throws IOException {
        escribirLog(mapa.toString());
        escribirLog(equipos.toString());
        escribirLog(partidos.toString());
        escribirLog(tablaDePosiciones(equipos));
    }

}