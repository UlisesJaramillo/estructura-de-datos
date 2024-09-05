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
 *                  Nombre del Archivo : NodoAdy.java                                           *
 *                                                                                              *
 *                              Alumno : Ulises Jaramillo                                       *
 *                                                                                              *
 *                              Legajo : FAI-1698                                               *
 *                                                                                              *
 *                                                                                              *
 *----------------------------------------------------------------------------------------------*
 * Descripción:                                                                                 *
 *      Clase utilizada por la estructura Grafo.                                                *
 * Métodos:                                                                                     *
 *      setEtiqueta --                                                                          *
 *      getEtiqueta --                                                                          *
 *      getVertice --                                                                           *
 *      getSigAdyacente --                                                                      *
 *      setVertice --                                                                           *
 *      setSigAdyacente --                                                                      *
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - **/
public class NodoAdy {
    private NodoVert vertice;
    private NodoAdy sigAdyacente;
    private Comparable etiqueta;    

    public NodoAdy(NodoVert vert,Comparable etiq) {
        this.sigAdyacente = null;
        this.vertice = vert;
        this.etiqueta = etiq;        
    }

    public void setEtiqueta(Comparable etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public NodoVert getVertice() {
        return vertice;
    }

    public NodoAdy getSigAdyacente() {
        return sigAdyacente;
    }

    public void setVertice(NodoVert vertice) {
        this.vertice = vertice;
    }

    public void setSigAdyacente(NodoAdy sigAdyacente) {
        this.sigAdyacente = sigAdyacente;
    }
}
