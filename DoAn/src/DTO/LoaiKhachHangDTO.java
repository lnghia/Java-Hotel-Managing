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
public class LoaiKhachHangDTO {
    private String maLoaiKhachHang;
    private String tenLoaiKh;
    private float hesoPhuThu;

    public LoaiKhachHangDTO(String maLoaiKhachHang, String tenLoaiKh, float hesoPhuThu) {
        this.maLoaiKhachHang = maLoaiKhachHang;
        this.tenLoaiKh = tenLoaiKh;
        this.hesoPhuThu = hesoPhuThu;
    }

    public LoaiKhachHangDTO(String tenLoaiKh, float hesoPhuThu) {
        this.tenLoaiKh = tenLoaiKh;
        this.hesoPhuThu = hesoPhuThu;
    }

    public String getMaLoaiKhachHang() {
        return maLoaiKhachHang;
    }

    public void setMaLoaiKhachHang(String maLoaiKhachHang) {
        this.maLoaiKhachHang = maLoaiKhachHang;
    }

    public String getTenLoaiKh() {
        return tenLoaiKh;
    }

    public void setTenLoaiKh(String tenLoaiKh) {
        this.tenLoaiKh = tenLoaiKh;
    }

    public float getHesoPhuThu() {
        return hesoPhuThu;
    }

    public void setHesoPhuThu(float hesoPhuThu) {
        this.hesoPhuThu = hesoPhuThu;
    }
    
    public static LoaiKhachHangDTO parse(HashMap<String, String> inp){
        if (inp==null || inp.isEmpty()){
            return null;
        }
        
        return new LoaiKhachHangDTO(inp.get("MALOAIKHACHHANG"), inp.get("TENLOAIKHACHHANG"), Float.parseFloat(inp.get("HESOPHUTHU")));
    }
}
