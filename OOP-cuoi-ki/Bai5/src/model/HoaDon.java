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
public class HoaDon implements Serializable {
    private MatHang matHang;
    private KhachHang khachHang;
    private int sl;

    public HoaDon(MatHang matHang, KhachHang khachHang, int sl) {
        this.matHang = matHang;
        this.khachHang = khachHang;
        this.sl = sl;
    }

    public MatHang getMatHang() {
        return matHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }
    
}
