/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import java.util.ArrayList;
import DAL.DAL_DICHVU;
import DTO.DTO_DICHVU;
/**
 *
 * @author SpingGr4ss
 */
public class BUS_DICHVU {
    DAL_DICHVU dichvu = new DAL_DICHVU();
    public ArrayList<DTO_DICHVU> getDichVu()
    {
        return dichvu.getDichVu();
    }
    
    public void updateDichVu(String madichvu, String tendichvu){
        dichvu.updateDichVu(madichvu, tendichvu);
    }
    
    public void deleteDichVu(String madichvu)
    {
        dichvu.deleteDichVu(madichvu);
    }
    
    public void insertDichVu(String madichvu, String tendichvu)
    {
        dichvu.insertDichVu(madichvu, tendichvu);
    }
}
