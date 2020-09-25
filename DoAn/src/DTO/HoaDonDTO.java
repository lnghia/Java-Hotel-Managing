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
public class HoaDonDTO {
    private String soHd;
    private String ngayLap;
    private String maKH;
    private String diaChi;
    private double tongTien;
    
    public HoaDonDTO(){}
    
    public HoaDonDTO(String soHd, String ngayLap, String maKH, String diaChi, double tongTien) {
        this.soHd = soHd;
        this.ngayLap = ngayLap;
        this.maKH = maKH;
        this.diaChi = diaChi;
        this.tongTien = tongTien;
    }

    public String getSoHd() {
        return soHd;
    }

    public void setSoHd(String soHd) {
        this.soHd = soHd;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
    public static HoaDonDTO parse(HashMap<String, String> map){
        if(map==null){
            return null;
        }
        
        return new HoaDonDTO(map.get("SOHD"), 
                             map.get("NGAYLAP"), 
                             map.get("KHACHHANG"), 
                             map.get("DIACHI"), 
                             Double.parseDouble(map.get("TONGTIEN")));
    }
}
