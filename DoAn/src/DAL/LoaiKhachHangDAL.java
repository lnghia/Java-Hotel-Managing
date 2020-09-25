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
public class LoaiKhachHangDAL {
    private static LoaiKhachHangDAL instance;
    
    public static LoaiKhachHangDAL getInstance(){
        if(instance==null){
            instance=new LoaiKhachHangDAL();
        }
        
        return instance;
    }
    
    public float getHeSoPhuThu(String customerTypeId){
        String query="select HESOPHUTHU from LOAIKHACHHANG where MALOAIKHACHHANG='" + customerTypeId +"'";
        //  and TRANGTHAI=true
        
        return Float.parseFloat(DataProvider.getInstance().executeQuery(query, new String[]{}).get(0).get("HESOPHUTHU"));
    }
}
