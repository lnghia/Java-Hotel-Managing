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
public class TiLePhuThuDTO {
    private int khachThu;
    private float tiLePhuThu;

    public TiLePhuThuDTO(int khachThu, float tiLePhuThu) {
        this.khachThu = khachThu;
        this.tiLePhuThu = tiLePhuThu;
    }

    public TiLePhuThuDTO(float tiLePhuThu) {
        this.tiLePhuThu = tiLePhuThu;
    }

    public int getKhachThu() {
        return khachThu;
    }

    public void setKhachThu(int khachThu) {
        this.khachThu = khachThu;
    }

    public float getTiLePhuThu() {
        return tiLePhuThu;
    }

    public void setTiLePhuThu(float tiLePhuThu) {
        this.tiLePhuThu = tiLePhuThu;
    }
    
    public static TiLePhuThuDTO parse(HashMap<String, String> inp){
        if(inp==null || inp.isEmpty()){
            return null;
        }
        
        return new TiLePhuThuDTO(Integer.parseInt(inp.get("KHACHTHU")), Float.parseFloat(inp.get("TILEPHUTHU")));
    }
}
