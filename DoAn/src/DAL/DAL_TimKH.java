/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Huyen
 */
public class DAL_TimKH {
    Connection conn;
    String [] Header ={"Mã khách hàng", "Mã loại khách", "Họ tên","Giới tính", "Ngày sinh", "CMND", "Địa chỉ","SĐT","Email"}; 
    DefaultTableModel dtm = new DefaultTableModel(Header,0);
    Statement st=null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    public DefaultTableModel TimKiem(String dk, String data) 
    {
        String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
        int row=0;
        try {
            conn= DriverManager.getConnection(url);
            if (conn!=null)
            {
                String sql1 = "Select * from khachhang where cmnd = ?";
                String sql2 = "Select * from khachhang where hoten = ?";
                String sql3 = "Select * from khachhang where sdt = ?";
                if (dk.equals("cmnd"))
                    ps = conn.prepareStatement(sql1);
                if (dk.equals("hoten"))
                    ps = conn.prepareStatement(sql2);
                if (dk.equals("sdt"))
                    ps = conn.prepareStatement(sql3);
                ps.setString(1, data);
                //st = conn.createStatement();
                rs = ps.executeQuery();
                Vector dt = null;
                dtm.setRowCount(0);
                while (rs.next())
                {                    
                    dt = new Vector();
                    row++;
                    dt.add(rs.getString("MaKhachHang"));
                    dt.add(rs.getString("MaLoaiKhachHang"));
                    dt.add(rs.getString("HoTen"));
                    dt.add(rs.getString("GioiTinh"));
                    dt.add(rs.getString("NgaySinh"));
                    dt.add(rs.getString("CMND"));
                    dt.add(rs.getString("DiaChi"));
                    dt.add(rs.getString("Email"));
                    dt.add(rs.getString("SDT"));
                    dtm.addRow(dt);
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL_TimKH.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (row==0)
            return null;
        return dtm;
    }
}
