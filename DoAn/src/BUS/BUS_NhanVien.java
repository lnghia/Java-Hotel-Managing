/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import  DAL.*;
import DTO.DTO_NhanVien;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Huyen
 */
public class BUS_NhanVien {
    DAL_NhanVien dal = new DAL_NhanVien();
    public DefaultTableModel getData()
    {
       return dal.getData();
    }
    public int Add(DTO_NhanVien nv)
    {
        return  dal.Add(nv);
    }
    public int Update(DTO_NhanVien nv, String manv)
    {
        return  dal.Update(nv, manv);
    }
    
    public int Delete(String manv)
    {
        return  dal.Delete(manv);
    }
    public ArrayList <String> getMaBacLuong()
    {
        return dal.getMaBacLuong();
    }
    public ArrayList <String> getChucVu()
    {
        return dal.getChucVu();
    }
    public ArrayList <String> getPhongBan()
    {
        return dal.getPhongBan();
    }
    public int MaNV()
    {
        return dal.MaNV();
    }
    public String MaCV(String tencv)
    {
        return  dal.MaChucVu(tencv);
    }
    public String MaPB(String tenpb)
    {
        return  dal.MaPhongban(tenpb);
    }
}
