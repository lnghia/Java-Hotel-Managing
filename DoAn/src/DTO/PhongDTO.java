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
public class PhongDTO {
    private String maPhong;
    private String maLoaiPhong;
    private String moTa;
    private String ghiChu;
    private String tinhTrang;

    public PhongDTO(String maLoaiPhong, String moTa, String ghiChu, String tinhTrang) {
        this.maLoaiPhong = maLoaiPhong;
        this.moTa = moTa;
        this.ghiChu = ghiChu;
        this.tinhTrang = tinhTrang;
    }

    public PhongDTO(String maPhong, String maLoaiPhong, String moTa, String ghiChu, String tinhTrang) {
        this.maPhong = maPhong;
        this.maLoaiPhong = maLoaiPhong;
        this.moTa = moTa;
        this.ghiChu = ghiChu;
        this.tinhTrang = tinhTrang;
    }
    
    

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    public static PhongDTO parse(HashMap<String, String> inp){
        if(inp==null || inp.isEmpty()){
            return null;
        }
        
        return new PhongDTO(inp.get("MAPHONG"), inp.get("MALOAIPHONG"), inp.get("MOTA"), inp.get("GHICHU"), inp.get("TINHTRANG"));
    }
}
