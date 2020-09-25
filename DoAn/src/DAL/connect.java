/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author SpingGr4ss
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;  
import java.sql.Statement; 
import java.util.*;

/**
 *
 * @author sqlitetutorial.net
 */
public class connect {
     /**
     * Connect to a sample database
     */
    public static Connection connect() {
        Connection conn = null;
        // db parameters
       // Class.forName("org.sqlite.JDBC"); 
       try{
        String url = "jdbc:sqlite:C:/sqlite/db/QuanLiKhachSan.db";
        // create a connection to the database
        conn = DriverManager.getConnection(url);
        return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       return conn;       
    }
    
    /*public static void main(String args[]) throws Exception {
        connect();
    }*/
    
    /**
     * @param args the command line arguments
     */
}
