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
    private int maKh;
    private String tenKh;
    private String diaChi;
    private String dienThoai;

    public KhachHang(String tenKh, String diaChi, String dienThoai) {
        this.maKh = id;
        id++;
        this.tenKh = tenKh;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
    }

    public static String checkFormat(String tenKh ,String diaChi, String phone){
        String message = "";
        if (tenKh.isEmpty())
            message = "Tên không được để trống";
        if (diaChi.isEmpty())
            message = "Địa chỉ không được để trống";    
        if (phone.isEmpty())
            message = "Phone không được để trống";        
        if (tenKh.matches("[^a-zA-Z]+")){
            message = "Tên không hợp lệ";
        }
        if (phone.matches("[^0-9]+"))
            message = "Phone không hợp lệ";    
        return message;
    }
    
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        KhachHang.id = id;
    }

    public int getMaKh() {
        return maKh;
    }

    public void setMaKh(int maKh) {
        this.maKh = maKh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }
    
}
