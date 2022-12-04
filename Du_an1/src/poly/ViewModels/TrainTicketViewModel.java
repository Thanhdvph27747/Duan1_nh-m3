/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.ViewModels;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class TrainTicketViewModel {
    private Date ngayDi;
    private double price,thue;
    private String gioKhoiHanh,gioDen,diemDi,diemDen;
    private String tenTau;

    public TrainTicketViewModel() {
    }

    public TrainTicketViewModel(Date ngayDi, double price, double thue, String gioKhoiHanh, String gioDen, String diemDi, String diemDen, String tenTau) {
        this.ngayDi = ngayDi;
        this.price = price;
        this.thue = thue;
        this.gioKhoiHanh = gioKhoiHanh;
        this.gioDen = gioDen;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
        this.tenTau = tenTau;
    }

    public Date getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(Date ngayDi) {
        this.ngayDi = ngayDi;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getThue() {
        return thue;
    }

    public void setThue(double thue) {
        this.thue = thue;
    }

    public String getGioKhoiHanh() {
        return gioKhoiHanh;
    }

    public void setGioKhoiHanh(String gioKhoiHanh) {
        this.gioKhoiHanh = gioKhoiHanh;
    }

    public String getGioDen() {
        return gioDen;
    }

    public void setGioDen(String gioDen) {
        this.gioDen = gioDen;
    }

    public String getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(String diemDi) {
        this.diemDi = diemDi;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public String getTenTau() {
        return tenTau;
    }

    public void setTenTau(String tenTau) {
        this.tenTau = tenTau;
    }
    
    
}
