package bai17;

import exception.SachException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai17 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Sach> list = readFile();
        list.forEach(sach -> {
            System.out.println(sach.toString());
        });
        list.sort((s1, s2) -> (int) (s2.getGiaBan() - s1.getGiaBan()));
        String path = "/home/truong02_bp/Desktop/OOP/OOP-2/src/bai17/SX.OUT";
        writeFile(list, path);
        list.sort((s1, s2) -> {
            if (s1.getChuyenNganh().compareTo(s2.getChuyenNganh()) == 0)
                return s1.getTenSach().compareTo(s2.getTenSach());
            return s1.getChuyenNganh().compareTo(s2.getChuyenNganh());
        });
        String path2 = "/home/truong02_bp/Desktop/OOP/OOP-2/src/bai17/CN.OUT";
        writeFile(list, path2);
    }

    public static List<Sach> readFile() throws FileNotFoundException {
        List<Sach> list = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/home/truong02_bp/Desktop/OOP/OOP-2/src/bai17/SACH.INP");
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Không mở được file");
        }
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNextLine()) {
            String first = scanner.nextLine();
            if (first.isEmpty())
                continue;
            int maSach = Integer.parseInt(first);
            String tenSach = scanner.nextLine();
            String chuyenNganh = scanner.nextLine();
            double giaBan = Double.parseDouble(scanner.nextLine());
            Sach sach = new Sach(maSach, tenSach, chuyenNganh, giaBan);
            try {
                Sach.checkFormat(sach);
                list.add(sach);
            } catch (SachException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void writeFile(List<Sach> list, String path) throws FileNotFoundException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Không thể mở file");
        }
        PrintWriter pw = new PrintWriter(fos);
        list.forEach(sach -> {
            pw.println(sach.toString());
        });
        pw.close();
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
