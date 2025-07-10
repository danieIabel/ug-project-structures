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

    public void insertar(String dato) {
        if ("".equals(dato)) {
            Aviso.datoVacio();
            return;
        }

        int valor = Integer.parseInt(dato);
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

    public void obtenerAltura() {
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

    public void obtenerPeso() {
        String aviso = "El total de nodos es: " + pesoRecursivo(raiz);
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
        if (nodo == null) {
            return false;
        }

        nodo.visitado = true;
        ultimoVisitado = nodo;

        if (valor == nodo.informacion) return true;
        if (valor < nodo.informacion) {
            return buscarRecursivo(nodo.izquierda, valor);
        } else {
            return buscarRecursivo(nodo.derecha, valor);
        }
    }

    public void eliminar(String dato) {
        if ("".equals(dato)) {
            Aviso.datoVacio();
            return;
        }

        int valor = Integer.parseInt(dato);
        raiz = eliminarIterativo(raiz, valor);
    }

    private NodoArbol eliminarIterativo(NodoArbol raiz, int valor) {
        if (raiz == null) {
            Aviso.nodoNoEncontrado(valor);
            return null;
        }

        if (valor < raiz.informacion) {
            raiz.izquierda = eliminarIterativo(raiz.izquierda, valor);
        } else if (valor > raiz.informacion) {
            raiz.derecha = eliminarIterativo(raiz.derecha, valor);
        } else {
            // Nodo con el valor encontrado
            if (raiz.derecha == null) {
                return raiz.izquierda;
            } else if (raiz.izquierda == null) {
                return raiz.derecha;
            } else {
                // Buscar el mayor de los menores (predecesor)
                NodoArbol predecesor = raiz.izquierda;
                NodoArbol padrePredecesor = null;
                boolean tienePadre = false;

                while (predecesor.derecha != null) {
                    padrePredecesor = predecesor;
                    predecesor = predecesor.derecha;
                    tienePadre = true;
                }

                raiz.informacion = predecesor.informacion;

                if (tienePadre && padrePredecesor != null) {
                    padrePredecesor.derecha = predecesor.izquierda;
                } else {
                    raiz.izquierda = predecesor.izquierda;
                }
            }

            Aviso.info("Nodo eliminado: " + valor);
        }
        return raiz;
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
        String resultado = "raiz -> " + preOrdenRecursivo(raiz).trim();
        return resultado;
    }
}
