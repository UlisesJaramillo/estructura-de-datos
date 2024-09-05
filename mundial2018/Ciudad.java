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
 *                  Nombre del Archivo : Ciudad.java                                            *
 *                                                                                              *
 *                              Alumno : Ulises Jaramillo                                       *
 *                                                                                              *
 *                              Legajo : FAI-1698                                               *
 *                                                                                              *
 *                                                                                              *
 *----------------------------------------------------------------------------------------------*
 * Descripción:                                                                                 *
 *      Método que implementa a una ciudad.                                                     *
 *      Tiene dos métodos toString, según para lo que se necesite.                              *
 * Métodos:                                                                                     *
 *      setNombre -- Poner nombre.                                                              *
 *      setSuperficie -- Poner superficie.                                                      *
 *      setPoblacion -- Poner población.                                                        *
 *      setSede -- poner si es sede.                                                            *
 *      esSede -- determina si es sede.                                                         *
 *      getNombreCiudad -- Obtener nombre de la ciudad.                                         *
 *      getSuperficie -- obtener la superficie.                                                 *
 *      getPoblacion -- Obtener la población.                                                   *
 *      getEsSedeString -- devuelve una cadena indicando si es sede.                            *
 *      equals -- Hace una comparacion por nombre.                                              *
 *      toString -- mostrar ciudad por pantalla.                                                *
 *      toString2 -- mostrar ciudad por pantalla alternativo.                                   *
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - **/
public class Ciudad {
    private String nombre;
    private double superficie;
    private int cantHabitantes;
    private boolean esSede;

    public Ciudad() {
        this.nombre = null;
        this.superficie = 0;
        this.cantHabitantes = 0;
        this.esSede = false;
    }

    public Ciudad(String nombre) {
        this.nombre = nombre;
        this.superficie = 0;
        this.cantHabitantes = 0;
        this.esSede = false;
    }

    public Ciudad(String nombre, double superficie, int poblacion, boolean esSede) {
        this.nombre = nombre;
        this.superficie = superficie;
        this.cantHabitantes = poblacion;
        this.esSede = esSede;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public void setPoblacion(int poblacion) {
        this.cantHabitantes = poblacion;
    }

    public void setSede(boolean esSede) {
        this.esSede = esSede;
    }

    public String getNombreCiudad() {
        return nombre;
    }

    public double getSuperficie() {
        return superficie;
    }

    public int getPoblacion() {
        return cantHabitantes;
    }

    public boolean esSede() {
        return esSede;
    }

    public String getEsSedeString() {

        String res = "SI";
        if (!this.esSede) {
            res = "NO";
        }
        return res;
    }

     @Override
 /***********************************************************************************************
 * equals -- Hace una comparacion por nombre.                                                   *
 *             El método equals compara los nombres de las ciudades ignorando mayusculas.       *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:   ciudad -- ciudad a comparar.                                                      *
 *                                                                                              *
 * SALIDA:  Retorna booleano.                                                                   *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    public boolean equals(Object ciudad) {
        boolean res = false;
        Ciudad otraCiudad = (Ciudad) ciudad;
        if (this.nombre.equalsIgnoreCase(otraCiudad.getNombreCiudad())) {
            res = true;
        }
        return res;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    public String toString2() {
        String sede = "NO";
        if (this.esSede) {
            sede = "SI";
        }
        return "Ciudad: " + this.nombre + ", Superficie: " + this.superficie + ", Población: " + this.cantHabitantes + ", Sede: " + sede;
    }
}
