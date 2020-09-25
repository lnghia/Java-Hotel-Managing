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
public class CTPhieuThueDTO {
    private String maPTP;
    private String hoTen;
    private String maLoaiKH;
    private String cmnd;
    private String diaChi;

    public CTPhieuThueDTO(String maPTP, String hoTen, String maLoaiKH, String cmnd, String diaChi) {
        this.maPTP = maPTP;
        this.hoTen = hoTen;
        this.maLoaiKH = maLoaiKH;
        this.cmnd = cmnd;
        this.diaChi = diaChi;
    }

    public CTPhieuThueDTO(String hoTen, String maLoaiKH, String cmnd, String diaChi) {
        this.hoTen = hoTen;
        this.maLoaiKH = maLoaiKH;
        this.cmnd = cmnd;
        this.diaChi = diaChi;
    }

    public String getMaPTP() {
        return maPTP;
    }

    public void setMaPTP(String maPTP) {
        this.maPTP = maPTP;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMaLoaiKH() {
        return maLoaiKH;
    }

    public void setMaLoaiKH(String maLoaiKH) {
        this.maLoaiKH = maLoaiKH;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public static CTPhieuThueDTO parse(HashMap<String, String> inp){
        if(inp==null){
            return null;
        }
        
        return new CTPhieuThueDTO(inp.get("MAPTP"),
                                  inp.get("HoTen"),
                                  inp.get("MaLoaiKhachHang"),
                                  inp.get("CMND"),
                                  inp.get("DiaChi"));
    }
}
