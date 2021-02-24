package bai18;

import exception.MonHocException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai18 {
        public static void main(String[] args) throws FileNotFoundException {
            List<MonHoc> list = readFile();
            list.forEach(sach -> {
                System.out.println(sach.toString());
            });
            list.sort((m1,m2) -> m2.getSoTinChi()-m1.getSoTinChi());
            String path = "/home/truong02_bp/Desktop/OOP/OOP-2/src/bai18/SX.OUT";
            writeFile(list,path);
            list.sort((m1,m2) -> {
                int value = m1.getNhomMon().compareTo(m2.getNhomMon());
                if (value == 0)
                    return m1.getTenMon().compareTo(m2.getTenMon());
                return value;
            });
            String path2 = "/home/truong02_bp/Desktop/OOP/OOP-2/src/bai18/NHOM.OUT";
            writeFile(list, path2);
        }

        public static List<MonHoc> readFile() throws FileNotFoundException {
            List<MonHoc> list = new ArrayList<>();
            FileInputStream fis = null;
            try {
                fis = new FileInputStream("/home/truong02_bp/Desktop/OOP/OOP-2/src/bai18/MH.INP");
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException("Không mở được file");
            }
            Scanner scanner = new Scanner(fis);
            while (scanner.hasNextLine()) {
                String first = scanner.nextLine();
                if (first.isEmpty())
                    continue;
                int maMon = Integer.parseInt(first);
                String tenMon = scanner.nextLine();
                String nhomMon = scanner.nextLine();
                int soTinChi = Integer.parseInt(scanner.nextLine());
                try {
                    MonHoc monHoc = new MonHoc(maMon,tenMon,nhomMon,soTinChi);
                    MonHoc.checkFormat(monHoc);
                    list.add(monHoc);
                } catch (MonHocException e) {
                    e.printStackTrace();
                }
            }
            return list;
        }

        public static void writeFile(List<MonHoc> list, String path) throws FileNotFoundException {
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
