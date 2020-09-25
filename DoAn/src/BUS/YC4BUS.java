/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

/**
 *
 * @author nghia
 */
public class YC4BUS {
    private static YC4BUS instance;

    public static YC4BUS getInstance() {
        if(instance==null){
            instance=new YC4BUS();
        }
        
        return instance;
    }
    
    public float calculateSumMoney(float tienDv, float tienO){
        return tienDv+tienO;
    }
}
