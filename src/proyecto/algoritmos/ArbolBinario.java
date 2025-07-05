/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.algoritmos;

import proyecto.utils.*;

public class ArbolBinario {

    private NodoArbol raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(int valor) {
        limpiarVisitas(raiz);
        
        if (raiz == null) {
            raiz = new NodoArbol(valor);
        } else {
            insertarRecursivo(raiz, valor);
        }
    }

    private void insertarRecursivo(NodoArbol actual, int valor) {
        if (valor < actual.informacion) {
            if (actual.izquierda == null) {
                actual.izquierda = new NodoArbol(valor);
                actual.izquierda.padre = actual;
            } else {
                insertarRecursivo(actual.izquierda, valor);
            }
        } else if (valor > actual.informacion) {
            if (actual.derecha == null) {
                actual.derecha = new NodoArbol(valor);
                actual.derecha.padre = actual;
            } else {
                insertarRecursivo(actual.derecha, valor);
            }
        }
    }

    public void inOrden() {
        String aviso = inOrdenRecursivo(raiz).trim();
        Aviso.info("Recorrido InOrder: " + aviso);
    }

    private String inOrdenRecursivo(NodoArbol nodo) {
        if (nodo == null) {
            return "";
        }
        return inOrdenRecursivo(nodo.izquierda)
                + nodo.informacion + " "
                + inOrdenRecursivo(nodo.derecha);
    }

    public void preOrden() {
        String aviso = preOrdenRecursivo(raiz).trim();
        Aviso.info("Recorrido PreOrder: " + aviso);
    }

    private String preOrdenRecursivo(NodoArbol nodo) {
        if (nodo == null) {
            return "";
        }
        return nodo.informacion + " "
                + preOrdenRecursivo(nodo.izquierda)
                + preOrdenRecursivo(nodo.derecha);
    }

    public void postOrden() {
        String aviso = postOrdenRecursivo(raiz).trim();
        Aviso.info("Recorrido PostOrder: " + aviso);
    }

    private String postOrdenRecursivo(NodoArbol nodo) {
        if (nodo == null) {
            return "";
        }
        return postOrdenRecursivo(nodo.izquierda)
                + postOrdenRecursivo(nodo.derecha)
                + nodo.informacion + " ";
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void contarHojas() {
        String aviso = "La cantidad de nodos hojas es: " + contarHojasRecursivo(raiz);
        Aviso.info(aviso); 
    }

    private int contarHojasRecursivo(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.izquierda == null && nodo.derecha == null) {
            return 1;
        }
        return contarHojasRecursivo(nodo.izquierda) + contarHojasRecursivo(nodo.derecha);
    }

    public void altura() {
        String aviso = "La altura del arbol es: " + alturaRecursiva(raiz);
        Aviso.info(aviso); 
    }

    private int alturaRecursiva(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }

        int izquierdaAltura = alturaRecursiva(nodo.izquierda);
        int derechaAltura = alturaRecursiva(nodo.derecha);
        return 1 + Math.max(izquierdaAltura, derechaAltura);
    }

    public void contarNodos() {
        String aviso = "El total de nodos es: " + contarNodosRecursivo(raiz);
        Aviso.info(aviso); 
    }

    private int contarNodosRecursivo(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarNodosRecursivo(nodo.izquierda) + contarNodosRecursivo(nodo.derecha);
    }

    public void buscar(int valor) {
        limpiarVisitas(raiz);
        boolean encontrado = buscarRecursivo(raiz, valor);
        
        if (encontrado) {
            Aviso.nodoEncontrado(valor);
        } else {
            Aviso.nodoNoEncontrado(valor);
        }
    }
    
    private void limpiarVisitas(NodoArbol nodo) {
        if (nodo == null) return;
        nodo.visitado = false;
        limpiarVisitas(nodo.izquierda);
        limpiarVisitas(nodo.derecha);
    }

    private boolean buscarRecursivo(NodoArbol nodo, int valor) {
        if (nodo == null) {
            return false;
        }

        nodo.visitado = true;

        if (valor == nodo.informacion) {
            return true;
        }
        if (valor < nodo.informacion) {
            return buscarRecursivo(nodo.izquierda, valor);
        } else {
            return buscarRecursivo(nodo.derecha, valor);
        }
    }
    
    public void borrarArbol() {
        if (raiz == null) {
            Aviso.error("No hay árbol para borrar.");
        } else {
            raiz.setContador(0);
            raiz = null;
            Aviso.info("El árbol ha sido borrado exitosamente.");
        }
    }
    
   @Override
    public String toString() {
        String resultado = "raiz -> " +  preOrdenRecursivo(raiz).trim();
        return resultado;
    }
}
