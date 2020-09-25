/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.*;
import com.sun.org.apache.xml.internal.dtm.DTM;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
        
/**
 *
 * @author Huyen
 */
public class DAL_ThemKH {
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    String [] Header ={"Mã khách hàng", "Mã loại khách", "Họ tên","Giới tính", "Ngày sinh", "CMND", "Địa chỉ","SĐT","Email"}; 
    DefaultTableModel dtm = new DefaultTableModel(Header,0);
    public DefaultTableModel getData()
    {
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            conn =DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql = "Select * from KhachHang where trangthai=true";
                st = conn.createStatement();
                rs = st.executeQuery(sql);                
                dtm.setRowCount(0);
                Vector data = null;
                while (rs.next())
                {
                    data = new Vector();
                    data.add(rs.getString("MaKhachHang"));                    
                    data.add(rs.getString("MaLoaiKhachHang"));
                    data.add(rs.getString("Hoten"));
                    data.add(rs.getString("GioiTinh"));                    
                    data.add(rs.getString("NgaySinh"));                    
                    data.add(rs.getString("CMND"));
                    data.add(rs.getString("DiaChi"));
                    data.add(rs.getString("SDT"));
                    data.add(rs.getString("Email"));
                    dtm.addRow(data);
                }
            }
            else
                System.err.println("Ko co ket noi");
        } catch (Exception e) {
        }
        finally
        {
            try {
                conn.close();
                st.close();
                rs.close();
            } catch (Exception e) {
            }
        }
        return dtm;
    }
    public int Add(DTO_KhachHang KH)
    {
        int res=0;
         try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            conn =DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql = "Insert into Khachhang values (?,?,?,?,?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1,KH.getMaKhachHang());
                ps.setString(2,KH.getMaLoaiKhachHang());
                ps.setString(3,KH.getHoTen());
                ps.setString(4,KH.getGioiTinh());
                ps.setString(5,KH.getNgaySinh());
                ps.setString(6,KH.getCMND());
                ps.setString(7,KH.getDiaChi());
                ps.setString(8,KH.getSDT());
                ps.setString(9,KH.getEmail());
                ps.setBoolean(10,KH.isTrangThai());
                res = ps.executeUpdate();
            }
         }
        catch (Exception e)
                {
                    
                }
         finally
         {
             try {
                 conn.close();
                 rs.close();
                 ps.close();
             } catch (Exception e) {
             }
         }
         return res;
    }
    public int Update(DTO_KhachHang KH, String MaKH)
    {
        int res=0;
         try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            conn =DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql = "update Khachhang set makhachhang=?, maloaikhachhang=?,hoten=?,gioitinh=?,ngaysinh=?,cmnd=?,diachi=?,sdt=?,email=?,trangthai=? where makhachhang=?" ;
                ps = conn.prepareStatement(sql);
                ps.setString(1,KH.getMaKhachHang());
                ps.setString(2,KH.getMaLoaiKhachHang());
                ps.setString(3,KH.getHoTen());
                ps.setString(4,KH.getGioiTinh());
                ps.setString(5,KH.getNgaySinh());
                ps.setString(6,KH.getCMND());
                ps.setString(7,KH.getDiaChi());
                ps.setString(8,KH.getSDT());
                ps.setString(9,KH.getEmail());
                ps.setBoolean(10,KH.isTrangThai());
                ps.setString(11,MaKH);
                res = ps.executeUpdate();
            }
         }
        catch (Exception e)
                {
                    
                }
         finally
         {
             try {
                 conn.close();
                 rs.close();
                 ps.close();
             } catch (Exception e) {
             }
         }
         return res;
    }
    public int Delete(String MaKH)
    {
        int res=0;
         try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            conn =DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql = "Update KhachHang set trangthai=false where MaKhachHang=?" ;
                ps = conn.prepareStatement(sql);
                ps.setString(1,MaKH);
                res = ps.executeUpdate();
            }
         }
        catch (Exception e)
                {
                    
                }
         finally
         {
             try {
                 conn.close();
                 rs.close();
                 ps.close();
             } catch (Exception e) {
             }
         }
         return res;
    }
public int MaKH()
    {
        int ma=0;
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            conn=DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql = "Select makhachhang from khachhang";
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                int tam=0;
                while (rs.next())
                {
                    tam=Integer.parseInt(rs.getString("makhachhang"));
                    if (ma<tam)
                        ma=tam;
                }
            }
        } catch (Exception e) {
        }
        finally
        {
            try {
                conn.close();
                st.close();
                rs.close();
            } catch (Exception e) {
            }
        }
        return ma+1;
    }
    public ArrayList<String> getLoaiKhachHang()
    {
        ArrayList<String> ds = new ArrayList<String>();
        int i=0;
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            conn = DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql = "Select tenloaikhachhang from loaikhachhang ";
                st = conn.createStatement();
                rs=st.executeQuery(sql);
                String tam="";
                while (rs.next())
                {
                    tam= rs.getString(1);
                    ds.add(tam);
                    i++;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return ds;
    }
    public int Add_CT(String MaPTP, String HoTen, String MaLoaiKhachHang, String CMND, String DiaChi, boolean tt )
    {
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            conn = DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql = "Insert into CT_PhieuThuePhong values (?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
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
                 if (conn!=null)
                conn.close();
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
            conn=DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql = "Select maptp from phieuthuephong";
                st = conn.createStatement();
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
        }
        finally
        {
            try {
                conn.close();
                st.close();
                rs.close();
            } catch (Exception e) {
            }
        }
        return ma+1;
    }
    public  int  SoKhachToiDa()
    {
        int gt=1;
        String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db"; 
        try {
            conn = DriverManager.getConnection(url);
            String sql = "Select GIATRI from ThamSo where TENTHAMSO='SoKhachToiDa'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            gt=rs.getInt("GIATRI");
        } catch (SQLException ex) {
            System.err.println("SOK"+ex.getMessage());
        }
        finally
        {
            try {
                conn.close();
                st.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return gt;
    }
    
}
