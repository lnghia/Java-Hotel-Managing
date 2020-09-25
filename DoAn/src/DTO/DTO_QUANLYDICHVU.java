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
public class DTO_QUANLYDICHVU {

    public DTO_QUANLYDICHVU() {
        this._MASANPHAM = "";
        this._TENSANPHAM = "";
        this._MADICHVU = "";
        this._SOLUONGBANDAU = 0;
        this._SOLUONGTRONGKHO = 0;
        this._DONGIA = 0;
        this._GHICHU = "";
    }

    public String getMASANPHAM() {
        return _MASANPHAM;
    }

    public void setMASANPHAM(String _MASANPHAM) {
        this._MASANPHAM = _MASANPHAM;
    }

    public String getTENSANPHAM() {
        return _TENSANPHAM;
    }

    public void setTENSANPHAM(String _TENSANPHAM) {
        this._TENSANPHAM = _TENSANPHAM;
    }

    public String getMADICHVU() {
        return _MADICHVU;
    }

    public void setMADICHVU(String _MADICHVU) {
        this._MADICHVU = _MADICHVU;
    }

    public int getSOLUONGBANDAU() {
        return _SOLUONGBANDAU;
    }

    public void setSOLUONGBANDAU(int _SOLUONGBANDAU) {
        this._SOLUONGBANDAU = _SOLUONGBANDAU;
    }

    public int getSOLUONGTRONGKHO() {
        return _SOLUONGTRONGKHO;
    }

    public void setSOLUONGTRONGKHO(int _SOLUONGTRONGKHO) {
        this._SOLUONGTRONGKHO = _SOLUONGTRONGKHO;
    }

    public float getDONGIA() {
        return _DONGIA;
    }

    public void setDONGIA(float _DONGIA) {
        this._DONGIA = _DONGIA;
    }

    public String getGHICHU() {
        return _GHICHU;
    }

    public void setGHICHU(String _GHICHU) {
        this._GHICHU = _GHICHU;
    }
    private String _MASANPHAM;
    private String _TENSANPHAM;
    private String _MADICHVU;
    private int _SOLUONGBANDAU;
    private int _SOLUONGTRONGKHO;
    private float _DONGIA;
    private String _GHICHU;
}
