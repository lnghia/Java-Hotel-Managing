/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.CTSuDungDichVuDAL;
import DTO.CTSuDungDichVuDTO;
import java.util.ArrayList;
import jdk.nashorn.internal.objects.DataPropertyDescriptor;

/**
 *
 * @author nghia
 */
public class CTSuDungDichVuBUS {
    private static CTSuDungDichVuBUS instance;
    
    public static CTSuDungDichVuBUS getInstance(){
        if(instance==null){
            instance=new CTSuDungDichVuBUS();
        }
        
        return instance;
    }
    
    public ArrayList<CTSuDungDichVuDTO> getCTSDDV(){
        return CTSuDungDichVuDAL.getInstance().getCTSDDV();
    }
}
