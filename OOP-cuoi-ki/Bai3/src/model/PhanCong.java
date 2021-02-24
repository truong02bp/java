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
public class PhanCong implements Serializable {
    private DuAn duAn;
    private NhanVien nhanVien;
    private int ngay;
    private String viTri;

    public PhanCong(DuAn duAn, NhanVien nhanVien, int ngay, String viTri) {
        this.duAn = duAn;
        this.nhanVien = nhanVien;
        this.ngay = ngay;
        this.viTri = viTri;
    }
    
    public static String checkFormat(String ngay){
        String message = "";
        if (ngay.isEmpty())
            message = "Ngày không được để trống";
        else 
            if (ngay.matches("[^0-9]+"))
                message = "Ngày không hợp lệ";
            else 
                if (Integer.parseInt(ngay) <= 0)
                    message = "Ngày không được <= 0"; 
        return message;
    }
    
    public DuAn getDuAn() {
        return duAn;
    }

    public void setDuAn(DuAn duAn) {
        this.duAn = duAn;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
    
    
    
}
