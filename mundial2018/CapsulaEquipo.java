/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundial2018;
import java.lang.Comparable;

/**
 *
 * Esta clase esta hecha para que la clase equipo pueda ser comparada por puntos.
 */
public class CapsulaEquipo implements Comparable<CapsulaEquipo>{
    private Equipo equipo;
    
    public CapsulaEquipo(Equipo equipo){
        this.equipo=equipo;
    }
    
    
    @Override
    public int compareTo(CapsulaEquipo equipo2){
        int resultado;
        if ((this.equipo.getPuntos()-equipo2.getPuntos()) > 0){
            resultado = 1;
        }else{
            resultado = -1;
        }
        return resultado;
    }
    
    public int getPuntos(){
        return this.equipo.getPuntos();
    }
    
    @Override
    public String toString(){
       return this.equipo.toString2();
    }
}
