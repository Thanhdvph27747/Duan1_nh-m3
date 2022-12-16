/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.Responsitory;

import java.sql.ResultSet;
import poly.Model.NguoiDung;
import poly.Model.NhanVien;
import poly.Utility.JDBCHelper;

/**
 *
 * @author DELL
 */
public class NhanVienResponsitory {
    public NhanVien getDuLieu(String id, String pass) {

        String sql = "select id,ma,ho,ten,Email,Pass from nhanvien"
                + " where id like '" + id + "' and Pass like '" + pass + "'";
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                NhanVien nd = new NhanVien();
                nd.setId(rs.getString(1));
                nd.setMa(rs.getString(2));
                nd.setHo(rs.getString(3));
                nd.setTen(rs.getString(4));
                nd.setEmail(rs.getString(5));
               
                nd.setPass(rs.getString(6));
                return nd;
            }
        } catch (Exception ex) {
            System.out.println("Lỗi: " + ex);
        }
        return null;
    }
}
