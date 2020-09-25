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
public class DTO_QLLOAIPHONG {

    public String getMALOAIPHONG() {
        return _MALOAIPHONG;
    }

    public void setMALOAIPHONG(String _MALOAIPHONG) {
        this._MALOAIPHONG = _MALOAIPHONG;
    }

    public float getDONGIA() {
        return _DONGIA;
    }

    public void setDONGIA(float _DONGIA) {
        this._DONGIA = _DONGIA;
    }

    public int getSOLUONG() {
        return _SOLUONG;
    }

    public void setSOLUONG(int _SOLUONG) {
        this._SOLUONG = _SOLUONG;
    }

    public DTO_QLLOAIPHONG(String _MALOAIPHONG, float _DONGIA, int _SOLUONG) {
        this._MALOAIPHONG = _MALOAIPHONG;
        this._DONGIA = _DONGIA;
        this._SOLUONG = _SOLUONG;
    }
    
    public DTO_QLLOAIPHONG() {
        this._MALOAIPHONG = "";
        this._DONGIA = 0;
        this._SOLUONG = 0;
    }
    
    private String _MALOAIPHONG;
    private float _DONGIA;
    private int _SOLUONG;
    
}
