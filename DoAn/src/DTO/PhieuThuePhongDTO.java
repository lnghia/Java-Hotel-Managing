/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nghia
 */
public class PhieuThuePhongDTO {
    private String maPTP;
    private String maPhong;
    private String maKH;
    private String maHTThue;
    private Time gioBDThue;
    private String ngayBDThue;
    private int soKhach;
    private float donGiaThue;
    private float donGiaTieuChuan;

    public PhieuThuePhongDTO() {
    }

    public PhieuThuePhongDTO(String maPTP, String maPhong, String maKH, String maHTThue, Time gioBDThue, String ngayBDThue, int soKhach, float donGiaThue, float donGiaTieuChuan) {
        this.maPTP = maPTP;
        this.maPhong = maPhong;
        this.maKH = maKH;
        this.maHTThue = maHTThue;
        this.gioBDThue = gioBDThue;
        this.ngayBDThue = ngayBDThue;
        this.soKhach = soKhach;
        this.donGiaThue = donGiaThue;
        this.donGiaTieuChuan = donGiaTieuChuan;
    }

    public String getMaPTP() {
        return maPTP;
    }

    public void setMaPTP(String maPTP) {
        this.maPTP = maPTP;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaHTThue() {
        return maHTThue;
    }

    public void setMaHTThue(String maHTThue) {
        this.maHTThue = maHTThue;
    }

    public Time getGioBDThue() {
        return gioBDThue;
    }

    public void setGioBDThue(Time gioBDThue) {
        this.gioBDThue = gioBDThue;
    }

    public String getNgayBDThue() {
        return ngayBDThue;
    }

    public void setNgayBDThue(String ngayBDThue) {
        this.ngayBDThue = ngayBDThue;
    }

    public int getSoKhach() {
        return soKhach;
    }

    public void setSoKhach(int soKhach) {
        this.soKhach = soKhach;
    }

    public float getDonGiaThue() {
        return donGiaThue;
    }

    public void setDonGiaThue(float donGiaThue) {
        this.donGiaThue = donGiaThue;
    }

    public float getDonGiaTieuChuan() {
        return donGiaTieuChuan;
    }

    public void setDonGiaTieuChuan(float donGiaTieuChuan) {
        this.donGiaTieuChuan = donGiaTieuChuan;
    }
    
    public static PhieuThuePhongDTO parse(HashMap<String, String> data){
        if(data==null){
            return null;
        }
        
        try {
            DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
            DateFormat tf=new SimpleDateFormat("hh:mm");
            
            return new PhieuThuePhongDTO(data.get("MAPTP"),
                    data.get("MAPHONG"),
                    data.get("MAKHACHHANG"),
                    data.get("MAHINHTHUCTHUE"), 
                    new Time(tf.parse(data.get("GIOBATDAUTHUE")).getTime()),
                    data.get("NGAYBATDAUTHUE"),
                    Integer.parseInt(data.get("SOKHACH")),
                    Float.parseFloat(data.get("DONGIATHUE")),
                    Float.parseFloat(data.get("DONGIATIEUCHUAN")));
        } catch (ParseException ex) {
            Logger.getLogger(PhieuThuePhongDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
