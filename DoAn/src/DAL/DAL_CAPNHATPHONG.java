/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.DTO_Phong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author SpingGr4ss
 */
public class DAL_CAPNHATPHONG {
    Connection conn = null;
    public ArrayList<DTO_Phong> getPhong(){
        ArrayList<DTO_Phong> result = new ArrayList<DTO_Phong>();
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            ResultSet rs =st.executeQuery(" Select MAPHONG, MALOAIPHONG, MOTA, GHICHU, TINHTRANG from PHONG ORDER BY MALOAIPHONG ASC "); 
            while(rs.next()){  

                DTO_Phong phong = new DTO_Phong();
                phong.setMaPhong(rs.getString("MAPHONG"));
                phong.setMaLoaiPhong(rs.getString("MALOAIPHONG"));
                phong.setMoTa(rs.getString("MOTA"));
                phong.setGhiChu(rs.getString("GHICHU"));
                phong.setTinhTrang(rs.getString("TINHTRANG"));
                result.add(phong);
            }     
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;
    }
    
    public ArrayList<DTO_Phong> getPhongTrong(){
        ArrayList<DTO_Phong> result = new ArrayList<DTO_Phong>();
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            ResultSet rs =st.executeQuery(" Select MAPHONG, MALOAIPHONG, MOTA, GHICHU, TINHTRANG from PHONG WHERE TINHTRANG = 'Trống' ORDER BY MALOAIPHONG ASC "); 
            while(rs.next()){  

                DTO_Phong phong = new DTO_Phong();
                phong.setMaPhong(rs.getString("MAPHONG"));
                phong.setMaLoaiPhong(rs.getString("MALOAIPHONG"));
                phong.setMoTa(rs.getString("MOTA"));
                phong.setGhiChu(rs.getString("GHICHU"));
                phong.setTinhTrang(rs.getString("TINHTRANG"));
                result.add(phong);
            }     
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;
    }
    
    public ArrayList<DTO_Phong> getPhongDangThue(){
        ArrayList<DTO_Phong> result = new ArrayList<DTO_Phong>();
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            ResultSet rs =st.executeQuery(" Select MAPHONG, MALOAIPHONG, MOTA, GHICHU, TINHTRANG from PHONG WHERE TINHTRANG != 'Trống' ORDER BY MALOAIPHONG ASC "); 
            while(rs.next()){  

                DTO_Phong phong = new DTO_Phong();
                phong.setMaPhong(rs.getString("MAPHONG"));
                phong.setMaLoaiPhong(rs.getString("MALOAIPHONG"));
                phong.setMoTa(rs.getString("MOTA"));
                phong.setGhiChu(rs.getString("GHICHU"));
                phong.setTinhTrang(rs.getString("TINHTRANG"));
                result.add(phong);
            }     
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;
    }
    
    public void updatePhong(String maphong, String maloaiphong, String mota, String ghichu, String tinhtrang)
    {
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();           
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            if (tinhtrang.compareTo("") == 0)
                tinhtrang = "Trống";
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            String query = "update PHONG set MALOAIPHONG = ?, MOTA = ?, GHICHU = ?, TINHTRANG = ? where MAPHONG = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, maloaiphong);
            pst.setString(2, mota);
            pst.setString(3, ghichu);
            pst.setString(4, tinhtrang);
            pst.setString(5, maphong);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
    public void insertPhong(String maphong, String maloaiphong, String mota, String ghichu, String tinhtrang)
    {
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            int trangthai = 1;
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            String query = "INSERT INTO PHONG (MAPHONG,MALOAIPHONG,MOTA,GHICHU,TINHTRANG,TRANGTHAI) VALUES( ?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, maphong);
            pst.setString(2, maloaiphong);
            pst.setString(3, mota);
            pst.setString(4, ghichu);
            pst.setString(5, tinhtrang);  
            pst.setInt(6, trangthai); 
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
    
    
    public void deletePhong(String maphong)
    {
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            String query = "DELETE FROM PHONG WHERE MAPHONG = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, maphong);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    
    public ArrayList<String> getLoaiPhong()
    {
        ArrayList<String> result = new ArrayList<String>();
        try {
            // db parameters
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQL server has been established.");
            Statement st = conn.createStatement();  
            ResultSet rs =st.executeQuery(" SELECT MALOAIPHONG FROM LOAIPHONG; "); 
            while(rs.next()){   
                String s = rs.getString("MALOAIPHONG");
                result.add(s);
            }     
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;
    }
}
