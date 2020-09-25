/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DTO_KhachHang;
import DTO.DTO_NhanVien;
//import com.sun.org.omg.SendingContext.CodeBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huyen
 */
public class DAL_NhanVien {
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    String [] Header ={"Mã nhân viên", "Họ tên", "Ngày sinh", "Ngày kí hợp đồng", "Số hợp đồng ","Bậc lương", "Phòng ban","Chức vụ",  "SĐT"}; 
    DefaultTableModel dtm = new DefaultTableModel(Header,0);
    public DefaultTableModel getData()
    {
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            conn =DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql = "Select MaNhanVien, HoTen, NgaySinh, NgayKyHopDong, SoHopDong, MaBacLuong, TenChucVu, TenPhongBan, SDT from NhanVien, phongban, chucvu where nhanvien.machucvu=chucvu.machucvu and nhanvien.maphongban=phongban.maphongban and nhanvien.trangthai=true";
                String sql2 = "Select * from NhanVien";
                st = conn.createStatement();
                rs = st.executeQuery(sql);                
                dtm.setRowCount(0);
                Vector data = null;
                while (rs.next())
                {
                    data = new Vector();
                    data.add(rs.getString("MaNhanVien"));
                    data.add(rs.getString("Hoten"));                   
                    data.add(rs.getString("NgaySinh"));                    
                    data.add(rs.getString("NgayKyHopDong"));
                    data.add(rs.getString("SoHopDong"));                 
                    data.add(rs.getString("MaBacLuong"));
                    data.add(rs.getString("TenPhongBan"));                    
                    data.add(rs.getString("TenChucVu"));
                    data.add(rs.getString("SDT"));
                    dtm.addRow(data);
                }
            }
            else
                System.err.println("Ko co ket noi");
        } catch (Exception e) {
            e.printStackTrace();
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
        return dtm;
    }
    public int Add(DTO_NhanVien NV)
    {
        int res=0;
         try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            conn =DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql = "Insert into nhanvien values (?,?,?,?,?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1,NV.getMaNhanVien());
                ps.setString(2,NV.getHoTen());
                ps.setString(3,NV.getNgaySinh());
                ps.setString(4,NV.getNgayKiHopDong());
                ps.setString(5,NV.getSoHopDong());
                ps.setString(6,NV.getMaBacLuong());
                ps.setString(8,NV.getMaChucVu());
                ps.setString(7,NV.getMaPhongBan());
                ps.setString(10,NV.getSDT());
                ps.setBoolean(9,NV.isTrangThai());
                res = ps.executeUpdate();
            }
         }
        catch (Exception e)
                {
                    e.printStackTrace();
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
    public int Update(DTO_NhanVien NV, String MaNV)
    {
        int res=0;
         try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            conn =DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql = "update nhanvien set hoten=?,ngaysinh=?,ngaykyhopdong=?,sohopdong=?, mabacluong=?,maphongban=?, machucvu=?, sdt=?,trangthai=? where manhanvien=?" ;
                ps = conn.prepareStatement(sql);
                ps.setString(1,NV.getHoTen());
                ps.setString(2,NV.getNgaySinh());
                ps.setString(3,NV.getNgayKiHopDong());
                ps.setString(4,NV.getSoHopDong());
                ps.setString(5,NV.getMaBacLuong());
                ps.setString(6,NV.getMaPhongBan());
                ps.setString(7,NV.getMaChucVu());
                ps.setString(8,NV.getSDT());
                ps.setBoolean(9,NV.isTrangThai());
                ps.setString(10,MaNV);
                res = ps.executeUpdate();
            }
         }
        catch (Exception e)
                {
                    e.printStackTrace();
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
    public int Delete(String MaNV)
    {
        int res=0;
         try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            conn =DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql = "Update Nhanvien set trangthai=false where MaNHanvien=?" ;
                ps = conn.prepareStatement(sql);
                ps.setString(1,MaNV);
                res = ps.executeUpdate();
            }
         }
        catch (Exception e)
                {
                    e.printStackTrace();
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
    public int MaNV()
    {
        int ma=0;
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            conn=DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql = "Select manhanvien from nhanvien";
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                int tam=0;
                while (rs.next())
                {
                    tam=Integer.parseInt(rs.getString("manhanvien"));
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
        public ArrayList<String> getMaBacLuong()
    {
        ArrayList<String> ds = new ArrayList<String>();
        int i=0;
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            conn = DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql = "Select mabacluong from bacluong ";
                st = conn.createStatement();
                rs=st.executeQuery(sql);
                String tam="";
                while (rs.next())
                {
                    tam= rs.getString("mabacluong");
                    ds.add(tam);
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                conn.close();
                rs.close();
                st.close();
            } catch (Exception e) {
            }
        }
        return ds;
    }
        public ArrayList<String> getPhongBan()
    {
        ArrayList<String> ds = new ArrayList<String>();
        int i=0;
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            conn = DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql = "Select tenphongban from phongban ";
                st = conn.createStatement();
                rs=st.executeQuery(sql);
                String tam="";
                while (rs.next())
                {
                    tam= rs.getString("tenphongban");
                    ds.add(tam);
                    i++;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        finally
        {
            try {
                conn.close();
                rs.close();
                st.close();
            } catch (Exception e) {
            }
        }
        return ds;
    }
        public ArrayList<String> getChucVu()
    {
        ArrayList<String> ds = new ArrayList<String>();
        int i=0;
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            conn = DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql = "Select tenchucvu from chucvu ";
                st = conn.createStatement();
                rs=st.executeQuery(sql);
                String tam="";
                while (rs.next())
                {
                    tam= rs.getString("tenchucvu");
                    ds.add(tam);
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                conn.close();
                rs.close();
                st.close();
            } catch (Exception e) {
            }
        }
        return ds;
    }
    public String MaChucVu(String tencv)
    {       
        String tam="";
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            conn = DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql = "Select machucvu from chucvu where tenchucvu=? ";
                ps=conn.prepareStatement(sql);
                ps.setString(1, tencv);
                rs=ps.executeQuery();
                while (rs.next())
                {
                    tam= rs.getString("machucvu");
                    System.err.println(tencv+"+"+tam);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                conn.close();
                rs.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tam;
    }
    public String MaPhongban(String tenpb)
    {
        String tam="";
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            conn = DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql = "Select maphongban from phongban where tenphongban=? ";
                ps=conn.prepareStatement(sql);
                ps.setString(1, tenpb);
                rs=ps.executeQuery();
                while (rs.next())
                {
                    tam= rs.getString("maphongban");
                    System.err.println(tenpb+"+"+tam);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                conn.close();
                rs.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tam;
    }
}
