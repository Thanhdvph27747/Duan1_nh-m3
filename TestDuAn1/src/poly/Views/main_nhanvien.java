/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package poly.Views;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import poly.Model.NhanVien;
import poly.Model.Tau;
import poly.Model.Traintickets;
import poly.Services.ITrainTicketService;
import poly.Services.TrainticketsService;
import poly.Services.impl.TrainTickServiceImpl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import poly.ViewModels.TrainTicketViewModel;

/**
 *
 * @author DELL
 */
public class main_nhanvien extends javax.swing.JFrame {

    private TrainticketsService veser = new TrainticketsService();
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultComboBoxModel defaultComboBoxModel;
    private ITrainTicketService trainTicketService = new TrainTickServiceImpl();
    private ArrayList<Tau> getListVeTau = trainTicketService.getCbTau();
    private ArrayList<Traintickets> getListThanhToan = veser.checkthanhtoan();
    private ArrayList<Traintickets> getDanhSachVe = veser.getTTVe();

    public main_nhanvien() {
        initComponents();
        loadthanhtoan();
        setLocationRelativeTo(null);
        loadCbTau(trainTicketService.getCbTau());
        loadDatVe();
    }

    public main_nhanvien(NhanVien nv) {
        initComponents();
        loadthanhtoan();
        setLocationRelativeTo(null);
        lblma.setText(nv.getMa());
        lblho.setText(nv.getHo());
        lblten.setText(nv.getTen());
        lblemail.setText(nv.getEmail());
        lblgioitinh.setText(nv.getGioiTinh());
        lbMaQuan.setText(nv.getMaQuan());
        loadCbTau(trainTicketService.getCbTau());
        loadDatVe();
    }

    public void loadthanhtoan() {
        ArrayList<Traintickets> v = veser.checkthanhtoan();
        dtm = (DefaultTableModel) tblxacnhan.getModel();
        dtm.setRowCount(0);
        txtmave.setText("");
        for (Traintickets x : v) {
            dtm.addRow(new Object[]{
                x.getId(),
                x.getNguoidung().getTen(),
                x.getGiokhoihanh(), x.getGioden(),
                x.getTau().getTentau(), x.getTau().getToa(), x.getTau().getVitri(),
                x.getGia(),
                x.getNguoidung().getEmail()
            });
        }
    }

    public void loadCbTau(ArrayList<Tau> getList) {
        cbTenTau.removeAllItems();
        defaultComboBoxModel = (DefaultComboBoxModel) cbTenTau.getModel();
        for (Tau tau : getList) {
            defaultComboBoxModel.addElement(tau.getTentau());
        }
    }

    private void loadDatVe() {
        ArrayList<Traintickets> ve = veser.getTTVe();
        dtm = (DefaultTableModel) tblQuanLyVe.getModel();
        dtm.setRowCount(0);
        dtm.setColumnIdentifiers(new String[]{"Ngày đi", "Price", "Thuế", "Giờ khởi hành", "Giờ đến", "Điểm đi", "Điểm đến", "Tên tàu"});
        for (Traintickets n : ve) {
            dtm.addRow(new Object[]{
                // n.getId(),
                n.getNgaydi(),
                n.getGia(), n.getThue(),
                n.getGiokhoihanh(), n.getGioden(),
                n.getDiemdi(), n.getDiemden(),
                n.getTau().getTentau(), // n.getTau().getToa(), n.getTau().getVitri(), 
            });
        }
    }

    public boolean checkValidate() {
        if (jDateNgayDi.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Ngày đi không được bỏ trống");
            return false;
        }
        if (jDateNgayDi.getDate().before(new Date())) {
            JOptionPane.showMessageDialog(this, "Chọn ngày không hợp lệ");
            return false;
        }
        if (txtPrice.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Giá không được bỏ trống");
            return false;
        }

        try {
            double gia = Double.parseDouble(txtPrice.getText());
            if (gia <= 0) {
                JOptionPane.showMessageDialog(this, "Giá phải lớn hơn 0");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giá phải nhập số");
            return false;
        }
        if (txtThue.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Thuế không được bỏ trống");
            return false;
        }

        try {
            double thue = Double.parseDouble(txtThue.getText());
            if (thue <= 0) {
                JOptionPane.showMessageDialog(this, "Thuế phải lớn hơn 0");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thuế phải nhập số");
            return false;
        }
        if (cbDiemDen.getSelectedItem().toString().equalsIgnoreCase(cbDiemDi.getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(this, "Điểm đi và điểm đến không được trùng");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu3 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblxacnhan = new javax.swing.JTable();
        btnxacnhan = new javax.swing.JButton();
        btnhuy = new javax.swing.JButton();
        txtmave = new javax.swing.JTextField();
        btnLamMoi = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblma = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblho = new javax.swing.JLabel();
        lblten = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        lblgioitinh = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbMaQuan = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQuanLyVe = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbDiemDi = new javax.swing.JComboBox<>();
        cbDiemDen = new javax.swing.JComboBox<>();
        cbTenTau = new javax.swing.JComboBox<>();
        jDateNgayDi = new com.toedter.calendar.JDateChooser();
        txtPrice = new javax.swing.JTextField();
        txtThue = new javax.swing.JTextField();
        txtGioKhoiHanh = new javax.swing.JTextField();
        txtGioDen = new javax.swing.JTextField();
        btnThemVe = new javax.swing.JButton();
        btnSuaVeTau = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("jMenu3");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(51, 255, 204));

        tblxacnhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã vé", "Tên", "Giờ khởi hành", "Giờ đến", "Tên tàu", "Toa", "Vị trí", "Giá"
            }
        ));
        tblxacnhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblxacnhanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblxacnhan);

        btnxacnhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Accept.png"))); // NOI18N
        btnxacnhan.setText("Xác nhận");
        btnxacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxacnhanActionPerformed(evt);
            }
        });

        btnhuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/No.png"))); // NOI18N
        btnhuy.setText("Hủy");
        btnhuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhuyActionPerformed(evt);
            }
        });

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtmave, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btnLamMoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnxacnhan)
                .addGap(118, 118, 118)
                .addComponent(btnhuy)
                .addGap(115, 115, 115))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(txtmave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnxacnhan)
                    .addComponent(btnhuy)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Xác nhận thanh toán", jPanel3);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Key.png"))); // NOI18N
        jLabel1.setText("Mã nhân viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/To do list.png"))); // NOI18N
        jLabel2.setText("Họ : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Clien list.png"))); // NOI18N
        jLabel3.setText("Tên : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Documents.png"))); // NOI18N
        jLabel4.setText("Email : ");

        lblma.setText("null");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rsz_2gioitinh.png"))); // NOI18N
        jLabel6.setText("Giới tính : ");

        lblho.setText("null");

        lblten.setText("null");

        lblemail.setText("null");

        lblgioitinh.setText("null");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poly/Views/rsz_bieu-tuong-dia-chi-png-dep.png"))); // NOI18N
        jLabel7.setText("Mã quận");

        lbMaQuan.setText("null");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(89, 89, 89)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMaQuan)
                    .addComponent(lblgioitinh)
                    .addComponent(lblemail)
                    .addComponent(lblten)
                    .addComponent(lblho)
                    .addComponent(lblma))
                .addContainerGap(282, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblma))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblho))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblten))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblemail))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblgioitinh))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbMaQuan))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông tin nhân viên", jPanel1);

        jPanel4.setBackground(new java.awt.Color(102, 255, 102));

        tblQuanLyVe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblQuanLyVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanLyVeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQuanLyVe);

        jLabel5.setText("Ngày đi");

        jLabel8.setText("Price");

        jLabel9.setText("Giờ khởi hành");

        jLabel10.setText("Giờ đến");

        jLabel11.setText("Tên tàu");

        jLabel12.setText("Điểm đi");

        jLabel13.setText("Điểm đến");

        jLabel14.setText("Thuế");

        cbDiemDi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hà Nội", "Hải Dương", "Hải Phòng", "Quảng Ninh", "Móng Cái" }));

        cbDiemDen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hà Nội", "Hải Dương", "Hải Phòng", "Quảng Ninh", "Móng Cái" }));

        cbTenTau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jDateNgayDi.setDateFormatString("dd-MM-yyyy");

        btnThemVe.setText("Thêm");
        btnThemVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVeActionPerformed(evt);
            }
        });

        btnSuaVeTau.setText("Sửa");
        btnSuaVeTau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaVeTauActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(txtThue)
                                                .addGap(107, 107, 107)
                                                .addComponent(jLabel11))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jDateNgayDi, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                                    .addComponent(txtPrice))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel12))))
                                        .addGap(43, 43, 43)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbDiemDi, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbDiemDen, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbTenTau, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(49, 49, 49))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtGioKhoiHanh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                            .addComponent(txtGioDen, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnThemVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(86, 86, 86)
                                        .addComponent(btnSuaVeTau)
                                        .addGap(77, 77, 77)))))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel12)
                        .addComponent(cbDiemDi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateNgayDi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13)
                    .addComponent(cbDiemDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(cbTenTau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtGioKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemVe)
                    .addComponent(btnSuaVeTau))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtGioDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản lí chuyến tàu", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVeActionPerformed
        if (checkValidate()) {
            TrainTicketViewModel traintickets = new TrainTicketViewModel();
            traintickets.setNgayDi(jDateNgayDi.getDate());
            traintickets.setPrice(Double.parseDouble(txtPrice.getText()));
            traintickets.setThue(Double.parseDouble(txtThue.getText()));
            traintickets.setGioKhoiHanh(txtGioKhoiHanh.getText());
            traintickets.setGioDen(txtGioDen.getText());
            traintickets.setDiemDi(cbDiemDi.getSelectedItem().toString());
            traintickets.setDiemDen(cbDiemDen.getSelectedItem().toString());

            int index = cbTenTau.getSelectedIndex();
            Tau t = getListVeTau.get(index);
            traintickets.setTenTau(t.getId());

            JOptionPane.showMessageDialog(this, trainTicketService.themVe(traintickets));
            loadDatVe();
            loadCbTau(trainTicketService.getCbTau());
        }
    }//GEN-LAST:event_btnThemVeActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        loadthanhtoan();
        loadDatVe();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnhuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhuyActionPerformed
        // TODO add your handling code here:
        int row = tblxacnhan.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chưa có yêu cầu thanh toán");
            return;
        }
        int con = JOptionPane.showConfirmDialog(this, "Xác nhận hủy vé chứ");
        if (con == JOptionPane.NO_OPTION || con == JOptionPane.CANCEL_OPTION || con == JOptionPane.CLOSED_OPTION) {
            return;
        } else {
            // JOptionPane.showMessageDialog(this, "Hệ thống đã thực hiện xác nhận!");
            Tau t = new Tau();
            t.setVitri((int) tblxacnhan.getValueAt(row, 6));
            t.setToa(tblxacnhan.getValueAt(row, 5).toString());
            t.setTentau(tblxacnhan.getValueAt(row, 4).toString());
            veser.updatexacnhan3(t);
            loadthanhtoan();

            //lấy các giá trị
            String liDo = JOptionPane.showInputDialog(this, "Lý lo ");
            Traintickets vetau = getListThanhToan.get(row);
            String email = vetau.getNguoidung().getEmail();
            String maVe = vetau.getId();
            String diemDi = vetau.getDiemdi();
            String diemDen = vetau.getDiemden();
            Date ngayDi = vetau.getNgaydi();
            // gửi gmail

            final String username = lblemail.getText();
            final String password = "linh1905";

            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS

            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(email)
                );
                message.setSubject("Thông báo hoàn vé");
                message.setText("Mã vé : " + maVe + "\n"
                        + "Xuất phát từ :" + diemDi + " đến " + diemDen + "\n"
                        + "Ngày đi: " + ngayDi + "\n"
                        + "Đã bị hủy bởi nhân viên " + lblma.getText() + "\n"
                        + "Lý do : " + liDo);

                Transport.send(message);

                System.out.println("Done");

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnhuyActionPerformed

    private void btnxacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxacnhanActionPerformed
        // TODO add your handling code here:
        int row = tblxacnhan.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chưa có yêu cầu thanh toán");
            return;
        }
        int con = JOptionPane.showConfirmDialog(this, "Bạn xác nhận hóa đơn này đã thanh toán rồi chứ?");
        if (con == JOptionPane.NO_OPTION || con == JOptionPane.CANCEL_OPTION || con == JOptionPane.CLOSED_OPTION) {
            return;
        } else {
            Tau t = new Tau();
            t.setVitri((int) tblxacnhan.getValueAt(row, 6));
            t.setToa(tblxacnhan.getValueAt(row, 5).toString());
            t.setTentau(tblxacnhan.getValueAt(row, 4).toString());
            veser.updatexacnhan2(t);
            veser.UpdateVe(t);
            loadthanhtoan();
            JOptionPane.showMessageDialog(this, "Hệ thống đã thực hiện xác nhận!");

        }
    }//GEN-LAST:event_btnxacnhanActionPerformed

    private void tblxacnhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblxacnhanMouseClicked
        // TODO add your handling code here:
        int row = tblxacnhan.getSelectedRow();
        txtmave.setText(tblxacnhan.getValueAt(row, 0).toString());
    }//GEN-LAST:event_tblxacnhanMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row= tblQuanLyVe.getSelectedRow();
        String idVe = getDanhSachVe.get(row).getId();
        JOptionPane.showMessageDialog(this, trainTicketService.xoaVe(idVe));
        loadCbTau(trainTicketService.getCbTau());
        loadDatVe();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblQuanLyVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanLyVeMouseClicked
        int row = tblQuanLyVe.getSelectedRow();
        // jDateNgayDi.setDate(tblQuanLyVe.getValueAt(row, 0).toString());
        txtPrice.setText(tblQuanLyVe.getValueAt(row, 1).toString());
        txtThue.setText(tblQuanLyVe.getValueAt(row, 2).toString());
        txtGioDen.setText(tblQuanLyVe.getValueAt(row, 4).toString());
        txtGioKhoiHanh.setText(tblQuanLyVe.getValueAt(row, 3).toString());
        cbDiemDen.getModel().setSelectedItem(tblQuanLyVe.getValueAt(row, 6).toString());
        cbDiemDi.getModel().setSelectedItem(tblQuanLyVe.getValueAt(row, 5).toString());
    }//GEN-LAST:event_tblQuanLyVeMouseClicked

    private void btnSuaVeTauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaVeTauActionPerformed
        // TODO add your handling code here:
        int row = tblQuanLyVe.getSelectedRow();
        if(checkValidate()){
        String idVe = getDanhSachVe.get(row).getId();
        TrainTicketViewModel traintickets = new TrainTicketViewModel();
        traintickets.setNgayDi(jDateNgayDi.getDate());
        traintickets.setPrice(Double.parseDouble(txtPrice.getText()));
        traintickets.setThue(Double.parseDouble(txtThue.getText()));
        traintickets.setGioKhoiHanh(txtGioKhoiHanh.getText());
        traintickets.setGioDen(txtGioDen.getText());
        traintickets.setDiemDi(cbDiemDi.getSelectedItem().toString());
        traintickets.setDiemDen(cbDiemDen.getSelectedItem().toString());
        JOptionPane.showMessageDialog(this, trainTicketService.suaVe(idVe, traintickets));
        loadDatVe();
        loadCbTau(trainTicketService.getCbTau());
        }
    }//GEN-LAST:event_btnSuaVeTauActionPerformed

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
            java.util.logging.Logger.getLogger(main_nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main_nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main_nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main_nhanvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main_nhanvien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSuaVeTau;
    private javax.swing.JButton btnThemVe;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnhuy;
    private javax.swing.JButton btnxacnhan;
    private javax.swing.JComboBox<String> cbDiemDen;
    private javax.swing.JComboBox<String> cbDiemDi;
    private javax.swing.JComboBox<String> cbTenTau;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private com.toedter.calendar.JDateChooser jDateNgayDi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbMaQuan;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblgioitinh;
    private javax.swing.JLabel lblho;
    private javax.swing.JLabel lblma;
    private javax.swing.JLabel lblten;
    private javax.swing.JTable tblQuanLyVe;
    private javax.swing.JTable tblxacnhan;
    private javax.swing.JTextField txtGioDen;
    private javax.swing.JTextField txtGioKhoiHanh;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtThue;
    private javax.swing.JTextField txtmave;
    // End of variables declaration//GEN-END:variables
}
