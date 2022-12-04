/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.Responsitory;

import java.util.ArrayList;
import poly.Model.Tau;
import java.sql.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import poly.Model.NguoiDung;
import poly.Model.Traintickets;
import poly.Utility.DBConnection;
import poly.Utility.JDBCHelper;

/**
 *
 * @author DELL
 */
public class TrainticketResponsitory {
    
    private DBConnection connection;
    
    public ArrayList<Traintickets> getTTVe() {
        ArrayList<Traintickets> ve = new ArrayList<>();
        String sql = "select traintickets.id,NgayDi,GioKhoiHanh,GioDen,DiemDi,DiemDen,price,tau.TenTau,tau.toa,tau.vitri,Thue\n"
                + " from TrainTickets join Tau on TrainTickets.IdHangTau = tau.id where trangthai=1 ";
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                Tau taus = new Tau();
                
                taus.setTentau(rs.getString(8));
                taus.setToa(rs.getString(9));
                taus.setVitri(rs.getInt(10));
                String id = rs.getString(1);
                Date ngaydi = rs.getDate(2);
                String giokhoihanh = rs.getString(3);
                String gioden = rs.getString(4);
                String diemdi = rs.getString(5);
                String diemden = rs.getString(6);
                Double price = rs.getDouble(7);
                Double thue = rs.getDouble(11);
                ve.add(new Traintickets(id, ngaydi, giokhoihanh, gioden, diemdi, diemden, price, thue, taus));
                
            }
        } catch (Exception ex) {
            System.out.println("Lỗi : " + ex);
        }
        return ve;
    }
    
    public ArrayList<Traintickets> timKiem(String diemDi, String diemDen, String ngayDi) {
        ArrayList<Traintickets> listTim = new ArrayList<>();
        String sql = "select traintickets.id,NgayDi,GioKhoiHanh,GioDen,DiemDi,DiemDen,price,tau.TenTau,tau.toa,tau.vitri,Thue\n"
                + " from TrainTickets join Tau on TrainTickets.IdHangTau = tau.id where trangthai=1 and "
                + "DiemDi like N'%" + diemDi + "%' and DiemDen like N'%" + diemDen + "%' and NgayDi like '" + ngayDi + "'";
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                Tau taus = new Tau();
                
                taus.setTentau(rs.getString(8));
                taus.setToa(rs.getString(9));
                taus.setVitri(rs.getInt(10));
                String id = rs.getString(1);
                Date ngaydi = rs.getDate(2);
                String giokhoihanh = rs.getString(3);
                String gioden = rs.getString(4);
                String diemdi = rs.getString(5);
                String diemden = rs.getString(6);
                Double price = rs.getDouble(7);
                Double thue = rs.getDouble(11);
                listTim.add(new Traintickets(id, ngaydi, giokhoihanh, gioden, diemdi, diemden, price, thue, taus));
                
            }
        } catch (Exception ex) {
            System.out.println("Lỗi : " + ex);
        }
        return listTim;
    }
    
    public ArrayList<Traintickets> getTTVeCuaToi(String socmnd) {
        ArrayList<Traintickets> ve = new ArrayList<>();
        String sql = " select NguoiDung.ten,NguoiDung.SoCMND,traintickets.id,ngaydi,TrainTickets.DiemDi,DiemDen,GioKhoiHanh,GioDen,tau.TenTau,tau.Toa,tau.vitri\n"
                + " from TrainTickets join Tau on TrainTickets.IdHangTau = tau.id \n"
                + " join nguoidung on traintickets.iduser = nguoidung.id where socmnd like'" + socmnd + "'" + "and trangthai=0 and xacnhan=3";
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                Tau taus = new Tau();
                
                taus.setTentau(rs.getString(9));
                taus.setVitri(rs.getInt(11));
                taus.setToa(rs.getString(10));
                NguoiDung nd = new NguoiDung();
                nd.setTen(rs.getString(1));
                nd.setCmnd(rs.getString(2));
                String id = rs.getString(3);
                Date ngaydi = rs.getDate(4);
                String giokhoihanh = rs.getString(7);
                String gioden = rs.getString(8);
                String diemdi = rs.getString(5);
                String diemden = rs.getString(6);
                
                ve.add(new Traintickets(id, ngaydi, giokhoihanh, gioden, diemdi, diemden, taus, nd));
                
            }
        } catch (Exception ex) {
            System.out.println("Lỗi : " + ex);
        }
        return ve;
    }
    
    public Integer UpdateVe(Tau t) {
        String sql = "update tau set trangthai = 0 where tentau=? and toa=? and vitri = ?";
        int row = JDBCHelper.executeUpdate(sql, t.getTentau(), t.getToa(), t.getVitri());
        return row;
    }
    
    public Integer InsertVe(Traintickets t) {
        String sql = "update traintickets set iduser = ? where id= ?";
        int row = JDBCHelper.executeUpdate(sql, t.getIduser(), t.getId());
        return row;
    }
    
    public Integer XoaLichSuVe(Tau t) {
        String sql = "update tau set trangthai=2 where tentau=? and toa=? and vitri=?";
        int row = JDBCHelper.executeUpdate(sql, t.getTentau(), t.getToa(), t.getVitri());
        return row;
    }

    //goi ra main nhanvien
    public ArrayList<Traintickets> checkthanhtoan() {
        ArrayList<Traintickets> ve = new ArrayList<>();
        String sql = " select TrainTickets.Id, NguoiDung.ten,GioKhoiHanh,GioDen,tau.TenTau,tau.Toa,tau.vitri,Price\n"
                + " from TrainTickets join Tau on TrainTickets.IdHangTau = tau.id \n"
                + " join nguoidung on traintickets.iduser = nguoidung.id where tau.xacnhan=2";
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                Tau taus = new Tau();
                taus.setTentau(rs.getString(5));
                taus.setToa(rs.getString(6));
                taus.setVitri(rs.getInt(7));
                
                NguoiDung ng = new NguoiDung();
                ng.setTen(rs.getString(2));
                
                String id = rs.getString(1);                
                String giokhoihanh = rs.getString(3);
                String gioden = rs.getString(4);
                
                Double price = rs.getDouble(8);
                
                ve.add(new Traintickets(id, giokhoihanh, gioden, price, taus, ng));
                
            }
        } catch (Exception ex) {
            System.out.println("Lỗi : " + ex);
        }
        return ve;
    }
    
    public Integer updatexacnhan(Tau t) {
        String sql = "update tau set xacnhan = 2 where tentau=? and toa=? and vitri=?";
        int row = JDBCHelper.executeUpdate(sql, t.getTentau(), t.getToa(), t.getVitri());
        return row;
    }
    public Integer updatexacnhan2(Tau t) {
        String sql = "update tau set xacnhan = 3 where tentau=? and toa=? and vitri=?";
        int row = JDBCHelper.executeUpdate(sql, t.getTentau(), t.getToa(), t.getVitri());
        return row;
    }
    public Integer updatexacnhan3(Tau t) {
        String sql = "update tau set trangthai=1, xacnhan = 1 where tentau=? and toa=? and vitri=?";
        int row = JDBCHelper.executeUpdate(sql, t.getTentau(), t.getToa(), t.getVitri());
        return row;
    }
    
    
    //Quản Lý Vé Tàu
    //loadTenTau
    public ArrayList<Tau> loadCbTau(){
        ArrayList<Tau> getAll= new ArrayList<>();
        String sql="select Id,TenTau from Tau where id not in (select IdHangTau from TrainTickets)";
        try (Connection con= connection.getConnection();
                PreparedStatement ps= con.prepareStatement(sql)) {
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Traintickets traintickets= new Traintickets();
                Tau tau= new Tau();
                tau.setId(rs.getString(1));
                tau.setTentau(rs.getString(2));
                
//                Tau tau3= new Tau();
//                tau3.setTentau(rs.getString(3));
//                Tau tau4= new Tau();
//                tau4.setTentau(rs.getString(4));
                
//                traintickets.setTau(tau);
//                traintickets.setTau(tau2);
//                traintickets.setTau(tau3);
//                traintickets.setTau(tau4);
                getAll.add(tau);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return getAll;
    }
    public ArrayList<String> listCB() {
        ArrayList<String> listQue = new ArrayList<>();
        String sql = "select TenTau from Tau where id not in (select IdHangTau from TrainTickets)";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String st = rs.getString(1);
                listQue.add(st);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listQue;
    }
    
}
