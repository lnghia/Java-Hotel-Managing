/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.DTO_DICHVU;
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
public class DAL_DICHVU {
    Connection conn = null;
    public ArrayList<DTO_DICHVU> getDichVu(){
        ArrayList<DTO_DICHVU> result = new ArrayList<DTO_DICHVU>();
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            ResultSet rs =st.executeQuery(" Select MADICHVU, TENDICHVU from DICHVU ORDER BY MADICHVU ASC "); 
            while(rs.next()){  
                System.out.println(rs.getString(1)+ "  " + rs.getString(2));  
                DTO_DICHVU dichvu = new DTO_DICHVU();
                dichvu.setMADICHVU(rs.getString("MADICHVU"));
                dichvu.setTENDICHVU(rs.getString("TENDICHVU")); 
                result.add(dichvu);
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
    
    public void updateDichVu(String madichvu, String tendichvu)
    {
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            String query = "update DICHVU set TENDICHVU = ? where MADICHVU = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, tendichvu);
            pst.setString(2, madichvu);
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
    public void insertDichVu(String madichvu, String tendichvu)
    {
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            String query = "INSERT INTO DICHVU (MADICHVU,TENDICHVU) VALUES( ?, ?);";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, madichvu);
            pst.setString(2, tendichvu);
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
    
    
    public void deleteDichVu(String madichvu)
    {
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            String query = "DELETE FROM DICHVU WHERE MADICHVU = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, madichvu);
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
