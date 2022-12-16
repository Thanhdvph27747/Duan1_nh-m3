/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.Services.impl;

import java.util.ArrayList;
import java.util.Date;
import poly.Model.Tau;
import poly.Model.Traintickets;
import poly.Responsitory.TrainticketResponsitory;
import poly.Services.ITrainTicketService;
import poly.ViewModels.TrainTicketViewModel;

/**
 *
 * @author ASUS
 */
public class TrainTickServiceImpl implements ITrainTicketService{

    private TrainticketResponsitory trainticketResponsitory= new TrainticketResponsitory();

    @Override
    public ArrayList<TrainTicketViewModel> timKiem(String diemDi, String diemDen, String ngayDi) {
        return trainticketResponsitory.timKiem(diemDi, diemDen, ngayDi);
    }

    @Override
    public ArrayList<Tau> getCbTau() {
        return trainticketResponsitory.loadCbTau();
    }

    @Override
    public String themVe(TrainTicketViewModel trainTicketViewModel) {
        boolean check= trainticketResponsitory.themVe(trainTicketViewModel);
        if(check){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public String suaVe(String id, TrainTicketViewModel trainTicketViewModel) {
        boolean check= trainticketResponsitory.suaVe(id, trainTicketViewModel);
        if(check){
            return "Cập nhật thành công";
        }else{
            return "Cập nhật thất bại";
        }
    }

    @Override
    public String xoaVe(String id) {
        boolean check= trainticketResponsitory.xoaVe(id);
        if(check){
            return "Xóa thành công";
        }else{
            return "Xóa thất bại";
        } 
    }

    @Override
    public ArrayList<TrainTicketViewModel> getAll() {
        return trainticketResponsitory.getTTVe();
    }
    
    
    
}
