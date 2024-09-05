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
 *                  Nombre del Archivo : Partido.java                                           *
 *                                                                                              *
 *                              Alumno : Ulises Jaramillo                                       *
 *                                                                                              *
 *                              Legajo : FAI-1698                                               *
 *                                                                                              *
 *                                                                                              *
 *----------------------------------------------------------------------------------------------*
 * Descripción:                                                                                 *
 *      Esta clase implementa un partido ya realizado.                                          *
 * Métodos:                                                                                     *
 *      getEquipo1 -- Métodos get y set.                                                        *
 *      setEquipo1 --                                                                           *
 *      getEquipo2 --                                                                           *
 *      setEquipo2 --                                                                           *
 *      getRonda --                                                                             *
 *      setRonda --                                                                             *
 *      getCiudad --                                                                            *
 *      setCiudad --                                                                            *
 *      getGolesEq1 --                                                                          *
 *      setGolesEq1 --                                                                          *
 *      getGolesEq2 --                                                                          *
 *      setGolesEq2 --                                                                          *
 *      toString -- Muestra por pantalla los datos del partido.                                 *
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - **/
public class Partido {
    private String equipo1;
    private String equipo2;
    private String ronda;
    private String ciudad;
    private int golesEq1;
    private int golesEq2;
    
    public Partido(){
        
    }

    public Partido(String equipo1, String equipo2, String ronda, String ciudad, int golesEq1, int golesEq2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.ronda = ronda;
        this.ciudad = ciudad;
        this.golesEq1 = golesEq1;
        this.golesEq2 = golesEq2;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public String getRonda() {
        return ronda;
    }

    public void setRonda(String ronda) {
        this.ronda = ronda;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getGolesEq1() {
        return golesEq1;
    }

    public void setGolesEq1(int golesEq1) {
        this.golesEq1 = golesEq1;
    }

    public int getGolesEq2() {
        return golesEq2;
    }

    public void setGolesEq2(int golesEq2) {
        this.golesEq2 = golesEq2;
    }

    @Override
    public String toString() {
        String cadena = "";
        cadena += "***" + this.equipo1 + " Vs. " + this.equipo2 + " compiten en : " + this.ciudad + " ronda: " + this.ronda + " goles equipo 1: " + this.golesEq1 + " goles equipo 2: " + this.golesEq2+"\n";
        return cadena;
    }

}
