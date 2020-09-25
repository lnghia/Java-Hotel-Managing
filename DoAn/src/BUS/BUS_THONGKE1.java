/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAl.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author SpingGr4ss
 */
public class BUS_THONGKE1 {

    DAL_THONGKE1 dal = new DAL_THONGKE1();

    
     public DefaultTableModel ThongKeTheoTinh(String bd, String kt)
    {
        try
        {
            return dal.ThongKeTheoTinh(bd, kt);
        }
        catch (Exception e)
                {
                }
        return null;
    }
    public DefaultTableModel ThongKeTheoThang(String bd, String kt)
    {
        try
        {
            return dal.ThongKeTheoThang(bd, kt);
        }
        catch (Exception e)
                {
                }
        return null;
    }
    
}
