/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import mundial2018.Camino;

/***********************************************************************************************
 ***                     TRABAJO PRACTICO   ---  ESTRUCTURA DE DATOS                         ***
 ***********************************************************************************************
 *                                                                                             *
 *                 Nombre del proyecto : Mundial Rusia 2018                                    *
 *                                                                                             *
 *                  Nombre del Archivo : Grafo.java                                            *
 *                                                                                             *
 *                              Alumno : Ulises Jaramillo                                      *
 *                                                                                             *
 *                              Legajo : FAI-1698                                              *
 *                                                                                             *
 *                                                                                             *
 *---------------------------------------------------------------------------------------------*
 * Métodos:                                                                                    *
 *   obtenerVertice -- Obtiene el elemento del vertice.                                        *
 *   insertarVertice -- Inserta un nuevo vertice.                                              *
 *   ubicarVertice -- Busca el vertice con el elemento buscado.                                *
 *   existeCamino -- Metodo que sirve para indicar si existe un camino entre dos vertices.     *
 *   existeCaminoAux -- Método  auxiliar que trabaja con el método existeCamino.               *
 *   esVacio -- Método para indicar si el Grafo está vacío.                                    *
 *   existeVertice  -- Método para indicar si existe un vertice con el elemento buscado.       *
 *   insertarArco -- Método para insertar un arco entre vertices (grafo no dirigido).          *
 *   insertarArcoAux -- Método auxiliar de insertarArco.                                       *
 *   eliminarArco -- Método para eliminar un arco.                                             *
 *   eliminarArcoAux -- Método auxiliar de eliminarArco.                                       *
 *   existeArco -- Método para comprobar si existe un arco.                                    *
 *   eliminarVertice -- Método para eliminar un vertice con sus arcos.                         *
 *   eliminarAdyacentes -- Método que me permite eliminar todos los adyacentes.                *
 *   listarEnProfundidad -- Método de listado de tipo profundidad.                             *
 *   listarEnProfundidadAux -- Método auxiliar de listar en profundidad.                       *
 *   listarEnAnchura -- Método de listado de tipo anchura.                                     *
 *   listarEnAnchuraAux -- Método auxiliar de listar en anchura.                               *
 *   caminoMasCorto  -- Método para determinar el camino mas corto entre dos nodos.            *
 *   caminoMasCortoAux  -- Método auxiliar de caminoMasCorto.                                  *
 *   caminoMasCortoPorTresNodos  -- Método idem a camino mas corto, que pasa por una ciudad    *
 *                              intermedia.                                                    *
 *   caminoMenorNodos  -- Método camino mas corto pero en cantidad de ciudades.                *
 *   caminoMenorNodosAux -- Método auxiliar de caminoMenorNodos.                               *
 *   caminosPosibles -- Método para listar todos los caminos posibles entre las dos ciudades.  *
 *   caminosPosiblesAux -- Método auxiliar de caminosPosibles.                                 *
 *   toString -- Método aAcedena para ver el grafo en pantalla.                                *
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
public class Grafo {

    private NodoVert inicio;

    public Grafo() {
        this.inicio = null;
    }
    
 /***********************************************************************************************
 * obtenerVertice -- Obtiene el elemento del vertice.                                           *
 *                                                                                              *
 *        Este método se utiliza para, según un valor, poder obtener el elemento                *
 *        que está contienido en el vertice del Grafo, hace uso de ubicarVertice.               *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:   elem   -- valor para buscar el elemento del vertice.                              *
 *                                                                                              *
 * SALIDA:  Retorna el elemento que contiene el vertice.                                        *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/

    public Object obtenerVertice(Object elem) {
        NodoVert aux = this.ubicarVertice(elem);
        Object res = null;
        if (aux != null) {
            res = aux.getElem();
        }
        return res;
    }
    
 /***********************************************************************************************
 * insertarVertice -- Inserta un nuevo vertice.                                                 *
 *                                                                                              *
 *        Este método se utiliza para insertar un nuevo vertice al Grafo.                       *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:   elem   -- valor para Insertar.                                                    *
 *                                                                                              *
 * SALIDA:  Retorna un booleano para indicar el exito.                                          *                                  
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/

    public boolean insertarVertice(Object elem) {
        boolean exito = false;
        NodoVert aux = this.ubicarVertice(elem);                                                //primero busca si existe un vertice con el elemento a insertar
        if (aux == null) {
            this.inicio = new NodoVert(elem, this.inicio);                                      //sino existe un vertice con el elemento, crea el vertice y pasa a ser el nuevo inicio.
            exito = true;
        }
        return exito;
    }

    
/************************************************************************************************
 * ubicarVertice -- Busca el vertice con el elemento buscado.                                   *
 *                                                                                              *
 *        Este método se utiliza para buscar el vertice que contiene el elemento buscado.       *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:   Buscado   -- valor para buscar.                                                   *
 *                                                                                              *
 * SALIDA:  Retorna un vertice, si el valor es encontrado, sino, retorna nulo.                  *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *                
 *==============================================================================================*/
    private NodoVert ubicarVertice(Object buscado) {
        NodoVert aux = this.inicio;
        while (aux != null && !aux.getElem().equals(buscado)) {
            aux = aux.getSigVertice();
        }
        return aux;
    }
    
    
/************************************************************************************************
 * existeCamino -- Metodo que sirve para indicar si existe un camino entre dos vertices.        *
 *                                                                                              *
 *        El método hace uso de ubicarVertice y existeCaminoAux.                                *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     origen   -- valor de origen.                                                    *
 *              destino -- valor de desino.                                                     *            
 *                                                                                              *
 * SALIDA:  Retorna booleano para indicar la existencia del camino.                             *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    public boolean existeCamino(Object origen, Object destino) {
        boolean exito = false;
        NodoVert origenAux, destinoAux;
        origenAux = ubicarVertice(origen);
        destinoAux = ubicarVertice(destino);
        if (origenAux != null && destinoAux != null) {                                          //verifica si existen los vertices
            Lista visitados = new Lista();                                                      //crea una lista de visitados para poder tener en cuenta los vertices visitados.
            exito = existeCaminoAux(origenAux, destino, visitados);
        }
        return exito;
    }
    
    
/************************************************************************************************
 * existeCaminoAux -- Método  auxiliar que trabaja con el metodo existeCamino.                  *
 *                                                                                              *
 *        El método es recursivo y hace uso de la lista de visitados para realizar el recorrido.*
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     nodo   -- valor del vertice origen.                                             *
 *              dest  -- valor del elemento de destino.                                         *
 *              visitados -- lista de vertices visitados.                                       *
 *                                                                                              *
 * SALIDA:  Retorna booleano para indicar la existencia del camino.                             *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/

    private boolean existeCaminoAux(NodoVert nodo, Object dest, Lista visitados) {
        boolean exito = false;
        if (nodo != null) {
            if (nodo.getElem().equals(dest)) {                                                  //condicion de corte
                exito = true;
            } else {
                                                                                                //si no es el destino, verifica si hay camino entre n y dest.
                visitados.insertar(nodo.getElem(), visitados.longitud() + 1);                   //inserta el nodo visitado, para no volver a visitarlo.
                NodoAdy ady = nodo.getPrimerAdy();
                while (!exito && ady != null) {
                    if (visitados.localizar(ady.getVertice().getElem()) < 0) {
                        exito = existeCaminoAux(ady.getVertice(), dest, visitados);             //Paso recursivo.
                    }
                    ady=ady.getSigAdyacente();
                }
            }
        }
        return exito;
    }
    
    
/************************************************************************************************
 * esVacio -- Método para indicar si el Grafo está vacío.                                       *
 *                                                                                              *
 *        Solo hace la verificacion si el nodoVert inicio es igual a nulo.                      *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     ninguno.                                                                        *
 *                                                                                              *
 * SALIDA:  Retorna booleano.                                                                   *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    public boolean esVacio() {
        return this.inicio == null;
    }
    
    
/************************************************************************************************
 * existeVertice -- Método para indicar si un vertice con el elemento buscado.                  *
 *                                                                                              *
 *        Solo hace uso del método ubicarVertice y hace la combrobacion a nulo.                 *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     elemento -- elemento a buscar.                                                  *
 *                                                                                              *
 * SALIDA:  Retorna booleano.                                                                   *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    public boolean existeVertice(Object elem) {
        return this.ubicarVertice(elem) != null;
    }
    
    
/************************************************************************************************
 * insertarArco -- Método para insertar un arco entre vertices (grafo no dirigido).             *
 *                                                                                              *
 *        El método busca los elementos para determinar la existencia de los vertices           *
 *      y luego crea 2 arcos, realizando la conexión.                                           *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     elemA -- primer elemento a conectar.                                            *
 *              elemB -- segundo elemento a conectar.                                           *
 *              etiqueta -- valor para el arco.                                                 *
 *                                                                                              *
 * SALIDA:  Retorna booleano.                                                                   *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    public boolean insertarArco(Object elemA, Object elemB, Comparable etiqueta) {   
        boolean exito = false;
        NodoVert vertA, vertB;
        vertA = ubicarVertice(elemA);
        vertB = ubicarVertice(elemB);
        if (vertA != null && vertB != null) {
            if (insertarArcoAux(vertA, vertB, etiqueta)) {                                       //hace dos recorridos uno para cada arco (ida y vuelta).
                exito = insertarArcoAux(vertB, vertA, etiqueta);
            }
        }
        return exito;
    }
    
    
/************************************************************************************************
 * insertarArcoAux -- Método auxiliar de insertarArco.                                          *
 *                                                                                              *
 *        El método busca los elementos para determinar la existencia de los vertices           *
 *      y luego crea 2 arcos, realizando la conexión.                                           *
 *                                                                                              *
 * VISIBILIDAD: Private.                                                                        *
 *                                                                                              *
 * ENTRADA:     origen -- primer elemento a conectar.                                           *
 *              destino -- segundo elemento a conectar.                                         *
 *              etiqueta -- valor para el arco.                                                 *
 *                                                                                              *
 * SALIDA:  Retorna booleano.                                                                   *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    private boolean insertarArcoAux(NodoVert origen, NodoVert destino, Comparable etiqueta) {
        boolean exito = false;
        if (origen.getPrimerAdy() == null) {
            origen.setPrimerAdy(new NodoAdy(destino, etiqueta));                                //en caso de que el primer nodoVertice no tenga un primer adyacente,
            exito = true;                                                                       //crea un nuevo nodoAdy y lo conecta con el destino y le asigna el valor de la etiqueta.
        } else {
            NodoAdy ady = origen.getPrimerAdy();                                                //en caso de que si tenga un primer nodoAdy, pero sea el unico adyacente,
            if (ady.getSigAdyacente() == null) {                                                //verifica si es el unico nodo adyacente no es el destino, creamos el arco.
                if (!ady.getVertice().equals(destino)) {                                        
                    exito = true;                                                               
                    ady.setSigAdyacente(new NodoAdy(destino, etiqueta));                        
                }
            } else {                                                                            //en el caso de que no sea el unico nodo adyacente, 
                boolean continuar = true;                                                       //recorre todos los nodos adyacentes para verificar si ya existe un arco.
                while (ady.getSigAdyacente() != null && continuar) {
                    if (ady.getVertice().equals(destino)) {
                        continuar = false;
                    }
                    ady = ady.getSigAdyacente();
                }
                if (continuar) {
                    ady.setSigAdyacente(new NodoAdy(destino, etiqueta));                        //en el caso de no encontrar ningun nodo adyacente que tenga al destino,
                    exito = true;                                                               //agrega el arco.
                }
            }
        }
        return exito;
    }
    
    
/************************************************************************************************
 * eliminarArco -- Método para eliminar un arco.                                                *
 *                                                                                              *
 *        El método busca los elementos para eliminar los arcos usando a eliminarArcoAux        *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     elemA -- primer elemento para eliminación.                                      *
 *              elemB -- segundo elemento para eliminación.                                     *
 *                                                                                              *
 * SALIDA:  Retorna booleano.                                                                   *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    public boolean eliminarArco(Object elemA, Object elemB) {
        boolean exito = false;
        NodoVert vertA, vertB;
        vertA = ubicarVertice(elemA);
        vertB = ubicarVertice(elemB);
        if (vertA != null && vertB != null) {
            if (eliminarArcoAux(vertA, vertB)) {                                                 //elimina los dos arcos que conectan a los vertices.
                exito = this.eliminarArcoAux(vertB, vertA);
            }
        }
        return exito;
    }
    
    
/************************************************************************************************
 * eliminarArcoAux -- Método auxiliar de eliminarArco.                                          *
 *                                                                                              *
 *        El método busca los elementos para eliminar los arcos usando a eliminarArcoAux        *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     vertA -- primer nodo a eliminar.                                                *
 *              vertB -- segundo nodo a eliminar.                                               *
 *                                                                                              *
 * SALIDA:  Retorna booleano.                                                                   *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    private boolean eliminarArcoAux(NodoVert vertA, NodoVert vertB) {
        boolean exito = false;
        NodoAdy ady = vertA.getPrimerAdy();
        if (ady.getVertice().getElem().equals(vertB.getElem())) {                               //en caso de que el primer nodo sea el destino
            vertA.setPrimerAdy(ady.getSigAdyacente());
            exito = true;
        } else {
            while (ady.getSigAdyacente() != null &&                                             //recorre todos los nodos adyacentes hasta encontrar.
                    !(ady.getSigAdyacente().getVertice().getElem().equals(vertB.getElem()))) {
                ady = ady.getSigAdyacente();
            }
            if (ady.getSigAdyacente() != null) {
                exito = true;
                ady.setSigAdyacente(ady.getSigAdyacente().getSigAdyacente());                   //realiza la eliminacion
            }
        }
        return exito;
    }
    
    
/************************************************************************************************
 * existeArco -- Método para comprobar si existe un arco.                                       *
 *                                                                                              *
 *          Dados dos elementos de tipoVertice (origen y destino), devuelve verdadero si existe *
 *      un arco en la estructura que los une y falso en caso contrario.                         *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     elemA -- primer elemento a verficar.                                            *
 *              elemB -- segundo elemento a verificar.                                          *
 *                                                                                              *
 * SALIDA:  Retorna booleano.                                                                   *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    public boolean existeArco(Object elemA, Object elemB) {
        boolean exito = false;
        NodoVert vertA, vertB;
        vertA = ubicarVertice(elemA);
        vertB = ubicarVertice(elemB);
        if (vertA != null && vertB != null) {
            NodoAdy ady = vertA.getPrimerAdy();
            while (ady != null && !ady.getVertice().getElem().equals(elemB)) {                  //solo comprueba un arco, como el otro ya está creado, no necesita hacer una nueva comprobarlo.
                ady = ady.getSigAdyacente();
            }
            if (ady != null) {
                exito = true;
            }
        }
        return exito;
    }
    
    
/************************************************************************************************
 * eliminarVertice -- Método para eliminar un vertice con sus arcos.                            *
 *                                                                                              *
 *    Dado un elemento de tipoVertice se lo quita de la estructura. Si se encuentra el vértice, * 
 *   también deben eliminarse todos los arcos que lo tengan como origen o destino.              *
 * Si se puede realizar la eliminación con éxito devuelve verdadero, en caso contrario          *    
 * devuelve falso.                                                                              *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     elem -- elemento a verficar.                                                    *
 *                                                                                              *
 * SALIDA:  Retorna booleano.                                                                   *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    public boolean eliminarVertice(Object elem) {
        boolean exito = false;
        if (this.inicio != null) {
            if (this.inicio.getElem().equals(elem)) {                                           //verfica si el inicio es el vertice a eliminar.
                exito = true;
                this.eliminarAdyacentes(inicio);                                                //en caso afirmativo elimina todos los nodos adyacentes que lo tengan como destino u origen.
                this.inicio = this.inicio.getSigVertice();                                      //realiza la eliminación.
            } else {
                NodoVert vertAux = this.inicio;                                                 
                NodoVert vertSigAux = this.inicio.getSigVertice();
                while (vertSigAux != null && !vertSigAux.getElem().equals(elem)) {              //en caso de que no sea el nodo inicial, hace un recorrido con la ayuda de dos nodos auxiliares.
                    vertAux = vertSigAux;
                    vertSigAux = vertSigAux.getSigVertice();
                }
                if (vertSigAux != null) {                                                       
                    exito = true;
                    vertAux.setSigVertice(vertSigAux.getSigVertice());                          //al encontrarlo, realiza la eliminacion del vertice y sus arcos.
                    this.eliminarAdyacentes(vertSigAux);

                }
            }
        }
        return exito;
    }
    
    
/************************************************************************************************
 * eliminarAdyacentes -- Método que me permite eliminar todos los adyacentes.                   *
 *                                                                                              *
 *               Este método es utilizado por eliminarVertice, elimina tanto de ida             *
 *              como de vuelta.                                                                 *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     vert -- Nodo vertice al cual se le eliminaran los adyaccentes.                  *
 *                                                                                              *
 * SALIDA:  Retorna booleano.                                                                   *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    private void eliminarAdyacentes(NodoVert vert) {
        NodoAdy ady = vert.getPrimerAdy();
        while (ady != null) {
            this.eliminarArcoAux(ady.getVertice(), vert);                                       //elimina los dos arcos que conectan a los vertices.
            this.eliminarArcoAux(vert, ady.getVertice());
            ady = ady.getSigAdyacente();
        }
    }
    
    
/************************************************************************************************
 * listarEnProfundidad -- Método de listado de tipo profundidad.                                *
 *                                                                                              *
 *               El método se encarga de listar un grafo de manera que sea en profundidad       *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     ninguno.                                                                        *
 *                                                                                              *
 * SALIDA:  Lista.                                                                              *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    public Lista listarEnProfundidad() {
        Lista visitados = new Lista();
        NodoVert aux = this.inicio;
        while (aux != null) {
            if (visitados.localizar(aux.getElem()) < 0) {                                       //si no encuentra el elemento del grafo en la lista de visitados, llama al metodo auxiliar.
                listarEnProfundidadAux(aux, visitados);
            }
            aux = aux.getSigVertice();
        }
        return visitados;
    }
    
    
/************************************************************************************************
 * listarEnProfundidadAux -- Método auxiliar de listar en profundidad.                          *
 *                                                                                              *
 *               Es un método recursivo que se encarga de recorrer el grafo en profundidad      *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     nodo -- Nodo vertice de la cual parte a recorrer.                               *
 *              vis -- Lista de visitados.                                                      *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Trabaja sobre la lista.                                                           *
 *                                                                                              *
 *==============================================================================================*/
    private void listarEnProfundidadAux(NodoVert nodo, Lista vis) {
        if (nodo != null) {                                                                     //condicion de corte.
                                                                                                //agrega a nodo a la lista de visitados
            vis.insertar(nodo.getElem(), vis.longitud() + 1);
            NodoAdy ady = nodo.getPrimerAdy();
            while (ady != null) {                                                               
                if (vis.localizar(ady.getVertice().getElem()) < 0) {                            //verifica si ya lo ha visitado
                    listarEnProfundidadAux(ady.getVertice(), vis);                              //Paso recursivo.
                }
                ady = ady.getSigAdyacente();
            }
        }
    }
    
    
/************************************************************************************************
 * listarEnAnchura -- Método de listado de tipo anchura.                                        *
 *                                                                                              *
 *               El método se encarga de listar un grafo de manera que sea en anchura.          *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     ninguno.                                                                        *
 *                                                                                              *
 * SALIDA:  Lista.                                                                              *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    public Lista listarEnAnchura() {
        Lista visitados = new Lista();
        NodoVert aux = this.inicio;
        while (aux != null) {
            if (visitados.localizar(aux.getElem()) < 0) {                                       //si no encuentra el elemento del grafo en la lista de visitados, llama al metodo auxiliar
                listarEnAnchuraAux(aux, visitados);
            }
            aux = aux.getSigVertice();
        }
        return visitados;
    }
    
    
/************************************************************************************************
 * listarEnAnchuraAux -- Método auxiliar de listar en anchura.                                  *
 *                                                                                              *
 *               Es un método recursivo que se encarga de recorrer el grafo en anchura,         *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     vert -- Nodo vertice de la cual parte a recorrer.                               *
 *              visitados -- Lista de visitados.                                                *
 *                                                                                              *
 * SALIDA:  Ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   Trabaja sobre la lista.                                                           *
 *                                                                                              *
 *==============================================================================================*/
    private void listarEnAnchuraAux(NodoVert vert, Lista visitados) {
        Cola cola = new Cola();
        cola.poner(vert);
        NodoVert aux;
        NodoAdy ady;
        while (!cola.esVacia()) {
            aux = (NodoVert) cola.obtenerFrente();
            cola.sacar();
            visitados.insertar(aux.getElem(), visitados.longitud() + 1);
            ady = aux.getPrimerAdy();
            while (ady != null) {
                if (visitados.localizar(ady) < 0) {
                    cola.poner(ady);
                }
                ady = ady.getSigAdyacente();
            }
        }
    }
    
    
/************************************************************************************************
 * caminoMasCorto -- Método para determinar el camino mas corto entre dos nodos.                *
 *                                                                                              *
 *                Dados dos elementos de tipoVertice (origen y destino), devuelve un camino     *
 *          (lista de vértices) que indique el camino que pasa por menos vértices que permite   *
 *          llegar del vértice origen al vértice destino.                                       *
 *          Si hay más de un camino con igual cantidad de vértices, devuelve cualquiera de      *
 *          ellos. Si alguno de los vértices no existe o no hay camino posible entre ellos      *
 *          devuelve la lista vacía.                                                            *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     elemA -- elemento de origen.                                                    *
 *              elemB -- elemento de destino.                                                   *
 *                                                                                              *
 * SALIDA:  Camino mas corto.                                                                   *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    public Camino caminoMasCorto(Object elemA, Object elemB) {
        NodoVert vertA, vertB;
        vertA = ubicarVertice(elemA);
        vertB = ubicarVertice(elemB);
        Lista visitados = new Lista();
        Camino camino = new Camino();
        camino.setDistancia(Integer.MAX_VALUE);                                                 //se asigna como distancia un número muy grande para después poder comparar.
        if (vertA != null & vertB != null) {
            caminoMasCortoAux(vertA, elemB, visitados, 0, camino);
        } else {
            camino.setDistancia(0);                                                             //en el caso de que alguno de los nodos no esté en el grafo, pone distancia 0.
        }
        return camino;
    }
    
    
/************************************************************************************************
 * caminoMasCortoAux -- Método auxiliar de caminoMasCorto.                                      *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     nodo -- nodo del cual parte el recorrido.                                       *
 *              dest -- elemento de destino.                                                    *
 *              visitados -- lista de nodos visitados.                                          *
 *              distActual -- distancia actual sirve para hacer la comparacion de distancias.   *
 *              camino -- camino mas corto.                                                     *
 *                                                                                              *
 * SALIDA:  ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    private void caminoMasCortoAux(NodoVert nodo, Object destino, Lista visitados, int distActual, Camino camino) {
        visitados.insertar(nodo.getElem(), visitados.longitud() + 1);
        if (nodo.getElem().equals(destino)) {                                                      
            camino.setListaDeItems(visitados.clone());                                       //se crea un clon de la lista de visitados, porque la lista es modificada constantemente.
            camino.setDistancia(distActual);
        } else {                                                                                //si el nodo no es el destino.
            NodoAdy ady = nodo.getPrimerAdy();
            while (ady != null) {
                distActual += (int) ady.getEtiqueta();                                          //suma la distancia de el nodo adyacente.
                if (distActual < camino.getDistancia()) {                                       //si encuentra un camino mas corto avanza con la recursión.
                    if (visitados.localizar(ady.getVertice().getElem()) < 0) {
                        caminoMasCortoAux(ady.getVertice(), destino, visitados, distActual, camino);
                    }
                }                                                                               //resta porque prueba con otro camino mas corto
                distActual -= (int) ady.getEtiqueta();
                ady = ady.getSigAdyacente();
            }
            
        }
        visitados.eliminar(visitados.longitud());                                               //quita el ultimo nodo.
    }
    
    
/************************************************************************************************
 * caminoMasCortoPorTresNodos -- Método idem a camino mas corto, que pasa por una ciudad        *
 *                              intermedia.                                                     *
 *                                                                                              *
 *                          Este método es similar a camino mas corto, la diferencia radica en  *
 *                  hacer una verificacion extra, la de localizar el nodo intermedio antes de   *
 *                  generar el camino.                                                          *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     elemA -- ciudad de origen.                                                      *
 *              elemB -- ciudad de destino.                                                     *
 *              elemC -- ciudad intermedia.                                                     *                                               
 *                                                                                              *
 * SALIDA:  Camino.                                                                             *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    public Camino caminoMasCortoPorTresNodos(Object elemA, Object elemB, Object elemC) {
        NodoVert vertA, vertB, vertC;
        vertA = ubicarVertice(elemA);
        vertB = ubicarVertice(elemB);
        vertC = ubicarVertice(elemC);
        Lista visitados = new Lista();
        Camino camino = new Camino();
        camino.setDistancia(Integer.MAX_VALUE);                                                 //se asigna como distancia un número muy grande para después poder comparar.
        if (vertA != null && vertB != null && vertC != null) {
            caminoMasCortoPorTresNodosAux(vertA, elemB, elemC, visitados, 0, camino);
        } else {
            camino.setDistancia(0);                                                             //en el caso de que alguno de los nodos no esté en el grafo, pone distancia 0.
        }
        return camino;
    }
    
    private void caminoMasCortoPorTresNodosAux(NodoVert nodo, Object dest, Object intermedio, Lista visitados, int distActual, Camino camino) {
        visitados.insertar(nodo.getElem(), visitados.longitud() + 1);
        System.out.println(visitados.toString());
        if (nodo.getElem().equals(dest)) {
            if (visitados.localizar(intermedio) > 0) {
                
                camino.setListaDeItems(visitados.clone());                                       //se crea un clon de la lista de visitados, porque la lista es modificada constantemente.
                camino.setDistancia(distActual);
            }

        } else {                                                                                //si el nodo no es el destino.
            NodoAdy ady = nodo.getPrimerAdy();
            while (ady != null) {
                distActual += (int) ady.getEtiqueta();                                          //suma la distancia de el nodo adyacente.
                if (distActual < camino.getDistancia()) {                                       //si encuentra un camino mas corto avanza con la recursión.
                    if (visitados.localizar(ady.getVertice().getElem()) < 0) {
                        caminoMasCortoPorTresNodosAux(ady.getVertice(), dest, intermedio, visitados, distActual, camino);
                    }
                }                                                                               //resta porque prueba con otro camino mas corto
                distActual -= (int) ady.getEtiqueta();
                ady = ady.getSigAdyacente();
            }

        }
        visitados.eliminar(visitados.longitud()); 
    }
    
/************************************************************************************************
 * caminoMenorNodos -- Método camino mas corto pero en cantidad de ciudades.                    *
 *                                                                                              *
 *                                                                                              *
 *     Dado un origen y un destino devuelve un camino que tenga la menor cantidad de ciudades.  *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     elemA -- ciudad de origen.                                                      *
 *              elemB -- ciudad de destino.                                                     *                                              
 *                                                                                              *
 * SALIDA:  Camino.                                                                             *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    public Camino caminoMenorNodos(Object elemA, Object elemB) {
        Lista visitados = new Lista();
        Camino camino = new Camino();
        NodoVert vertA;
        NodoVert vertB;
        vertA = ubicarVertice(elemA);
        vertB = ubicarVertice(elemB);
        if (vertA != null && vertB != null) {
            caminoMenorNodosAux(vertA, elemB, visitados, 0, camino);
        }
        return camino;
    }
    
    
/************************************************************************************************
 * caminoMenorNodosAux -- Método auxiliar de caminoMenorNodos.                                  *
 *                                                                                              *
 *                                                                                              *
 *     Dado un origen y un destino devuelve un camino que tenga la menor cantidad de ciudades.  *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     nodo -- nodo del cual parte el recorrido.                                       *
 *              destino -- ciudad de destino.                                                   *   
 *              visitados -- lista de ciudades visitadas.                                       *
 *              distActual -- distancia.                                                        *
 *              camino -- camino mas corto.                                                     *
 *                                                                                              *
 * SALIDA:  ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    private void caminoMenorNodosAux(NodoVert nodo, Object destino, Lista visitados, int distActual, Camino camino) {
        if (nodo != null) {
            visitados.insertar(nodo.getElem(), visitados.longitud() + 1);
            if (nodo.getElem().equals(destino)) {                                                  //cuando encuentra el destino, hace un clon de la lista de nodos visitados
                camino.setListaDeItems(visitados.clone());
                camino.setDistancia(distActual);

            } else {
                NodoAdy ady = nodo.getPrimerAdy();
                while (ady != null) {
                    distActual += (int) (ady.getEtiqueta());
                    if (visitados.localizar(ady.getVertice().getElem()) < 0) {
                        if (camino.esVacio() || visitados.longitud() < camino.getCantItems()) {//verifica la cantidad de ciudades visitadas
                            caminoMenorNodosAux(ady.getVertice(), destino, visitados, distActual, camino);
                        }
                    }
                    distActual -= (int) (ady.getEtiqueta());
                    ady = ady.getSigAdyacente();
                }
            }
            visitados.eliminar(visitados.longitud());
        }
    }
    
    
/************************************************************************************************
 * caminosPosibles -- Método para listar todos los caminos posibles entre las dos ciudades.     *
 *                                                                                              *
 *                                                                                              *
 *     Crea una lista de caminos ( todos los caminos posibles).                                 *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     elemA -- ciudad de origen.                                                      *
 *              elemB -- ciudad de destino.                                                     *                                              
 *                                                                                              *
 * SALIDA:  Lista.                                                                              *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    public Lista caminosPosibles(Object elemA, Object elemB) {
        Lista visitados = new Lista(), lista = new Lista();                                     
        NodoVert vertA;
        NodoVert vertB;
        vertA = ubicarVertice(elemA);
        vertB = ubicarVertice(elemB);
        if (vertA != null && vertB != null) {
            caminosPosiblesAux(vertA, elemB, visitados, 0, lista);
        }
        return lista;
    }
    
    
/************************************************************************************************
 * caminosPosiblesAux -- Método auxiliar de caminosPosibles.                                    *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: Privado.                                                                        *
 *                                                                                              *
 * ENTRADA:     nodo -- nodo del cual parte el recorrido.                                       *
 *              dest -- ciudad de destino.                                                      *   
 *              visitados -- lista de ciudades visitadas.                                       *
 *              dist -- distancia.                                                              *
 *              lista -- lista de caminos.                                                      *
 *                                                                                              *
 * SALIDA:  ninguno.                                                                            *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    private void caminosPosiblesAux(NodoVert nodo, Object dest, Lista visitados, int dist, Lista lista) {
        if (nodo != null) {
            visitados.insertar(nodo.getElem(), visitados.longitud() + 1);
            if (nodo.getElem().equals(dest)) {                                                  //llega a destino.
                lista.insertar(new Camino(visitados.clone(), dist), lista.longitud() + 1);      //agrega el camino a la lista
            } else {
                NodoAdy ady = nodo.getPrimerAdy();
                while (ady != null) {                                                           //recorre recursivamente los nodos
                    dist += (int) ady.getEtiqueta();
                    if (visitados.localizar(ady.getVertice().getElem()) < 0) {
                        caminosPosiblesAux(ady.getVertice(), dest, visitados, dist, lista);
                    }
                    dist -= (int) ady.getEtiqueta();
                    ady = ady.getSigAdyacente();
                }
            }
            visitados.eliminar(visitados.longitud());                                           //elimina el ultimo nodo.
        }
    }
    
    
/************************************************************************************************
 * toString -- Método aAcedena para ver el grafo en pantalla.                                   *
 *                                                                                              *
 *                                                                                              *
 * VISIBILIDAD: Publico.                                                                        *
 *                                                                                              *
 * ENTRADA:     ningunno.                                                                       *
 *                                                                                              *
 * SALIDA:  String.                                                                             *
 *                                                                                              *
 * ALERTAS:   ninguno.                                                                          *
 *                                                                                              *
 *==============================================================================================*/
    @Override
    public String toString() {
        String resultado = "";
        NodoAdy ady;
        NodoVert aux = this.inicio;
        while (aux != null) {
            ady = aux.getPrimerAdy();
            if (aux != null && ady == null) {
                resultado += " ( " + aux.getElem().toString() + " )\n";
            } else {
                while (ady != null) {
                    resultado +=" ( " + aux.getElem().toString() + " ) --> " + ady.getEtiqueta() + " --> ( " + ady.getVertice().getElem().toString() + " )\n";
                    ady = ady.getSigAdyacente();
                }
                
            }
            aux = aux.getSigVertice();

        }

        return resultado;
    }
}
