/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SpingGr4ss
 */
public class DAL_THONGKE1 {

    Connection Conn = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    String [] Header1 ={"Tỉnh ","Tổng số khách"};
    String [] Header2 ={"Thời gian bắt đầu ","Thời gian kết thức", "Tổng số khách"};
    DefaultTableModel dtm1 = new DefaultTableModel(Header1, 0);
    DefaultTableModel dtm2 = new DefaultTableModel(Header2, 0);
    
    public DefaultTableModel ThongKeTheoTinh(String bd, String kt)
    {
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "select DiaChi, count(CMND) as soluong from CT_Phieuthuephong, phieuthuephong where phieuthuephong.ngaybatdauthue>=? and phieuthuephong.ngaybatdauthue<=? and phieuthuephong.maptp=ct_phieuthueophong.maptp group by DiaChi";
                ps = Conn.prepareStatement(sql);
                ps.setString(1, bd);
                ps.setString(2, kt);
                rs = ps.executeQuery();
                Vector Data;
                while (rs.next())
                {
                    Data = new Vector();
                    Data.add(rs.getString("DiaChi"));
                    Data.add(rs.getInt("soluong"));
                    dtm1.addRow(Data);
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
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dtm1;
    }
    public DefaultTableModel ThongKeTheoThang(String bd, String kt)
    {
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "select count(CMND) as soluong from CT_Phieuthuephong, phieuthuephong where phieuthuephong.ngaybatdauthue>=? and phieuthuephong.ngaybatdauthue<=? and phieuthuephong.maptp=ct_phieuthueophong.maptp";
                ps = Conn.prepareStatement(sql);
                ps.setString(1, bd);
                ps.setString(2, kt);
                rs = ps.executeQuery();
                Vector Data; 
                while (rs.next())
                {
                    Data = new Vector();
                    Data.add(bd);
                    Data.add(kt);
                    Data.add(rs.getInt("soluong"));
                    dtm2.addRow(Data);
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
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dtm2;
    }
    
}
