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
public class DTO_LoaiPhong {
    private String MaLoaiPhong;
    private float DonGia;
    private boolean TrangThai;

    public String getMaLoaiPhong() {
        return MaLoaiPhong;
    }

    public void setMaLoaiPhong(String MaLoaiPhong) {
        this.MaLoaiPhong = MaLoaiPhong;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
    public DTO_LoaiPhong(String mlp, float dg, boolean tt)
    {
        this.MaLoaiPhong=mlp;
        this.DonGia=dg;
        this.TrangThai=tt;
    }
}
