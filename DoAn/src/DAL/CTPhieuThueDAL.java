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
public class CTPhieuThueDAL {
    private static CTPhieuThueDAL instance;
    
    public static CTPhieuThueDAL getInstance(){
        if(instance==null){
            instance=new CTPhieuThueDAL();
        }
        
        return instance;
    }
    
    public boolean isCustomerInRoom(String phieuThueId, String hoten){
        String query="select CMND from CT_PHIEUTHUEPHONG where MAPTP='"+phieuThueId+"' and HoTen='"+hoten+"'";
        
        return !DataProvider.getInstance().executeQuery(query, new String[]{}).isEmpty();
    }
    
//    public  getCustomerInfo(String maPTP){
//        String query="select HoTen, MaLoaiKhachHang, CMND, DiaChi from CT_PHIEUTHUEPHONG where MAPTP='?' and TRANGTHAI=true";
//        
//        return DataProvider.getInstance().executeQuery(query, new String[]{maPTP}).get(0).get("MaLoaiKhachHang");
//    }
}
