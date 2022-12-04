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
    private int vitri;
    private int xacnhan;
    public Tau(String id, String tentau, String toa, int vitri) {
        this.id = id;
        this.tentau = tentau;
        this.toa = toa;
        this.vitri = vitri;
    }

    public Tau() {
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

    public int getXacnhan() {
        return xacnhan;
    }

    public void setXacnhan(int xacnhan) {
        this.xacnhan = xacnhan;
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

    public int getVitri() {
        return vitri;
    }

    public void setVitri(int vitri) {
        this.vitri = vitri;
    }
    
    
}
