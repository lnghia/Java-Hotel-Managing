/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import java.util.ArrayList;
import DAL.DAL_LOAIKHACH;
import DTO.DTO_LOAIKHACH;
/**
 *
 * @author SpingGr4ss
 */
public class BUS_LOAIKHACH {
    DAL_LOAIKHACH loaikhach = new DAL_LOAIKHACH();
    public ArrayList<DTO_LOAIKHACH> getLoaiphong()
    {
        return loaikhach.getLoaiKhach();
    }
    
    public void updateLoaikhach(String maloaikhach, String tenloaikhach, String hesophuthu){
        loaikhach.updateLoaiKhach(maloaikhach, tenloaikhach, hesophuthu);
    }
    
    public void deleteLoaikhach(String maloaikhach)
    {
        loaikhach.deleteLoaiKhach(maloaikhach);
    }
    
    public void insertLoaikhach(String maloaikhach, String tenloaikhach, String hesophuthu)
    {
        loaikhach.insertloaiKhach(maloaikhach, tenloaikhach, hesophuthu);
    }
}
