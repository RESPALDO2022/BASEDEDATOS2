package Formularios;

import Fondo.ImagenFondo;

public class fminicio extends javax.swing.JFrame {

    public fminicio() { 
        initComponents();
        this.setExtendedState(fminicio.MAXIMIZED_BOTH);
        this.setTitle("Sistema Reserva de Hotel");
        principal.setBorder(new ImagenFondo() );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principal = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        lblidpersona = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblapellido = new javax.swing.JLabel();
        lblacceso = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mnuinicio = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        mnuconsultas = new javax.swing.JMenu();
        mnuconfiguraciones = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        mnusalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        principal.setBackground(new java.awt.Color(255, 255, 255));
        principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        principal.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Felix Titling", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 0));
        jLabel1.setText("SISTEMA HOTEL");
        principal.add(jLabel1);
        jLabel1.setBounds(180, 50, 390, 70);

        lblidpersona.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblidpersona.setText("jLabel2");
        principal.add(lblidpersona);
        lblidpersona.setBounds(250, 150, 250, 30);

        lblnombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblnombre.setText("jLabel2");
        principal.add(lblnombre);
        lblnombre.setBounds(250, 200, 250, 30);

        lblapellido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblapellido.setText("jLabel2");
        principal.add(lblapellido);
        lblapellido.setBounds(250, 250, 250, 30);

        lblacceso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblacceso.setText("jLabel2");
        principal.add(lblacceso);
        lblacceso.setBounds(250, 300, 250, 30);

        menuBar.setBackground(new java.awt.Color(255, 204, 204));

        mnuinicio.setForeground(new java.awt.Color(51, 51, 0));
        mnuinicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inicio.jpeg"))); // NOI18N
        mnuinicio.setMnemonic('e');
        mnuinicio.setText("Inicio");
        mnuinicio.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        cutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/habitacion.png"))); // NOI18N
        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Habitaciones");
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        mnuinicio.add(cutMenuItem);

        copyMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/product.png"))); // NOI18N
        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Productos");
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        mnuinicio.add(copyMenuItem);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reservas.png"))); // NOI18N
        jMenuItem1.setText("Reservas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuinicio.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clientesa.png"))); // NOI18N
        jMenuItem2.setText("Clientes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuinicio.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pagos.png"))); // NOI18N
        jMenuItem3.setText("Pagos");
        mnuinicio.add(jMenuItem3);

        menuBar.add(mnuinicio);

        mnuconsultas.setForeground(new java.awt.Color(51, 51, 0));
        mnuconsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/consultas.jpeg"))); // NOI18N
        mnuconsultas.setText("Reportes");
        mnuconsultas.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        menuBar.add(mnuconsultas);

        mnuconfiguraciones.setForeground(new java.awt.Color(51, 51, 0));
        mnuconfiguraciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuracion.jpeg"))); // NOI18N
        mnuconfiguraciones.setText("Configuraciones");
        mnuconfiguraciones.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N
        jMenuItem4.setText("Trabajadores / Accesos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mnuconfiguraciones.add(jMenuItem4);

        menuBar.add(mnuconfiguraciones);

        mnusalir.setForeground(new java.awt.Color(51, 51, 0));
        mnusalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.jpeg"))); // NOI18N
        mnusalir.setText("Salir");
        mnusalir.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        mnusalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnusalirMouseClicked(evt);
            }
        });
        menuBar.add(mnusalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       fmreserva form = new fmreserva();
       principal.add(form);
       form.toFront();
       form.setVisible(true);
       fmreserva.txtidtrabajador.setText(lblidpersona.getText());
       fmreserva.txttrabajador.setText(lblnombre.getText() + " " + lblapellido.getText());
       fmreserva.idusuario = Integer.parseInt(lblidpersona.getText());
       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        fmtrabajador form = new fmtrabajador();
        principal.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed
        fmhabitacion form= new fmhabitacion();
        principal.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        fmcliente form = new fmcliente();
        principal.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
        fmproducto form = new fmproducto();
        principal.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void mnusalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnusalirMouseClicked
       this.dispose();
    }//GEN-LAST:event_mnusalirMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fminicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fminicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    public static javax.swing.JLabel lblacceso;
    public static javax.swing.JLabel lblapellido;
    public static javax.swing.JLabel lblidpersona;
    public static javax.swing.JLabel lblnombre;
    private javax.swing.JMenuBar menuBar;
    public static javax.swing.JMenu mnuconfiguraciones;
    public static javax.swing.JMenu mnuconsultas;
    private javax.swing.JMenu mnuinicio;
    private javax.swing.JMenu mnusalir;
    private javax.swing.JDesktopPane principal;
    // End of variables declaration//GEN-END:variables

}
