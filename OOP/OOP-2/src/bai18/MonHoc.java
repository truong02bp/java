package bai18;

import exception.MonHocException;

import java.util.Arrays;
import java.util.List;

public class MonHoc {
    private int maMon;
    private String tenMon;
    private String nhomMon;
    private int soTinChi;

    public MonHoc() {
    }

    public MonHoc(int maMon, String tenMon, String nhomMon, int soTinChi) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.nhomMon = nhomMon;
        this.soTinChi = soTinChi;
    }

    public static void checkFormat(MonHoc monHoc) throws MonHocException {
        if (monHoc.maMon>=10000 || monHoc.maMon < 1000)
            throw new MonHocException("Mã sai định dạng");
        if (monHoc.tenMon.isEmpty())
            throw new MonHocException("Tên sai định dạng");
        List<String> template = Arrays.asList("Cơ bản","cơ sở ngành","chuyên ngành","kỹ năng mềm");
        if (!template.contains(monHoc.nhomMon))
            throw new MonHocException("Nhóm sai định dạng");
        if (monHoc.soTinChi<=0 || monHoc.soTinChi >= 7)
            throw new MonHocException("Số tín chỉ sai định dạng");
    }

    public String getTenMon() {
        return tenMon;
    }

    public String getNhomMon() {
        return nhomMon;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    @Override
    public String toString() {
        return maMon + " " + tenMon + " " + nhomMon + " " + soTinChi;
    }
}
