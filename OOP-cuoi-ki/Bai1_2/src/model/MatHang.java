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
    private int maMh;
    private String tenMh;
    private String nhomMh;
    private String gia;
    public static int id = 1000;
    public MatHang(String tenMh, String nhomMh, String gia) {
        this.maMh = id;
        id++;
        this.tenMh = tenMh;
        this.nhomMh = nhomMh;
        this.gia = gia;
    }
    
    public static String checkFormat(String tenMh , String gia){
        String message = "";
        if (tenMh.isEmpty())
            message = "Tên không được để trống";
        if (tenMh.matches("[^a-zA-Z]+")){
            message = "Tên không hợp lệ";
        }
        if (gia.matches("[^0-9]+"))
            message = "Giá không hợp lệ";
        else
        {
            if (gia.isEmpty())
                message = "Giá không được để trống";
            else 
                if (Integer.parseInt(gia) <= 0)
                    message = "Giá phải lớn hơn 0";
        }
               
            
        return message;
    }
    
    public int getMaMh() {
        return maMh;
    }

    public void setMaMh(int maMh) {
        this.maMh = maMh;
    }

    public String getTenMh() {
        return tenMh;
    }

    public void setTenMh(String tenMh) {
        this.tenMh = tenMh;
    }

    public String getNhomMh() {
        return nhomMh;
    }

    public void setNhomMh(String nhomMh) {
        this.nhomMh = nhomMh;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
    
    
}
