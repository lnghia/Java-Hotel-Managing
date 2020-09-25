/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.CTHoaDonDTO;
import java.util.HashMap;

/**
 *
 * @author nghia
 */
public class CTHoaDonDAL {
    private static CTHoaDonDAL instance;
    
    public static CTHoaDonDAL getInstance(){
        if(instance==null){
            instance=new CTHoaDonDAL();
        }
        
        return instance;
    }
    
    public String getMaPhong(String soHD){
        String query="select MAPHONG from CT_HOADON where SOHD = '?' ";
        
        HashMap<String, String> ans = DataProvider.getInstance().executeQuery(query, new String[]{soHD}).stream().findFirst().orElse(null);
        
        return (ans==null)?"":ans.get("MAPHONG");
    }
    
    public int themCTHD(CTHoaDonDTO ctHd){
        StringBuilder sb=new StringBuilder("");
        
        sb.append("insert into CT_HOADON (MAPHONG, SOHD, SOLUONGTHUE, GIATIEN, TONGTIENTHUEPHONG, TONGTIENDICHVU, THANHTIEN, TRANGTHAI) values('");
        sb.append(ctHd.getMaPh());
        sb.append("', '");
        sb.append(ctHd.getSoHd());
        sb.append("', '");
        sb.append(Integer.toString(ctHd.getSoluongThue()));
        sb.append("', '");
        sb.append(Float.toString(ctHd.getGiaTien()));
        sb.append("', '");
        sb.append(Float.toString(ctHd.getTongTienPh()));
        sb.append("', '");
        sb.append(Float.toString(ctHd.getTongTienDv()));
        sb.append("', '");
        sb.append(Float.toString(ctHd.getThanhTien()));
        sb.append("', 'true')");
        
        return DataProvider.getInstance().executeNonQuery(sb.toString(), new String[]{});
    }
}
