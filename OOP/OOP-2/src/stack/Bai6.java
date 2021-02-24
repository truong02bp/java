package stack;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StackOfIntegers stack = new StackOfIntegers(n);
        while (n>0)
        {
            stack.push(n%2);
            n/=2;
        }
        while (!stack.isEmpty())
            System.out.print(stack.pop());
    }
}
