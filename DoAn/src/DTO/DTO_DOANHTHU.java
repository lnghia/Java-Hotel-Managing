/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author SpingGr4ss
 */
public class DTO_DOANHTHU {

    public String getLOAIPHONG() {
        return _LOAIPHONG;
    }

    public void setLOAIPHONG(String _LOAIPHONG) {
        this._LOAIPHONG = _LOAIPHONG;
    }

    public float getDOANHTHU() {
        return _DOANHTHU;
    }

    public void setDOANHTHU(float _DOANHTHU) {
        this._DOANHTHU = _DOANHTHU;
    }

    public float getTYLE() {
        return _TYLE;
    }

    public void setTYLE(float _TYLE) {
        this._TYLE = _TYLE;
    }

    public DTO_DOANHTHU() {
        this._LOAIPHONG = "";
        this._DOANHTHU = 0;
        this._TYLE = 0;
    }
    private String _LOAIPHONG;
    private float _DOANHTHU;
    private float _TYLE;
    
}
