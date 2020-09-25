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
public class CustomerDTO {
    private String maKH;
    private String maLoaiKH;
    private String hoTen;
    private String gioiTinh;
    private String ngaySinh;
    private String cmnd;
    private String diaChi;
    private String sdt;
    private String email;

    public CustomerDTO(String maKH, String maLoaiKH, String hoTen, String gioiTinh, String ngaySinh, String cmnd, String diaChi, String sdt, String email) {
        this.maKH = maKH;
        this.maLoaiKH = maLoaiKH;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.cmnd = cmnd;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
    }

    public CustomerDTO(String maLoaiKH, String hoTen, String gioiTinh, String ngaySinh, String cmnd, String diaChi, String sdt, String email) {
        this.maLoaiKH = maLoaiKH;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.cmnd = cmnd;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaLoaiKH() {
        return maLoaiKH;
    }

    public void setMaLoaiKH(String maLoaiKH) {
        this.maLoaiKH = maLoaiKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public static CustomerDTO parse(HashMap<String, String> inp){
        if(inp==null){
            return null;
        }
        
        return new CustomerDTO(inp.get("MAKHACHHANG"),
                               inp.get("MALOAIKHACHHANG"),
                               inp.get("HOTEN"),
                               inp.get("GIOITINH"),
                               inp.get("NGAYSINH"),
                               inp.get("CMND"),
                               inp.get("DIACHI"),
                               inp.get("SDT"),
                               inp.get("EMAIL"));
    }
}
