package stack;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StackOfIntegers stack = new StackOfIntegers(n);
        int i=2;
        while (i< Math.sqrt(n)+1)
        {
            while (n%i==0)
            {
                stack.push(i);
                n/=i;
            }
            i++;
        }
        if (n>1)
            stack.push(n);
        while (!stack.isEmpty())
            System.out.print(stack.pop()+" ");
    }
}
