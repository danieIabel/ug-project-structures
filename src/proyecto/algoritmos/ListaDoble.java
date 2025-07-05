package proyecto.algoritmos;

import proyecto.utils.Aviso;

/**
 *
 * @author ABEL
 */
public class ListaDoble {
    private NodoDoble cabeza;
    private NodoDoble cola;

    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
    }

    public void insertarInicio(String dato) {
        if ("".equals(dato)) {
            Aviso.datoVacio();
            return;
        }

        NodoDoble nuevo = new NodoDoble(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
    }

    public void insertarFinal(String dato) {
        if ("".equals(dato)) {
            Aviso.datoVacio();
            return;
        }

        NodoDoble nuevo = new NodoDoble(dato);
        if (cola == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    public void insertarAntes(String dato, String antesDe) {
        if ("".equals(dato)) {
            Aviso.datoVacio();
            return;
        }

        if ("".equals(antesDe)) {
            Aviso.refereciaVacia();
            return;
        }

        if (cabeza == null) {
            Aviso.listaVacia();
            return;
        }

        NodoDoble actual = cabeza;

        while (actual != null && !actual.informacion.equals(antesDe)) {
            actual = actual.siguiente;
        }

        if (actual == null) {
            Aviso.noEncontrado();
            return;
        }

        NodoDoble nuevo = new NodoDoble(dato);

        if (actual == cabeza) {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        } else {
            nuevo.anterior = actual.anterior;
            nuevo.siguiente = actual;
            actual.anterior.siguiente = nuevo;
            actual.anterior = nuevo;
        }
    }

    public void insertarDespues(String dato, String despuesDe) {
        if ("".equals(dato)) {
            Aviso.datoVacio();
            return;
        }

        if ("".equals(despuesDe)) {
            Aviso.refereciaVacia();
            return;
        }

        if (cabeza == null) {
            Aviso.listaVacia();
            return;
        }

        NodoDoble actual = cabeza;

        while (actual != null && !actual.informacion.equals(despuesDe)) {
            actual = actual.siguiente;
        }

        if (actual == null) {
            Aviso.noEncontrado();
            return;
        }

        NodoDoble nuevo = new NodoDoble(dato);

        if (actual == cola) {
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
            cola = nuevo;
        } else {
            nuevo.siguiente = actual.siguiente;
            nuevo.anterior = actual;
            actual.siguiente.anterior = nuevo;
            actual.siguiente = nuevo;
        }
    }

    public void eliminarInicio() {
        if (cabeza == null) {
            Aviso.listaVacia();
            return;
        }

        if (cabeza == cola) {
            cola = null;
            cabeza = null;
        } else {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        }
    }

    public void eliminarFinal() {
        if (cola == null) {
            Aviso.listaVacia();
            return;
        }

        if (cabeza == cola) {
            cola = null;
            cabeza = null;
        } else {
            cola = cola.anterior;
            cola.siguiente = null;
        }
    }

    public void eliminarEste(String dato) {
        if ("".equals(dato)) {
            Aviso.refereciaVacia();
            return;
        }

        if (cabeza == null) {
            Aviso.listaVacia();
            return;
        }
        
        NodoDoble actual = cabeza;

        while (actual != null && !actual.informacion.equals(dato)) {
            actual = actual.siguiente;
        }

        if (actual == null) {
            Aviso.noEncontrado();
            return;
        }

        if (actual == cabeza) {
            eliminarInicio();
        } else if (actual == cola) {
            eliminarFinal();
        } else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }
    }

    public void eliminarAntesDe(String dato) {
        if ("".equals(dato)) {
            Aviso.refereciaVacia();
            return;
        }

        if (cabeza == null || cabeza.siguiente == null) {
            Aviso.noHaySuficientes();
            return;
        }

        NodoDoble actual = cabeza.siguiente;

        while (actual != null && !actual.informacion.equals(dato)) {
            actual = actual.siguiente;
        }

        if (actual == null) {
            Aviso.noEncontrado();
            return;
        }
        
        if (actual.anterior == null) {
            Aviso.noHayAnterior(dato);
            return;
        }

        if (actual.anterior == cabeza) {
            eliminarInicio();
        } else {
            NodoDoble nodoAEliminar = actual.anterior;
            nodoAEliminar.anterior.siguiente = actual;
            actual.anterior = nodoAEliminar.anterior;
        }
    }

    public NodoDoble getCabeza() {
        return cabeza;
    }

    public NodoDoble getCola() {
        return cola;
    }
    
    @Override
    public String toString() {
        String resultado = "cabeza -> ";
        NodoDoble actual = cabeza;

        while (actual != null) {
            resultado += "[" + actual.informacion + "] <-> ";
            actual = actual.siguiente;
        }

        resultado += "null";
        return resultado;
    }
}
