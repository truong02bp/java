package phanso;

public class Utils {

    public static int GCD(int a , int b){
        int temp;
        while (b!=0){
            temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}
