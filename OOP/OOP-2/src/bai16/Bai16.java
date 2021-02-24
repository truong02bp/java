package bai16;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bai16 {
    public static void main(String[] args) throws FileNotFoundException {
        List<MatHang> list = readFile();
        list.forEach(matHang -> {
            System.out.println(matHang.toString());
        });
        list.sort((m1, m2) -> {
            return (int) (m2.getGiaBan()-m1.getGiaBan());
        });
        String path = "/home/truong02_bp/Desktop/OOP/OOP-2/src/bai16/MH.OUT";
        writeFile(list,path);
        list.sort((m1, m2) -> {
            int value = m1.getNhom().compareTo(m2.getNhom());
            if (value == 0)
                return m1.getTen().compareTo(m2.getTen());
            return value;
        });
        String path2 = "/home/truong02_bp/Desktop/OOP/OOP-2/src/bai16/NHOM.OUT";
        writeFile(list,path2);
    }

    public static List<MatHang> readFile() throws FileNotFoundException {
        List<MatHang> list = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/home/truong02_bp/Desktop/OOP/OOP-2/src/bai16/MH.INP");
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File không tồn tại");
        }
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNextLine()){
            int maHang = Integer.parseInt(scanner.nextLine());
            String ten = scanner.nextLine();
            String nhom = scanner.nextLine();
            double giaBan = Double.parseDouble(scanner.nextLine());
            if (!MHUtils.checkMa(maHang) || !MHUtils.checkTen(ten) || !MHUtils.checkNhom(nhom) || !MHUtils.checkGia(giaBan))
                continue;
            list.add(new MatHang(maHang,ten,nhom,giaBan));
        }
        scanner.close();
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
        return list;
    }

    public static void writeFile(List<MatHang> list , String path) throws FileNotFoundException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Không thể mở file");
        }
        PrintWriter pw = new PrintWriter(fos);
        list.forEach(matHang -> {
            pw.println(matHang.toString());
        });
        pw.close();
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
