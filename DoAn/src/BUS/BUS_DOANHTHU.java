/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import java.util.ArrayList;
import DAL.DAL_DOANHTHU;
import DTO.DTO_DOANHTHU;
/**
 *
 * @author SpingGr4ss
 */
public class BUS_DOANHTHU {
    DAL_DOANHTHU doanhthu = new DAL_DOANHTHU();
    
    public ArrayList<DTO_DOANHTHU> getDoanhThu(String thang, String nam)
    {
        return doanhthu.getDoanhThu(thang, nam);
    }
    
    public String GetTongDoanhThu(String thang, String nam)
    {
        return doanhthu.GetTongDoanhThu(thang, nam);
    }
    
    public ArrayList<String> getThang()
    {
        return doanhthu.getThang();
    }
    
    public ArrayList<String> getNam()
    {
        return doanhthu.getNam();
    }
}
