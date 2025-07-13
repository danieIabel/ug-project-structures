package proyecto.algoritmos;

import proyecto.utils.Aviso;

/**
 *
 * @author ABEL
 */
public class ListaCircular {

    private NodoCircular cabeza;

    public ListaCircular() {
        this.cabeza = null;
    }

    public void insertarInicio(String dato) {
        if ("".equals(dato)) {
            Aviso.datoVacio();
            return;
        }

        NodoCircular nuevo = new NodoCircular(dato);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoCircular actual = cabeza;
            while (actual.enlace != cabeza)
                actual = actual.enlace;
            nuevo.enlace = cabeza;
            cabeza = nuevo;
            actual.enlace = cabeza;
        }
    }
    
    public void insertarFinal(String dato) {
        if ("".equals(dato)) {
            Aviso.datoVacio();
            return;
        }

        NodoCircular nuevo = new NodoCircular(dato);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoCircular actual = cabeza;
            while (actual.enlace != cabeza)
                actual = actual.enlace;
            actual.enlace = nuevo;
            nuevo.enlace = cabeza;
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

        NodoCircular nuevo = new NodoCircular(dato);

        if (cabeza.informacion.equals(antesDe)) {
            NodoCircular actual = cabeza;

            while (actual.enlace != cabeza) {
                actual = actual.enlace;
            }

            nuevo.enlace = cabeza;
            actual.enlace = nuevo;
            cabeza = nuevo;
            return;
        }

        NodoCircular actual = cabeza;

        do {
            if (actual.enlace.informacion.equals(antesDe)) {
                nuevo.enlace = actual.enlace;
                actual.enlace = nuevo;
                return;
            }
            actual = actual.enlace;
        } while (actual != cabeza);

        Aviso.noEncontrado();
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

        NodoCircular actual = cabeza;

        do {
            if (actual.informacion.equals(despuesDe)) {
                NodoCircular nuevo = new NodoCircular(dato);
                nuevo.enlace = actual.enlace;
                actual.enlace = nuevo;
                return;
            }
            actual = actual.enlace;
        } while (actual != cabeza);

        Aviso.noEncontrado();
    }

    public void eliminarInicio() {
        if (cabeza == null) {
            Aviso.listaVacia();
            return;
        }

        if (cabeza.enlace == cabeza) {
            cabeza = null;
            return;
        }

        NodoCircular actual = cabeza;
        while (actual.enlace != cabeza)
            actual = actual.enlace;

        cabeza = cabeza.enlace;
        actual.enlace = cabeza;
    }

    public void eliminarFinal() {
        if (cabeza == null) {
            Aviso.listaVacia();
            return;
        }

        if (cabeza.enlace == cabeza) {
            cabeza = null;
            return;
        }

        NodoCircular actual = cabeza;
        NodoCircular anterior = null;

        while (actual.enlace != cabeza) {
            anterior = actual;
            actual = actual.enlace;
        }

        if (anterior != null)
            anterior.enlace = cabeza;
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
            eliminarInicio();
            return;
        }

        NodoCircular actual = cabeza;
        while (actual.enlace != cabeza && !actual.enlace.informacion.equals(dato))
            actual = actual.enlace;

        if (actual.enlace.informacion.equals(dato))
            actual.enlace = actual.enlace.enlace;
        else
            Aviso.noEncontrado();
    }

    public void eliminarAntesDe(String dato) {
        if ("".equals(dato)) {
            Aviso.refereciaVacia();
            return;
        }

        if (cabeza == null || cabeza.enlace == cabeza) {
            Aviso.noHaySuficientes();
            return;
        }

        if (cabeza.informacion.equals(dato)) {
            Aviso.noHayAnterior(dato);
            return;
        }

        NodoCircular anterior = null;
        NodoCircular actual = cabeza;
        NodoCircular siguiente = cabeza.enlace;

        do {
            if (siguiente.informacion.equals(dato)) {
                if (actual == cabeza) {
                    eliminarInicio();
                    return;
                }

                if (anterior != null)
                    anterior.enlace = siguiente;
                return;
            }

            anterior = actual;
            actual = siguiente;
            siguiente = siguiente.enlace;
        } while (actual != cabeza);

        Aviso.noEncontrado();
    }

    public NodoCircular getCabeza() {
        return cabeza;
    }

    @Override
    public String toString() {
        if (cabeza == null) {
            return "cabeza -> null";
        }

        String resultado = "cabeza -> ";
        NodoCircular actual = cabeza;

        do {
            resultado += "[" + actual.informacion + "] <-> ";
            actual = actual.enlace;
        } while (actual != cabeza);

        resultado += "(cabeza)";
        return resultado;
    }
}
