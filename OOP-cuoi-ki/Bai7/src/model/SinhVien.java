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
public class SinhVien implements Serializable {
    private int ma;
    private String ten;
    private String diaChi;
    private String ngaySinh;
    private String lop;
    public static int id = 10000;

    public SinhVien(String ten,String diaChi, String ngaySinh, String lop) {
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
        this.diaChi = diaChi;
        this.ma = id;
        id++;
    }
    
    public static String check(String ten , String diaChi, String ngaySinh ){
        String message = "";
        if (ten.isEmpty())
            message = "Ten khong duoc de trong";
        if (diaChi.isEmpty())
            message = "Dia chi khong duoc de trong";
        if (ngaySinh.isEmpty())
            message = "Ngay sinh khong duoc de trong";
        return message;
    }

    public String getDiaChi() {
        return diaChi;
    }
    
    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getLop() {
        return lop;
    }
    
}
