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
 *                  Nombre del Archivo : Cola.java                                              *
 *                                                                                              *
 *                              Alumno : Ulises Jaramillo                                       *
 *                                                                                              *
 *                              Legajo : FAI-1698                                               *
 *                                                                                              *
 *                                                                                              *
 *----------------------------------------------------------------------------------------------*
 * Descripción:                                                                                 *
 *      Clase que implementa una cola de tipo dinámica.                                         *
 * Métodos:                                                                                     *
 *      sacar -- Saca el elemento que está en el frente de la cola.                             *
 *      esVacia -- Verifica si la Cola esta vacía.                                              *
 *      obtenerFrente -- Obtiene el elemento que esta en el frente, sin sacarlo de la cola.     *
 *      poner -- Poner un elemento en la cola.                                                  *
 *      toString -- Muesra los datos de cola por pantalla.                                      *
 *      clone -- Clona la estructura.                                                           *
 *      cloneAux -- Método auxiliar que trabaja con Clone.                                      *
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - **/
public class Cola {
    private Nodo frente;
    private Nodo fin;

    public Cola() {
                                                                                                // Crea y devuelve una cola vacía
        this.frente = null;
        this.fin = null;
    }

    public boolean sacar() {
                                                                                                // Saca el elemento que está en el frente de la cola. 
                                                                                                //Devuelve verdadero si el elemento se pudo sacar (la
                                                                                                //estructura no estaba vacía) y falso en caso contrario.
        boolean exito = true;
        if (this.frente == null) {
            exito = false;
        } else {
            this.frente = this.frente.getEnlace();
            if (this.frente == null) {
                this.fin = null;
            }
        }
        return exito;
    }

    public boolean esVacia() {
        boolean res = false;
        if (this.frente == null) {
            res = true;
        }
        return res;
    }

    public Object obtenerFrente() {
        Object res = null;
        if (this.frente != null) {
            res = this.frente.getElemento();
        }
        return res;
    }

    public boolean poner(Object elemento) {
        boolean exito = false;
        Nodo nodoNuevo = new Nodo(elemento);

        if (this.frente == null) {
            this.fin = nodoNuevo;
            this.frente = nodoNuevo;
            exito=true;
        } else {
            this.fin.setEnlace(nodoNuevo);
            this.fin = nodoNuevo;
            exito=true;
        }
        
        return exito;

    }

    @Override
    public String toString() {
        String cadena;
        Nodo aux;
        aux = this.frente;
        if (this.esVacia()) {
            cadena = "Cola vacia";
        } else {
            cadena = "[";
            while (aux != null) {
                cadena += aux.getElemento();
                aux = aux.getEnlace();
                if (aux != null) {
                    cadena += ", ";
                }
            }
            cadena += "]";
        }
        return cadena;
    }

    public Cola clone() {
        Cola colaClon = new Cola();
        Nodo aux;
        aux = this.frente;
        cloneAux(colaClon, aux);
        return colaClon;
    }

    public void cloneAux(Cola colaClon, Nodo aux) {
        if (aux != null) {
            Nodo nodoNuevo = new Nodo(aux.getElemento());
            if (colaClon.fin == null) {
                colaClon.frente = nodoNuevo;
                colaClon.fin = nodoNuevo;
            } else {
                colaClon.fin.setEnlace(nodoNuevo);
                colaClon.fin = nodoNuevo;
            }
            cloneAux(colaClon, aux.getEnlace());
        }
    }
}
