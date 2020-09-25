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
public class LoaiPhongDAL {
    private static LoaiPhongDAL instance;
    
    public static LoaiPhongDAL getInstance(){
        if(instance==null){
            instance=new LoaiPhongDAL();
        }
        
        return instance;
    }
    
    public String getRoomTypeUnitPrice(String roomTypeId){
        String query="select DONGIA from LOAIPHONG where MALOAIPHONG='" + roomTypeId + "'";
        //and TRANGTHAI=true
        
        return DataProvider.getInstance().executeQuery(query, new String[]{}).get(0).get("DONGIA");
    }
}
