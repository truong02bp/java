
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Huy Trường
 */
public class HoaDon implements Serializable {
    private KhachHang khachHang;
    private DichVu dichVu;
    private int sl;

    public HoaDon(KhachHang khachHang, DichVu dichVu, int sl) {
        this.khachHang = khachHang;
        this.dichVu = dichVu;
        this.sl = sl;
    }
    
    public static String check(String sl){
        String message = "";
        if (sl.isEmpty())
            message = "So luong khong duoc trong";
        else 
            if (sl.matches(".*[^0-9].*"))
                message = "So luong khong hop le";
        return message;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }
    
    public KhachHang getKhachHang() {
        return khachHang;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public int getSl() {
        return sl;
    }
    
}
