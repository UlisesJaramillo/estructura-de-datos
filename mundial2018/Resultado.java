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
 *      Se implementó ésta clase para tener en cuenta todos los resultados de los encuentros    *
 *      futbolisticos de cada equipo.                                                           *
 * Métodos:                                                                                     *
 *      getGolesFavor -- Métodos get y set de los atributos.                                    *
 *      setGolesFavor --                                                                        *
 *      getGolesContra --                                                                       *
 *      setGolesContra --                                                                       *
 *      getRival --                                                                             *
 *      setRival --                                                                             *
 *      equals --                                                                               *
 *      toString -- Muestra por pantalla los datos del resultado.                               *
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - **/
public class Resultado{
    private int golesFavor=0;
    private int golesContra=0;
    private String rival;

    public Resultado(int golesFavor, int golesContra, String rival) {
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
        this.rival = rival;
    }
    public Resultado(String nombre){
        this.rival=nombre;
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

    public String getRival() {
        return rival;
    }

    public void setRival(String rival) {
        this.rival = rival;
    }
    
    @Override
    public boolean equals(Object obj){
        Resultado resultado = (Resultado)obj;
       return this.rival.equalsIgnoreCase(resultado.getRival());
       
    }
    @Override
    public String toString(){
        return "jugó contra: "+this.rival+" goles a Favor: "+this.golesFavor+" goles en Contra: "+this.golesContra+"\n";
    }
    
}
