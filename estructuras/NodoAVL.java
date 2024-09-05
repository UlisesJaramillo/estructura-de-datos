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
 *                  Nombre del Archivo : NodoAVL.java                                           *
 *                                                                                              *
 *                              Alumno : Ulises Jaramillo                                       *
 *                                                                                              *
 *                              Legajo : FAI-1698                                               *
 *                                                                                              *
 *                                                                                              *
 *----------------------------------------------------------------------------------------------*
 * Descripción:                                                                                 *
 *      Clase utilizada por la estructura arbol AVL.                                            *
 * Métodos:                                                                                     *
 *      getElemento -- Métodos get y set.                                                       *
 *      setElemento --                                                                          *
 *      calcularAltura -- Método para calcular la altura del nodo, en el arbolAVL.              *
 *      mayorIgual --                                                                           *
 *      getAltura --                                                                            *
 *      getIzquierdo --                                                                         *
 *      getDerecho --                                                                           *
 *      setIzquierdo --                                                                         *
 *      setDerecho --                                                                           *
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - **/
public class NodoAVL {                                                                           //el elemento tiene que ser comparable para que el arbol pueda manipularlo correctamente.
    private Comparable elemento;
    private int altura;
    private NodoAVL izquierdo;
    private NodoAVL derecho;

    public NodoAVL(Comparable elemento) {
        this.elemento= elemento;
        altura = 0;
        izquierdo = null;
        derecho = null;
    }

    public void setElemento(Comparable elemento) {
        this.elemento = elemento;
    }
    
    public Comparable getElemento() {
        return this.elemento;
    }
 /***********************************************************************************************
 * calcularAltura -- Método para calcular la altura del nodo, en el arbolAVL.                   *
 *                                                                                              *
 *                  Actualiza el valor de la altura en el nodo, relativo al arbol.              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     ninguno.                                                                        *
 *                                                                                              *
 * SALIDA:    ninguno.                                                                          *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    public void calcularAltura() {        
        int altIzq = -1, altDer = -1;
        if (this.izquierdo != null) {
            altIzq = this.izquierdo.altura;
        }
        if (this.derecho != null) {
            altDer = this.derecho.altura;
        }
        this.altura = this.mayorIgual(altDer, altIzq) + 1;
    }
    
    private int mayorIgual(int a, int b) {
        int res = b;
        if (a >= b) {
            res = a;
        }
        return res;
    }

    public int getAltura() {
        return this.altura;
    }

    public NodoAVL getIzquierdo() {
        return this.izquierdo;
    }

    public NodoAVL getDerecho() {
        return this.derecho;
    }

    public void setIzquierdo(NodoAVL n) {
        this.izquierdo = n;
    }

    public void setDerecho(NodoAVL n) {
        this.derecho = n;
    }
}
