package bai16;

public class MatHang {
    private int maHang;
    private String ten;
    private String nhom;
    private double giaBan;

    public MatHang() {
    }

    public MatHang(int maHang, String ten, String nhom, double giaBan) {
        this.maHang = maHang;
        this.ten = ten;
        this.nhom = nhom;
        this.giaBan = giaBan;
    }

    public String getTen() {
        return ten;
    }

    public String getNhom() {
        return nhom;
    }

    public double getGiaBan() {
        return giaBan;
    }

    @Override
    public String toString() {
        return ""+ maHang + " " + ten + " " + nhom + " " + giaBan;
    }
}
