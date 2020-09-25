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
public class DTO_LOAIKHACH {

    public String getMALOAIKHACHHANG() {
        return _MALOAIKHACHHANG;
    }

    public void setMALOAIKHACHHANG(String _MALOAIKHACHHANG) {
        this._MALOAIKHACHHANG = _MALOAIKHACHHANG;
    }

    public String getTENLOAIKHACHHANG() {
        return _TENLOAIKHACHHANG;
    }

    public void setTENLOAIKHACHHANG(String _TENLOAIKHACHHANG) {
        this._TENLOAIKHACHHANG = _TENLOAIKHACHHANG;
    }

    public float getHESOPHUTHU() {
        return _HESOPHUTHU;
    }

    public void setHESOPHUTHU(float _HESOPHUTHU) {
        this._HESOPHUTHU = _HESOPHUTHU;
    }

    public DTO_LOAIKHACH() {
        this._MALOAIKHACHHANG = "";
        this._TENLOAIKHACHHANG = "";
        this._HESOPHUTHU = 0;
    }
    private String _MALOAIKHACHHANG;
    private String _TENLOAIKHACHHANG;
    private float _HESOPHUTHU;
    
}
