/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huyen
 */
public class DAL_YC7 {
    Connection Conn = null;
    Statement st = null;
    ResultSet rs = null;
    String [] Header1 ={"Tỉnh ","Tổng số khách"};
    String [] Header2 ={"Tháng ","Tổng số khách"};
    DefaultTableModel dtm1 = new DefaultTableModel(Header1, 0);
    DefaultTableModel dtm2 = new DefaultTableModel(Header2, 0);
    public DefaultTableModel ThongKeTheoTinh()
    {
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "select DiaChi, count(CMND) as soluong from CT_Phieuthuephong group by DiaChi";
                st = Conn.createStatement();
                rs = st.executeQuery(sql);
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
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dtm1;
    }
    private int Thang1()
    {
        int SoLuong=0;
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "select sum(sokhach) as soluong from Phieuthuephong where ngaybatdauthue like '%/01/%'";
                st = Conn.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next())
                {
                    SoLuong=rs.getInt("soluong");
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
        return SoLuong;
    }
    private int Thang2()
    {
        int SoLuong=0;
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "select sum(sokhach) as soluong from Phieuthuephong where ngaybatdauthue like '%/02/%'";
                st = Conn.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next())
                {
                    SoLuong=rs.getInt("soluong");
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
        return SoLuong;
    }
    private int Thang3()
    {
        int SoLuong=0;
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "select sum(sokhach) as soluong from Phieuthuephong where ngaybatdauthue like '%/03/%'";
                st = Conn.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next())
                {
                    SoLuong=rs.getInt("soluong");
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
        return SoLuong;
    }
    private int Thang4()
    {
        int SoLuong=0;
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "select sum(sokhach) as soluong from Phieuthuephong where ngaybatdauthue like '%/04/%'";
                st = Conn.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next())
                {
                    SoLuong=rs.getInt("soluong");
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
        return SoLuong;
    }
    private int Thang5()
    {
        int SoLuong=0;
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "select sum(sokhach) as soluong from Phieuthuephong where ngaybatdauthue like '%/05/%'";
                st = Conn.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next())
                {
                    SoLuong=rs.getInt("soluong");
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
        return SoLuong;
    }
    private int Thang6()
    {
        int SoLuong=0;
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "select sum(sokhach) as soluong from Phieuthuephong where ngaybatdauthue like '%/06/%'";
                st = Conn.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next())
                {
                    SoLuong=rs.getInt("soluong");
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
        return SoLuong;
    }
    private int Thang7()
    {
        int SoLuong=0;
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "select sum(sokhach) as soluong from Phieuthuephong where ngaybatdauthue like '%/07/%'";
                st = Conn.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next())
                {
                    SoLuong=rs.getInt("soluong");
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
        return SoLuong;
    }
    private int Thang8()
    {
        int SoLuong=0;
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "select sum(sokhach) as soluong from Phieuthuephong where ngaybatdauthue like '%/08/%'";
                st = Conn.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next())
                {
                    SoLuong=rs.getInt("soluong");
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
        return SoLuong;
    }
    private int Thang9()
    {
        int SoLuong=0;
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "select sum(sokhach) as soluong from Phieuthuephong where ngaybatdauthue like '%/09/%'";
                st = Conn.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next())
                {
                    SoLuong=rs.getInt("soluong");
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
        return SoLuong;
    }
    private int Thang10()
    {
        int SoLuong=0;
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "select sum(sokhach) as soluong from Phieuthuephong where ngaybatdauthue like '%/10/%'";
                st = Conn.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next())
                {
                    SoLuong=rs.getInt("soluong");
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
        return SoLuong;
    }private int Thang11()
    {
        int SoLuong=0;
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "select sum(sokhach) as soluong from Phieuthuephong where ngaybatdauthue like '%/11/%'";
                st = Conn.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next())
                {
                    SoLuong=rs.getInt("soluong");
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
        return SoLuong;
    }
    private int Thang12()
    {
        int SoLuong=0;
        try {
            String url ="jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
            Conn = DriverManager.getConnection(url);
            if (Conn!=null)
            {
                String sql = "select sum(sokhach) as soluong from Phieuthuephong where ngaybatdauthue like '%/12/%'";
                st = Conn.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next())
                {
                    SoLuong=rs.getInt("soluong");
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
        return SoLuong;
    }
    public DefaultTableModel ThongKeTheoThang()
    {
        try {
            Vector Data = new Vector();
            Data.add("01");
            Data.add(Thang1());
            dtm2.addRow(Data);
            Data = new Vector();
            Data.add("02");
            Data.add(Thang2());
            dtm2.addRow(Data);
            Data = new Vector();
            Data.add("03");
            Data.add(Thang3());
            dtm2.addRow(Data);
            Data = new Vector();
            Data.add("04");
            Data.add(Thang4());
            dtm2.addRow(Data);
            Data = new Vector();
            Data.add("05");
            Data.add(Thang5());
            dtm2.addRow(Data);
            Data = new Vector();
            Data.add("06");
            Data.add(Thang6());
            dtm2.addRow(Data);
            Data = new Vector();
            Data.add("07");
            Data.add(Thang7());
            dtm2.addRow(Data);
            Data = new Vector();
            Data.add("08");
            Data.add(Thang8());
            dtm2.addRow(Data);
            Data = new Vector();
            Data.add("09");
            Data.add(Thang9());
            dtm2.addRow(Data);
            Data = new Vector();
            Data.add("10");
            Data.add(Thang10());
            dtm2.addRow(Data);
            Data = new Vector();
            Data.add("11");
            Data.add(Thang11());
            dtm2.addRow(Data);
            Data = new Vector();
            Data.add("12");
            Data.add(Thang12());
            dtm2.addRow(Data);
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
        return dtm2;
    }
    
}
