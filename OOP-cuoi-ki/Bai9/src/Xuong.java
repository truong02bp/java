
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Huy Trường
 */
public class Xuong implements Serializable {
    private int ma;
    private String ten;
    private String moTa;
    private int heSo;
    private static int id = 100;

    public Xuong(String ten, String moTa, int heSo) {
        this.ten = ten;
        this.moTa = moTa;
        this.heSo = heSo;
        this.ma = id;
        id++;
    }    
    
    public static String check(String ten, String moTa){
        String message = "";
        if (ten.isEmpty())
            message = "Ten khong duoc de trong";
        if (moTa.isEmpty())
            message = "Mo ta khong duoc de trong";
        return message;
    }

    public static void setId(int id) {
        Xuong.id = id;
    }
    
    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public int getHeSo() {
        return heSo;
    }
    
    
    
    
}
