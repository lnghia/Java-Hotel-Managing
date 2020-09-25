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
public class DTO_KhachHang {
    private String MaKhachHang, MaLoaiKhachHang, HoTen, GioiTinh, NgaySinh, CMND, DiaChi, Email, SDT;

    public DTO_KhachHang() {
    }
    
    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    private boolean TrangThai;
    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getMaLoaiKhachHang() {
        return MaLoaiKhachHang;
    }

    public void setMaLoaiKhachHang(String MaLoaiKhachHang) {
        this.MaLoaiKhachHang = MaLoaiKhachHang;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public DTO_KhachHang(String mkh, String mlkh, String ht, String gt, String ns, String cmnd, String dc,  String sdt, String email,boolean tt)
    {
        this.MaKhachHang=mkh;
        this.MaLoaiKhachHang=mlkh;
        this.HoTen=ht;
        this.GioiTinh=gt;
        this.NgaySinh=ns;
        this.CMND=cmnd;
        this.DiaChi=dc;
        this.Email=email;
        this.SDT = sdt;
        this.TrangThai=tt;        
    }
}
