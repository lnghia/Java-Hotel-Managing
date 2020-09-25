/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.*;
//import com.sun.jmx.snmp.SnmpDefinitions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huyen
 */
public class DAL_YC2 {
    Connection Conn= null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    private String header[]={"Mã loại khách", "Họ tên", "CMND","Địa chỉ"};
    private DefaultTableModel dtm = new DefaultTableModel(header,0);
    public DefaultTableModel getDataKhachThuePhong(String maptp)
    {
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            // create a connection to the database
            Conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        if (Conn!=null)
        {
            try {
            //String sqlite ="Select maphong, maloaiphong, mota, ghichu, tinhtrang from Phong";
            String sqlite ="Select maloaikhachhang, hoten, cmnd, diachi from ct_phieuthuephong where trangthai=true and maptp=?";
            ps = Conn.prepareStatement(sqlite);
            ps.setString(1, maptp);
            rs = ps.executeQuery();
            Vector data = null;
            dtm.setRowCount(0);
            while (rs.next())
            {
                data=new Vector();
                data.add(rs.getString("maloaikhachhang"));
                data.add(rs.getString("hoten"));
                data.add(rs.getString("cmnd"));
                data.add(rs.getString("diachi"));
                dtm.addRow(data);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (Conn!=null)
                    Conn.close();
                if (ps!=null)
                    ps.close();
                if (rs!=null)
                    rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }
        
        return dtm;
    }
    public ArrayList <DTO_PhieuThuePhong> getData()
    {          
        ArrayList <DTO_PhieuThuePhong> arr = new ArrayList<DTO_PhieuThuePhong>();
        if (Conn!=null)
            System.err.println("Get data not  null ");
        else
        { 
            try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "Select * from PhieuThuePhong where trangthai=true";
                st =Conn.createStatement();
                rs = st.executeQuery(sql);   
                int result =0 ;
                while (rs.next())
                {
                    result++;
                    DTO_PhieuThuePhong data = new DTO_PhieuThuePhong();
                    data.setMaPTP(rs.getString("MaPTP"));
                    data.setMaPhong(rs.getString("MaPhong"));
                    data.setMaHinhThuc(rs.getString("MaHinhThucThue"));
                    data.setGioBatDauThue(rs.getString("GioBatDauThue"));
                    data.setNgayBatDauThue(rs.getString("NgayBatDauThue"));
                    data.setSoKhach(rs.getInt("SoKhach"));
                    data.setDonGiaThue(rs.getFloat("DonGiaThue"));
                    data.setDonGiaTieuChuan(rs.getFloat("DonGiaTieuChuan"));
                    arr.add(data);
                }
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }         
         finally {
                try {
                        Conn.close();
                        st.close();
                        rs.close();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
               
            }  
        }    
        return arr;
    }
    public int Add(DTO_PhieuThuePhong ptp)
    {  
        int result =0;
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "Insert into PhieuThuePhong values (?,?,?,?,?,?,?,?,?,?)";
                ps = Conn.prepareStatement(sql);
                ps.setString(1, ptp.getMaPTP());
                ps.setString(2, ptp.getMaPhong());
                ps.setString(3, ptp.getMaHinhThuc());
                ps.setString(4, ptp.getGioBatDauThue());
                ps.setString(5, ptp.getNgayBatDauThue());
                ps.setInt(6, ptp.getSoKhach());
                ps.setFloat(7, ptp.getDonGiaThue());
                ps.setFloat(8, ptp.getDonGiaTieuChuan());
                ps.setBoolean(9, true);
                ps.setBoolean(10, false);
                result = ps.executeUpdate();
            }
            else 
                System.err.println("Lỗi conn");
        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println("Theem"+e.getMessage());
        }
        finally
        {
            try {
                 if (Conn!=null)
                Conn.close();
            if (ps!=null)
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
           
        }
        return result;
    }
        
    public int Update (DTO_PhieuThuePhong ptp)
    {
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            int result=0;
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "Update Phieuthuephong set maphong = ? ,  mahinhthucthue=?, giobatdauthue = ?, ngaybatdauthue=?, sokhach=?, dongiathue=?, dongiatieuchuan=?, trangthai=? where maptp=?";
                ps = Conn.prepareStatement(sql);
                ps.setString(9, ptp.getMaPTP());
                ps.setString(1, ptp.getMaPhong());
                ps.setString(2, ptp.getMaHinhThuc());
                ps.setString(3, ptp.getGioBatDauThue());
                ps.setString(4, ptp.getNgayBatDauThue());
                ps.setInt(5, ptp.getSoKhach());
                ps.setFloat(6, ptp.getDonGiaThue());
                ps.setFloat(7, ptp.getDonGiaTieuChuan());
                ps.setBoolean(8, true);
                result=ps.executeUpdate();
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                if (Conn!=null)
                    Conn.close();
                if (ps!=null)
                    ps.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    public int Update_CT (String MaPTP, String HoTen, String MaLoaiKhachHang, String CMND, String DiaChi, String CMNDcu )
    {
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            int result=0;
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "Update CT_Phieuthuephong set hoten=?, maloaikhachhang = ?, cmnd=?,diachi=? where maptp=? and cmnd=?";
                ps = Conn.prepareStatement(sql);
                ps.setString(1, HoTen);
                ps.setString(2, MaLoaiKhachHang);
                ps.setString(3, CMND);
                ps.setString(4, DiaChi);
                ps.setString(5, MaPTP);
                ps.setString(6, CMNDcu);
                result=ps.executeUpdate();
                return result;
            }
        } catch (Exception e) {
        }
        finally
        {
            try {
                if (Conn!=null)
                    Conn.close();
                if (ps!=null)
                    ps.close();
            } catch (Exception e) {
            }
        }
        return 0;
    }
    public int Delete(String maptp)
    {
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn=DriverManager.getConnection(url);
            if (Conn!=null)
            {
                int result = 0;
                String sql = "Update Phieuthuephong set trangthai=false where maptp=?";
                ps = Conn.prepareStatement(sql);
                ps.setString(1, maptp);
                result = ps.executeUpdate();
                return result;
            }
        } catch (Exception e) {
        }
        finally{
            try {
                Conn.close();
                ps.close();
            } catch (Exception e) {
            }
        }
        return 0;
    }
    public int Delete_CT(String maptp)
    {
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn=DriverManager.getConnection(url);
            if (Conn!=null)
            {
                int result = 0;
                String sql = "Update CT_Phieuthuephong set trangthai=false where maptp=?";
                ps = Conn.prepareStatement(sql);
                ps.setString(1, maptp);
                result = ps.executeUpdate();
                return result;
            }
        } catch (Exception e) {
        }
        finally{
            try {
                Conn.close();
                st.close();
                rs.close();
                ps.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return 0;
    }
    public String MaLoaiPhong(String MaPhong)
    {
        String tam="";
        int res=0;
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "Select maloaiphong from Phong where maphong=?";
                ps = Conn.prepareStatement(sql);
                ps.setString(1, MaPhong);
                rs=ps.executeQuery();
                while (rs.next())
                {
                    tam=rs.getString("maloaiphong");
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                Conn.close();
                ps.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tam;
    }
    public float GetDonGiaTieuChuan(String MaLoaiPhong)
    {
        float tam=0;
        int res=0;
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "Select dongia from LoaiPhong where maloaiphong=?";
                ps = Conn.prepareStatement(sql);
                ps.setString(1, MaLoaiPhong);
                rs=ps.executeQuery();
                while (rs.next())
                {
                    tam=rs.getFloat("dongia");
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                Conn.close();
                ps.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tam;
    }
    public float GetTyLePhuThu(String LoaiKhachHang)
    {
        float tam=0;
        int res=0;
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "Select hesophuthu from LoaiKhachhang where tenloaikhachhang=?";
                ps = Conn.prepareStatement(sql);
                ps.setString(1, LoaiKhachHang);
                rs=ps.executeQuery();
                while (rs.next())
                {
                    tam=rs.getFloat("hesophuthu");
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                Conn.close();
                ps.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tam;
    }
    public float GetSoKhachKhongPhuThu()
    {
        float tam=0;
        int res=0;
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "Select giatri from thamso where tenthamso='sokhachkhongtinhphuthu'";
                st = Conn.createStatement();
                rs=st.executeQuery(sql);
                while (rs.next())
                {
                    tam=rs.getFloat("giatri");
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                Conn.close();
                ps.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tam;
    }
    public float GetTyLePhuThuTheoSoKhach()
    {
        float tam=0;
        int res=0;
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "Select giatri from thamso where tenthamso='tilephuthu'";
                st = Conn.createStatement();
                rs=st.executeQuery(sql);
                while (rs.next())
                {
                    tam=rs.getFloat("giatri");
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                Conn.close();
                ps.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tam;
    }
    public int Add_CT(String MaPTP, String HoTen, String MaLoaiKhachHang, String CMND, String DiaChi, boolean tt )
    {
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "Insert into CT_PhieuThuePhong values (?,?,?,?,?,?)";
                ps = Conn.prepareStatement(sql);
                ps.setString(1, MaPTP);
                ps.setString(2, HoTen);
                ps.setString(3, MaLoaiKhachHang);
                ps.setString(4, CMND);
                ps.setString(5, DiaChi);
                ps.setBoolean(6, tt);
                int result =0;
                result = ps.executeUpdate();
                System.err.println(result);
                return result;
            }
            else 
                System.err.println("Lỗi conn");
        } catch (Exception e) {
        }
        finally
        {
            try {
                 if (Conn!=null)
                Conn.close();
            if (ps!=null)
                ps.close();
            } catch (Exception e) {
            }
           
        }
        return 0;
    }
    public int MaPTP()
    {       
        int ma=0;
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn=DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "Select maptp from phieuthuephong";
                st = Conn.createStatement();
                rs = st.executeQuery(sql);
                int tam=0;
                while (rs.next())
                {
                    tam=Integer.parseInt(rs.getString("maptp"));
                    if (ma<tam)
                        ma=tam;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                Conn.close();
                st.close();
                rs.close();
            } catch (Exception e) {
            }
        }
        return ma+1;
    }
    
    public ArrayList<String> getDanhSachPhongTrong()
    {
        ArrayList<String> ds = new ArrayList<String>();
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "Select MaPhong from Phong where TINHTRANG = 'Trống'";
                st = Conn.createStatement();
                rs=st.executeQuery(sql);
                String tam="";
                int i=0;
                while (rs.next())
                {
                    tam= rs.getString(1);
                    ds.add(tam);
                    i++;
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                Conn.close();
                st.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ds;
    }
    public ArrayList <String> getDanhSachHinhThuc()
    {
        if (Conn!=null)
            System.err.println("get hinh thuc not null");
        ArrayList <String> arr = new ArrayList<String>();
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn= DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "Select tenhinhthucthue from hinhthucthue where trangthai=true";
                st = Conn.createStatement();
                rs=st.executeQuery(sql);
                String tam="";
                while (rs.next())
                {
                    tam= rs.getString(1);
                    arr.add(tam);
                }                    
            }
        } catch (Exception e) {
            //System.err.println(e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            try {
                Conn.close();
                st.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr;
    }
    public  int  SoKhachToiDa()
    {
        int gt=1;
        String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db"; 
        try {
            Conn = DriverManager.getConnection(url);
            String sql = "Select GIATRI from ThamSo where TENTHAMSO='SoKhachToiDa'";
            st = Conn.createStatement();
            rs = st.executeQuery(sql);
            gt=rs.getInt("GIATRI");
        } catch (SQLException ex) {
            System.err.println("SOK"+ex.getMessage());
        }
        finally
        {
            try {
                Conn.close();
                st.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return gt;
    }
    public boolean  checkPhongTrong(String MaPhong)
    {
        String tam="";
        int res=0;
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "Select tinhtrang from Phong where maphong=?";
                ps = Conn.prepareStatement(sql);
                ps.setString(1, MaPhong);
                rs=ps.executeQuery();
                while (rs.next())
                {
                    tam=rs.getString("tinhtrang");
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                Conn.close();
                ps.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.err.println("Hinhthus"+tam);
        if (tam.equals("Trống") || tam.equals("Trống"))
            return  true;
        return false;
    }
    public int UpdatePhong(String MaPhong, String tt)
    {
        int res=0;
         try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn =DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "update Phong set tinhtrang = ? where maphong=?" ;
                ps = Conn.prepareStatement(sql);
                ps.setString(1,tt);
                ps.setString(2,MaPhong);
                res = ps.executeUpdate();
            }
         }
        catch (Exception e)
                {
                    
                }
         finally
         {
             try {
                 Conn.close();
                 rs.close();
                 ps.close();
             } catch (Exception e) {
             }
         }
         return res;
    }         
}
