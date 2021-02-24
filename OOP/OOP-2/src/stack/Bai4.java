package stack;

import java.util.Scanner;

public class Bai4 {

    public static boolean snt(int value)
    {
        if (value == 0 || value ==1 )
            return false;
        for (int i=2;i<=Math.sqrt(value);i++)
            if (value%i==0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StackOfIntegers stack = new StackOfIntegers(n);
        for (int i=2;i<n;i++)
            if (snt(i))
                stack.push(i);
        while (!stack.isEmpty())
        {
            System.out.print(stack.pop()+" ");
        }
    }
}
