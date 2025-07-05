package proyecto.algoritmos;

/**
 *
 * @author ABEL
 */
public class NodoDoble {
    public String informacion;
    public NodoDoble siguiente;
    public NodoDoble anterior;

    // Para identificar los nodos
    private static int contador = 0;
    private final int id;

    public NodoDoble(String informacion) {
        this.informacion = informacion;
        this.siguiente = null;
        this.anterior = null;
        this.id = ++contador;
    }

    public static void setContador(int contador) {
        NodoDoble.contador = contador;
    }

    @Override
    public String toString() {
        return String.format("%03d", id);
    }
}


