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
public class Detail implements Serializable{
    private MatHang matHang;
    private int sl;

    public Detail() {
    }

    
    
    public Detail(MatHang matHang, int sl) {
        this.matHang = matHang;
        this.sl = sl;
    }
    
    public MatHang getMatHang() {
        return matHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    
}
