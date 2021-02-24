/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Huy Trường
 */
public class NhanVien implements Serializable {
    
    public static int id = 1000;
    private int ma;
    private String ten;
    private String diaChi;
    private String sdt;
    private int bac;

    public static String checkFormat(String ten ,String diaChi, String sdt , String bac){
        String message = "";
        if (ten.isEmpty())
            message = "Tên không được để trống";
        if (ten.matches("[^a-zA-z]+"))
            message = "Tên không hợp lệ";
        if (diaChi.isEmpty())
            message = "Dia chi không được để trống";
        if (sdt.isEmpty())
            message = "Sdt không được để trống";
        if (sdt.matches("[^0-9]+"))
            message = "Sdt không hợp lệ";
        if (bac.matches("[^1-9]+"))
            message = "Bậc không hợp lệ";
        else 
            if (Integer.parseInt(bac)<=0 || Integer.parseInt(bac)>9)
                message = "Bậc phải > 0 và < 10";
        return message;
    }
    
    public NhanVien(String ten, String sdt,String diaChi, int bac) {
        this.ma = id;
        id++;
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.bac = bac;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        NhanVien.id = id;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }
    
}
