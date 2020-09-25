/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import java.util.ArrayList;
import DAL.DAL_CAPNHATPHONG;
import DTO.DTO_Phong;
/**
 *
 * @author SpingGr4ss
 */
public class BUS_CAPNHATPHONG {
    DAL_CAPNHATPHONG phong = new DAL_CAPNHATPHONG();
    public ArrayList<DTO_Phong> getPhong()
    {
        return phong.getPhong();
    }
    
    public ArrayList<DTO_Phong> getPhongTrong()
    {
        return phong.getPhongTrong();
    }
    
    public ArrayList<DTO_Phong> getPhongDangThue()
    {
        return phong.getPhongDangThue();
    }
    
    public void updatePhong(String maphong, String maloaiphong, String mota, String ghichu, String tinhtrang)
    {
        phong.updatePhong(maphong, maloaiphong, mota, ghichu, tinhtrang);
    }
    
    public void insertPhong(String maphong, String maloaiphong, String mota, String ghichu, String tinhtrang)
    {
        phong.insertPhong(maphong, maloaiphong, mota, ghichu, tinhtrang);
    }
    
    public void deletePhong(String maloaiphong)
    {
        phong.deletePhong(maloaiphong);
    }
    
    public ArrayList<String> getLoaiPhong()
    {
        return phong.getLoaiPhong();
    }
}
