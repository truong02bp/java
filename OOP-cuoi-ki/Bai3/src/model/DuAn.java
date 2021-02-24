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
public class DuAn implements Serializable {
    public static int id = 10000;
    private int ma;
    private String ten;
    private String kieu;
    private int tien;
    
    
    public DuAn(String ten, String kieu, int tien) {
        this.ma = id;
        id++;
        this.ten = ten;
        this.kieu = kieu;
        this.tien = tien;
    }

    public static String checkFormat(String ten , String tien){
        String message = "";
        if (ten.isEmpty())
            message = "Tên không được để trống";
        if (tien.isEmpty())
            message = "Tiền không được để trống";
        else 
            if (tien.matches("[^0-9]+"))
                message = "Tiền không hợp lệ";
            else 
                if (Integer.parseInt(tien) <= 0)
                    message = "Tiền không được <= 0";
        return message;
    }
    
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        DuAn.id = id;
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

    public String getKieu() {
        return kieu;
    }

    public void setKieu(String kieu) {
        this.kieu = kieu;
    }

    public int getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }
    
    
}
