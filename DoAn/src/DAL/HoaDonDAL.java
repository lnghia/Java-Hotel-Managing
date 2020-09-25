/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.HoaDonDTO;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author nghia
 */
public class HoaDonDAL {
    private static HoaDonDAL instance;
    
    public static HoaDonDAL getInstance(){
        if(instance==null){
            instance=new HoaDonDAL();
        }
        
        return instance;
    }
    
//    public ArrayList<HashMap<String, String>> get
    
    public HoaDonDTO hDById(String soHd){
        String query="select * from HOADON where SOHD like '%' + ? + '%'";
        
        return HoaDonDTO.parse(DataProvider.
                               getInstance().
                               executeQuery(query, new String[]{soHd}).
                               stream().filter((item) -> item.get("SOHD").equals(soHd)).findFirst().orElse(null));
    }
    
    public String getLatestInvoiceNum(){
        String query="select SOHD from HOADON";
        
        ArrayList<HashMap<String, String>> ans=DataProvider.getInstance().executeQuery(query, new String[]{});
        
        int rs=0;
        
        for(HashMap<String, String> row : ans){
            rs=Math.max(rs, Integer.parseInt(row.get("SOHD")));
        }
        
        return Integer.toString(rs);
    }
    
    public int xuatHd(HoaDonDTO Hd){
        StringBuilder sb=new StringBuilder("");
        sb.append("insert into HOADON (SOHD, NGAYLAP, KHACHHANG, DIACHI, TONGTIEN, TRANGTHAI) values ('");
        sb.append(Hd.getSoHd());
        sb.append("', '");
        sb.append(Hd.getNgayLap());
        sb.append("', '");
        sb.append(Hd.getMaKH());
        sb.append("', '");
        sb.append(Hd.getDiaChi());
        sb.append("', '");
        sb.append(Double.toString(Hd.getTongTien()));
        sb.append("', 'true')");
        
        return DataProvider.getInstance().executeNonQuery(sb.toString(), new String[]{});
    }
}
