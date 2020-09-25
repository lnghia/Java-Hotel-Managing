/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import java.util.ArrayList;
import DAL.DAL_LOAIPHONG;
import DTO.DTO_QLLOAIPHONG;
/**
 *
 * @author SpingGr4ss
 */
public class BUS_LOAIPHONG {
    DAL_LOAIPHONG loaiphong = new DAL_LOAIPHONG();
    public ArrayList<DTO_QLLOAIPHONG> getLoaiphong()
    {
        return loaiphong.getLoaiPhong();
    }
    
    public void updateLoaiphong(String maloaiphong, String dongia){
        loaiphong.updateLoaiPhong(maloaiphong, dongia);
    }
    
    public void deleteLoaiphong(String maloaiphong)
    {
        loaiphong.deleteLoaiPhong(maloaiphong);
    }
    
    public void insertLoaiphong(String maloaiphong, String dongia)
    {
        loaiphong.insertloaiPhong(maloaiphong, dongia);
    }
}
