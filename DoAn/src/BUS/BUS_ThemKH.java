/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DTO.*;
import DAL.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Huyen
 */
public class BUS_ThemKH {
    DAL_ThemKH dal;

    public BUS_ThemKH() {
        dal = new DAL_ThemKH();
    }
    public DefaultTableModel getData()
    {
        return dal.getData();
    }
    public int Add(DTO_KhachHang KH)
    {
        return dal.Add(KH);
    }
    public int Update(DTO_KhachHang KH, String makh)
    {
        return dal.Update(KH, makh);
    }
    public int Delete(String MaKH)
    {
        return dal.Delete(MaKH);
    }
    
    public ArrayList <String> getLoaiKhachHang()
    {
        return dal.getLoaiKhachHang();
    }
    public int Add_CT(String MaPTP, String HoTen, String MaLoaiKhachHang, String CMND, String DiaChi, boolean tt )
    {
        return  dal.Add_CT(MaPTP, HoTen, MaLoaiKhachHang, CMND, DiaChi, tt);
    }
    public int MaPTP()
    {
        return dal.MaPTP();
    }
    public int SoKhachToiDa()
    {
        return dal.SoKhachToiDa();
    }
    
}
