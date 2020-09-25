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

/**
 *
 * @author SpingGr4ss
 */
public class DAL_LOGIN {
    Connection conn = null;
    public String XacNhan(String taikhoan, String matkhau)
    {
        String result = "";
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            ResultSet rs =st.executeQuery(" Select QUYEN from PHANQUYEN where TAIKHOAN = '"+ taikhoan +"' AND MATKHAU = '"+ matkhau +"' ");  
            while(rs.next()){  
                result = rs.getString("QUYEN");           
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
