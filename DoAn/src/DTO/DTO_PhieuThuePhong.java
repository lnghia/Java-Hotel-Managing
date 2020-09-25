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
public class DTO_PhieuThuePhong {
    private String MaPTP, MaPhong, MaHinhThuc, GioBatDauThue, NgayBatDauThue;
    private int SoKhach;
    private float DonGiaThue,DonGiaTieuChuan;
    private boolean TrangThai;    
    private boolean TinhTrang;

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    public DTO_PhieuThuePhong()
    {
        
    }
    public String getMaPTP() {
        return MaPTP;
    }

    public void setMaPTP(String MaPTP) {
        this.MaPTP = MaPTP;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getMaHinhThuc() {
        return MaHinhThuc;
    }

    public void setMaHinhThuc(String MaHinhThuc) {
        this.MaHinhThuc = MaHinhThuc;
    }

    public String getGioBatDauThue() {
        return GioBatDauThue;
    }

    public void setGioBatDauThue(String GioBatDauThue) {
        this.GioBatDauThue = GioBatDauThue;
    }

    public String getNgayBatDauThue() {
        return NgayBatDauThue;
    }

    public void setNgayBatDauThue(String NgayBatDauThue) {
        this.NgayBatDauThue = NgayBatDauThue;
    }

    public int getSoKhach() {
        return SoKhach;
    }

    public void setSoKhach(int SoKhach) {
        this.SoKhach = SoKhach;
    }

    public float getDonGiaThue() {
        return DonGiaThue;
    }

    public void setDonGiaThue(float DonGiaThue) {
        this.DonGiaThue = DonGiaThue;
    }

    public float getDonGiaTieuChuan() {
        return DonGiaTieuChuan;
    }

    public void setDonGiaTieuChuan(float DonGiaTieuChuan) {
        this.DonGiaTieuChuan = DonGiaTieuChuan;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
    

    public DTO_PhieuThuePhong (String mptp, String mp,String mht, String gbdt, String nbdt, int sl, float dgt, float dgtc, boolean tt, boolean  tinhtrang)
    {
        this.MaPTP=mptp;
        this.MaPhong=mp;
        this.MaHinhThuc=mht;
        this.GioBatDauThue=gbdt;
        this.NgayBatDauThue=nbdt;
        this.SoKhach=sl;
        this.DonGiaThue=dgt;
        this.DonGiaTieuChuan=dgtc;
        this.TrangThai=tt;
        this.TinhTrang=tinhtrang;
    }
}
