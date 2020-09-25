/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BUS.HoaDonBUS;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author nghia
 */
public class YC4DAL {
    private static YC4DAL instance;

    public static YC4DAL getInstance() {
        if(instance==null){
            instance=new YC4DAL();
        }
        
        return instance;
    }
    
    public Float getTienO(String roomId){
        String query="select DONGIATHUE from PHIEUTHUEPHONG where MAPHONG='"+roomId+"' and TINHTRANG='0' or TINHTRANG='false'";
        
        ArrayList<HashMap<String, String>> tmp=DataProvider.getInstance().executeQuery(query, new String[]{});
        float temp=Float.parseFloat(DataProvider.getInstance().executeQuery(query, new String[]{}).get(0).get("DONGIATHUE"));
        
        return temp;
    }
    
    public int themHoaDon(String tenKh, String diaChi, String tongTien, String loaiPh){
        DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
        String soHd=HoaDonBUS.getInstance().generateInvoiceNum();
        String query="insert into HOADON (NGAYLAP, KHACHHANG, DIACHI, TONGTIEN, TRANGTHAI, SOHD, LOAIPHONG) values ('" + java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) + "', '"+
                tenKh + "', '" + diaChi + "', '" + tongTien + "', 'true','" + soHd +"', '" + loaiPh +"')";
        
        int temp=DataProvider.getInstance().executeNonQuery(query, new String[]{});
        
        return temp>0?Integer.parseInt(soHd):-1;
    }
    
    public int themCTHD(String maPh, String soHd, String soluongthue, String giatien, String tienPh, String tienDv, String thanhTien){
        String query="insert into CT_HOADON (MAPHONG, SOHD, SOLUONGTHUE, GIATIEN, TONGTIENTHUEPHONG, TONGTIENDICHVU, THANHTIEN, TRANGTHAI) values "+
                "('"+maPh+"', '"+soHd+"', '"+soluongthue+"', '"+giatien+"', '"+tienPh+"', '"+tienDv+"', '"+thanhTien+"', 'true')";
        
        return DataProvider.getInstance().executeNonQuery(query, new String[]{});
    }
    
    public String getSoKh(String maPh){
        String query="select SOKHACH from PHIEUTHUEPHONG where MAPHONG='" + maPh + "' and TINHTRANG='0' or TINHTRANG='false'";
        
        return DataProvider.getInstance().executeQuery(query, new String[]{}).get(0).get("SOKHACH");
    }
    
    public void updateTrangThaiPhong(String roomId){
        String query="update PHONG set TINHTRANG= 'Trống' where MAPHONG='"+roomId+"'";
        
        DataProvider.getInstance().executeNonQuery(query, new String[]{});
    }
    
    public void updateTrangThaiPhieuThue(String roomId){
        String query="update PHIEUTHUEPHONG set TINHTRANG='1' where MAPHONG='"+roomId+"' and TINHTRANG='0' or TINHTRANG='false'";
        
        DataProvider.getInstance().executeNonQuery(query, new String[]{});
    }
    
    public int updateHoaDon(String tenKh, String sdt, String diaChi, String soHd){
        String query="update HOADON set KHACHHANG='"+tenKh+"', DIACHI='"+diaChi+"' where SOHD='"+soHd+"'";
        
        return DataProvider.getInstance().executeNonQuery(query, new String[]{});
    }
    
    public int xoaHd(String soHd){
        String query="delete from HOADON where SOHD='"+soHd+"'";
        
        return DataProvider.getInstance().executeNonQuery(query, new String[]{});
    }
    
    public boolean isBaoCaoAvailable(String thang, String nam){
        String query="select MABCDT from BAOCAODOANHTHU where THANG='"+thang+"' and NAM='"+nam+"' and (TRANGTHAI='1' or TRANGTHAI='true')";
        
        return !DataProvider.getInstance().executeQuery(query, new String[]{}).isEmpty();
    }
    
    public int themBaoCao(String thang, String nam){
        if(isBaoCaoAvailable(thang, nam)){
            return 0;
        }
        
        String query="insert into BAOCAODOANHTHU (MABCDT, THANG, NAM, TONGDOANHTHU, TRANGTHAI) values ('"+thang+nam+"', '"+thang+"', '"+nam+"', 0, 'true')";
        
        return DataProvider.getInstance().executeNonQuery(query, new String[]{});
    }
    
    public float getDoanhThuByLoaiPh(String thang, String nam, String loaiPh){
        String query="select DOANHTHU from CT_BCDT where MABCDT='"+thang+nam+"' and MALOAIPHONG='"+loaiPh+"'";
        
        HashMap<String, String> tmp=DataProvider.getInstance().executeQuery(query, new String[]{}).stream().findFirst().orElse(null);
        
        return (tmp==null)?-1:Float.parseFloat(tmp.get("DOANHTHU"));
    }
    
    public int themCTBC(String thang, String nam, String loaiPh, String tien){
        float tmp=getDoanhThuByLoaiPh(thang, nam, loaiPh);
        String query="";
        
        if(tmp==-1f){
            query="insert into CT_BCDT (MABCDT, MALOAIPHONG, DOANHTHU, TYLE, TRANGTHAI) values ('"+thang+nam+"', '"+loaiPh+"', "+tien+", 0, 'true')";
        }
        else{
            Float newDt=tmp+Float.parseFloat(tien);
            query="update CT_BCDT set DOANHTHU="+Float.toString(newDt)+" where MABCDT='"+thang+nam+"' and MALOAIPHONG='"+loaiPh+"'";
        }
        
        return DataProvider.getInstance().executeNonQuery(query, new String[]{});
    }
}
