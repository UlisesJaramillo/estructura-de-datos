/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import java.lang.Comparable;
/************************************************************************************************
 ***                     TRABAJO PRACTICO   ---  ESTRUCTURA DE DATOS                          ***
 ************************************************************************************************
 *                                                                                              *
 *                 Nombre del proyecto : Mundial Rusia 2018                                     *
 *                                                                                              *
 *                  Nombre del Archivo : ArbolAVL.java                                          *
 *                                                                                              *
 *                              Alumno : Ulises Jaramillo                                       *
 *                                                                                              *
 *                              Legajo : FAI-1698                                               *
 *                                                                                              *
 *                                                                                              *
 *----------------------------------------------------------------------------------------------*
 * Descripción:                                                                                 *
 *      Los árboles AVL son árboles binarios de búsqueda que están siempre equilibrados         *
 * de tal modo que, para todos los nodos, la altura de la rama izquierda no diere en más de    *
 * una unidad de la altura de la rama derecha, y viceversa. Gracias a esta forma de equilibrio  *
 * (o balanceo), la complejidad de la búsqueda en uno de estos árboles se mantiene siempre en   *
 * orden de complejidad O(log n).                                                               *
 *                                                                                              *
 *                                                                                              *
 *       Para implementar este tipo de dato abstracto, se parte de un árbol binario de búsqueda *
 * en el que se modican las operaciones de inserción y eliminación para asegurar que la        *
 * diferencia de altura entre los subárboles derecho e izquierdo de cada nodo no sea mayor a uno*
 * en valor absoluto. A la diferencia de altura entre los subárboles de un nodo la llamaremos   *
 * balance y lo calcularemos de la siguiente manera:                                            *
 *                   balance(N) = alturaHijoIzq(N) − alturaHijoDer(N)                           *
 *                                                                                              *
 * Métodos:                                                                                     *
 *      insertar -- Inserta un elemento al arbol.                                               *
 *      insertarAux -- Método auxiliar de insertar.                                             *
 *      balance -- Calcula el valor de balance de un nodoAVL.                                   *
 *      balancear -- Método que se encarga de determinar el tipo de rotación.                   *
 *      insertarHijo -- Método para insertar el nuevo hijo al padre del pivote.                 *
 *      rotaciónSimpleDerecha -- Método realiza la rotación simple derecha.                     *
 *      rotaciónSimpleIzquierda -- Método realiza la rotación simple izquierda.                 *
 *      eliminar -- Método para eliminar un nodo.                                               *
 *      buscarEliminar -- Método para hacer la busqueda de un nodo a eliminar.                  *
 *      eliminarAux -- Método auxiliar para eliminar un nodo.                                   *
 *      buscarMayor -- Método para buscar el nodo con el elemento mayor de un subArbol.         *
 *      obtenerElemento -- Método para recuperar un nodo en base a un elemento.                 *
 *      obtenerElementoAux -- Método auxiliar de obtener elemento.                              *
 *      existeElemento --                                                                       *
 *      existeElementoAux --                                                                    *
 *      listarRango --                                                                          *   
 *      listarRangoAux --                                                                       *
 *      listarElementosGolesNeg -- Método para listar todos los equipos con goles negativos.    *
 *      listarElementosGolesNeg -- Método auxiliar de listar elementos goles neg.               *   
 *      toString --                                                                             *
 *      toStringAux --                                                                          *
 *      listarInOrden --                                                                        *
 *      listarInOrdenAux --                                                                     *
 *      listarPosOrden --                                                                       *
 *      listarPosOrdenAux --                                                                    *
 *      listarPreOrden --                                                                       *   
 *      listarPreOrdenAux --                                                                    *
 *      eliminarResultadosConEquipo -- Método para eliminar resultados del equipo contrario.    *
 *      eliminarResultadosConEquipoAux -- Método auxiliar de eliminarResultadosConEquipo.       *
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - **/
public class ArbolAVL {

    private NodoAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }
 /***********************************************************************************************
 * insertar -- Inserta un elemento al arbol.                                                    *
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
    public boolean insertar(Comparable elemento) {
        boolean exito;
        if (this.raiz == null) {
            this.raiz = new NodoAVL(elemento);
            exito = true;
        } else {
            exito = insertarAux(this.raiz, null, elemento);
        }
        return exito;
    }
 /***********************************************************************************************
 * insertarAux -- Método auxiliar de insertar.                                                  *
 *              Es un método recursivo que se usa cuando el nodo a insertar no va en la raiz.   *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     nodo -- NodoAVL que es el nodo raiz.                                               *
 *              padreN -- NodoAVL padre de n.                                                   *
 *              elemento -- Elemento a insertar, tiene que ser comparable.                      *
 *                                                                                              *
 * SALIDA:  Retorna booleano.                                                                   *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private boolean insertarAux(NodoAVL nodo, NodoAVL padreN, Comparable elemento) {
        boolean exito = false;
        if (nodo != null) {
            if (elemento.compareTo(nodo.getElemento()) < 0) {
                if (nodo.getIzquierdo() == null) {
                    exito = true;
                    nodo.setIzquierdo(new NodoAVL(elemento));
                    nodo.calcularAltura();
                } else {
                    exito = insertarAux(nodo.getIzquierdo(), nodo, elemento);
                    nodo.calcularAltura();
                    this.balancear(nodo, padreN);
                }
            } else if (elemento.compareTo(nodo.getElemento()) > 0) {// mayor a cero ( no permite elemento iguales)
                if (nodo.getDerecho() == null) {
                    exito = true;
                    nodo.setDerecho(new NodoAVL(elemento));
                    nodo.calcularAltura();
                } else {
                    exito = insertarAux(nodo.getDerecho(), nodo, elemento);
                    nodo.calcularAltura();
                    this.balancear(nodo, padreN);
                }
            }
        }
        return exito;
    }
 /***********************************************************************************************
 * balance -- Calcula el valor de balance de un nodoAVL.                                        *
 *                                                                                              *
 *              El calculo que se realiza para el valor del balance es el siguiente:            *
 *                                                                                              *
 *              balance(N) = alturaHijoIzq(N) − alturaHijoDer(N)                                *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     nodo -- NodoAVL del cual se hacen los calculos de balance.                         *
 *                                                                                              *
 * SALIDA:  Retorna un entero con el valor del balance..                                        *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private int balance(NodoAVL nodo) {
        int balance = 0;
        NodoAVL izq, der;
        izq = nodo.getIzquierdo();
        der = nodo.getDerecho();
        if (izq != null && der != null) {
            balance = izq.getAltura() - der.getAltura();
        } else if (izq != null) {
            balance = izq.getAltura() - (-1);
        } else if (der != null) {
            balance = -1 - der.getAltura();
        }
        return balance;
    }
 /***********************************************************************************************
 * balancear -- Método que se encarga de determinar el tipo de rotación.                        *
 *                                                                                              *
 *          Este método determina que tipo de rotación se va a llevar a cabo, con el criterio   *
 *      descripto en la siguiente tabla, para ello tenemos que saber el balance de cada nodo.   *
 *                                                                                              *
 *              Balance padre | Balance hijo |   Signo   |        Rotación        |             *
 *              -------------------------------------------------------------------             *
 *                    2       |     1 ó 0    |   igual   | Simple a derecha       |             *
 *                    2       |      -1      |  distinto | Doble izquierda-derecha|             *
 *                   -2       |    -1 ó 0    |   igual   | Simple a izquierda     |             *
 *                   -2       |       1      |  distinto | Doble derecha-izquierda|             *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     pivote -- Nodo que hace de pivote en la rotación.                               *
 *              padre -- Nodo padre del pivote.                                                 *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private void balancear(NodoAVL pivote, NodoAVL padre) {
        NodoAVL nuevoHijo;                                                                      
        if (this.balance(pivote) == 2) {                                                        //El árbol está inclinado hacia la izquierda. 
            if (this.balance(pivote.getIzquierdo()) == -1) {                                    //Aplicar rotación doble izquierda-derecha
                nuevoHijo = this.rotaciónSimpleIzquierda(pivote.getIzquierdo());
                this.insertarHijo(pivote.getIzquierdo(), nuevoHijo, pivote);
                nuevoHijo = this.rotaciónSimpleDerecha(pivote);
                this.insertarHijo(pivote, nuevoHijo, padre);
            } else {                                                                            //Aplicar rotación simple a derecha
                nuevoHijo = this.rotaciónSimpleDerecha(pivote);
                this.insertarHijo(pivote, nuevoHijo, padre);
            }
        } else if (this.balance(pivote) == -2) {                                                //El árbol tiene una inclinación hacia la derecha.
            if (this.balance(pivote.getDerecho()) == 1) {                                       //Aplicar doble rotación derecha-izquierda
                nuevoHijo = this.rotaciónSimpleDerecha(pivote.getDerecho());
                this.insertarHijo(pivote.getDerecho(), nuevoHijo, pivote);
                nuevoHijo = this.rotaciónSimpleIzquierda(pivote);
                this.insertarHijo(pivote, nuevoHijo, padre);
            } else {                                                                            //Aplicar rotación simple a izquierda
                nuevoHijo = this.rotaciónSimpleIzquierda(pivote);
                nuevoHijo.calcularAltura();
                this.insertarHijo(pivote, nuevoHijo, padre);
            }
        }
    }
 /***********************************************************************************************
 * insertarHijo -- Método para insertar el nuevo hijo al padre del pivote.                      *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     nodo -- Nodo al cual se insertará el nuevo nodo hijo.                           *
 *              padre -- Nodo padre de n.                                                       *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private void insertarHijo(NodoAVL nodo, NodoAVL hijo, NodoAVL padre) {
        if (padre != null) {
            if (nodo.getElemento().compareTo(padre.getElemento()) < 0) {                        //compara los valores de los elemenetos alojados en los nodos y determina que hijo es.
                padre.setIzquierdo(hijo);
            } else {
                padre.setDerecho(hijo);
            }
        } else {
            this.raiz = hijo;                                                                   //si nodo no tiene padre, signigica que estamos en la raiz del arbol.
        }
    }
 /***********************************************************************************************
 * rotaciónSimpleDerecha -- Método realiza la rotación simple derecha.                          *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     pivote -- nodo pivote del cual se hace la rotación.                             *
 *                                                                                              *
 * SALIDA:      nuevoPadre -- nuevo nodo a enlazar, que será el padre del pivote.               *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private NodoAVL rotaciónSimpleDerecha(NodoAVL pivote) {
        NodoAVL nuevoPadre;
        NodoAVL temp;
        nuevoPadre = pivote.getIzquierdo();
        temp = nuevoPadre.getDerecho();
        nuevoPadre.setDerecho(pivote);
        pivote.setIzquierdo(temp);
        pivote.calcularAltura();
        nuevoPadre.calcularAltura();
        return nuevoPadre;
    }
 /***********************************************************************************************
 * rotaciónSimpleIzquierda -- Método realiza la rotación simple izquierda.                      *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     pivote -- nodo pivote del cual se hace la rotación.                             *
 *                                                                                              *
 * SALIDA:      nuevoPadre -- nuevo nodo a enlazar, que será el padre del pivote.               *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private NodoAVL rotaciónSimpleIzquierda(NodoAVL pivote) {
        NodoAVL nuevoPadre;
        NodoAVL temp;
        nuevoPadre = pivote.getDerecho();
        temp = nuevoPadre.getIzquierdo();
        nuevoPadre.setIzquierdo(pivote);
        pivote.setDerecho(temp);
        pivote.calcularAltura();
        nuevoPadre.calcularAltura();
        return nuevoPadre;
    }
 /***********************************************************************************************
 * eliminar -- Método para eliminar un nodo.                                                    *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     elemento -- Elemento a eliminar.                                                *
 *                                                                                              *
 * SALIDA:      exito -- booleano que indica el exito de la eliminación del elemento            *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    public boolean eliminar(Comparable elemento) {
        boolean exito = false;
        if (this.raiz != null) {
            if (elemento.compareTo(this.raiz.getElemento()) == 0) {
                exito = true;
                if (this.raiz.getIzquierdo() != null || this.raiz.getDerecho() != null) {
                    this.eliminarAux(raiz, null);
                } else {
                    this.raiz = null;
                }
            } else if (elemento.compareTo(raiz.getElemento()) < 0) {
                exito = this.buscarEliminar(this.raiz.getIzquierdo(), raiz, elemento);
                this.raiz.calcularAltura();
                this.balancear(raiz, null);
            } else {
                exito = this.buscarEliminar(this.raiz.getDerecho(), raiz, elemento);
                this.raiz.calcularAltura();
                this.balancear(raiz, null);
            }
        }
        return exito;
    }
 /***********************************************************************************************
 * buscarEliminar -- Método para hacer la busqueda de un nodo a eliminar.                       *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     elemento -- Elemento a eliminar.                                                *
 *              nodo -- Nodo de donde se parte la busqueda.                                     *
 *              padre -- Nodo padre de n.                                                       *
 *                                                                                              *
 * SALIDA:      exito -- booleano que indica el exito de la busqueda.                           *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private boolean buscarEliminar(NodoAVL nodo, NodoAVL padre, Comparable elemento) {
        boolean exito = false;
        if (nodo != null) {
            if (elemento.compareTo(nodo.getElemento()) == 0) {
                exito = true;
                this.eliminarAux(nodo, padre);
            } else if (elemento.compareTo(nodo.getElemento()) < 0) {                            //recorre recursivamente el arbol dependiendo del valor del elemento buscado.
                exito = buscarEliminar(nodo.getIzquierdo(), nodo, elemento);
            } else {
                exito = buscarEliminar(nodo.getDerecho(), nodo, elemento);
            }
            if (exito) {
                nodo.calcularAltura();
                this.balancear(nodo, padre);
            }
        }

        return exito;
    }
 /***********************************************************************************************
 * eliminarAux -- Método auxiliar para eliminar un nodo.                                        *
 *                                                                                              *
 *          Al eliminar un nodo del arbol, se tiene re reacomodar los nodos para que sigan      *
 *      balanceados.                                                                            *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     nodo -- Nodo a eliminar.                                                        *
 *              padre -- Nodo padre de n.                                                       *
 *                                                                                              *
 * SALIDA:      ninguno.                                                                        *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private void eliminarAux(NodoAVL nodo, NodoAVL padre) {                                     //se busca al mayor del subárbol izquierdo.        
        if (nodo.getIzquierdo() != null) {            
            if (nodo.getIzquierdo().getDerecho() == null) {                                     //el mayor elemento es la raiz del subArbol.
                nodo.setElemento(nodo.getIzquierdo().getElemento());
                nodo.setIzquierdo(nodo.getIzquierdo().getIzquierdo());
            } else {                                                                            //Se busca recursivamente al mayor del subárbol izquierdo de "n"
                this.buscarMayor(nodo.getIzquierdo(), nodo, nodo);                
                nodo.calcularAltura();
            }
        } else {                                                                                //El subárbol izquierdo de "nodo" es nulo, entonces la raíz del subárbol derecho 
                                                                                                //de "nodo" lo reemplazará
                     
            this.insertarHijo(nodo, nodo.getDerecho(), padre);                                  //es una hoja, se realiza la eliminación.                                               
        }
    }
 /***********************************************************************************************
 * buscarMayor -- Método para buscar el nodo con el elemento mayor de un subArbol.              *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     nodo -- Nodo a eliminar.                                                        *
 *              padreBuscado -- Nodo padre de buscado.                                          *
 *              buscado -- Nodo a buscar.                                                       *
 *                                                                                              *
 * SALIDA:    ninguno.                                                                          *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private void buscarMayor(NodoAVL buscado, NodoAVL padreBuscado, NodoAVL nodo) {
        if (buscado.getDerecho() != null) {
            buscarMayor(buscado.getDerecho(), buscado, nodo);
            buscado.calcularAltura();
            this.balancear(buscado, padreBuscado);
        } else {                                                                                //"buscado" es el MAYOR del subárbol
            nodo.setElemento(buscado.getElemento());
            padreBuscado.setDerecho(buscado.getIzquierdo());
        }
    }
 /***********************************************************************************************
 * obtenerElemento -- Método para recuperar un nodo en base a un elemento.                      *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     elemento -- Elemento a buscar.                                                  *
 *                                                                                              *
 * SALIDA:    ninguno                                                                           *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    public Object obtenerElemento(Comparable elemento) {
        Object nodo = null;
        if (this.raiz != null) {
            nodo = obtenerElementoAux(this.raiz, elemento);
        }
        return nodo;
    }
 /***********************************************************************************************
 * obtenerElementoAux -- Método auxiliar de obtener elemento.                                   *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     nodo -- Nodo a encontrar.                                                       *
 *              elemento -- elemento por el cual se realiza la busqueda.                        *
 *                                                                                              *
 * SALIDA:    nodo.                                                                             *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private Object obtenerElementoAux(NodoAVL nodo, Comparable elemento) {

        Object nodoAux = null;
        if (nodo != null) {
            if (elemento.compareTo(nodo.getElemento()) == 0) {
                nodoAux = nodo.getElemento();
            } else if (elemento.compareTo(nodo.getElemento()) < 0) {
                nodoAux = obtenerElementoAux(nodo.getIzquierdo(), elemento);
            } else {
                nodoAux = obtenerElementoAux(nodo.getDerecho(), elemento);
            }
        }
        return nodoAux;
    }

    public boolean existeElemento(Comparable elemento) {
        boolean existe = false;
        if (this.raiz != null) {
            existe = existeElementoAux(this.raiz, elemento);
        }
        return existe;
    }

    private boolean existeElementoAux(NodoAVL nodo, Comparable elemento) {
        boolean existe = false;
        if (nodo != null) {
            if (elemento.compareTo(nodo.getElemento()) == 0) {
                existe = true;
            } else if (elemento.compareTo(nodo.getElemento()) < 0) {
                existe = existeElementoAux(nodo.getIzquierdo(), elemento);
            } else {
                existe = existeElementoAux(nodo.getDerecho(), elemento);
            }

        }
        return existe;
    }

    public Lista listarRango(Comparable min, Comparable max) {
        Lista ls = new Lista();
        if (this.raiz != null) {
            listarRangoAux(this.raiz, min, max, ls);
        }
        return ls;
    }

    private void listarRangoAux(NodoAVL n, Comparable min, Comparable max, Lista l) {
        //
        if (n != null) {
            if (min.compareTo(n.getElemento()) < 0) {
                listarRangoAux(n.getIzquierdo(), min, max, l);
            }
            if (min.compareTo(n.getElemento()) <= 0 && max.compareTo(n.getElemento()) >= 0) {
                l.insertar(n.getElemento(), l.longitud() + 1);
            }
            if (max.compareTo(n.getElemento()) > 0) {
                listarRangoAux(n.getDerecho(), min, max, l);
            }

        }
    }
 

    @Override
    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoAVL n) {
        String cadena = "";
        if (n != null) {
            cadena += "Padre: " + n.getElemento().toString() + " , Altura : " + n.getAltura();
            cadena += " ---> ";
            if (n.getIzquierdo() != null) {
                cadena += "HI: " + n.getIzquierdo().getElemento().toString() + " ; ";
            } else {
                cadena += "HI: null ";
            }
            cadena += "\n";
            cadena += "                                      ";
            if (n.getDerecho() != null) {
                cadena += "HD: " + n.getDerecho().getElemento().toString();
            } else {
                cadena += "HD: null ";
            }
            cadena += "\n";
            cadena += toStringAux(n.getIzquierdo());
            cadena += toStringAux(n.getDerecho());
        }
        return cadena;
    }

    public Lista listarInOrden() {
        Lista salida = new Lista();
        listarInOrdenAux(this.raiz, salida);
        return salida;
    }

    private void listarInOrdenAux(NodoAVL n, Lista ls) {
        if (n != null) {

            listarInOrdenAux(n.getIzquierdo(), ls);
            ls.insertar(n.getElemento(), ls.longitud() + 1);
            listarInOrdenAux(n.getDerecho(), ls);
        }

    }

    public Lista listarPosOrden() {
        Lista salida = new Lista();
        listarPosOrdenAux(this.raiz, salida);
        return salida;
    }

    private void listarPosOrdenAux(NodoAVL n, Lista ls) {
        if (n != null) {

            listarPosOrdenAux(n.getIzquierdo(), ls);

            listarPosOrdenAux(n.getDerecho(), ls);
            ls.insertar(n.getElemento(), ls.longitud() + 1);
        }
    }

    public Lista listarPreOrden() {
        Lista salida = new Lista();
        listarPreOrdenAux(this.raiz, salida);
        return salida;
    }

    private void listarPreOrdenAux(NodoAVL n, Lista ls) {
        if (n != null) {
            ls.insertar(n.getElemento(), ls.longitud() + 1);

            listarPreOrdenAux(n.getIzquierdo(), ls);

            listarPreOrdenAux(n.getDerecho(), ls);
        }
    }


}
