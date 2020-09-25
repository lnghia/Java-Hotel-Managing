/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import java.util.ArrayList;
import DAL.DAL_QUANLYDICHVU;
import DTO.DTO_QUANLYDICHVU;
/**
 *
 * @author SpingGr4ss
 */
public class BUS_QUANLYDICHVU {
    DAL_QUANLYDICHVU qldichvu = new DAL_QUANLYDICHVU();
    public ArrayList<DTO_QUANLYDICHVU> getQLDichVu()
    {
        return qldichvu.getQLDichVu();
    }
    
    public void updateQLDichVu(String masanpham, String tensanpham, String loaidichvu, String soluongbandau, String soluongtrongkho, String dongia, String ghichu){
        qldichvu.updateQLDichVu(masanpham, tensanpham,loaidichvu, soluongbandau, soluongtrongkho, dongia, ghichu );
    }
    
    public void deleteQLDichVu(String masanpham)
    {
        qldichvu.deleteLoaiPhong(masanpham);
    }
    
    public void insertQLDichVu(String masanpham, String tensanpham, String loaidichvu, String soluongbandau, String soluongtrongkho, String dongia, String ghichu)
    {
        qldichvu.insertQLDichVu(masanpham, tensanpham,loaidichvu, soluongbandau, soluongtrongkho, dongia, ghichu );
    }
    
    public String getMaDichVu(String loaisanpham)
    {
        return qldichvu.getMaDichVu(loaisanpham);
    }
    
    public String getTenDichVu(String masanpham)
    {
        return qldichvu.getTenDichVu(masanpham);
    }
    
    public ArrayList<String> getLoaiDichVu()
    {
        return qldichvu.getLoaiDichVu();
    }
}
