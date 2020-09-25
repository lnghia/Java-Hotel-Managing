/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import java.util.ArrayList;
import DAL.DAL_LOGIN;
/**
 *
 * @author SpingGr4ss
 */
public class BUS_LOGIN {
    DAL_LOGIN login = new DAL_LOGIN();
    public String XacNhan(String taikhoan, String matkhau)
    {
        return login.XacNhan(taikhoan, matkhau);
    }
    
}
