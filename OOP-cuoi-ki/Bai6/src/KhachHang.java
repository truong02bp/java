
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
public class KhachHang implements Serializable {
    private int ma;
    private String ten;
    private String diaChi;
    private String loai;
    public static int id = 10000;
    public KhachHang(String ten, String diaChi, String loai) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.loai = loai;
        this.ma = id;
        id++;
    }

    public static String check(String ten , String diaChi){
        String message = "";
        if (ten.isEmpty())
            message = "Ten khong duoc de trong";
        if (diaChi.isEmpty())
            message = "Dia chi khong duoc de trong";
        return message;
    }
    
    
    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
    
    
}
