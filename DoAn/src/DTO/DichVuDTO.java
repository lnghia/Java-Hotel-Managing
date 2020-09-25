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
public class DichVuDTO {
    private String maDV;
    private String tenDV;

    public DichVuDTO(String maDV, String tenDV) {
        this.maDV = maDV;
        this.tenDV = tenDV;
    }

    public DichVuDTO(String tenDV) {
        this.tenDV = tenDV;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }
    
    public static DichVuDTO parse(HashMap<String, String> inp){
        if(inp==null || inp.isEmpty()){
            return null;
        }
        
        return new DichVuDTO(inp.get("MADICHVU"), inp.get("TENDICHVU"));
    }
}
