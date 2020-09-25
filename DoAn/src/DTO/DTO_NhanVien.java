/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Huyen
 */
public class DTO_NhanVien {
    private String MaNhanVien, HoTen, NgaySinh, NgayKiHopDong, SoHopDong, MaBacLuong, MaChucVu, MaPhongBan,  SDT;
    
    private boolean TrangThai;

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getNgayKiHopDong() {
        return NgayKiHopDong;
    }

    public void setNgayKiHopDong(String NgayKiHopDong) {
        this.NgayKiHopDong = NgayKiHopDong;
    }

    public String getSoHopDong() {
        return SoHopDong;
    }

    public void setSoHopDong(String SoHopDong) {
        this.SoHopDong = SoHopDong;
    }

    public String getMaBacLuong() {
        return MaBacLuong;
    }

    public void setMaBacLuong(String MaBacLuong) {
        this.MaBacLuong = MaBacLuong;
    }

    public String getMaPhongBan() {
        return MaPhongBan;
    }

    public void setMaPhongBan(String MaPhongBan) {
        this.MaPhongBan = MaPhongBan;
    }

    public String getMaChucVu() {
        return MaChucVu;
    }

    public void setMaChucVu(String MaChucVu) {
        this.MaChucVu = MaChucVu;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public DTO_NhanVien(String manv, String hoten, String ngaysinh, String ngaykihd, String sohd,String mabacluong, String macv, String mapb, boolean  tt,String SDT) 
    {
        this.MaNhanVien=manv;
        this.HoTen=hoten;
        this.NgaySinh=ngaysinh;
        this.NgayKiHopDong=ngaykihd;
        this.SoHopDong=sohd;
        this.MaBacLuong=mabacluong;
        this.MaChucVu=macv;
        this.MaPhongBan=mapb;
        this.TrangThai=tt;
        this.SDT=SDT;
    }
    
}
