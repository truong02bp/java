package sinhvien;

import java.util.Scanner;

public class SinhVienUtils {

    public static SinhVien nhap(Scanner scanner)
    {
        System.out.println("Nhập mã sinh viên :");
        String code = scanner.nextLine();
        System.out.println("Nhập tên :");
        String name = scanner.nextLine();
        System.out.println("Nhập lớp :");
        String lop = scanner.nextLine();
        System.out.println("Nhập khoa :");
        String major = scanner.nextLine();
        return new SinhVien(code,name,lop,major);
    }

}
