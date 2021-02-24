
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
public class DichVu implements Serializable {
    private int ma;
    private String ten;
    private int gia;
    private String donVi;
    public static int id = 100;

    public DichVu(String ten, int gia, String donVi) {
        this.ten = ten;
        this.gia = gia;
        this.donVi = donVi;
        this.ma = id;
        id++;
    }
    

    public static String check(String ten , String gia , String donVi){
        String message = "";
        if (ten.isEmpty())
            message = "Ten khong duoc de trong";
        if (donVi.isEmpty())
            message = "Dia chi khong duoc de trong";
        if (gia.isEmpty())
            message = "Gia khong duoc de trong";
        else 
            if (gia.matches(".*[^0-9].*"))
                message = "Gia khong hop le";
        return message;
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public int getGia() {
        return gia;
    }

    public String getDonVi() {
        return donVi;
    }
    
}
