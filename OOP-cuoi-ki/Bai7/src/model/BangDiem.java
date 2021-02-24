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
public class BangDiem implements Serializable {
    private MonHoc monHoc;
    private SinhVien sinhVien;
    private int diem;
    
    public BangDiem(MonHoc monHoc, SinhVien sinhVien , int diem) {
        this.monHoc = monHoc;
        this.sinhVien = sinhVien;
        this.diem = diem;
    }
    public static String check(String diem){
        String message="";
        if (diem.isEmpty())
            message = "So don vi sinh khong duoc de trong";
        else 
            if (diem.matches(".*[^0-9].*"))
                message = "So tin chi khong hop le";
        return message;
    }
    public MonHoc getMonHoc() {
        return monHoc;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public int getDiem() {
        return diem;
    }
    
}
