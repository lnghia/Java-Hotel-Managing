/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huyen
 */
public class DAL_QuanLiNhanVien {
    Connection Conn = null;
    Statement st = null;
    ResultSet rs = null;
    String [] Header = {"Họ tên","Chức vụ","Phòng ban", "Lương"};
    DefaultTableModel dtm = new DefaultTableModel(Header,0);
    public DefaultTableModel getDanhSachNhanVien()
    {
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "SELECT hoten, tenchucvu, tenphongban, ((heso*Thamso.giatri)+(heso*Thamso.giatri)*hesophucap/100) as luong\n" +
"from NHANVIEN, CHUCVU, PHONGBAN , Bacluong, thamso\n" +
"WHERE NHANVIEN.MACHUCVU=CHUCVU.machucvu and Nhanvien.mabacluong=bacluong.mabacluong and NHANVIEN.maphongban = PHONGBAN.maphongban and Nhanvien.trangthai=true and thamso.tenthamso='LuongCoBan'";
                st = Conn.createStatement();
                rs = st.executeQuery(sql);
                Vector Data; 
                while (rs.next())
                {
                    Data = new Vector();
                    Data.add(rs.getString("hoten"));
                    Data.add(rs.getString("tenchucvu"));
                    Data.add(rs.getString("tenphongban"));                    
                    Data.add(rs.getFloat("luong"));
                    dtm.addRow(Data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                Conn.close();
                rs.close();
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dtm;
    }
   
}
