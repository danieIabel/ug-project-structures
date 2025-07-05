package proyecto.algoritmos;

/**
 *
 * @author ABEL
 */
public class NodoArbol {
    public int informacion;
    public NodoArbol izquierda;
    public NodoArbol derecha;
    public NodoArbol padre;

    // Para identificar los nodos
    private static int contador = 0;
    private final int id;

    // Bandera temporal para saber si fue recorrido
    public boolean visitado = false;

    public NodoArbol(int informacion) {
        this.informacion = informacion;
        this.izquierda = null;
        this.derecha = null;
        this.padre = null;
        this.id = ++contador;
    }

    public static void setContador(int contador) {
        NodoArbol.contador = contador;
    } 
    
    @Override
    public String toString() {
        return String.format("%02d", id);
    }
}


