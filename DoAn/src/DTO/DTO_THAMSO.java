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
public class DTO_THAMSO {

    public String getTENTHAMSO() {
        return _TENTHAMSO;
    }

    public void setTENTHAMSO(String _TENTHAMSO) {
        this._TENTHAMSO = _TENTHAMSO;
    }

    public float getGIATRI() {
        return _GIATRI;
    }

    public void setGIATRI(float _GIATRI) {
        this._GIATRI = _GIATRI;
    }

    public DTO_THAMSO() {
        this._TENTHAMSO = "";
        this._GIATRI = 0;
    }
    private String _TENTHAMSO;
    private float _GIATRI;
    
    
}
