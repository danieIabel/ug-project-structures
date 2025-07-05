/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.utils;

import javax.swing.JOptionPane;

/**
 *
 * @author ABEL
 */
public class Aviso {

    public static void warn(String texto) {
        JOptionPane.showMessageDialog(null, texto, "Aviso", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void info(String texto) {
        JOptionPane.showMessageDialog(null, texto, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void error(String texto) {
        JOptionPane.showMessageDialog(null, texto, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void datoVacio() {
        JOptionPane.showMessageDialog(null, "El dato no puede estar vacío", "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    public static void listaVacia() {
        JOptionPane.showMessageDialog(null, "La lista está vacía");
    }

    public static void refereciaVacia() {
        JOptionPane.showMessageDialog(null, "La referencia no puede estar vacía", "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    public static void noEncontrado() {
        JOptionPane.showMessageDialog(null, "El elemento no esta en la lista");
    }

    public static void noHaySuficientes() {
        JOptionPane.showMessageDialog(null, "No hay nodos suficientes para eliminar");
    }

    public static void noHayAnterior(String dato) {
        JOptionPane.showMessageDialog(null, "No existe un nodo que preceda al que contiene " + dato, "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    public static void loginIncorrecto() {
        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de Login", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void pilaLlena(int max) {
        JOptionPane.showMessageDialog(null, "Pila llena, se ha alcanzado el máximo: " + max);
    }
    
    public static void pilaVacia(int tope) {
        JOptionPane.showMessageDialog(null, "Pila Vacía, el tope actual es: " + tope);
    }
    
    public static void colaLlena(int max) {
        JOptionPane.showMessageDialog(null, "Cola llena, se ha alcanzado el máximo: " + max);
    }
    
    public static void colaVacia(int tope) {
        JOptionPane.showMessageDialog(null, "Cola Vacía, el tope actual es: " + tope);
    }
    
    public static void nodoEncontrado(int valor) {
        JOptionPane.showMessageDialog(null, "El nodo con el valor " + valor + " si se encuentra en el arbol");
    }
    
    public static void nodoNoEncontrado(int valor) {
        JOptionPane.showMessageDialog(null, "Nodo con el valor " + valor + " no existe en el arbol", "No encontrado", JOptionPane.ERROR_MESSAGE);
    }
}
