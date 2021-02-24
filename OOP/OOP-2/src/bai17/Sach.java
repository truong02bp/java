package bai17;

import exception.SachException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Sach implements Serializable {
    private int maSach;
    private String tenSach;
    private String chuyenNganh;
    private double giaBan;

    public Sach() {
    }

    public Sach(int maSach, String tenSach, String chuyenNganh, double giaBan) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.chuyenNganh = chuyenNganh;
        this.giaBan = giaBan;
    }

    public static void checkFormat(Sach sach) throws SachException {
        if (sach.maSach >= 10000 || sach.maSach < 1000)
            throw new SachException("Mã không đúng định dạng");
        if (sach.tenSach.isEmpty())
            throw new SachException("Tên không đúng định dạng");
        List<String> template = Arrays.asList("Giáo khoa","Văn học","Kỹ thuật");
        if (!template.contains(sach.chuyenNganh))
            throw new SachException("Chuyên ngành không đúng định dạng");
        if (sach.giaBan <= 0)
            throw new SachException("Giá không đúng định dạng");
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public double getGiaBan() {
        return giaBan;
    }

    @Override
    public String toString() {
        return maSach + " " + tenSach + " " + chuyenNganh + " " + giaBan;
    }
}
