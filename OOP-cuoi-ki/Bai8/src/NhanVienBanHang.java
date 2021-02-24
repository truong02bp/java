
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
public class NhanVienBanHang implements Serializable {
    private int ma;
    private String ten;
    private String diaChi;
    private String sdt;
    private static int id = 1000;

    public NhanVienBanHang(String ten, String diaChi, String sdt) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.ma = id;
        id++;
    }

    
    
    public static String check(String ten, String diaChi , String sdt){
        String message = "";
        if (ten.isEmpty())
            message = "Ten khong duoc de trong";
        if (diaChi.isEmpty())
            message = "Dia chi khong duoc de trong";
        
        if (sdt.isEmpty())
            message = "So dien thoai khong duoc de trong";
        else 
            if (sdt.matches(".*[^0-9].*"))
                message = "So dien thoai khong hop le";
        return message;
    }
    
    public static void setId(int id) {
        NhanVienBanHang.id = id;
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSdt() {
        return sdt;
    }
    
    
    
}
