/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.DTO_LOAIKHACH;
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
public class DAL_LOAIKHACH {
    Connection conn = null;
    public ArrayList<DTO_LOAIKHACH> getLoaiKhach(){
        ArrayList<DTO_LOAIKHACH> result = new ArrayList<DTO_LOAIKHACH>();
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            ResultSet rs =st.executeQuery(" Select MALOAIKHACHHANG, TENLOAIKHACHHANG, HESOPHUTHU from LOAIKHACHHANG "); 
            while(rs.next()){  
                System.out.println(rs.getString(1)+ "  " + rs.getString(2));  
                DTO_LOAIKHACH loaikhach = new DTO_LOAIKHACH();
                loaikhach.setMALOAIKHACHHANG(rs.getString("MALOAIKHACHHANG"));
                loaikhach.setTENLOAIKHACHHANG(rs.getString("TENLOAIKHACHHANG")); 
                loaikhach.setHESOPHUTHU(rs.getFloat("HESOPHUTHU"));
                result.add(loaikhach);
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
    
    public void updateLoaiKhach(String maloaikhach, String tenloaikhach, String hesophuthu)
    {
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            String query = "update LOAIKHACHHANG set TENLOAIKHACHHANG = ?, HESOPHUTHU = ? where MALOAIKHACHHANG = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, tenloaikhach);
            pst.setString(2, hesophuthu);
            pst.setString(3, maloaikhach);
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
    public void insertloaiKhach(String maloaikhach, String tenloaikhach, String hesophuthu)
    {
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            String query = "INSERT INTO LOAIKHACHHANG (MALOAIKHACHHANG,TENLOAIKHACHHANG,HESOPHUTHU) VALUES( ?, ?, ? );";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, maloaikhach);
            pst.setString(2, tenloaikhach);
            pst.setString(3, hesophuthu);
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
    
    
    public void deleteLoaiKhach(String maloaikhach)
    {
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            String query = "DELETE FROM LOAIKHACHHANG WHERE MALOAIKHACHHANG = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, maloaikhach);
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
}
