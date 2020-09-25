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
public class CTSuDungDichVuDTO {
    private String maPhong;
    private String maDichVu;
    private String khachHangSD;
    private String ngayGioSD;
    private int soLuong;
    private float donGia;
    private float thanhTien;
    
    public CTSuDungDichVuDTO(){}

    public CTSuDungDichVuDTO(String maPhong, String maDichVu, String khachHangSD, String ngayGioSD, int soLuong, float donGia, float thanhTien) {
        this.maPhong = maPhong;
        this.maDichVu = maDichVu;
        this.khachHangSD = khachHangSD;
        this.ngayGioSD = ngayGioSD;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getKhachHangSD() {
        return khachHangSD;
    }

    public void setKhachHangSD(String khachHangSD) {
        this.khachHangSD = khachHangSD;
    }

    public String getNgayGioSD() {
        return ngayGioSD;
    }

    public void setNgayGioSD(String ngayGioSD) {
        this.ngayGioSD = ngayGioSD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    public static CTSuDungDichVuDTO parse(HashMap<String, String> inp){
        if(inp==null){
            return null;
        }
        
        return new CTSuDungDichVuDTO(inp.get("MAPHONG"),
                                     inp.get("MADICHVU"),
                                     inp.get("KHACHHANGSUDUNG"),
                                     inp.get("NGAYGIOSUDUNG"),
                                     Integer.parseInt(inp.get("SOLUONG")),
                                     Float.parseFloat(inp.get("DONGIA")),
                                     Float.parseFloat(inp.get("THANHTIEN")));
    }
}
