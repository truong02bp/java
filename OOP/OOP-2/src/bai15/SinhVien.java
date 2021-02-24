package bai15;

import exception.SinhVienException;

public class SinhVien {
    private int maSV;
    private String ten;
    private String lop;
    private double dtb;

    public SinhVien() {
    }

    public SinhVien(int maSV, String ten, String lop, double dtb) {
        this.maSV = maSV;
        this.ten = ten;
        this.lop = lop;
        this.dtb = dtb;
    }

    public static void checkFormat(SinhVien sinhVien) throws SinhVienException {
        if (sinhVien.maSV > 9999 || sinhVien.maSV < 1000)
            throw new SinhVienException("Mã sinh viên không đúng định dạng");
        String[] list = sinhVien.ten.split(" ");
        if (list.length <= 2)
            throw new SinhVienException("Tên không đúng định dạng");
        String key = "^D[0-9]{2}CQ[A-Z]{2}[0-9]{2}-B$";
        if (!sinhVien.lop.matches(key))
            throw new SinhVienException("Lớp không đúng định dạng");
        if (sinhVien.dtb< 0 || sinhVien.dtb > 10)
            throw new SinhVienException("Điểm trung bình không hợp lệ");
    }

    public double getDtb() {
        return dtb;
    }

    public String getLop() {
        return lop;
    }

    public String getTen() {
        return ten;
    }

    @Override
    public String toString() {
        return "" + maSV +" " + ten + " " + lop  + " " + dtb + "";
    }
}
