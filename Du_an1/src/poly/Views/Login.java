/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package poly.Views;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import poly.Model.NguoiDung;
import poly.Services.NguoiDungServices;
import poly.ViewModels.NguoiDungViewModels;

/**
 *
 * @author DELL
 */
public class Login extends javax.swing.JFrame {
    
    private NguoiDungServices ndser = new NguoiDungServices();
    private Dat_ve c;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setLocation(300, 200);
        
    }
    
    private void checkdn() {
        ArrayList<NguoiDungViewModels> ndvm = ndser.getThongTin();
        for (NguoiDungViewModels n : ndvm) {
            n.getId();
            n.getPass();
            
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 0));
        jLabel3.setText("Đặt vé online");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 16, -1, -1));

        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("User");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 51, 204));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        txtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuserActionPerformed(evt);
            }
        });
        getContentPane().add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 260, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        jButton2.setText("Đăng kí");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Accept.png"))); // NOI18N
        jButton3.setText("Đăng nhập");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("Hotline: 0386644656");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 328, -1, -1));

        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Chân thành cảm ơn quý khách!");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 336, -1, -1));
        getContentPane().add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 260, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/Views/rsz_1626711605_447_hinh-nen-anime-cuc-dep-cuc-net-cho-nguoi-thich.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (true) {
            new Reignter().setVisible(true);
            this.setVisible(false);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (txtpassword.getText().trim().equals("") || txtuser.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin!");
            return;
        }
        String id = txtuser.getText();
        String pass = txtpassword.getText();
        NguoiDung nd = ndser.getDuLieu(id, pass);
        if (nd == null) {
            JOptionPane.showMessageDialog(this, "Thông tin tài khoản mật khẩu không chính xác");
            
        } else {
            NguoiDung nguoiDung = new NguoiDung();
            nguoiDung.setTen(nd.getTen());
            nguoiDung.setGioitinh(nd.getGioitinh());
            nguoiDung.setEmail(nd.getEmail());
            nguoiDung.setSdt(nd.getSdt());
            nguoiDung.setCmnd(nd.getCmnd());
            Dat_ve datve = new Dat_ve(nguoiDung);
            this.dispose();
            datve.setVisible(true);
        }
        

    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuserActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
