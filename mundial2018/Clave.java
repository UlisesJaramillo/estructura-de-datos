/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundial2018;

/************************************************************************************************
 ***                     TRABAJO PRACTICO   ---  ESTRUCTURA DE DATOS                          ***
 ************************************************************************************************
 *                                                                                              *
 *                 Nombre del proyecto : Mundial Rusia 2018                                     *
 *                                                                                              *
 *                  Nombre del Archivo : Clave.java                                             *
 *                                                                                              *
 *                              Alumno : Ulises Jaramillo                                       *
 *                                                                                              *
 *                              Legajo : FAI-1698                                               *
 *                                                                                              *
 *                                                                                              *
 *----------------------------------------------------------------------------------------------*
 * Descripción:                                                                                 *
 *      Esta clase es creada para generar las claves usadas en HashMap para el guardado de      *
 *      los partidos, la clase se asegura que con el metodo generar clave todas las claves se   *
 *      hagan de la misma forma, evitando cualquier tipo de inconsistencia.                     *
 * Métodos:                                                                                     *
 *                                                                                              *
 *      generarClave -- Método para generar la clave.                                           *
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - **/
public class Clave {
    
    
 /***********************************************************************************************
 * generarClave -- Método para generar la clave.                                                *
 *                                                                                              *
 *          La manera de generar la clave es teniendo en cuenta los nombres de cada equipo      *
 *      convertido en mayusculas y ordenados alfabeticamente.                                   *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     nombre1 -- nombre del primer equipo.                                            *
 *              nombre2 -- nombre del segundo equipo.                                           *
 *              fase -- fase en la que participan los equipos.                                  *
 *                                                                                              *
 * SALIDA:  Retorna String (clave).                                                             *
 *                                                                                              *
 * ALERTAS:   Convierte ambas cadenas a mayusculas.                                             *
 *                                                                                              *                
 *==============================================================================================*/
    public String generarClave(String nombre1,String nombre2){
        String cadena="";
        nombre1=nombre1.toUpperCase();
        nombre2=nombre2.toUpperCase();
        if(nombre1.compareToIgnoreCase(nombre2)<0){                                             //realiza un ordenamiento de los nombres.
            cadena=nombre1+"-"+nombre2;                                             
        }else{
            cadena=nombre2+"-"+nombre1;
        }
        System.out.println(cadena);
        return cadena;
    }
}
