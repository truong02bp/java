/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javafx.util.Pair;

/**
 *
 * @author Huy Trường
 */
public class DanhSach implements Serializable {
    private KhachHang kh;
    private List<Detail> details;

    public DanhSach() {
    }

    
    public DanhSach(KhachHang kh, List<Detail> details) {
        this.kh = kh;
        this.details = details;
    }
    
    
    
    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }
  
}
