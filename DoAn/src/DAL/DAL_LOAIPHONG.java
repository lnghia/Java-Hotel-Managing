/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DTO_QLLOAIPHONG;
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
public class DAL_LOAIPHONG {
    Connection conn = null;
    public ArrayList<DTO_QLLOAIPHONG> getLoaiPhong(){
        ArrayList<DTO_QLLOAIPHONG> result = new ArrayList<DTO_QLLOAIPHONG>();
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            ResultSet rs =st.executeQuery(" Select LOAIPHONG.MALOAIPHONG, DONGIA, COUNT(PHONG.MALOAIPHONG) as 'SOLUONG' from LOAIPHONG LEFT JOIN PHONG ON LOAIPHONG.MALOAIPHONG = PHONG.MALOAIPHONG  GROUP BY LOAIPHONG.MALOAIPHONG "); 
            while(rs.next()){  
                System.out.println(rs.getString(1)+ "  " + rs.getString(2));  
                DTO_QLLOAIPHONG loaiphong = new DTO_QLLOAIPHONG();
                loaiphong.setMALOAIPHONG(rs.getString("MALOAIPHONG"));
                loaiphong.setDONGIA(rs.getFloat("DONGIA")); 
                loaiphong.setSOLUONG(rs.getInt("SOLUONG"));
                result.add(loaiphong);
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
    
    public void updateLoaiPhong(String maloaiphong, String dongia)
    {
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            String query = "update LOAIPHONG set DONGIA = ? where MALOAIPHONG = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, dongia);
            pst.setString(2, maloaiphong);
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
    public void insertloaiPhong(String maloaiphong, String dongia)
    {
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            String query = "INSERT INTO LOAIPHONG (MALOAIPHONG,DONGIA) VALUES( ?, ? );";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, maloaiphong);
            pst.setString(2, dongia);
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
    
    
    public void deleteLoaiPhong(String maloaiphong)
    {
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            String query = "DELETE FROM LOAIPHONG WHERE MALOAIPHONG = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, maloaiphong);
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
