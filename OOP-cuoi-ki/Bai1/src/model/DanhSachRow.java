/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huy Trường
 */
public class DanhSachRow {
    private int maKh;
    private String tenKh;
    private int maMh;
    private String tenMh;
    private int sl;

    public DanhSachRow(int maKh, String tenKh, int maMh, String tenMh, int sl) {
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.maMh = maMh;
        this.tenMh = tenMh;
        this.sl = sl;
    }

    public static List<DanhSachRow> getFromDs(List<DanhSach> list){
        List<DanhSachRow> result = new ArrayList<>();
        for (DanhSach danhSach : list) {
            int code = danhSach.getKh().getCode();
            String name = danhSach.getKh().getName();
            for (Detail detail : danhSach.getDetails()) {
                result.add(new DanhSachRow(code, name, detail.getMatHang().getCode(), detail.getMatHang().getName(), detail.getSl()));
            }
        }
        return result;
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

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }
    
   
}
