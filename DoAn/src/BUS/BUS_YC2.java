/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAL.*;
import DTO.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Huyen
 */
public class BUS_YC2 {
    DAL_YC2 dal = new DAL_YC2();
    public ArrayList<DTO_PhieuThuePhong> getData()
    {
        return dal.getData();
    }
    public DefaultTableModel getDachSachKhachThue(String maptp)
    {
        return dal.getDataKhachThuePhong(maptp);
    }
    public int Add(DTO_PhieuThuePhong dto)
    {
        return dal.Add(dto);
    }
    public int Update(DTO_PhieuThuePhong dto){
        return dal.Update(dto);
    }
    public int Delete(String maptp)
    {
        return dal.Delete(maptp);
    }
    public int Update_CT(String MaPTP, String HoTen, String MaLoaiKhachHang, String CMND, String DiaChi, String CMNDcu){
        return dal.Update_CT(MaPTP,HoTen,MaLoaiKhachHang,CMND,DiaChi,CMNDcu);
    }
    public int Delete_CT(String maptp)
    {
        return dal.Delete_CT(maptp);
    }
    public int MaPTP()
    {
        return dal.MaPTP();
    }
    public ArrayList <String> getDanhSachPhongTrong()
    {
        return dal.getDanhSachPhongTrong();
    }
    public ArrayList <String> getDanhSachHinhThuc()
    {
        return dal.getDanhSachHinhThuc();
    }
    public int SoKhachToiDa()
    {
        return dal.SoKhachToiDa();
    }
    public int UpdatePhong(String MaPhong, String tt)
    {
        return dal.UpdatePhong(MaPhong, tt);
    }
    public boolean  checkPhong(String MaPhong)
    {
        return dal.checkPhongTrong(MaPhong);
    }
    public float GetDonGia(String MaPhong)
    {
        return dal.GetDonGiaTieuChuan(dal.MaLoaiPhong(MaPhong));
    }
    
    public float GetHeSoPhuThu(String LoaiKhachHang)
    {
        return dal.GetTyLePhuThu(LoaiKhachHang);
    }
    public float GetSoKhachKhongPhuThu()
    {
        return dal.GetSoKhachKhongPhuThu();
    }
    public float GetTiLePhuThuTheoSoKhach()
    {
        return dal.GetTyLePhuThuTheoSoKhach();
    }
    public int Add_CT(String MaPTP, String HoTen, String MaLoaiKhachHang, String CMND, String DiaChi, boolean tt )
    {
        return  dal.Add_CT(MaPTP, HoTen, MaLoaiKhachHang, CMND, DiaChi, tt);
    }
}
