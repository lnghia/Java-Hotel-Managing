/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAL.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Huyen
 */
public class BUS_YC1 {
    DAL_YC1 dal= new DAL_YC1();
    public DefaultTableModel getDaTa()
    {
        return dal.getData();
    }
}
