package hcn;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        System.out.println("Nhập chiều dài : ");
        double height = scanner.nextDouble();
        System.out.println("Nhập chiều rộng : ");
        double width = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nhập màu sắc : ");
        String color = scanner.nextLine();
        Rectangle rectangle = new Rectangle(width, height, color);
        System.out.println("Chiều dài : " + rectangle.getHeight());
        System.out.println("Chiều rộng : " + rectangle.getWidth());
        System.out.println("Màu sắc : " + rectangle.getColor());
        System.out.println("Diện tích : " + rectangle.findArea());
        System.out.println("Chu vi : " + rectangle.findPerimeter());
    }
}
