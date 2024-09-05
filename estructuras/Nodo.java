/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

/************************************************************************************************
 ***                     TRABAJO PRACTICO   ---  ESTRUCTURA DE DATOS                          ***
 ************************************************************************************************
 *                                                                                              *
 *                 Nombre del proyecto : Mundial Rusia 2018                                     *
 *                                                                                              *
 *                  Nombre del Archivo : Nodo.java                                              *
 *                                                                                              *
 *                              Alumno : Ulises Jaramillo                                       *
 *                                                                                              *
 *                              Legajo : FAI-1698                                               *
 *                                                                                              *
 *                                                                                              *
 *----------------------------------------------------------------------------------------------*
 * Descripción:                                                                                 *
 *      En esta clase definiremos el nodo,la cual utilizaremos en todas las estructuras         *
 *      dinamicas de tipo lineal.                                                               *
 * Métodos:                                                                                     *
 *      getElemento -- Métodos get y set.                                                       *
 *      setElemento --                                                                          *
 *      getEnlace --                                                                            *
 *      setEnlace --                                                                            *
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - **/
public class Nodo {
    private Object elemento;
    private Nodo enlace;

    public Nodo(Object elemento, Nodo enlace) {
        this.elemento = elemento;
        this.enlace = enlace;
    }

    public Nodo(Object elem) {
        this.elemento = elem;
        this.enlace = null;
    }
    public Nodo(){
        this.elemento=null;
        this.enlace=null;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
}
