/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import  DAL.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Huyen
 */
public class BUS_YC7 {
    DAL_YC7 dal = new DAL_YC7();
    public DefaultTableModel ThongKeTheoTinh()
    {
        return dal.ThongKeTheoTinh();
    }
    public DefaultTableModel ThongKeTheoThang()
    {
        return dal.ThongKeTheoThang();
    }

}
