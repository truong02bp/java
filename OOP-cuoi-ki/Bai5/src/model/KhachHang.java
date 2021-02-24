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
public class KhachHang implements Serializable {
    public static int id = 10000;
    private int ma;
    private String ten;
    private String diaChi;
    private String nhom;

    public KhachHang(String ten, String diaChi, String nhom) {
        this.ma = id;
        id++;
        this.ten = ten;
        this.diaChi = diaChi;
        this.nhom = nhom;
    }
    public static String check(String ten , String diaChi){
        String message = "";
        if (ten.isEmpty())
            message = "Ten khong duoc trong";
        if (diaChi.isEmpty())
            message = "Dia chi khong duoc trong";
        return message;
    }
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        KhachHang.id = id;
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

    public String getNhom() {
        return nhom;
    }

    public void setNhom(String nhom) {
        this.nhom = nhom;
    }
    
    
    
}
