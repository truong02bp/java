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
public class PhongBan implements Serializable {
    
    public static int id = 100;
    private int ma;
    private String ten;
    private String moTa;
    private int heSo;

    public static String checkFormat(String ten , String moTa , String heSo){
        String message = "";
        if (ten.isEmpty())
            message = "Tên không được để trống";
        if (ten.matches("[^a-zA-z]+"))
            message = "Tên không hợp lệ";
        if (moTa.isEmpty())
            message = "Mô tả không được để trống";
        if (heSo.matches("[^1-9]+"))
            message = "Hệ số không hợp lệ";
        else 
            if (Integer.parseInt(heSo)<=0 || Integer.parseInt(heSo)>20)
                message = "Hệ số > 0 và < 21";
        return message;
    }

    public PhongBan(String ten, String moTa, int heSo) {
        this.ma = id;
        id++;
        this.ten = ten;
        this.moTa = moTa;
        this.heSo = heSo;
    }

    
    
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        PhongBan.id = id;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getHeSo() {
        return heSo;
    }

    public void setHeSo(int heSo) {
        this.heSo = heSo;
    }
    
    
}
