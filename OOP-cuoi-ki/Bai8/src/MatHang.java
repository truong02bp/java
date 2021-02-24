
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
public class MatHang implements Serializable {
    private int ma;
    private String ten;
    private String nhom;
    private int giaMua;
    private int giaBan;
    private static int id = 1000;

    public MatHang(String ten, String nhom, int giaMua, int giaBan) {
        this.ten = ten;
        this.nhom = nhom;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        this.ma = id;
        id++;
    }
    
    public static String check(String ten, String giaMua , String giaBan){
        String message = "";
        int kt1=1,kt2=1;
        if (ten.isEmpty())
            message = "Ten khong duoc de trong";
        if (giaMua.isEmpty())
        {
            message = "Gia mua khong duoc de trong";
            kt1=0;
        }
        else 
            if (giaMua.matches(".*[^0-9].*"))
            {
                message = "Gia mua khong hop le";
                kt1=0;
            }
        if (giaBan.isEmpty())
        {
            message = "Gia ban khong duoc de trong";
            kt2=0;
        }
        else 
            if (giaBan.matches(".*[^0-9].*"))
            {
                message = "Gia ban khong hop le";
                kt2=0;
            }
        if (kt1==1 && kt2==1){
            if (Integer.parseInt(giaBan) - Integer.parseInt(giaMua) < 0)
                message = "Gia ban phai lon hon hoac bang gia mua";
        }
        return message;
    }
    
    public static void setId(int id) {
        MatHang.id = id;
    }
    
    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getNhom() {
        return nhom;
    }

    public int getGiaMua() {
        return giaMua;
    }

    public int getGiaBan() {
        return giaBan;
    }
    
}
