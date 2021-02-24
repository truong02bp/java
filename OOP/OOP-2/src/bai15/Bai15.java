package bai15;

import exception.SinhVienException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai15 {

    public static void main(String[] args) throws FileNotFoundException {
        List<SinhVien> list = readFile();
        list.forEach(sinhVien -> {
            System.out.println(sinhVien.toString());
        });
        list.sort((s1, s2) -> s1.getLop().compareTo(s2.getLop()));
        list.sort((s1, s2) -> {
            if (s1.getLop().equals(s2.getLop()))
                return (int) (s2.getDtb() - s1.getDtb());
            return 0;
        });
        String path = "/home/truong02_bp/Desktop/OOP/OOP-2/src/bai15/SV.OUT";
        xuatFile(list, path, "");
        xepLoai(list);
    }

    public static void xepLoai(List<SinhVien> list) throws FileNotFoundException {
        list.sort((s1, s2) -> {
            String[] list1 = s1.getTen().split(" ");
            String[] list2 = s2.getTen().split(" ");
            int i = list1.length-1, j = list2.length-1;
            while (i >= 0 && j >= 0) {
                if (list1[i].compareTo(list2[j]) != 0)
                    return list1[i].compareTo(list2[j]);
                i--;
                j--;
            }
            return 0;
        });
        List<SinhVien> gioi = new ArrayList<>();
        List<SinhVien> kha = new ArrayList<>();
        List<SinhVien> tb = new ArrayList<>();
        List<SinhVien> yeu = new ArrayList<>();
        list.forEach(sinhVien -> {
            double value = sinhVien.getDtb();
            if (value >= 8)
                gioi.add(sinhVien);
            else if (value >= 7)
                kha.add(sinhVien);
            else if (value >= 5)
                tb.add(sinhVien);
            else
                yeu.add(sinhVien);
        });
        String path = "/home/truong02_bp/Desktop/OOP/OOP-2/src/bai15/XEPLOAI.OUT";
        xuatFile(gioi, path, "Giỏi :");
        xuatFile(kha, path, "Khá :");
        xuatFile(tb, path, "Trung bình :");
        xuatFile(yeu, path, "Yếu :");

    }

    public static List<SinhVien> readFile() throws FileNotFoundException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/home/truong02_bp/Desktop/OOP/OOP-2/src/bai15/SV.INP");
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Không tìm thấy file");
        }
        Scanner scanner = new Scanner(fis);
        List<SinhVien> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String first = scanner.nextLine();
            if (first.isEmpty())
                continue;
            int maSV = Integer.parseInt(first);
            String ten = scanner.nextLine();
            String lop = scanner.nextLine();
            double tb = Double.parseDouble(scanner.nextLine());
            SinhVien sinhVien = new SinhVien(maSV, ten, lop, tb);
            try {
                SinhVien.checkFormat(sinhVien);
                list.add(sinhVien);
            } catch (SinhVienException e) {
                e.printStackTrace();
            }
        }
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void xuatFile(List<SinhVien> list, String path, String message) throws FileNotFoundException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path, true);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Không thể mở file");
        }
        PrintWriter pw = new PrintWriter(fos);
        if (!message.isEmpty())
            pw.println(message);
        list.forEach(sinhVien -> {
            pw.println(sinhVien.toString());
        });
        pw.close();
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
