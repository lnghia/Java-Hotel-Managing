/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.DTO_DOANHTHU;
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
public class DAL_DOANHTHU {
    Connection conn = null;
    public ArrayList<DTO_DOANHTHU> getDoanhThu(String thang, String nam){
        ArrayList<DTO_DOANHTHU> result = new ArrayList<DTO_DOANHTHU>();
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            String mabcdt = "";
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            ResultSet rs =st.executeQuery(" Select CT_BCDT.MABCDT, CT_BCDT.MALOAIPHONG, CT_BCDT.DOANHTHU, CT_BCDT.TYLE from CT_BCDT INNER JOIN BAOCAODOANHTHU ON CT_BCDT.MABCDT = BAOCAODOANHTHU.MABCDT WHERE BAOCAODOANHTHU.THANG = '"+ thang +"' AND BAOCAODOANHTHU.NAM = '"+ nam +"' "); 
            while(rs.next()){  
                System.out.println(rs.getString(1)+ "  " + rs.getString(2));  
                DTO_DOANHTHU doanhthu = new DTO_DOANHTHU();
                mabcdt = rs.getString("MABCDT");
                doanhthu.setLOAIPHONG(rs.getString("MALOAIPHONG"));
                doanhthu.setDOANHTHU(rs.getFloat("DOANHTHU")); 
                doanhthu.setTYLE(rs.getFloat("TYLE"));
                result.add(doanhthu);
            }
            UpdateTongDoanhThu(mabcdt);
            
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
    
    void UpdateTongDoanhThu(String mabcdt)
    {
        try {
            // db parameters
            // create a connection to the database
            conn = connect.connect();
            Statement st = conn.createStatement();  //
            String query = "update BAOCAODOANHTHU set TONGDOANHTHU = (Select SUM(DOANHTHU) from CT_BCDT WHERE MABCDT = ? ) WHERE MABCDT = ? ";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, mabcdt);
            pst.setString(2, mabcdt);
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
    
    public String GetTongDoanhThu(String thang, String nam)
    {
        String result = "";
        try {
            // db parameters
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQL server has been established.");
            Statement st = conn.createStatement();  
            ResultSet rs =st.executeQuery(" select TONGDOANHTHU from BAOCAODOANHTHU INNER JOIN CT_BCDT ON CT_BCDT.MABCDT = BAOCAODOANHTHU.MABCDT WHERE THANG = '"+ thang +"' AND NAM = '"+ nam +"'  ");  
            result = rs.getString("TONGDOANHTHU");    
            
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
    
    public ArrayList<String> getThang()
    {
        ArrayList<String> result = new ArrayList<String>();
        try {
            // db parameters
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQL server has been established.");
            Statement st = conn.createStatement();  
            ResultSet rs =st.executeQuery(" SELECT DISTINCT THANG FROM BAOCAODOANHTHU; "); 
            while(rs.next()){   
                String s = rs.getString("THANG");
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
    
    public ArrayList<String> getNam()
    {
        ArrayList<String> result = new ArrayList<String>();
        try {
            // db parameters
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQL server has been established.");
            Statement st = conn.createStatement();  
            ResultSet rs =st.executeQuery(" SELECT DISTINCT NAM FROM BAOCAODOANHTHU; "); 
            while(rs.next()){   
                String s = rs.getString("NAM");
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
