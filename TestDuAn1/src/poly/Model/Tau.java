/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.Model;

/**
 *
 * @author DELL
 */
public class Tau {
    private String id,tentau,toa;
    private int soLuong;
    public Tau() {
    }

    public Tau(String id, String tentau, String toa, int soLuong) {
        this.id = id;
        this.tentau = tentau;
        this.toa = toa;
        this.soLuong = soLuong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTentau() {
        return tentau;
    }

    public void setTentau(String tentau) {
        this.tentau = tentau;
    }

    public String getToa() {
        return toa;
    }

    public void setToa(String toa) {
        this.toa = toa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    
    
    
    
    
}
