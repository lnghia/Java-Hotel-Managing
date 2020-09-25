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
public class DTO_DICHVU {

    public String getMADICHVU() {
        return _MADICHVU;
    }

    public void setMADICHVU(String _MADICHVU) {
        this._MADICHVU = _MADICHVU;
    }

    public String getTENDICHVU() {
        return _TENDICHVU;
    }

    public void setTENDICHVU(String _TENDICHVU) {
        this._TENDICHVU = _TENDICHVU;
    }

    public DTO_DICHVU() {
        this._MADICHVU = "";
        this._TENDICHVU = "";
    }
    private String _MADICHVU;
    private String _TENDICHVU;

    
}
