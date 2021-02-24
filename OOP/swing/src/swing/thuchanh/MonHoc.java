package swing.thuchanh;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MonHoc {
    public static int generate = 1000;
    private int maMon;
    private String tenMon;
    private String nhomMon;
    private int soTinChi;

    public MonHoc() {
        getSize();
        this.maMon = generate;
        generate++;
    }

    public MonHoc(String tenMon, String nhomMon, int soTinChi) {
        getSize();
        this.maMon = generate;
        generate++;
        this.tenMon = tenMon;
        this.nhomMon = nhomMon;
        this.soTinChi = soTinChi;
    }

    public MonHoc(int maMon, String tenMon, String nhomMon, int soTinChi) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.nhomMon = nhomMon;
        this.soTinChi = soTinChi;
    }

    private void getSize(){
        File file = new File("src/swing/thuchanh/MH.txt");
        if (file.length() != 0) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                Scanner scanner = new Scanner(fileInputStream);
                int start=0;
                while (scanner.hasNextLine()){
                    String value = scanner.nextLine();
                    if (start%4==0)
                        generate = Integer.parseInt(value)+1;
                    start++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public int getMaMon() {
        return maMon;
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

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public void setNhomMon(String nhomMon) {
        this.nhomMon = nhomMon;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }
}
