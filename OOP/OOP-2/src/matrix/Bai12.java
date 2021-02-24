package matrix;

import java.util.Scanner;

public class Bai12 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int choice = 1;
        do {
            System.out.println("1. Tính tổng và hiệu hai ma trận");
            System.out.println("2. Tính tích hai ma trận");
            System.out.println("3. Tìm chuyển vị của một ma trận");
            System.out.println("4. Kết thúc chương trình");
            System.out.println("Nhập lựa chọn");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    choiceOne();
                    break;
                case 2:
                    choiceTwo();
                    break;
                case 3:
                    choiceThree();
                    break;
                case 4:{
                    System.out.println("Chương trình kết thúc !");
                    return;
                }
                default:
                    System.out.println("Chọn không hợp lệ, hãy chọn lại: ");
            }
        }
        while (choice < 1 || choice > 4);
    }

    private static Matrix nhap() {
        int rows = 0;
        int cols = 0;
        System.out.println("Số hàng :");
        rows = scanner.nextInt();
        System.out.println("Số cột :");
        cols = scanner.nextInt();
        System.out.println("Nhập ma trận :");
        Matrix matrix = new Matrix(rows, cols);
        matrix.input();
        return matrix;
    }

    private static void choiceOne() throws Exception {
        System.out.println("Nhập ma trận a :");
        Matrix a = nhap();
        System.out.println("Nhập ma trận b :");
        Matrix b = nhap();
        System.out.println("a + b :");
        a.add(b).output();
        System.out.println("a - b :");
        a.sub(b).output();
    }

    private static void choiceTwo() throws Exception {
        System.out.println("Nhập ma trận a :");
        Matrix a = nhap();
        System.out.println("Nhập ma trận b :");
        Matrix b = nhap();
        System.out.println("a * b :");
        a.mul(b).output();
    }

    private static void choiceThree(){
        System.out.println("Nhập ma trận :");
        Matrix a = nhap();
        System.out.println("Ma trận chuyển vị :");
        a.transpose().output();
    }
}
