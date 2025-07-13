/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.algoritmos;

import proyecto.utils.*;

public class ArbolBinario {

    private NodoArbol raiz;
    private NodoArbol ultimoVisitado;

    public ArbolBinario() {
        this.raiz = null;
        this.ultimoVisitado = null;
    }

    public void insertar(String dato, boolean balancear) {
        if ("".equals(dato)) {
            Aviso.datoVacio();
            return;
        }

        int valor = Integer.parseInt(dato);
        limpiarVisitas(raiz);

        if (raiz == null)
            raiz = new NodoArbol(valor);
        else
            raiz = insertarRecursivo(raiz, valor, balancear);
    }

    private NodoArbol insertarRecursivo(NodoArbol nodo, int valor, boolean balancear) {
        if (nodo == null)
            return new NodoArbol(valor);

        if (valor < nodo.informacion) {
            nodo.izquierda = insertarRecursivo(nodo.izquierda, valor, balancear);
            if (nodo.izquierda != null)
                nodo.izquierda.padre = nodo;
        } else if (valor > nodo.informacion) {
            nodo.derecha = insertarRecursivo(nodo.derecha, valor, balancear);
            if (nodo.derecha != null)
                nodo.derecha.padre = nodo;
        }

        return balancear ? balancear(nodo) : nodo;
    }
   
    private NodoArbol balancear(NodoArbol nodo) {
        int balance = obtenerAltura(nodo.derecha) - obtenerAltura(nodo.izquierda);

        if (balance > 1) {
            if (obtenerAltura(nodo.derecha.izquierda) > obtenerAltura(nodo.derecha.derecha))
                nodo.derecha = rotacionDerecha(nodo.derecha);
            return rotacionIzquierda(nodo);
        }

        if (balance < -1) {
            if (obtenerAltura(nodo.izquierda.derecha) > obtenerAltura(nodo.izquierda.izquierda))
                nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            return rotacionDerecha(nodo);
        }

        return nodo;
    }
 
    private int obtenerAltura(NodoArbol nodo) {
        if (nodo == null) return 0;
        return 1 + Math.max(obtenerAltura(nodo.izquierda), obtenerAltura(nodo.derecha));
    }
    
    private NodoArbol rotacionIzquierda(NodoArbol nodo) {
        NodoArbol nuevaRaiz = nodo.derecha;
        nodo.derecha = nuevaRaiz.izquierda;
        nuevaRaiz.izquierda = nodo;

        if (nodo.derecha != null)
            nodo.derecha.padre = nodo;

        nuevaRaiz.padre = nodo.padre;
        nodo.padre = nuevaRaiz;

        return nuevaRaiz;
    }

    private NodoArbol rotacionDerecha(NodoArbol nodo) {
        NodoArbol nuevaRaiz = nodo.izquierda;
        nodo.izquierda = nuevaRaiz.derecha;
        nuevaRaiz.derecha = nodo;

        if (nodo.izquierda != null)
            nodo.izquierda.padre = nodo;

        nuevaRaiz.padre = nodo.padre;
        nodo.padre = nuevaRaiz;

        return nuevaRaiz;
    }
    
    public void inOrden() {
        String aviso = inOrdenRecursivo(raiz).trim();
        Aviso.info("Recorrido InOrder: " + aviso);
    }

    private String inOrdenRecursivo(NodoArbol nodo) {
        if (nodo == null) return "";
        return inOrdenRecursivo(nodo.izquierda)
                + nodo.informacion + " "
                + inOrdenRecursivo(nodo.derecha);
    }

    public void preOrden() {
        String aviso = preOrdenRecursivo(raiz).trim();
        Aviso.info("Recorrido PreOrder: " + aviso);
    }

    private String preOrdenRecursivo(NodoArbol nodo) {
        if (nodo == null) return "";
        return nodo.informacion + " "
                + preOrdenRecursivo(nodo.izquierda)
                + preOrdenRecursivo(nodo.derecha);
    }

    public void postOrden() {
        String aviso = postOrdenRecursivo(raiz).trim();
        Aviso.info("Recorrido PostOrder: " + aviso);
    }

    private String postOrdenRecursivo(NodoArbol nodo) {
        if (nodo == null) return "";
        return postOrdenRecursivo(nodo.izquierda)
                + postOrdenRecursivo(nodo.derecha)
                + nodo.informacion + " ";
    }

    public NodoArbol getRaiz() {
        return raiz;
    }
    
    public void obtenerAlturaArbol() {
        String aviso = "La altura del árbol es: " + alturaRecursiva(raiz);
        Aviso.info(aviso);
    }

    private int alturaRecursiva(NodoArbol nodo) {
        if (nodo == null) return 0;
 
        int izquierdaAltura = alturaRecursiva(nodo.izquierda);
        int derechaAltura = alturaRecursiva(nodo.derecha);
        return 1 + Math.max(izquierdaAltura, derechaAltura);
    }

    public void obtenerPeso() {
        String aviso = "El peso del árbol es: " + pesoRecursivo(raiz);
        Aviso.info(aviso);
    }

    private int pesoRecursivo(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + pesoRecursivo(nodo.izquierda) + pesoRecursivo(nodo.derecha);
    }

    private void limpiarVisitas(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        nodo.visitado = false;
        nodo.noEncontrado = false;
        limpiarVisitas(nodo.izquierda);
        limpiarVisitas(nodo.derecha);
    }

    public void buscar(String dato) {
        if ("".equals(dato)) {
            Aviso.datoVacio();
            return;
        }

        int valor = Integer.parseInt(dato);
        limpiarVisitas(raiz);
        ultimoVisitado = null;

        boolean encontrado = buscarRecursivo(raiz, valor);

        if (encontrado) {
            Aviso.nodoEncontrado(valor);
        } else {
            if (ultimoVisitado != null) {
                ultimoVisitado.visitado = true;
                ultimoVisitado.noEncontrado = true;
            }
            Aviso.nodoNoEncontrado(valor);
        }
    }

    private boolean buscarRecursivo(NodoArbol nodo, int valor) {
        if (nodo == null) return false;
        
        nodo.visitado = true;
        ultimoVisitado = nodo;

        if (valor == nodo.informacion) return true;
        if (valor < nodo.informacion)
            return buscarRecursivo(nodo.izquierda, valor);
        else
            return buscarRecursivo(nodo.derecha, valor);
    }

    public void eliminar(String dato, boolean balancear) {
        if ("".equals(dato)) {
            Aviso.datoVacio();
            return;
        }

        int valor = Integer.parseInt(dato);
        raiz = eliminarRecursivo(raiz, valor, balancear);
    }

    private NodoArbol eliminarRecursivo(NodoArbol nodo, int valor, boolean balancear) {
        if (nodo == null) {
            Aviso.nodoNoEncontrado(valor);
            return null;
        }

        if (valor < nodo.informacion) {
            nodo.izquierda = eliminarRecursivo(nodo.izquierda, valor, balancear);
        } else if (valor > nodo.informacion) {
            nodo.derecha = eliminarRecursivo(nodo.derecha, valor, balancear);
        } else {
            if (nodo.izquierda == null) return nodo.derecha;
            if (nodo.derecha == null) return nodo.izquierda;

            NodoArbol predecesor = nodo.izquierda;
            while (predecesor.derecha != null) {
                predecesor = predecesor.derecha;
            }

            nodo.informacion = predecesor.informacion;
            nodo.izquierda = eliminarRecursivo(nodo.izquierda, predecesor.informacion, balancear);
            Aviso.info("Nodo eliminado: " + valor);
        }

        return balancear ? balancear(nodo) : nodo;
    }

    public void borrarArbol() {
        if (raiz == null) {
            Aviso.error("No hay árbol para borrar.");
            return;
        }

        raiz.setContador(0);
        raiz = null;
        Aviso.info("El árbol ha sido borrado exitosamente.");
    }
    
    public void balancearTodo() {
        boolean cambiado;

        do {
            NodoArbol antes = raiz;
            raiz = balancearRecursivo(raiz);
            cambiado = (antes != raiz);
        } while (cambiado);
    }

    private NodoArbol balancearRecursivo(NodoArbol nodo) {
        if (nodo == null) return null;

        nodo.izquierda = balancearRecursivo(nodo.izquierda);
        if (nodo.izquierda != null) nodo.izquierda.padre = nodo;

        nodo.derecha = balancearRecursivo(nodo.derecha);
        if (nodo.derecha != null) nodo.derecha.padre = nodo;

        return balancear(nodo);
    }

    @Override
    public String toString() {
        String resultado = "raiz -> " + preOrdenRecursivo(raiz).trim();
        return resultado;
    }
}
