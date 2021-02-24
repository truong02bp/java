
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
    private CongNhan congNhan;
    private Xuong xuong;
    private int soNgay;

    public DanhSach(CongNhan congNhan, Xuong xuong, int soNgay) {
        this.congNhan = congNhan;
        this.xuong = xuong;
        this.soNgay = soNgay;
    }
    public static String check(String soNgay){
        String message = "";
        if (soNgay.isEmpty())
            message = "So ngay khong duoc de trong";
        else 
            if (soNgay.matches(".*[^0-9].*"))
                message = "So ngay khong hop le";
            else 
                if (Integer.parseInt(soNgay) > 30)
                    message = "Cong nhan chi lam toi da 30 ngay";
        return message;
    }
    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }
    
    public CongNhan getCongNhan() {
        return congNhan;
    }

    public Xuong getXuong() {
        return xuong;
    }

    public int getSoNgay() {
        return soNgay;
    }
    
}
