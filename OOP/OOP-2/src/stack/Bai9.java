package stack;

import java.util.Scanner;

public class Bai9 {

    private static String convert(int n , int b){
        char[] template = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J'
                ,'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        StringBuilder result = new StringBuilder("");
        StackOfChars stack = new StackOfChars(100);
        while (n>0){
            stack.push(template[n%b]);
            n/=b;
        }
        while (!stack.isEmpty())
            result.append(stack.pop());
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(convert(n,b));
    }
}
