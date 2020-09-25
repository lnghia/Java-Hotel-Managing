/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.PhieuThuePhongDTO;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author nghia
 */
public class PhieuThuePhongDAL {
    private static PhieuThuePhongDAL instance;
    
    public static PhieuThuePhongDAL getInstance(){
        if(instance==null){
            instance=new PhieuThuePhongDAL();
        }
        
        return instance;
    }
    
    public String getMostRecentStartDateByRoomId(String roomId){
        String query="select NGAYBATDAUTHUE from PHIEUTHUEPHONG where MAPHONG='" + roomId + "' and TRANGTHAI=true and TINHTRANG=false";
        
        return DataProvider.getInstance().executeQuery(query, new String[]{}).get(0).get("NGAYBATDAUTHUE");
    }
    
    public String getActivePhieuThueId(String roomId){
        String query="select MAPTP from PHIEUTHUEPHONG where MAPHONG='" + roomId + "' and TINHTRANG='0'";
        
        return DataProvider.getInstance().executeQuery(query, new String[]{}).get(0).get("MAPTP");
    }
        
    public PhieuThuePhongDTO getMostRecentPTPByRoomId(String roomId){
//        String mostRecentDate=getMostRecentStartDateByRoomId(roomId);
        String query="select * from PHIEUTHUEPHONG where MAPHONG='"+ roomId +"' and (TINHTRANG='false' or TINHTRANG='0')";
        
        //PhieuThuePhongDTO tmp=PhieuThuePhongDTO.parse(DataProvider.getInstance().executeQuery(query, new String[]{}).stream().findFirst().orElse(null));
        
        return PhieuThuePhongDTO.parse(DataProvider.getInstance().executeQuery(query, new String[]{}).stream().findFirst().orElse(null));
    }
    
    public String getCustomerId(String roomId){
//        String mostRecentDate=getMostRecentStartDateByRoomId(roomId);
        String query="select MAKHACHHANG from PHIEUTHUEPHONG where MAPHONG='" + roomId + "' and TINHTRANG='false' and TRANGTHAI='true'";
        
        return DataProvider.getInstance().executeQuery(query, new String[]{}).get(0).get("MAKHACHHANG");
    }
}
