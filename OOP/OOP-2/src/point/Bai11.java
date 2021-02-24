package point;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai11 {

    public static boolean isRightTriangle(double a ,double b ,double c ) {
        a*=a;
        b*=b;
        c*=c;
        System.out.println(a+" " + b + " " + c);
        if (a+b==c || a+c==b || b+c==a)
            return true;
        return false;
    }

    public static void check(List<MyPoint> list) {
        double a = MyPoint.distance(list.get(0), list.get(1));
        double b = MyPoint.distance(list.get(1), list.get(2));
        double c = MyPoint.distance(list.get(0), list.get(2));
        if (a + b <= c || a + c <= b || b + c <= a)
            System.out.println("Không phải tam giác");
        else {
            if (a == b && b == c)
                System.out.println("Tam giác đều");
            else {
                boolean isRightTriangle = isRightTriangle(a,b,c);
                if (a == b || b == c || a == c) {
                    if (isRightTriangle)
                        System.out.println("Tam giác vuông cân");
                    else
                        System.out.println("Tam giác cân");
                } else {
                    if (isRightTriangle)
                        System.out.println("Tam giác vuông");
                    else
                        System.out.println("Là tam giác");
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MyPoint> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Nhập điểm thứ " + (i + 1));
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            list.add(new MyPoint(x, y));
        }
        check(list);
    }
}
