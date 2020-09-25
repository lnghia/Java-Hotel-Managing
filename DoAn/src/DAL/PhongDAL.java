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
public class PhongDAL {
    private static PhongDAL instance;
    
    public static PhongDAL getInstance(){
        if(instance==null){
            instance=new PhongDAL();
        }
        
        return instance;
    }
    
    public String getRoomTypeId(String roomId){
        String query="select MALOAIPHONG from PHONG where MAPHONG='" + roomId + "'";
        //and TRANGTHAI=true
        
        return DataProvider.getInstance().executeQuery(query, new String[]{}).get(0).get("MALOAIPHONG");
    }
}
