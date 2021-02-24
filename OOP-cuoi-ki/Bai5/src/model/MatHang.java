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
public class MatHang implements Serializable {
    public static int id = 10000;
    private int ma;
    private String ten;
    private int gia;

    public MatHang(String ten, int gia) {
        this.ma = id;
        id++;
        this.ten = ten;
        this.gia = gia;
    }

    
    public static String check(String ten , String gia){
        String message = "";
        if (ten.isEmpty())
            message = "Ten khong duoc trong";
        if (gia.isEmpty())
            message = "Gia khong duoc trong";
        else 
            if (gia.matches("[^0-9]+") || !gia.matches("[^a-zA-Z]+"))
                message = "Gia khong hop le";
        return message;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        MatHang.id = id;
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

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
    
    
    
}
