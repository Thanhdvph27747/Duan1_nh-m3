/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.Services;

import java.util.ArrayList;
import java.util.Date;
import poly.Model.Tau;
import poly.Model.Traintickets;
import poly.ViewModels.TrainTicketViewModel;

/**
 *
 * @author ASUS
 */
public interface ITrainTicketService {
    
    public ArrayList<Traintickets> timKiem(String diemDi,String diemDen,String ngayDi);
    
    //
    public ArrayList<Tau> getCbTau();
    
    public String themVe(TrainTicketViewModel trainTicketViewModel);
    
    public String suaVe(String id,TrainTicketViewModel trainTicketViewModel);
    
    public String xoaVe(String id);
}
