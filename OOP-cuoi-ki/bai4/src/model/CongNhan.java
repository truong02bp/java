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
public class CongNhan implements Serializable {
    public static int id = 10000;
    private int ma;
    private String ten;
    private String diaChi;
    private String ca;

    public CongNhan(String ten, String diaChi, String ca) {
        this.ma = id;
        id++;
        this.ten = ten;
        this.diaChi = diaChi;
        this.ca = ca;
    }
    public static String check(String ten , String diaChi , String ca){
        String message = "";
        if  (ten.isEmpty())
            message = "Ten khong duoc trong";
        if  (diaChi.isEmpty())
            message = "Dia chi khong duoc trong";
        return message;
    }
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        CongNhan.id = id;
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

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }
    
    
    
    
}
