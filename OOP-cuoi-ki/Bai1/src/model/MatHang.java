/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exception.HandlerException;
import java.io.Serializable;

/**
 *
 * @author Huy Trường
 */
public class MatHang implements Serializable{
    private static int id = 1000;
    private String name;
    private String group;
    private int price;
    private int code;

    public MatHang() {
        this.code = id;
        id++;
    }

    public MatHang(String name, String group, int price) {
        this.code = id;
        id++;
        this.name = name;
        this.group = group;
        this.price = price;
    }

    public static String check(String name , String price){
        String message = "";
        if (name.isEmpty()){
            message = "Tên không được để trống";
        }
        if (name.matches("[^a-zA-Z]+")){
            message = "Tên không hợp lệ";
        }
        if (price.matches("[^0-9]+")){
            message = "Giá không hợp lệ";
        }
        else    {
            if (Integer.valueOf(price) <= 0){
             message = "Giá phải lớn hơn 0";
            }
        }
        return message;
    }

    public static void setId(int id) {
        MatHang.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    
}
