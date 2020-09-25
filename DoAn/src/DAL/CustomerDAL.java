/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.CustomerDTO;

/**
 *
 * @author nghia
 */
public class CustomerDAL {
    private static CustomerDAL instance;
    
    public static CustomerDAL getInstance(){
        if(instance==null){
            instance=new CustomerDAL();
        }
        
        return instance;
    }
    
    public CustomerDTO getCustomerInfo(String id){
        String query="select * from KHACHHANG where MAKHACHHANG='"+id+"'";
        
        return CustomerDTO.parse(DataProvider.getInstance().executeQuery(query, new String[]{}).get(0));
    }
}
