/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.DTO_QUANLYDICHVU;
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
public class DAL_QUANLYDICHVU {
    Connection conn = null;
    public ArrayList<DTO_QUANLYDICHVU> getQLDichVu(){
        ArrayList<DTO_QUANLYDICHVU> result = new ArrayList<DTO_QUANLYDICHVU>();
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            ResultSet rs =st.executeQuery(" Select MASANPHAM, TENSANPHAM, MADICHVU, SOLUONGBANDAU, SOLUONGTRONGKHO, DONGIA, GHICHU from CT_QUANLYDICHVU"); 
            while(rs.next()){  
                System.out.println(rs.getString(1)+ "  " + rs.getString(2));  
                DTO_QUANLYDICHVU qldichvu = new DTO_QUANLYDICHVU();
                qldichvu.setMASANPHAM(rs.getString("MASANPHAM"));
                qldichvu.setTENSANPHAM(rs.getString("TENSANPHAM")); 
                qldichvu.setMADICHVU(rs.getString("MADICHVU"));
                qldichvu.setSOLUONGBANDAU(rs.getInt("SOLUONGBANDAU"));
                qldichvu.setSOLUONGTRONGKHO(rs.getInt("SOLUONGTRONGKHO"));
                qldichvu.setDONGIA(rs.getFloat("DONGIA"));
                qldichvu.setGHICHU(rs.getString("GHICHU"));
                result.add(qldichvu);
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
    
    public void updateQLDichVu(String masanpham, String tensanpham, String loaidichvu, String soluongbandau, String soluongtrongkho, String dongia, String ghichu)
    {
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            String query = "update CT_QUANLYDICHVU set TENSANPHAM = ?, MADICHVU = ?, SOLUONGBANDAU = ?, SOLUONGTRONGKHO = ?, DONGIA = ?, GHICHU = ? where MASANPHAM = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, tensanpham);
            String madichvu = getMaDichVu(loaidichvu);
            pst.setString(2, madichvu);
            pst.setString(3, soluongbandau);
            pst.setString(4, soluongtrongkho);
            pst.setString(5, dongia);
            pst.setString(6, ghichu);
            pst.setString(7, masanpham);
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
    public void insertQLDichVu(String masanpham, String tensanpham, String loaidichvu, String soluongbandau, String soluongtrongkho, String dongia, String ghichu)
    {
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            String query = "INSERT INTO CT_QUANLYDICHVU (MASANPHAM,TENSANPHAM,MADICHVU,SOLUONGBANDAU,SOLUONGTRONGKHO,DONGIA,GHICHU) VALUES( ?, ?, ?, ?, ?, ?, ? );";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, masanpham);
            pst.setString(2, tensanpham);
            String madichvu = getMaDichVu(loaidichvu);
            pst.setString(3, madichvu);
            pst.setString(4, soluongbandau);
            pst.setString(5, soluongtrongkho);
            pst.setString(6, dongia);
            pst.setString(7, ghichu);
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
    
    
    public void deleteLoaiPhong(String masanpham)
    {
        try {
            // db parameters
            //Class.forName("org.sqlite.JDBC"); 
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQLite has been established.");
            Statement st = conn.createStatement();  
            //ResultSet rs =st.executeQuery("select * from PHONG");  
            String query = "DELETE FROM CT_QUANLYDICHVU WHERE MASANPHAM = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, masanpham);
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
    
    public ArrayList<String> getLoaiDichVu()
    {
        ArrayList<String> result = new ArrayList<String>();
        try {
            // db parameters
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQL server has been established.");
            Statement st = conn.createStatement();  
            ResultSet rs =st.executeQuery(" SELECT DISTINCT TENDICHVU FROM DICHVU; "); 
            while(rs.next()){   
                String s = rs.getString("TENDICHVU");
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
    
    public String getTenDichVu(String madichvu)
    {
        String result = "";
        try {
            // db parameters
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQL server has been established.");
            Statement st = conn.createStatement();  
            ResultSet rs = st.executeQuery(" SELECT TENDICHVU FROM DICHVU where MADICHVU = '" + madichvu + "' "); 
            while(rs.next()){   
                result = rs.getString("TENDICHVU");
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
    
    public String getMaDichVu(String tendichvu)
    {
        String result = "";
        try {
            // db parameters
            // create a connection to the database
            conn = connect.connect();
            
            System.out.println("Connection to SQL server has been established.");
            Statement st = conn.createStatement();  
            ResultSet rs =st.executeQuery(" SELECT MADICHVU FROM DICHVU where TENDICHVU = '" + tendichvu + "' "); 
            while(rs.next()){   
                result = rs.getString("MADICHVU");
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
