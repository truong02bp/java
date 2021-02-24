
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
public class DanhSach implements Serializable {
    private MatHang matHang;
    private NhanVienBanHang nhanVienBanHang;
    private int sl;

    public DanhSach(MatHang matHang, NhanVienBanHang nhanVienBanHang, int sl) {
        this.matHang = matHang;
        this.nhanVienBanHang = nhanVienBanHang;
        this.sl = sl;
    }
    
    public static String check(String sl){
        String message = "";
        if (sl.isEmpty())
            message = "So luong khong duoc de trong";
        else 
            if (sl.matches(".*[^0-9].*"))
                message = "So luong khong hop le";
        return message;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }
    
    public MatHang getMatHang() {
        return matHang;
    }

    public NhanVienBanHang getNhanVienBanHang() {
        return nhanVienBanHang;
    }

    public int getSl() {
        return sl;
    }
    
}
