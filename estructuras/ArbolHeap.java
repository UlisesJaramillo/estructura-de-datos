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
 *                  Nombre del Archivo : ArbolHeap.java                                         *
 *                                                                                              *
 *                              Alumno : Ulises Jaramillo                                       *
 *                                                                                              *
 *                              Legajo : FAI-1698                                               *
 *                                                                                              *
 *                                                                                              *
 *----------------------------------------------------------------------------------------------*
 * Descripción:                                                                                 *
 *      Un árbol heap (también conocido como montículo) es una estructura que permite mantener  *
 *      sus elementos parcialmente ordenados. Su propósito es permitir encontrar rápidamente    *
 *      el menor o mayor elemento (según la implementación) de todos los elementos guardados en *
 *      la estructura.                                                                          *
 *      La implementación de esta clase es estática.                                            *
 * Métodos:                                                                                     *
 *      insertar --                                                                             *
 *      eliminarCima --                                                                         *
 *      hacerSubir --                                                                           *
 *      recuperarCima --                                                                        *
 *      toString --                                                                             *
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - **/
public class ArbolHeap {

private static final int TAM = 65;
private Comparable[] heap;
private int ultimo;

public ArbolHeap() {
    this.heap = new Comparable[TAM - 1];
    this.ultimo = 0;
}

public boolean insertar(Comparable elemento) {
    boolean exito = false;
    int pos;
    Comparable temp;
    if (this.ultimo == 0) {
        this.heap[1] = elemento;
        this.ultimo++;
        exito = true;
    } else {
        this.ultimo++;
        this.heap[this.ultimo] = elemento;
        pos = this.ultimo;
        while (!exito && pos != 1) {
            if ((this.heap[pos].compareTo(this.heap[(pos / 2)])) > 0) {         //si el nodo hijo es mayor que su padre, hace el intercambio
                temp = this.heap[(pos / 2)];
                this.heap[(pos / 2)] = this.heap[pos];
                this.heap[pos] = temp;
                pos = pos / 2;
            } else {
                exito = true;
            }
        }
    }
    return exito;
}

public boolean eliminarCima() {
    boolean exito;
    if (this.ultimo == 0) {
        exito = false;
    } else {
        this.heap[1] = this.heap[ultimo];
        this.ultimo--;
        hacerBajar(1);                                                          //(heap maximo), el que tiene mas puntos, estará primero.
        exito = true;
    }
    return exito;
}

private void hacerBajar(int posicion) {
    int hijoMenor;
    Comparable temp = this.heap[posicion];
    boolean salir = false;
    while (!salir) {
        hijoMenor = posicion * 2;
        if (hijoMenor <= this.ultimo) {
            if (hijoMenor < this.ultimo) {                           
                if ((this.heap[hijoMenor + 1].compareTo(this.heap[hijoMenor])) > 0) {                  
                    hijoMenor++;
                }
            }                               
            if ((this.heap[hijoMenor].compareTo(temp)) > 0) {
                this.heap[posicion] = this.heap[hijoMenor];
                posicion = hijoMenor;
            } else {
                salir = true;
            }
        } else {
            salir = true;
        }
    }
    this.heap[posicion] = temp;
}

public Comparable recuperarCima() {
    Comparable elemento;
    if (this.ultimo == 0) {
        elemento = null;
    } else {
        elemento = this.heap[1];
    }
    return elemento;
}

public boolean esVacia() {
    return (ultimo == 0);
}

@Override
public String toString() {
    String cadena = "";
    if (this.ultimo == 0) {
        cadena = "árbol vacío";
    } else {
        for (int i = 1; i <= this.ultimo; i++) {
            cadena = cadena + " " + this.heap[i];
        }
    }
    return cadena;
}
}
