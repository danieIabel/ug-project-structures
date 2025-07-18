/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyecto;

import java.awt.Color;
import javax.swing.JTextField;
import proyecto.utils.Aviso;

/**
 *
 * @author ABEL
 */
public class Login extends javax.swing.JPanel {
    String USUARIO = "admin";
    String PASS = "admin";
    String PLACEHOLDER_USUARIO = "Ingrese usuario";
    String PLACEHOLDER_PASS = "Ingrese contraseña";

    private Runnable loginListener;

    /**
     * Creates new form Bienvenido
     */
    public Login() {
        initComponents();
        addPlaceHolder(usuario, PLACEHOLDER_USUARIO);
        addPlaceHolder(password, PLACEHOLDER_PASS);
    }

    public void comprobar(Runnable listener) {
        this.loginListener = listener;
    }

    public static void addPlaceHolder(JTextField text, String placeholder) {
        text.setForeground(Color.gray);
        text.setText(placeholder);
    }

    public static void removePlaceHolder(JTextField text, String placeholder) {
        if (text.getText().equals(placeholder)) {
            text.setForeground(Color.black);
            text.setText("");
        }
    }

    public static void handlePlaceHolder(JTextField text, String placeholder) {
        String currentText = text.getText();

        if (currentText.equals(placeholder)) {
            removePlaceHolder(text, placeholder);
        } else if (currentText.isEmpty()) {
            addPlaceHolder(text, placeholder);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        infoLogin = new javax.swing.JPanel();
        bienvenidoText = new javax.swing.JLabel();
        asignaturaText = new javax.swing.JLabel();
        cursoText = new javax.swing.JLabel();
        grupoText = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        isotipo = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        iniciarSesion = new javax.swing.JButton();

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        infoLogin.setBackground(new java.awt.Color(50, 51, 128));

        bienvenidoText.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        bienvenidoText.setForeground(new java.awt.Color(255, 255, 255));
        bienvenidoText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bienvenidoText.setText("Bienvenido usuario");

        asignaturaText.setBackground(new java.awt.Color(255, 255, 255));
        asignaturaText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        asignaturaText.setForeground(new java.awt.Color(255, 255, 255));
        asignaturaText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        asignaturaText.setText("Estructura de Datos");

        cursoText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cursoText.setForeground(new java.awt.Color(255, 255, 255));
        cursoText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cursoText.setText("CURSO SOF-S-MA-3-1");

        grupoText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        grupoText.setForeground(new java.awt.Color(255, 255, 255));
        grupoText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        grupoText.setText("Abel Moreira");

        javax.swing.GroupLayout infoLoginLayout = new javax.swing.GroupLayout(infoLogin);
        infoLogin.setLayout(infoLoginLayout);
        infoLoginLayout.setHorizontalGroup(
            infoLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bienvenidoText, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(asignaturaText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cursoText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(grupoText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        infoLoginLayout.setVerticalGroup(
            infoLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoLoginLayout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(bienvenidoText)
                .addGap(18, 18, 18)
                .addComponent(asignaturaText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cursoText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(grupoText)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        background.add(infoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        isotipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        isotipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/isologo.png"))); // NOI18N
        jPanel1.add(isotipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 500, 70));

        usuario.setText("Ingrese usuario");
        usuario.setToolTipText("Ingrese el nombre de usuario");
        usuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usuarioFocusLost(evt);
            }
        });
        usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usuarioKeyTyped(evt);
            }
        });
        jPanel1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 200, 38));

        password.setText("Ingrese contraseña");
        password.setToolTipText("Ingrese su contraseña");
        password.setEchoChar('\u0000');
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 200, 38));

        iniciarSesion.setText("Iniciar Sesion");
        iniciarSesion.setToolTipText("");
        iniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(iniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 200, 38));

        background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 500, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSesionActionPerformed
        // TODO add your handling code here:
        String usuarioInput = usuario.getText();
        String passInput = new String(password.getPassword());

        if (usuarioInput.equals(USUARIO) && passInput.equals(PASS)) {
            if (loginListener != null) {
                loginListener.run();
            }
        } else {
            Aviso.loginIncorrecto();
        }
    }//GEN-LAST:event_iniciarSesionActionPerformed

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
        // TODO add your handling code here:
        if (!Character.isLetterOrDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_passwordKeyTyped

    private void usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyTyped
        // TODO add your handling code here:
        if (!Character.isLetterOrDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_usuarioKeyTyped

    private void usuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usuarioFocusGained
        // TODO add your handling code here:
        handlePlaceHolder(usuario, PLACEHOLDER_USUARIO);
    }//GEN-LAST:event_usuarioFocusGained

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
        // TODO add your handling code here:
        if (password.getPassword().equals(PLACEHOLDER_PASS))
            password.setEchoChar('\u25cf');
            
        handlePlaceHolder(password, PLACEHOLDER_PASS);
    }//GEN-LAST:event_passwordFocusGained

    private void usuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usuarioFocusLost
        // TODO add your handling code here:
        handlePlaceHolder(usuario, PLACEHOLDER_USUARIO);
    }//GEN-LAST:event_usuarioFocusLost

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        // TODO add your handling code here:
        if (password.getPassword().equals(""))
            password.setEchoChar('\u0000');
        handlePlaceHolder(password, PLACEHOLDER_PASS);
    }//GEN-LAST:event_passwordFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel asignaturaText;
    private javax.swing.JPanel background;
    private javax.swing.JLabel bienvenidoText;
    private javax.swing.JLabel cursoText;
    private javax.swing.JLabel grupoText;
    private javax.swing.JPanel infoLogin;
    private javax.swing.JButton iniciarSesion;
    private javax.swing.JLabel isotipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
