/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import DTO.DTO_THAMSO;
import java.sql.PreparedStatement;
/**
 *
 * @author SpingGr4ss
 */
public class DAL_THAMSO {
    Connection conn = null;
    public ArrayList<DTO_THAMSO> getThamSo(){
        ArrayList<DTO_THAMSO> result = new ArrayList<DTO_THAMSO>();
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            ResultSet rs =st.executeQuery(" Select TENTHAMSO, GIATRI from THAMSO ORDER BY GIATRI ASC  "); 
            while(rs.next()){  
                System.out.println(rs.getString(1)+ "  " + rs.getString(2));  
                DTO_THAMSO thamso = new DTO_THAMSO();
                thamso.setTENTHAMSO(rs.getString("TENTHAMSO"));
                thamso.setGIATRI(rs.getFloat("GIATRI")); 
                result.add(thamso);
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
    
    public void updateThamSo(String tenthamso, String giatri)
    {
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            String query = "update THAMSO set GIATRI = ? where TENTHAMSO = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, giatri);
            pst.setString(2, tenthamso);
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
    public void insertThamSo(String tenthamso, String giatri)
    {
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            String query = "INSERT INTO THAMSO (TENTHAMSO,GIATRI) VALUES( ?, ? );";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, tenthamso);
            pst.setString(2, giatri);
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
    
    
    public void deleteThamSo(String tenthamso)
    {
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            String query = "DELETE FROM THAMSO WHERE TENTHAMSO = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, tenthamso);
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
