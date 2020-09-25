/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author nghia
 */
public class CT_QUANLYDICHVUDAL {
    private static CT_QUANLYDICHVUDAL instance;
    
    public static CT_QUANLYDICHVUDAL getInstance(){
        if(instance==null){
            instance=new CT_QUANLYDICHVUDAL();
        }
        
        return instance;
    }
    
    public float getDonGiaDv(String maDv){
        String query="select DONGIA from CT_QUANLYDICHVU where MADICHVU='" + maDv + "'";
        
        return Float.parseFloat(DataProvider.getInstance().executeQuery(query, new String[]{}).get(0).get("DONGIA"));
    }
}
