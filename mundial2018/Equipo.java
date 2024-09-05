/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundial2018;


import estructuras.Lista;
import java.lang.Comparable;

/************************************************************************************************
 ***                     TRABAJO PRACTICO   ---  ESTRUCTURA DE DATOS                          ***
 ************************************************************************************************
 *                                                                                              *
 *                 Nombre del proyecto : Mundial Rusia 2018                                     *
 *                                                                                              *
 *                  Nombre del Archivo : Equipo.java                                            *
 *                                                                                              *
 *                              Alumno : Ulises Jaramillo                                       *
 *                                                                                              *
 *                              Legajo : FAI-1698                                               *
 *                                                                                              *
 *                                                                                              *
 *----------------------------------------------------------------------------------------------*
 * Descripción:                                                                                 *
 *      Clase que implementa a los equipos.                                                     *
 * Métodos:                                                                                     *
 *      getDirector -- Obtiene el nombre del director técnico.                                  *
 *      setDirector -- Pone el nombre del director técnico.                                     *
 *      getResultados -- Obtiene la lista de resultados del equipo.                             *
 *      setResultados -- Pone una lista de resultados al equipo.                                *
 *      getPuntos --                                                                            *
 *      setPuntos --                                                                            *
 *      getGolesFavor --                                                                        *
 *      setGolesFavor --                                                                        *
 *      getGolesContra --                                                                       *
 *      setGolesContra --                                                                       *
 *      getNombre --                                                                            *
 *      setNombre --                                                                            *
 *      equals -- determina si dos equipos son iguales en base al nombre.                       *
 *      compareTo -- Método de comparación de los equipos.                                      *
 *      agregarResultado -- Agrega un resultado a la lista de resultados.                       *
 *      eliminarResultado -- Elimina un resultado de la lista de resultados.                    *
 *      toString -- Muestra por pantalla el equipo.                                             *
 *      toString2 -- Método alternativo de toString.                                            *
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - **/
public class Equipo implements Comparable<Equipo>{
    private String nombre="";
    private String director="";
    private Lista resultados;
    private int puntos=0;
    private int golesFavor=0;
    private int golesContra=0;

    public Equipo(String nombre) {
        this.nombre=nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Lista getResultados() {
        return resultados;
    }

    public void setResultados(Lista eqContrarios) {
        this.resultados = eqContrarios;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Equipo() {
        this.resultados = new Lista();
    }

    public Equipo(String director, Lista eqContrarios, int puntos, int golesFavor, int golesContra) {
        this.director = director;
        this.resultados = eqContrarios;
        this.puntos = puntos;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
    }

    public Equipo(String director, int puntos, int golesFavor, int golesContra) {
        this.director = director;
        this.resultados = new Lista();
        this.puntos = puntos;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
    }

    @Override
    public boolean equals(Object obj) {
        Equipo eq = (Equipo) obj;
        return this.nombre.equalsIgnoreCase(eq.getNombre());
    }

    @Override
    public int compareTo(Equipo eq) {
        return this.nombre.compareToIgnoreCase(eq.getNombre());
    }
    
    
 /***********************************************************************************************
 * agregarResultado -- Agregar resultado en la Lista de resultados.                             *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     resultado -- Resultado de un Partido.                                           *
 *                                                                                              *
 * SALIDA:  Booleano.                                                                           *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    public boolean agregarResultado(Resultado resultado) {
        boolean exito = false;
        exito = this.resultados.insertar(resultado,this.resultados.longitud()+1);               //obtener la cantidad de goles del resultado y almacenarlos
        
        this.golesFavor+=resultado.getGolesFavor();                                                   
        this.golesContra+=resultado.getGolesContra();
        if(this.golesFavor>this.golesContra){                                                   //según la cantidad de goles en contra y a favor, determinamos los puntos obtenidos.
            this.puntos+=3;
        }else if(this.golesFavor==this.golesContra){
            this.puntos+=1;
        }
               
        
        return exito;
    }
    
    
 /***********************************************************************************************
 * eliminarResultado -- Elimina un resultado de la lista de resultados.                         *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     resultado -- Resultado a eliminar.                                              *
 *                                                                                              *
 * SALIDA:  Booleano.                                                                           *
 *                                                                                              *
 * ALERTAS:   Ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    public boolean eliminarResultado(Resultado resultado){
        boolean exito=false;
        if(this.resultados.eliminarApariciones(resultado)){
            exito=true;
            if(resultado.getGolesContra()<resultado.getGolesFavor()){
                this.puntos-=3;
            }else if(resultado.getGolesContra()==resultado.getGolesFavor()){
                this.puntos-=1;
            }
        }
        return exito;
    }
    @Override
    public String toString(){
        return this.nombre;
    }
    
    public String toString2(){
        return "Equipo: "+this.nombre+" Director Técnico: "+this.director+" Goles a favor: "+this.golesFavor+" Goles en contra: "+this.golesContra+" Puntaje: "+this.puntos+"\n";
    }
}
