/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import  DAL.*;
import DTO.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Huyen
 */
public class BUS_TimKH {
    DTO_KhachHang dto;
    DAL_TimKH dal;
    public BUS_TimKH()
    {
        dal = new DAL_TimKH();
    }
    public DefaultTableModel TimKH(String a, String b)
    {
        return dal.TimKiem(a,b);
    }
}
