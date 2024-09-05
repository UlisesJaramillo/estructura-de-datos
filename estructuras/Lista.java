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
 *                  Nombre del Archivo : Lista.java                                            *
 *                                                                                              *
 *                              Alumno : Ulises Jaramillo                                       *
 *                                                                                              *
 *                              Legajo : FAI-1698                                               *
 *                                                                                              *
 *                                                                                              *
 *----------------------------------------------------------------------------------------------*
 * Descripción:                                                                                 *
 *      Implementación dinámica de la clase Lista.                                              *
 * Métodos:                                                                                     *
 *      insertar -- Insertar elemento en la lista.                                              *
 *      eliminar -- Eliminar elemento de la lista.                                              *
 *      toString -- mostrar lista por pantalla.                                                 *
 *      recuperar -- Obtener elemento de la lista.                                              *
 *      esVacia -- Determina si la lista está vacía.                                            *
 *      vaciar -- Vaciar la lista.                                                              *
 *      equals -- Determina si dos listas son iguales.                                          *
 *      localizar -- Determina la posicion en donde se encuentra un elemento.                   *
 *      clone -- Clonar lista.                                                                  *
 *      clonarAux -- Método auxiliar de clone.                                                  *
 *      longitud -- Determina la longitud de la lista.                                          *
 *      eliminarNulos -- Elimina elementos nulos dentro de la lista.                            *
 *      eliminarApariciones -- Elimina de la lista todos los elementos que se desee eliminar.   *
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - **/
public class Lista {

    private Nodo cabecera = null;
    int longitud = 0;

    public Lista() {
    }

    public boolean insertar(Object elemento, int pos) {
        boolean exito = true;
        if (pos < 1 || pos > this.longitud + 1) {
            exito = false;
        } else if (pos == 1) {

            this.cabecera = new Nodo(elemento, this.cabecera);
            this.longitud += 1;

        } else {
            Nodo aux = this.cabecera;
            int i = 1;
            while (i < pos - 1) {
                aux = aux.getEnlace();
                i++;

            }
            Nodo nuevo = new Nodo(elemento, aux.getEnlace());
            aux.setEnlace(nuevo);
            this.longitud += 1;

        }

        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito = true;
        if (pos < 1 || pos > this.longitud + 1) {
            exito = false;
        } else if (pos == 1) {
            this.cabecera = this.cabecera.getEnlace();
            this.longitud -= 1;
        } else {
            Nodo aux = this.cabecera;
            int i = 1;
            while (i < pos - 1) {
                aux = aux.getEnlace();
                i++;

            }
            aux.setEnlace(aux.getEnlace().getEnlace());
            this.longitud -= 1;

        }

        return exito;
    }

    @Override
    public String toString() {
        Nodo aux = this.cabecera;
        String cadena = "";
        if (aux != null) {
            while (aux != null) {
                cadena += aux.getElemento().toString() + ",";
                aux = aux.getEnlace();

            }
            cadena = cadena.substring(0, cadena.length() - 1);                  //retira la ultima coma.
        }else{
            cadena="ninguno";
        }

        return cadena;
    }

    public Object recuperar(int pos) {
    //dado una posicion, recupera el elemento ubicado en la misma.
        Object elemento;
        if (pos < 1 || pos > this.longitud + 1) {
            elemento = Integer.MIN_VALUE;
        } else if (pos == 1) {
            elemento = this.cabecera.getElemento();
        } else {
            Nodo aux = this.cabecera;
            int i = 2;
            while (i <= pos) {
                aux = aux.getEnlace();
                i++;

            }
            elemento = aux.getElemento();
        }

        return elemento;
    }

    public boolean esVacia() {
        boolean exito = false;
        if (this.cabecera == null) {
            exito = true;
        }
        return exito;
    }

    public boolean vaciar() {
        boolean exito = true;
        this.cabecera=null;
        this.longitud = 0;

        return exito;
    }

    public boolean equals(Lista lst) {
        boolean res = false;
        if (this.longitud == lst.longitud) {
            boolean continuar = true;
            Nodo aux = this.cabecera;
            int i = 1;
            while (i < this.longitud && continuar) {
                if (!aux.getElemento().equals(lst.recuperar(i))) {
                    continuar = false;
                } else {
                    i++;
                    aux = aux.getEnlace();
                }
            }
            if (continuar) {
                res = true;
            }
        }
        return res;
    }

    public int localizar(Object elemento) {
    //dado un elemento, recupera la posicion en donde se hubica el elemento. en caso de no encontrarse, devuelve -1.
        int posicion = 0;
        Nodo aux = this.cabecera;
        do {
            
            if (aux != null && !aux.getElemento().equals(elemento)) {
                aux = aux.getEnlace();
                posicion += 1;
            }
            if (aux == null) {
                posicion = -1;
            }

        } while (aux != null && !(aux.getElemento().equals(elemento)));

        return posicion;
    }

    public Lista clone() {
        //metodo que clona una lista...
        Lista clon = new Lista();
        clon.longitud = this.longitud;

        clonarAux(this.cabecera, clon);

        return clon;
    }

    private void clonarAux(Nodo nodo, Lista clon) {

        if (nodo!= null) {

            clonarAux(nodo.getEnlace(), clon);

            Nodo nuevoNodo = new Nodo(nodo.getElemento());

            nuevoNodo.setEnlace(clon.cabecera);

            clon.cabecera = nuevoNodo;

        }
    }

    public int longitud() {
        return this.longitud;
    }

    public void eliminarNulos() {
        //elimina nulos dejando solamente uno solo.
        Nodo aux = this.cabecera;
        if (this.longitud > 0) {
            if (aux.getElemento() == null) {
                if (longitud == 1) {
                    this.cabecera = null;
                    this.longitud = 0;
                } else {
                    this.cabecera = aux.getEnlace();
                    this.longitud--;
                }
            } else {
                boolean continuar = true;
                Nodo aux2 = aux.getEnlace();
                while (aux2 != null && continuar) {
                    if (aux2.getElemento() == null) {
                        continuar = false;
                        this.longitud--;
                        aux.setEnlace(aux2.getEnlace());
                    } else {
                        aux = aux2;
                        aux2 = aux2.getEnlace();
                    }
                }
            }
        }
    }

    public boolean eliminarApariciones(Object x) {
        //elimina todas las aparicciones en la lista
        boolean exito = false;
        if (this.longitud >= 1) {
            Nodo aux1 = this.cabecera, aux2 = this.cabecera.getEnlace();
            while (aux1 != null || aux2 != null) {
                
                if (this.cabecera.getElemento().equals(x)) {
                    this.cabecera = this.cabecera.getEnlace();
                    this.longitud--;
                    exito = true;
                } else if (aux2 != null && aux2.getElemento().equals(x)) {
                    aux1.setEnlace(aux2.getEnlace());
                    this.longitud--;
                    exito = true;
                }
                aux1 = aux2;
                if (aux2 != null) {
                    aux2 = aux2.getEnlace();
                }
            }

        }
        return exito;
    }
}
