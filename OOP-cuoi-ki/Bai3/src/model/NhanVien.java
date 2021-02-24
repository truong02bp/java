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
    public static int id = 10000;
    private int ma;
    private String ten;
    private String diaChi;
    private String chuyenMon;

    public NhanVien(String ten, String diaChi, String chuyenMon) {
        this.ma = id;
        id++;
        this.ten = ten;
        this.diaChi = diaChi;
        this.chuyenMon = chuyenMon;
    }
    
    public static String checkFormat(String ten , String diaChi , String chuyenMon){
        String message = "";
        if (ten.isEmpty())
            message = "Tên không được để trống";
        if (diaChi.isEmpty())
            message = "Địa chỉ không được để trống";
        if (chuyenMon.isEmpty())
            message = "Chuyên môn không được để trống";   
        return message;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }
    
}
