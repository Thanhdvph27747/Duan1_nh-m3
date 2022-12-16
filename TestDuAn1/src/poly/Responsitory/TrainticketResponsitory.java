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
import poly.ViewModels.TrainTicketViewModel;

/**
 *
 * @author DELL
 */
public class TrainticketResponsitory {

    private DBConnection connection;

    public ArrayList<TrainTicketViewModel> getTTVe() {
        ArrayList<TrainTicketViewModel> listVe = new ArrayList<>();
        String sql = " select traintickets.id,NgayDi,GioKhoiHanh,GioDen,DiemDi,DiemDen,price,tau.TenTau,tau.toa,vitri,Thue \n"
                + " from TrainTickets join Tau on TrainTickets.IdHangTau = tau.id \n"
                + " where trangthai=1 and xacnhan=1";
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                TrainTicketViewModel ve= new TrainTicketViewModel();
                ve.setId(rs.getString(1));
                ve.setNgayDi(rs.getDate(2));
                ve.setGioKhoiHanh(rs.getString(3));
                ve.setGioDen(rs.getString(4));
                ve.setDiemDi(rs.getString(5));
                ve.setDiemDen(rs.getString(6));
                ve.setPrice(rs.getDouble(7));
                ve.setTenTau(rs.getString(8));
                ve.setToa(rs.getString(9));
                ve.setViTri(rs.getInt(10));
                ve.setThue(rs.getDouble(11));
                listVe.add(ve);

            }
        } catch (Exception ex) {
            System.out.println("Lỗi : " + ex);
        }
        return listVe;
    }
    public ArrayList<TrainTicketViewModel> timKiem(String diemDi, String diemDen, String ngayDi) {
        ArrayList<TrainTicketViewModel> listVe = new ArrayList<>();
        String sql = " select traintickets.id,NgayDi,GioKhoiHanh,GioDen,DiemDi,DiemDen,price,tau.TenTau,tau.toa,vitri,Thue \n"
                + " from TrainTickets join Tau on TrainTickets.IdHangTau = tau.id \n"
                + " where trangthai=1 and xacnhan=1 and\n"
                + "DiemDi like N'%" + diemDi + "%' and DiemDen like N'%" + diemDen + "%' and NgayDi like '" + ngayDi + "'";
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                TrainTicketViewModel ve= new TrainTicketViewModel();
                ve.setId(rs.getString(1));
                ve.setNgayDi(rs.getDate(2));
                ve.setGioKhoiHanh(rs.getString(3));
                ve.setGioDen(rs.getString(4));
                ve.setDiemDi(rs.getString(5));
                ve.setDiemDen(rs.getString(6));
                ve.setPrice(rs.getDouble(7));
                ve.setTenTau(rs.getString(8));
                ve.setToa(rs.getString(9));
                ve.setViTri(rs.getInt(10));
                ve.setThue(rs.getDouble(11));
                listVe.add(ve);

            }
        } catch (Exception ex) {
            System.out.println("Lỗi : " + ex);
        }
        return listVe;
    }


    public ArrayList<Traintickets> getTTVeCuaToi(String socmnd) {
        ArrayList<Traintickets> ve = new ArrayList<>();
        String sql = " select NguoiDung.ten,NguoiDung.SoCMND,traintickets.id,ngaydi,TrainTickets.DiemDi,DiemDen,GioKhoiHanh,GioDen,tau.TenTau,tau.Toa,tau.vitri\n"
                + " from TrainTickets join Tau on TrainTickets.IdHangTau = tau.id \n"
                + " join nguoidung on traintickets.iduser = nguoidung.id where socmnd like'" + socmnd + "'" + "and trangthai=0 and xacnhan=3 ";
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

                ve.add(new  );

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
        String sql = " select TrainTickets.Id, NguoiDung.ten,NguoiDung.Email,GioKhoiHanh,GioDen,tau.TenTau,tau.Toa,tau.vitri,Price,TrainTickets.ngaydi,TrainTickets.DiemDi,DiemDen\n"
                + " from TrainTickets join Tau on TrainTickets.IdHangTau = tau.id \n"
                + " join nguoidung on traintickets.iduser = nguoidung.id where tau.xacnhan=2";
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                Tau taus = new Tau();
                taus.setTentau(rs.getString(6));
                taus.setToa(rs.getString(7));
                taus.setVitri(rs.getInt(8));

                NguoiDung ng = new NguoiDung();
                ng.setTen(rs.getString(2));
                ng.setEmail(rs.getString(3));
                String id = rs.getString(1);
                String giokhoihanh = rs.getString(4);
                String gioden = rs.getString(5);
                String diemDi = rs.getString(11);
                String Diemden = rs.getString(12);
                Date ngayDI = rs.getDate(10);
                Double price = rs.getDouble(9);

                ve.add(new Traintickets(id, ngayDI, giokhoihanh, gioden, diemDi, Diemden, price, taus, ng));

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
    public ArrayList<Tau> loadCbTau() {
        ArrayList<Tau> getAll = new ArrayList<>();
        String sql = "select Id,TenTau from Tau where id not in (select IdHangTau from TrainTickets)";
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Traintickets traintickets = new Traintickets();
                Tau tau = new Tau();
                tau.setId(rs.getString(1));
                tau.setTentau(rs.getString(2));

                getAll.add(tau);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return getAll;
    }

    public boolean themVe(TrainTicketViewModel ve) {
        String sql = "insert into Traintickets(NgayDi,Price,Thue,GioKhoiHanh,GioDen,DiemDi,DiemDen,IdHangTau) values(?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ve.getNgayDi());
            ps.setObject(2, ve.getPrice());
            ps.setObject(3, ve.getThue());
            ps.setObject(4, ve.getGioKhoiHanh());
            ps.setObject(5, ve.getGioDen());
            ps.setObject(6, ve.getDiemDi());
            ps.setObject(7, ve.getDiemDen());
            ps.setObject(8, ve.getTenTau());
            check = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return check > 0;
    }

    public boolean suaVe(String id, TrainTicketViewModel ve) {
        String sql = "update Traintickets set NgayDi=? ,Price=? ,Thue=? ,GioKhoiHanh=? ,GioDen=? ,DiemDi=? ,DiemDen=?  where id= '" + id + "' ";
        int check = 0;
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ve.getNgayDi());
            ps.setObject(2, ve.getPrice());
            ps.setObject(3, ve.getThue());
            ps.setObject(4, ve.getGioKhoiHanh());
            ps.setObject(5, ve.getGioDen());
            ps.setObject(6, ve.getDiemDi());
            ps.setObject(7, ve.getDiemDen());
            check = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return check > 0;
    }

    public boolean xoaVe(String id) {
        String sql = "delete from Traintickets  where id= '" + id + "' ";
        int check = 0;
        try ( Connection con = connection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            check = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return check > 0;
    }

}
