/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyecto.componentes;
import java.awt.Color;

/**
 *
 * @author ABEL
 */
public class PanelArreglo extends javax.swing.JPanel {

    /**
     * Creates new form PanelNodo
     * @param data
     */
    public PanelArreglo(String data) {
        initComponents();
        valorInfo.setText(data);
    }

    public void setColorInfo(Color color) {
        bgInfo.setBackground(color);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgNodo = new javax.swing.JPanel();
        bgInfo = new javax.swing.JPanel();
        valorInfo = new javax.swing.JLabel();

        bgNodo.setBackground(new java.awt.Color(255, 255, 255));
        bgNodo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bgNodo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bgInfo.setBackground(new java.awt.Color(99, 102, 241));
        bgInfo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(21, 23, 85)));
        bgInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        valorInfo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        valorInfo.setForeground(new java.awt.Color(255, 255, 255));
        valorInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorInfo.setText("NULL");
        bgInfo.add(valorInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, -1));

        bgNodo.add(bgInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgNodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgNodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgInfo;
    private javax.swing.JPanel bgNodo;
    private javax.swing.JLabel valorInfo;
    // End of variables declaration//GEN-END:variables
}
