/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.ControllerRedes;
import Controller.EquiposCbx;
import javax.swing.JOptionPane;
import MTables.MTableRedes;
import Utiles.Utiles;

/**
 *
 * @author danny
 */
public class RedesView extends javax.swing.JFrame {

    private final ControllerRedes redes = new ControllerRedes();
    private MTableRedes mTableRedes = new MTableRedes();
    private Integer fila = -1;

    public RedesView() {
        initComponents();
        EquiposCbx.cargarNroEquipos(cbxSeleccionEquipos);
    }

    public void cargarTable() {
        mTableRedes.setRedes(redes);
        tblRedes.setModel(mTableRedes);
        tblRedes.updateUI();
    }

    public void clean() {
        txtIPEquipo.setText("");
        txtNombreEquipo.setText("");
        txtTransmisionAlta.setText("");
        txtTransmisionBaja.setText("");
        cargarTable();
        fila = -1;
        tblRedes.clearSelection();
    }

    private Boolean verify() {
        return txtIPEquipo.getText().trim().isEmpty() || txtNombreEquipo.getText().trim().isEmpty() || txtTransmisionAlta.getText().trim().isEmpty() || txtTransmisionBaja.getText().trim().isEmpty();
    }

    public void registrarMatriz() {
        if (verify()) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "CUIDAO", JOptionPane.ERROR_MESSAGE);
        } else {
            if (Utiles.validate(txtIPEquipo.getText().trim())) {
                Float transAlta = Utiles.transformStringFloat(txtTransmisionAlta.getText().trim());
                Float transBaja = Utiles.transformStringFloat(txtTransmisionBaja.getText().trim());
                if (fila == -1) {
                    if (redes.guardar(txtIPEquipo.getText().trim(), txtNombreEquipo.getText().trim(), transAlta, transBaja)) {
                        clean();
                        //promedio
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "ERROR AL GUARDAR", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "INGRESE UNA IP VALIDA", "Que bruto", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void createMatriz() {
        Integer nro = (Integer) cbxSeleccionEquipos.getSelectedItem();
        if (nro != null) {
            redes.crear(nro);
            cargarTable();
            txtIPEquipo.setEnabled(true);
            txtNombreEquipo.setEnabled(true);
            txtTransmisionAlta.setEnabled(true);
            txtTransmisionBaja.setEnabled(true);
            btnGuardar.setEnabled(true);
            tblRedes.setEnabled(true);
        }
    }
    Holaxd
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRedes = new javax.swing.JTable();
        cbxSeleccionEquipos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombreEquipo = new javax.swing.JTextField();
        txtIPEquipo = new javax.swing.JTextField();
        txtTransmisionAlta = new javax.swing.JTextField();
        txtTransmisionBaja = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();
        btnRegistrarMedia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        setLocation(new java.awt.Point(1000, 50));
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel1.setText("INGRESE LA TRANSMISION BAJA:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 200, 30));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jScrollPane1MousePressed(evt);
            }
        });

        tblRedes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "IP", "NOMBRE DE EQUIPO", "TRANSMISION ALTA", "TRANSMISION BAJA"
            }
        ));
        tblRedes.setEnabled(false);
        tblRedes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRedesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblRedesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblRedes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 630, 160));

        cbxSeleccionEquipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSeleccionEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSeleccionEquiposActionPerformed(evt);
            }
        });
        jPanel1.add(cbxSeleccionEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 22)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REDES DE COMUNICACION");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 50));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel3.setText("SELECCIONE LA CANTIDAD DE EQUIPOS:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 270, 30));

        jLabel4.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel4.setText("INGRESE LA IP:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 110, 30));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel5.setText("INGRESE EL NOMBRE:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 140, 30));

        jLabel6.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel6.setText("INGRESE LA TRANSMISION ALTA:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 200, 30));

        txtNombreEquipo.setEnabled(false);
        jPanel1.add(txtNombreEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 140, -1));

        txtIPEquipo.setEnabled(false);
        jPanel1.add(txtIPEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 140, -1));

        txtTransmisionAlta.setEnabled(false);
        jPanel1.add(txtTransmisionAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 130, -1));

        txtTransmisionBaja.setEnabled(false);
        jPanel1.add(txtTransmisionBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 130, -1));

        btnGuardar.setText("GUARDAR");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, -1, -1));

        btnGenerar.setText("GENERAR");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

        btnRegistrarMedia.setText("REGISTRAR MEDIA");
        jPanel1.add(btnRegistrarMedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxSeleccionEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSeleccionEquiposActionPerformed

    }//GEN-LAST:event_cbxSeleccionEquiposActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        createMatriz();
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        registrarMatriz();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jScrollPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MousePressed

    }//GEN-LAST:event_jScrollPane1MousePressed

    private void tblRedesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRedesMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblRedesMousePressed

    private void tblRedesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRedesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblRedesMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(RedesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RedesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RedesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RedesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RedesView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegistrarMedia;
    private javax.swing.JComboBox<String> cbxSeleccionEquipos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRedes;
    private javax.swing.JTextField txtIPEquipo;
    private javax.swing.JTextField txtNombreEquipo;
    private javax.swing.JTextField txtTransmisionAlta;
    private javax.swing.JTextField txtTransmisionBaja;
    // End of variables declaration//GEN-END:variables
}
