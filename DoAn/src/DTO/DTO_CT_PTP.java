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
public class DTO_CT_PTP {
    private String MaPTP,HoTen,MaLoaiKhachHang,CMND,DiaChi;
    public String getMaPTP() {
        return MaPTP;
    }

    public void setMaPTP(String MaPTP) {
        this.MaPTP = MaPTP;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getMaLoaiKhachHang() {
        return MaLoaiKhachHang;
    }

    public void setMaLoaiKhachHang(String MaLoaiKhachHang) {
        this.MaLoaiKhachHang = MaLoaiKhachHang;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
    private boolean TrangThai;
   
    public DTO_CT_PTP(String mptp, String ht, String mlkh, String cmnd, String dc, boolean tt)
    {
        this.MaPTP=mptp;
        this.HoTen=ht;
        this.MaLoaiKhachHang=mlkh;
        this.CMND=cmnd;
        this.DiaChi=dc;
        this.TrangThai=tt;
    }
}
