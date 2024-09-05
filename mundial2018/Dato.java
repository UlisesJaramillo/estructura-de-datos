/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundial2018;

import estructuras.ArbolAVL;
import estructuras.Cola;
import estructuras.Grafo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

/************************************************************************************************
 ***                     TRABAJO PRACTICO   ---  ESTRUCTURA DE DATOS                          ***
 ************************************************************************************************
 *                                                                                              *
 *                 Nombre del proyecto : Mundial Rusia 2018                                     *
 *                                                                                              *
 *                  Nombre del Archivo : Dato.java                                              *
 *                                                                                              *
 *                              Alumno : Ulises Jaramillo                                       *
 *                                                                                              *
 *                              Legajo : FAI-1698                                               *
 *                                                                                              *
 *                                                                                              *
 *----------------------------------------------------------------------------------------------*
 * Descripción:                                                                                 *
 *      Esta clase es creada para organizar todo lo que tiene que ver con los datos del trabajo *
 *      práctico, tanto la carga de todas las estructuras como la organizacion de los mismos y  *
 *      además, me permite trabajar con la escritura de un archivo LOG, para manejar todas las  *
 *      modificaciones del programa.                                                            *
 * Métodos:                                                                                     *
 *      cargarSistema -- Carga los datos en las estructuras de datos.                           *
 *      cargarCola -- carga una linea de datos.                                                 *
 *      cargarCiudades -- Método para cargar las ciudades a un grafo.                           *
 *      cargarEquipos -- Método para cargar los equipos a un arbolAVL.                          *
 *      cargarPartidos -- Método para cargar los partidos al HashMap.                           *
 *      cargarRutas -- Método para cargar las rutas en el grafo.                                *
 *      escribirLog -- Método que escribe en el documento LOG.                                  *
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - **/
public class Dato {
    private static Clave clave;
    
    public Dato(){
        
    }
    
    
 /***********************************************************************************************
 * cargarSistema -- Carga los datos en las estructuras de datos.                                *
 *                                                                                              *
 *              Este método se encarga de cargar todos los datos correspondientes en el sistema.*
 *          también se encarga de escribir en el archivo LOG, con fecha y hora de las           *
 *          modificaciones que se le hagan al sistema.                                          *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     mapa -- Mapa del mundial (grafo).                                               *
 *              equipos -- Son los equipos( selecciones) que participan.                        *
 *              partidos -- Son los partidos que se llevan a cabo.                              *
 *              archivo -- Archivo del cual se extraen los datos del trabajo practico.          *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Es un método estático.                                                            *
 *                                                                                              *                
 *==============================================================================================*/
    public static void cargarSistema(Grafo mapa,ArbolAVL equipos,HashMap partidos,BufferedReader archivo){
        char tipo;
        try {
            String dato = archivo.readLine();                                                   //carga una linea de datos desde el archivo de texto
            Cola cola = new Cola();
            clave = new Clave();
            do {
                tipo = dato.charAt(0);                                                          //carga el primer caracter de una linea de datos proveniente del archivo de texto, 
                cargarCola(dato, cola);                                                         //sirve para determinar que tipo de dato se va a almacenar.
                switch (tipo) {
                    case 'C': {
                        cargarCiudades(cola, mapa);
                        break;
                    }
                    case 'E': {
                        cargarEquipos(cola, equipos);
                        break;
                    }
                    case 'P': {
                        cargarPartidos(cola, equipos, partidos);
                        break;
                    }
                    case 'R': {
                        cargarRutas(cola, mapa);
                        break;
                    }
                }
            } while ((dato = archivo.readLine()) != null);
        } catch (IOException ex) {
            
        }
    }
    
    
 /***********************************************************************************************
 * cargarCola -- Carga una linea de datos.                                                      *
 *                                                                                              *
 *              Este metodo recibe una cadena con una linea de datos, puede ser una selección,  *
 *          un equipo, etc. luego se desarma la cadena para extraer cada dato, por ejemplo      *
 *          el nombre del pais, su director tecnico etc. usando como banderas los simbolos      *
 *          ":" y ";". Todos esos datos son almacenados en una cola para luego ser usados en    *
 *          la carga correspondiente.                                                           *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     dato -- Linea de datos a cargar.                                                *
 *              cola -- Cola a cargar con cada dato obtenido.                                   *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Es un método estático.                                                            *
 *                                                                                              *                
 *==============================================================================================*/
    private static void cargarCola(String dato, Cola cola) {
        String cadena;
        dato = dato.substring(dato.indexOf(":") + 2);
        int limite = dato.indexOf(";");
        while (limite != -1) {                                                                  //sino encuentra ";" devuelve -1.
            cadena = dato.substring(0, limite);                                                 //corta la cadena desde el origen hasta la bandera, para poder usar el dato de forma separada.
            cola.poner(cadena);
            dato = dato.substring(limite + 2, dato.length());                                   //remueve la cadena usada anteriormente.
            limite = dato.indexOf(";");                                                         //actualiza el nuevo limite, que es la siguiente bandera.
        }
        cola.poner(dato);
    }
    
    
 /***********************************************************************************************
 * cargarCiudades -- Método para cargar las ciudades a un grafo.                                *
 *                                                                                              *
 *              Este método recibe como parametro una cola con datos de una ciudad.             *
 *          Las ciudades que conforman el mapa, los enlaces o rutas se cargan con otro metodo   *
 *          de ésta misma clase.                                                                *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     mapa -- Mapa a cargar.                                                          *
 *              cola -- Cola de donde se extraen los datos.                                     *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Es un método estático.                                                            *
 *                                                                                              *                
 *==============================================================================================*/
    private static void cargarCiudades(Cola cola, Grafo mapa) {
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre(((String) cola.obtenerFrente()).toUpperCase());                        //se asegura que los datos se almacenen en mayuscula.(ver TP).
        cola.sacar();
        ciudad.setSuperficie(Double.parseDouble((String) cola.obtenerFrente()));
        cola.sacar();
        ciudad.setPoblacion(Integer.parseInt((String) cola.obtenerFrente()));
        cola.sacar();
        if (((String)cola.obtenerFrente()).equalsIgnoreCase("TRUE")) {
            ciudad.setSede(true);
        } else {
            ciudad.setSede(false);
        }
        cola.sacar();
        mapa.insertarVertice(ciudad);
        
    }
    
    
 /***********************************************************************************************
 * cargarEquipos -- Método para cargar los equipos a un arbolAVL.                               *
 *                                                                                              *
 *              En éste método recibe una cola con datos correspondientes a los equipos         *
 *          de futbol (selecciones) y se los carga a una estructura de tipo ArbolAVL.           *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     equipos -- Arbol a cargar.                                                      *
 *              cola -- Cola de donde se extraen los datos.                                     *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Es un método estático.                                                            *
 *                                                                                              *                
 *==============================================================================================*/
    private static void cargarEquipos(Cola cola, ArbolAVL equipos) {
        Equipo equipo = new Equipo();
        equipo.setNombre(((String) cola.obtenerFrente()).toUpperCase());
        cola.sacar();
        equipo.setDirector(((String) cola.obtenerFrente()).toUpperCase());
        cola.sacar();
        equipo.setPuntos(Integer.parseInt(cola.obtenerFrente().toString()));
        cola.sacar();
        equipo.setGolesFavor(Integer.parseInt(cola.obtenerFrente().toString()));
        cola.sacar();
        equipo.setGolesContra(Integer.parseInt(cola.obtenerFrente().toString()));
        cola.sacar();
        equipos.insertar(equipo);
    }
    
    
 /***********************************************************************************************
 * cargarPartidos -- Método para cargar los partidos al HashMap.                                *
 *                                                                                              *
 *              Este método carga los partidos en una estructura implementada por Java (HashMap)*
 *          los partidos se crean vinculando dos equipos, y una ciudad.                         *
 *          además se extrae de la cola los datos necesarios para cargar los partidos.          *
 *          Luego para poder crear un partido, es necesario que ya exitstan en las estructuras  *
 *          las ciudades y los equipos.                                                         *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     equipos -- Arbol a cargar.                                                      *
 *              partidos -- Estructura HashMap a cargar.                                        *
 *              cola -- Cola de donde se extraen los datos.                                     *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Es un método estático.                                                            *
 *                                                                                              *                
 *==============================================================================================*/
    private static void cargarPartidos(Cola cola, ArbolAVL equipos, HashMap partidos) {
        Partido partido = new Partido();
        Equipo eq1 = (Equipo) equipos.obtenerElemento(new Equipo((String) cola.obtenerFrente()));
        cola.sacar();
        partido.setEquipo1(eq1.getNombre());
        Equipo eq2 = (Equipo) equipos.obtenerElemento(new Equipo((String) cola.obtenerFrente()));
        cola.sacar();
        partido.setEquipo2(eq2.getNombre());        
        partido.setRonda(((String) cola.obtenerFrente()).toUpperCase());
        cola.sacar();
        partido.setCiudad(((String) cola.obtenerFrente()).toUpperCase());
        cola.sacar();
        partido.setGolesEq1(Integer.parseInt((String) cola.obtenerFrente()));
        cola.sacar();        
        partido.setGolesEq2(Integer.parseInt((String) cola.obtenerFrente()));
        cola.sacar();
                                                                                                //para colocar un partido en el HashMap necesitamos generar una clave que depende de 
                                                                                                //los nombres de los dos equipos que compiten en el partido.
        
        partidos.put(clave.generarClave(eq1.getNombre(), eq2.getNombre()), partido);                
        eq1.agregarResultado(new Resultado(partido.getGolesEq1(),partido.getGolesEq2(),eq2.getNombre()));//goles a favor, goles en contra, rival
        eq2.agregarResultado(new Resultado(partido.getGolesEq2(),partido.getGolesEq1(),eq1.getNombre()));
        
    }
 /***********************************************************************************************
 * cargarRutas -- Método para cargar las rutas en el grafo.                                     *
 *                                                                                              *
 *              En este metodo se crean las rutas que conectan las ciudades en el mapa.         *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     mapa -- Mapa a cargar.                                                          *
 *              cola -- Cola de donde se extraen los datos.                                     *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Es un método estático.                                                            *
 *                                                                                              *                
 *==============================================================================================*/
    private static void cargarRutas(Cola cola, Grafo mapa) {
        String origen, destino;
        int distancia;
        origen = (String) cola.obtenerFrente();
        cola.sacar();
        destino = (String) cola.obtenerFrente();
        cola.sacar();
        distancia = Integer.parseInt((String) cola.obtenerFrente());
        mapa.insertarArco(new Ciudad(origen.toUpperCase()), new Ciudad(destino.toUpperCase()), distancia);//se crea una ciudad, solo para la busqueda de las ciudades en el mapa
        cola.sacar();
        
    }
    
    
 /***********************************************************************************************
 * escribirLog -- Método que escribe en el documento LOG.                                       *
 *                                                                                              *
 *              Este metodo sirve para que las diferentes clases puedan escribir informacion    *
 *          en el archivo LOG.                                                                  *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     cadena -- Información a guardar en el archivo.                                  *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Es un método estático.                                                            *
 *                                                                                              *                
 *==============================================================================================*/
    public static void escribirLog(String cadena) throws IOException{
        try ( 
                BufferedWriter bufferW = new BufferedWriter(new FileWriter("LOG.txt", true))) {
            LocalDateTime dateNTime = LocalDateTime.now();
            bufferW.write("<"+dateNTime+">  : "+cadena);                                        //a cada modificacion, se le agrega la fecha y hora.
            bufferW.newLine();
        }
    }
}
