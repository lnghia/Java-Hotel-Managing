/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.SQLiteConfig;

/**
 *
 * @author nghia
 */
public class DataProvider {
//    private Connection conn;
    private static DataProvider instance;
    private String connectionStr;
    private SQLiteConfig config;
    
    public static synchronized DataProvider getInstance(){
        if(instance==null){
            instance=new DataProvider();
        }
        
        return instance;
    }
    
    public DataProvider(){
        getConnection();
    }
    
    private void getConnection(){
        Properties props=new Properties();
        
        try(BufferedInputStream in=(BufferedInputStream) getClass().getResourceAsStream("..\\Properties\\project.properties")){
            props.load(in);
            
            connectionStr=props.getProperty("dburl");
        
            Class.forName("org.sqlite.JDBC");
            
            config = new SQLiteConfig();
            config.setEncoding(SQLiteConfig.Encoding.UTF8);
            
            try (Connection conn = DriverManager.getConnection(connectionStr, config.toProperties())) {
                System.out.println("Succeeded in connecting to database !");
            }
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            System.out.println("Failed to connect to database !");
            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<HashMap<String, String>> executeQuery(String query, String[] parameters){
        ResultSet result;
        ArrayList<HashMap<String, String>> rs=new ArrayList<>();
        
//        if(conn==null){
//            getConnection();
//        }

        if(connectionStr==null || connectionStr.isEmpty() || config==null){
            getConnection();
        }
        
        try(    Connection conn = DriverManager.getConnection(connectionStr, config.toProperties()); 
                PreparedStatement stm=conn.prepareStatement(query)
            ){
            for(int i=0; i<parameters.length; ++i){
                stm.setString(i+1, parameters[i]);
            }   
            
            result=stm.executeQuery();
            
            int colsCount=result.getMetaData().getColumnCount();
            ResultSetMetaData rsmd=result.getMetaData();
            
            while(result.next()){
                HashMap<String, String> row=new HashMap<>();
                
                for(int i=1; i<=colsCount; ++i){
//                    row[i]=new String(result.getBytes(i+1), "cp437");
                    
                    row.put(rsmd.getColumnName(i), result.getString(i));
                }
                
                rs.add(row);
            }
            
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return rs;
    }
        
    public int executeNonQuery(String query, String[] parameters){
//        PreparedStatement stm=null;
        
//        if(conn==null){
//            getConnection();
//        }

        if(connectionStr==null || connectionStr.isEmpty() || config==null){
            getConnection();
        }
        
        try(    Connection conn=DriverManager.getConnection(connectionStr, config.toProperties()); 
                PreparedStatement stm = conn.prepareStatement(query)
            ){
            for(int i=0; i<parameters.length; ++i){
                stm.setString(i+1, parameters[i]);
            }
            
            return stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return 0;
    }
    
    public void close(PreparedStatement stm, ResultSet rs) throws SQLException{
        stm.close();
        rs.close();
    }
    
     public void close(PreparedStatement stm) throws SQLException{
        stm.close();
    }
    
    public void close(Connection conn, PreparedStatement stm, ResultSet rs) throws SQLException{
        conn.close();
        stm.close();
        rs.close();
    }
}
