/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundial2018;

import estructuras.Lista;

/************************************************************************************************
 ***                     TRABAJO PRACTICO   ---  ESTRUCTURA DE DATOS                          ***
 ************************************************************************************************
 *                                                                                              *
 *                 Nombre del proyecto : Mundial Rusia 2018                                     *
 *                                                                                              *
 *                  Nombre del Archivo : Camino.java                                            *
 *                                                                                              *
 *                              Alumno : Ulises Jaramillo                                       *
 *                                                                                              *
 *                              Legajo : FAI-1698                                               *
 *                                                                                              *
 *                                                                                              *
 *----------------------------------------------------------------------------------------------*
 * Descripción:                                                                                 *
 *      Se crea ésta clase con el motivo de simular un camino entre las ciudades.               *
 *      El camino está compuesto por nodos(Lista de nodos), que son las ciudades, y             *
 *      un valor (distancia),que representa la distancia total del recorrido.                   *
 * Métodos:                                                                                     *
 *      esVacio -- Determina si el camino está vacío.                                           *
 *      getDistancia -- obtener distancia.                                                      *
 *      setDistancia -- poner distancia.                                                        *
 *      getListaDeNodos -- obtener lista de nodos.                                              *
 *      setListaDeCiudades -- poner lista de nodos.                                             *
 *      getCantCiudades -- obtener cantidad de ciudades.                                        *
 *      sumarCaminos -- Método para sumar dos caminos.                                          *
 *      toString -- mostrar camino por pantalla.                                                *
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - **/
public class Camino {
    private int distancia;
    private Lista ListaDeItems;

    public Camino() {
        distancia = 0;
        ListaDeItems = new Lista();
    }
    
    public Camino(Lista ListaDeItems, int dist) {
        this.ListaDeItems = ListaDeItems;
        this.distancia = dist;
    }
    
    
 /***********************************************************************************************
 * esVacio -- Determina si el camino está vacío.                                                *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:   ninguno.                                                                          *
 *                                                                                              *
 * SALIDA:  Retorna booleano.                                                                   *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    public boolean esVacio() {
        return ListaDeItems.esVacia();
    }
    
    
 /***********************************************************************************************
 * getDistancia -- obtener distancia.                                                           *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:   ninguno.                                                                          *
 *                                                                                              *
 * SALIDA:  Retorna entero.                                                                     *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    public int getDistancia() {
        return distancia;
    }
    
    
 /***********************************************************************************************
 * setDistancia -- poner distancia.                                                             *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:   distancia -- distancia.                                                           *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    
    
 /***********************************************************************************************
 * getListaDeNodos -- Obtiene la lista de nodos.                                                *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:   ninguno.                                                                          *
 *                                                                                              *
 * SALIDA:  Retorna Lista.                                                                      *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    public Lista getlistaDeItems() {
        return ListaDeItems;
    }
    
    
 /***********************************************************************************************
 * setListaDeCiudades -- poner lista de nodos.                                                  *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:   ListaDeCiudades -- lista de nodos (ciudades).                                        *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    public void setListaDeItems(Lista ListaDeItems) {
        this.ListaDeItems = ListaDeItems;
    }
    
    
 /***********************************************************************************************
 * getCantCiudades -- Obtiene la cantidad de ciudades.                                          *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:   ninguno.                                                                          *
 *                                                                                              *
 * SALIDA:  Retorna entero.                                                                     *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    public int getCantItems() {
        return this.ListaDeItems.longitud();
    }
    
    
 /***********************************************************************************************
 * sumarCaminos -- Método para sumar dos caminos.                                               *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:   camino -- camino a sumar.                                                         *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    public void sumarCaminos(Camino camino){
        //método para sumar caminos.
        this.distancia+=camino.getDistancia();                                                  //se suman las distancias
        int i;
        for(i=2;i<=camino.getCantItems();i++){                               //no se tiene en cuenta la primera ciudad, para que nos se repitan
            this.ListaDeItems.insertar(camino.getlistaDeItems().recuperar(i), this.ListaDeItems.longitud()+1);
                                                                                                //se agregan las ciudades
        }
    }
    
    
 /***********************************************************************************************
 * toString -- Muestra el camino por pantalla.                                                  *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:   ninguno.                                                                          *
 *                                                                                              *
 * SALIDA:  Retorna String.                                                                     *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    @Override
    public String toString() {
        String cadena = "";
//        Ciudad ciudad;
//        for (int i = 1; i < ListaDeCiudades.longitud(); i++) {
//            ciudad = (Ciudad) ListaDeCiudades.recuperar(i);
//            cadena += ciudad.getNombreCiudad() + " ";
//        }
        cadena=this.ListaDeItems.toString();
        cadena += " con una distancia total de " + distancia + " km.\n";

        return cadena;
    } 
}
