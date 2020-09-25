/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import com.sun.tools.javac.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author nghia
 */
public class DichVuDAL {
    private static DichVuDAL instance;
    
    public static DichVuDAL getInstance(){
        if(instance==null){
            instance=new DichVuDAL();
        }
        
        return instance;
    }
    
    public String getTenDV(String maDV){
        String query="select TENDICHVU from DICHVU where MADICHVU='" + maDV + "'";
        
        return DataProvider.getInstance().executeQuery(query, new String[]{}).get(0).get("TENDICHVU");
    }
    
    public ArrayList<HashMap<String, String>> getDv(){
        String query="select MADICHVU, TENDICHVU from DICHVU"; //  where TRANGTHAI=true
        
        return DataProvider.getInstance().executeQuery(query, new String[]{});
    }
}
