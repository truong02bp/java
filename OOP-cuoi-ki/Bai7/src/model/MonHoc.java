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
public class MonHoc implements Serializable {
    private int ma;
    private String ten;
    private int tin;
    private String loai;
    public static int id = 100;

    public MonHoc(String ten, int tin, String loai) {
        this.ten = ten;
        this.tin = tin;
        this.loai = loai;
        this.ma = id;
        id++;
    }
    
    public static String check(String ten , String tin){
        String message = "";
        if (ten.isEmpty())
            message = "Ten khong duoc de trong";
        if (tin.isEmpty())
            message = "So don vi sinh khong duoc de trong";
        else 
            if (tin.matches(".*[^0-9].*"))
                message = "So tin chi khong hop le";
        return message;
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public int getTin() {
        return tin;
    }

    public String getLoai() {
        return loai;
    }
    
}
