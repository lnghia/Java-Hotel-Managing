/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.HashMap;

/**
 *
 * @author nghia
 */
public class CTHoaDonDTO {
    private String maPh;
    private String soHd;
    private int soluongThue;
    private float giaTien;
    private float tongTienPh;
    private float tongTienDv;
    private float thanhTien;

    public CTHoaDonDTO(String maPh, String soHd, int soluongThue, float giaTien, float tongTienPh, float tongTienDv, float thanhTien) {
        this.maPh = maPh;
        this.soHd = soHd;
        this.soluongThue = soluongThue;
        this.giaTien = giaTien;
        this.tongTienPh = tongTienPh;
        this.tongTienDv = tongTienDv;
        this.thanhTien = thanhTien;
    }

    public String getMaPh() {
        return maPh;
    }

    public void setMaPh(String maPh) {
        this.maPh = maPh;
    }

    public String getSoHd() {
        return soHd;
    }

    public void setSoHd(String soHd) {
        this.soHd = soHd;
    }

    public int getSoluongThue() {
        return soluongThue;
    }

    public void setSoluongThue(int soluongThue) {
        this.soluongThue = soluongThue;
    }

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    public float getTongTienPh() {
        return tongTienPh;
    }

    public void setTongTienPh(float tongTienPh) {
        this.tongTienPh = tongTienPh;
    }

    public float getTongTienDv() {
        return tongTienDv;
    }

    public void setTongTienDv(float tongTienDv) {
        this.tongTienDv = tongTienDv;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    public static CTHoaDonDTO parse(HashMap<String, String> inp){
        if(inp==null || inp.isEmpty()){
            return null;
        }
        
        return new CTHoaDonDTO(inp.get("MAPHONG"), 
                inp.get("SOHD"), 
                Integer.parseInt(inp.get("SOLUONGTHUE")), 
                Float.parseFloat(inp.get("GIATIEN")), 
                Float.parseFloat(inp.get("TONGTIENTHUEPHONG")), 
                Float.parseFloat(inp.get("TONGTIENDICHVU")), 
                Float.parseFloat(inp.get("THANHTIEN")));
    }
}
