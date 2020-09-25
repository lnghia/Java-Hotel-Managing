/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import java.util.*;
package DTO;

/**
 *
 * @author Huyen
 */
public class DTO_Phong {
    private String MaPhong;
    private String MaLoaiPhong;
    private String MoTa;
    private String GhiChu;
    private String TinhTrang;
    private boolean TrangThai;

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getMaLoaiPhong() {
        return MaLoaiPhong;
    }

    public void setMaLoaiPhong(String MaLoaiPhong) {
        this.MaLoaiPhong = MaLoaiPhong;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public DTO_Phong(String mp, String mlp, String mt, String gc, String tt, boolean tth)
    {
        this.MaPhong=mp;
        this.MaLoaiPhong=mlp;
        this.MoTa=mt;
        this.GhiChu=gc;
        this.TinhTrang=tt;
        this.TrangThai=tth;
    }
    
    public DTO_Phong()
    {
        this.MaPhong="";
        this.MaLoaiPhong="";
        this.MoTa="";
        this.GhiChu="";
        this.TinhTrang="";
    }
}