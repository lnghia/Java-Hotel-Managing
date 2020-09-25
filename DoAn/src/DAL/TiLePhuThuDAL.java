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
public class TiLePhuThuDAL {
    private static TiLePhuThuDAL instance;
    
    public static TiLePhuThuDAL getInstance(){
        if(instance==null){
            instance=new TiLePhuThuDAL();
        }
        
        return instance;
    }
    
    public float getTiLePhuThu(String khachThu){
        String query="select TILEPHUTHU from TILEPHUTHU where KHACHTHU='Khách thứ " + khachThu + "'"; 
        
        return Float.parseFloat(DataProvider.getInstance().executeQuery(query, new String[]{}).get(0).get("TILEPHUTHU"));
    }
}
