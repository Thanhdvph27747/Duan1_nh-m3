/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.Services;

import poly.Model.NhanVien;
import poly.Responsitory.NhanVienResponsitory;

/**
 *
 * @author DELL
 */
public class NhanVienServices {
    public final NhanVienResponsitory nvres;
    public NhanVienServices(){
        this.nvres = new NhanVienResponsitory();
    }
    public NhanVien getDuLieu(String id, String pass){
        return nvres.getDuLieu(id, pass);
    }
}
