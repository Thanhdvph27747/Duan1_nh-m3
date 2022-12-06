/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package poly.Views;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import poly.Model.NguoiDung;
import poly.Services.NguoiDungServices;

/**
 *
 * @author DELL
 */
public class Reignter extends javax.swing.JFrame {

    private NguoiDungServices nguoiDungServices= new NguoiDungServices();
    
    public Reignter() {
        initComponents();
        rdonam.setSelected(true);
        setLocation(450, 110);
    }
    private NguoiDung getNguoiDungFormInput(){
        NguoiDung n = new NguoiDung();
        n.setId(txtuser.getText());
        n.setPass(txtpass.getText());
        n.setTen(txtten.getText());
        n.setHo(txtho.getText());
        if(rdonam.isSelected()){
            n.setGioitinh(1);
        }else{
            n.setGioitinh(0);
        }
        n.setCmnd(txtcmnd.getText());
        n.setEmail(txtemail.getText());
        n.setSdt(txtsdt.getText());
        return n;
    }

    private void clearForm() {
        txtuser.setText("");
        txtpass.setText("");
        txtnhaplaipass.setText("");
        txtten.setText("");
        txtho.setText("");
        rdonam.setSelected(true);
        txtcmnd.setText("");
        txtemail.setText("");
        txtsdt.setText("");
        
    }

//    public boolean checkValidate(){
//        
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        txtnhaplaipass = new javax.swing.JPasswordField();
        txtten = new javax.swing.JTextField();
        txtho = new javax.swing.JTextField();
        txtsdt = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtcmnd = new javax.swing.JTextField();
        rdonam = new javax.swing.JRadioButton();
        rdonu = new javax.swing.JRadioButton();
        btnDangKy = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(204, 255, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 204));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fpt.png"))); // NOI18N
        jLabel10.setText("FPT Polytechnic");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("User");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 59, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 93, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Nhập lại pass");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 133, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tên");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 167, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Họ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 201, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Giới tính");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Số CMND");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Email");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("SĐT");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        txtuser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 56, 199, -1));

        txtpass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 90, 199, -1));

        txtnhaplaipass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtnhaplaipass, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 130, 199, -1));

        txtten.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtten, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 164, 199, -1));

        txtho.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtho, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 198, 199, -1));

        txtsdt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtsdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 199, -1));

        txtemail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 199, -1));

        txtcmnd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtcmnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 199, -1));

        buttonGroup1.add(rdonam);
        rdonam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdonam.setForeground(new java.awt.Color(255, 0, 0));
        rdonam.setText("Nam");
        getContentPane().add(rdonam, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        buttonGroup1.add(rdonu);
        rdonu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdonu.setForeground(new java.awt.Color(255, 0, 0));
        rdonu.setText("Nữ");
        getContentPane().add(rdonu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, -1, -1));

        btnDangKy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDangKy.setForeground(new java.awt.Color(153, 0, 204));
        btnDangKy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Disconnect.png"))); // NOI18N
        btnDangKy.setText("Đăng kí");
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });
        getContentPane().add(btnDangKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, -1, -1));

        btnQuayLai.setForeground(new java.awt.Color(102, 102, 255));
        btnQuayLai.setText("Quay lại >");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuayLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(102, 255, 204));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        // TODO add your handling code here:
        if (txtho.getText().equals("") || txtten.getText().equals("")
                || txtuser.getText().equals("") || txtpass.getText().equals("")
                || txtsdt.getText().equals("") || txtemail.getText().equals("")
                || txtcmnd.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!");
            return;
        }
        if (!txtnhaplaipass.getText().equals(txtpass.getText())) {
            JOptionPane.showMessageDialog(this, "Xác nhận mật khẩu đang sai!");
            return;
        }
        NguoiDung n = getNguoiDungFormInput();
        if (nguoiDungServices.addReignter(n) != null) {
            JOptionPane.showMessageDialog(this, "Đăng kí thành công");
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Thất bại!");
        }

    }//GEN-LAST:event_btnDangKyActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnQuayLaiActionPerformed

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
            java.util.logging.Logger.getLogger(Reignter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reignter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reignter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reignter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reignter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKy;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rdonam;
    private javax.swing.JRadioButton rdonu;
    private javax.swing.JTextField txtcmnd;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtho;
    private javax.swing.JPasswordField txtnhaplaipass;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txtten;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
