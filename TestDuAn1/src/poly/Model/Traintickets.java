/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.Model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Traintickets {

    private String id;
    private Date ngaydi;
    private String giokhoihanh, gioden, diemdi, diemden;
    private Double gia, thue;
    private String idTau;
    private String iduser;
    private int viTri,xacNhan,trangThai;

    public Traintickets() {
    }

    public Traintickets(String id, Date ngaydi, String giokhoihanh, String gioden, String diemdi, String diemden, Double gia, Double thue, String idTau, String iduser, int viTri, int xacNhan, int trangThai) {
        this.id = id;
        this.ngaydi = ngaydi;
        this.giokhoihanh = giokhoihanh;
        this.gioden = gioden;
        this.diemdi = diemdi;
        this.diemden = diemden;
        this.gia = gia;
        this.thue = thue;
        this.idTau = idTau;
        this.iduser = iduser;
        this.viTri = viTri;
        this.xacNhan = xacNhan;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getNgaydi() {
        return ngaydi;
    }

    public void setNgaydi(Date ngaydi) {
        this.ngaydi = ngaydi;
    }

    public String getGiokhoihanh() {
        return giokhoihanh;
    }

    public void setGiokhoihanh(String giokhoihanh) {
        this.giokhoihanh = giokhoihanh;
    }

    public String getGioden() {
        return gioden;
    }

    public void setGioden(String gioden) {
        this.gioden = gioden;
    }

    public String getDiemdi() {
        return diemdi;
    }

    public void setDiemdi(String diemdi) {
        this.diemdi = diemdi;
    }

    public String getDiemden() {
        return diemden;
    }

    public void setDiemden(String diemden) {
        this.diemden = diemden;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Double getThue() {
        return thue;
    }

    public void setThue(Double thue) {
        this.thue = thue;
    }

    public String getIdTau() {
        return idTau;
    }

    public void setIdTau(String idTau) {
        this.idTau = idTau;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public int getViTri() {
        return viTri;
    }

    public void setViTri(int viTri) {
        this.viTri = viTri;
    }

    public int getXacNhan() {
        return xacNhan;
    }

    public void setXacNhan(int xacNhan) {
        this.xacNhan = xacNhan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }



}
