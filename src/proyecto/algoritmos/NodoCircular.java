package proyecto.algoritmos;

/**
 *
 * @author ABEL
 */
public class NodoCircular {
    public String informacion;
    public NodoCircular enlace;

    // Para identificar los nodos
    private static int contador = 0;
    private final int id;

    public NodoCircular(String informacion) {
        this.informacion = informacion;
        this.enlace = this;
        this.id = ++contador;
    }

    public static void setContador(int contador) {
        NodoCircular.contador = contador;
    }

    @Override
    public String toString() {
        return String.format("%03d", id);
    }
}


