package proyecto.algoritmos;

/**
 *
 * @author ABEL
 */
public class Nodo {
    public String informacion;
    public Nodo enlace;

    // Para identificar los nodos
    private static int contador = 0;
    private final int id;

    public Nodo(String informacion) {
        this.informacion = informacion;
        this.enlace = null;
        this.id = ++contador;
    }

    public static void setContador(int contador) {
        Nodo.contador = contador;
    }

    @Override
    public String toString() {
        return String.format("%03d", id);
    }
}


