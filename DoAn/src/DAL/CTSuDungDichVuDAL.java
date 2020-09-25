/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.CTSuDungDichVuDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author nghia
 */
public class CTSuDungDichVuDAL {
    private static CTSuDungDichVuDAL instance;
    
    public static CTSuDungDichVuDAL getInstance(){
        if(instance==null){
            instance=new CTSuDungDichVuDAL();
        }
        
        return instance;
    }
    
    public ArrayList<CTSuDungDichVuDTO> getCTSuDungDVByPhong(String maPhong, String ngayBD){
        try {
            String query="select * from CT_SUDUNGDICHVU where MAPHONG = '" + maPhong + "'";
            //and TRANGTHAI=true
            Date startDate=new SimpleDateFormat("dd/MM/yyyy").parse(ngayBD);
            
            ArrayList<HashMap<String, String>> tmp=DataProvider.getInstance().executeQuery(query, new String[]{});
            
            ArrayList<CTSuDungDichVuDTO> ans=new ArrayList<>();
            
            for(HashMap<String, String> row : tmp){
                if(new SimpleDateFormat("dd/MM/yyyy").parse(row.get("NGAYGIOSUDUNG")).after(startDate)){
                    ans.add(CTSuDungDichVuDTO.parse(row));
                }
            }
            
            return ans;
        } catch (ParseException ex) {
            Logger.getLogger(CTSuDungDichVuDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
    
    public ArrayList<CTSuDungDichVuDTO> getCTSDDV(){
        String query="select * from CT_SUDUNGDICHVU where TRANGTHAI='true'";
        
        ArrayList<CTSuDungDichVuDTO> ans=new ArrayList<>();
        
        ArrayList<HashMap<String, String>> tmp=DataProvider.getInstance().executeQuery(query, new String[]{});
        
        for(HashMap<String, String> row : tmp){
            ans.add(CTSuDungDichVuDTO.parse(row));
        }
        
        return ans;
    }
    
    public int themCTSDDV(CTSuDungDichVuDTO dv){
        String query="insert into CT_SUDUNGDICHVU (MAPHONG, MADICHVU, NGAYGIOSUDUNG, SOLUONG, DONGIA, THANHTIEN, TRANGTHAI, KHACHHANGSUDUNG) values " +
                "('" + dv.getMaPhong() + "', '" + dv.getMaDichVu() + "', '" + dv.getNgayGioSD() + "', " + Integer.toString(dv.getSoLuong()) + ", " + dv.getDonGia() + ", " +
                dv.getThanhTien() + ", 'true', '" + dv.getKhachHangSD()+"');";
        
        return DataProvider.getInstance().executeNonQuery(query, new String[]{});
    }
    
//    public int suaCTSDDV(CTSuDungDichVuDTO dv){
//        String query="update CT_SUDUNGDICHVU set MAPHONG='"+dv.getMaPhong()+"', MADICHVU='"+dv.getMaDichVu()+"', NGAYGIOSUDUNG='"+dv.getNgayGioSD()+"', SOLUONG="+
//                Integer.toString(dv.getSoLuong()) + ", DONGIA=" + Float.toString(dv.getDonGia()) +", THANHTIEN="+Float.toString(dv.getThanhTien())
//    }
    
    public int xoaCTSDDV(String roomId, String customerId, String orderDate, String serviceId){
        String query="delete from CT_SUDUNGDICHVU where MAPHONG='"+roomId+"' and NGAYGIOSUDUNG='"+orderDate+"' and MADICHVU='"+serviceId+"'";
        //set TRANGTHAI='false' 
        
        return DataProvider.getInstance().executeNonQuery(query, new String[]{});
    }
}
