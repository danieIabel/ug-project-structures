/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.utils;

/**
 *
 * @author ABEL
 */
public class Arreglo {

    public static String mostrarArreglo(String[] array) {
        if (array == null) return "Sin definir";
        String resultado = "[";

        for (int i = 0; i < array.length; i++) {
            if (i > 0) resultado += ", ";
            resultado += (array[i] != null ? array[i] : "--");
        }

        return resultado += "]";
    }

    public static void eliminarPrimero(int contador, String[] arreglo) {
        if (contador == 0) return;
        for (int i = 0; i < contador - 1; i++)
            arreglo[i] = arreglo[i + 1];

        arreglo[contador - 1] = null;
    }
    
    public static void eliminarUltimo(int contador, String[] arreglo) {
        if (contador == 0) return;
        arreglo[contador - 1] = null;
    }
}
