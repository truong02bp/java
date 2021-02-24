package sinhvien;

import java.util.*;
import java.util.stream.Collectors;

public class Bai2 {

    public static void print(List<SinhVien> students) {
        for (SinhVien sinhVien : students) {
            System.out.println(sinhVien);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<SinhVien> students = new ArrayList<>();
        int n = scanner.nextInt();
        int l = 1;
        scanner.nextLine();
        while (l <= n) {
            System.out.println("Nhập sinh viên thứ " + l + ": ");
            SinhVien sinhVien = SinhVienUtils.nhap(scanner);
            students.add(sinhVien);
            l++;
        }
        System.out.println("Danh sách sinh viên : ");
        print(students);
        students = students.stream().sorted((s1, s2) -> s1.getName().compareTo(s2.getName())).collect(Collectors.toList());
        System.out.println("Danh sách sinh viên theo anphabet : ");
        print(students);
        students = students.stream().sorted((s1, s2) -> s1.getRoom().compareTo(s2.getRoom())).collect(Collectors.toList());
        System.out.println("Danh sách sinh viên theo anphabet và lớp : ");
        print(students);
    }
}
