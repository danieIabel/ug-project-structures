/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.utils;

import java.awt.Dimension;
import javax.swing.JComponent;

/**
 *
 * @author ABEL
 */
public class Panel {
    public static void lockSize(JComponent componente) {
        Dimension pref = componente.getPreferredSize();
        componente.setMinimumSize(pref);
        componente.setMaximumSize(pref);
    }
}
