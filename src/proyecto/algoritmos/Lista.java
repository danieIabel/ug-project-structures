package proyecto.algoritmos;

import proyecto.utils.Aviso;

/**
 *
 * @author ABEL
 */
public class Lista {
    private Nodo cabeza;
       
    public Lista() {
        this.cabeza = null;
    }

    public void insertarInicio(String dato) {
        if ("".equals(dato)) {
            Aviso.datoVacio();
            return;
        }

        Nodo nuevo = new Nodo(dato);
        nuevo.enlace = cabeza;
        cabeza = nuevo;
    }

    public void insertarFinal(String dato) {
        if ("".equals(dato)) {
            Aviso.datoVacio();
            return;
        }

        Nodo nuevo = new Nodo(dato);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        Nodo actual = cabeza;

        while (actual.enlace != null) {
            actual = actual.enlace;
        }

        actual.enlace = nuevo;
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

        Nodo nuevoNodo = new Nodo(dato);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            return;
        }

        if (cabeza.informacion.equals(antesDe)) {
            nuevoNodo.enlace = cabeza;
            cabeza = nuevoNodo;
            return;
        }

        Nodo actual = cabeza;

        while (actual.enlace != null && !actual.enlace.informacion.equals(antesDe)) {
            actual = actual.enlace;
        }
        
        if (actual.enlace != null && actual.enlace.informacion.equals(antesDe)) {
            nuevoNodo.enlace = actual.enlace;
            actual.enlace = nuevoNodo;
        } else {
            Aviso.noEncontrado();
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

        Nodo nuevoNodo = new Nodo(dato);
        Nodo actual = cabeza;

        while (actual != null && !actual.informacion.equals(despuesDe)) {
            actual = actual.enlace;
        }

        if (actual != null && actual.informacion.equals(despuesDe)) {
            nuevoNodo.enlace = actual.enlace;
            actual.enlace = nuevoNodo;
        } else {
            Aviso.noEncontrado();
        }
    }

    public void eliminarInicio() {
        if (cabeza == null) {
            Aviso.listaVacia();
            return;
        }

        cabeza = cabeza.enlace;
    }

    public void eliminarFinal() {
        if (cabeza == null) {
            Aviso.listaVacia();
            return;
        }

        if (cabeza.enlace == null) {
            cabeza = null;
            return;
        }

        Nodo actual = cabeza;

        while (actual.enlace.enlace != null) {
            actual = actual.enlace;
        }

        actual.enlace = null;
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

        if (cabeza.informacion.equals(dato)) {
            cabeza = cabeza.enlace;
            return;
        }

        Nodo actual = cabeza;

        while (actual.enlace != null && !actual.enlace.informacion.equals(dato)) {
            actual = actual.enlace;
        }

        if (actual.enlace != null) {
            actual.enlace = actual.enlace.enlace;
        } else {
            Aviso.noEncontrado();
        }
    }

    public void eliminarAntesDe(String dato) {
        if ("".equals(dato)) {
            Aviso.noEncontrado();
            return;
        }

        if (cabeza == null) {
            Aviso.noEncontrado();
            return;
        }

        if (cabeza.enlace == null) {
            Aviso.noHaySuficientes();
            return;
        }

        if (cabeza.informacion.equals(dato)) {
            Aviso.noHayAnterior(dato);
            return;
        }

        Nodo anterior = null;
        Nodo actual = cabeza;

        while (actual.enlace != null && !actual.enlace.informacion.equals(dato)) {
            anterior = actual;
            actual = actual.enlace;
        }

        if (actual.enlace != null) {
            if (anterior == null) {
                cabeza = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
        } else {
            Aviso.noEncontrado();
        }
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    @Override
    public String toString() {
        String resultado = "cabeza -> ";
        Nodo actual = cabeza;

        while (actual != null) {
            resultado += "[" + actual.informacion + "] -> ";
            actual = actual.enlace;
        }

        resultado += "null";
        return resultado;
    }
}
