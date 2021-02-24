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
public class KhachHang implements Serializable{
    private static int id = 10000;
    private int code;
    private String name;
    private String address;
    private String phone;

    public KhachHang() {
        this.code = id;
        id++;
    }

    public KhachHang(String name, String address, String phone) {
        this.code = id;
        id++;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public static String check(String name, String address, String phone){
        String message = "";
        if (name.isEmpty()){
            message = "Tên không được để trống";
        }
        if (address.isEmpty()){
            message = "Địa chỉ không được để trống";
        }
        if (phone.isEmpty()){
            message = "Phone không được để trống";
        }
        if (name.matches("[^a-zA-Z]+")){
            message = "Tên không hợp lệ";
        }
        if (phone.matches("[^0-9]+")){
            message = "Phone không hợp lệ";
        }
        return message;
    }
    
    public static void setId(int id) {
        KhachHang.id = id;
    }

   
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
