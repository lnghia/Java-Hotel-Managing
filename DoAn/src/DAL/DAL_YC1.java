/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import GUI.*;
/**
 *
 * @author Huyen
 */
public class DAL_YC1 {
    Connection Conn = null;
    private String header[]={"Mã phòng", "Loại phòng", "Mô tả","Ghi chú", "Tình trạng"};
    private DefaultTableModel dtm = new DefaultTableModel(header,0);
    Statement st = null;
    ResultSet rs = null;
   
    public DefaultTableModel getData()
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
            String sqlite ="Select * from Phong where trangthai=true";
            st = Conn.createStatement();
            rs = st.executeQuery(sqlite);
            Vector data = null;
            dtm.setRowCount(0);
            while (rs.next())
            {
                data=new Vector();
                data.add(rs.getString("MaPhong"));
                data.add(rs.getString("MaLoaiPhong"));
                data.add(rs.getString("MoTa"));
                data.add(rs.getString("GhiChu"));
                data.add(rs.getString("TinhTrang"));
                dtm.addRow(data);
            }
            if (dtm!=null)
        return dtm;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (Conn!=null)
                    Conn.close();
                if (st!=null)
                    st.close();
                if (rs!=null)
                    rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }
        
        return null;
    }
    
}
