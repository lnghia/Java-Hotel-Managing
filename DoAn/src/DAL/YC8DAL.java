/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author nghia
 */
public class YC8DAL {
    private static YC8DAL instance;

    public static YC8DAL getInstance() {
        if(instance==null){
            instance=new YC8DAL();
        }
        
        return instance;
    }
    
    public void getDvListByRoomId(String roomId){
//        String query="select * from CT_SUDUNGDICHVU where "
    }
    
    public ArrayList<HashMap<String, String>> getSpListByDvId(String dvId){
        String query="select TENSANPHAM, MASANPHAM from CT_QUANLYDICHVU where MADICHVU='"+dvId+"'";
        
        return DataProvider.getInstance().executeQuery(query, new String[]{});
    }
    
    public float getDonGiaDv(String maDv, String maSp){
        String query="select DONGIA from CT_QUANLYDICHVU where MADICHVU='" + maDv + "' and MASANPHAM='"+maSp+"'";
        
        return Float.parseFloat(DataProvider.getInstance().executeQuery(query, new String[]{}).get(0).get("DONGIA"));
    }
    
    public int getSoLuongSp(String maDv, String maSp){
        String query="select SOLUONGTRONGKHO from CT_QUANLYDICHVU where MASANPHAM='"+maSp+"' and MADICHVU='"+maDv+"'";
        
        return Integer.parseInt(DataProvider.getInstance().executeQuery(query, new String[]{}).get(0).get("SOLUONGTRONGKHO"));
    }
    
    public int updateSoluongSp(String maDv, String maSp, int soluong){
        String query="update CT_QUANLYDICHVU set SOLUONGTRONGKHO="+Integer.toString(soluong)+" where MADICHVU='"+maDv+"' and MASANPHAM='"+maSp+"'";
        
        return DataProvider.getInstance().executeNonQuery(query, new String[]{});
    }
}
