/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAL.DAL_THAMSO;
import DTO.DTO_THAMSO;
import java.util.ArrayList;
/**
 *
 * @author SpingGr4ss
 */
public class BUS_THAMSO {
    DAL_THAMSO thamso = new DAL_THAMSO();
    public ArrayList<DTO_THAMSO> getThamSo()
    {
        return thamso.getThamSo();
    }
    
    public void updateThamSo(String tenthamso, String giatri){
        thamso.updateThamSo(tenthamso, giatri);
    }
    
    public void deleteThamSo(String tenthamso)
    {
        thamso.deleteThamSo(tenthamso);
    }
    
    public void insertThamSo(String tenthamso, String giatri)
    {
        thamso.insertThamSo(tenthamso, giatri);
    }
}
