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
public class LoaiPhongDTO {
    private String maLoaiPhong;
    private float donGia;

    public LoaiPhongDTO(String maLoaiPhong, float donGia) {
        this.maLoaiPhong = maLoaiPhong;
        this.donGia = donGia;
    }

    public LoaiPhongDTO(float donGia) {
        this.donGia = donGia;
    }

    public String getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }
    
    public static LoaiPhongDTO parse(HashMap<String, String> inp){
        if(inp==null){
            return null;
        }
        
        return new LoaiPhongDTO(inp.get("MALOAIPHONG"), Float.parseFloat(inp.get("DONGIA")));
    }
}
