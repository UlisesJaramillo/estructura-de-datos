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
 *      getElem --       Métodos get y Set.                                                     *
 *      getSigVertice --                                                                        *
 *      getPrimerAdy --                                                                         *
 *      setElem --                                                                              *
 *      setSigVertice --                                                                        *
 *      setPrimerAdy --                                                                         *
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - **/
public class NodoVert {
    private Object elemento;
    private NodoVert sigVertice;
    private NodoAdy primerAdy;

    public NodoVert(Object objeto, NodoVert sigVert) {
        this.elemento = objeto;
        this.sigVertice = sigVert;
        this.primerAdy = null;
    }

    public Object getElem() {
        return elemento;
    }

    public NodoVert getSigVertice() {
        return sigVertice;
    }

    public NodoAdy getPrimerAdy() {
        return primerAdy;
    }

    public void setElem(Object objeto) {
        this.elemento = objeto;
    }

    public void setSigVertice(NodoVert sigVertice) {
        this.sigVertice = sigVertice;
    }

    public void setPrimerAdy(NodoAdy primerAdy) {
        this.primerAdy = primerAdy;
    }
}
