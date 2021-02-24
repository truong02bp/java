package point;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double max=0;
        List<MyPoint> points = new ArrayList<>();
        while (n-->0){
            System.out.println("Nhập x : ");
            double x = scanner.nextDouble();
            System.out.println("Nhập y : ");
            double y = scanner.nextDouble();
            points.add(new MyPoint(x,y));
        }
        for (int i=0;i<points.size()-1;i++)
            for (int j=i+1;j<points.size();j++)
                max = Math.max(max,points.get(i).distance(points.get(j)));
        System.out.println(max);
    }
}
