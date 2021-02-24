package stack;

import utils.ExpressionUtils;

import java.util.Scanner;
import java.util.Stack;

public class Bai7 {

    private static boolean isOperator(char c){
        if (c == '-' || c=='+' || c=='*' || c=='/')
            return true;
        return false;
    }

    private static String solve(int a , int b , char operator){
        int result = 0;
        switch (operator){
            case '+':
                result = a+b;
                break;
            case '-':
                result = b-a;
                break;
            case '*':
                result = a*b;
                break;
            case '/':
                result = b/a;
                break;
        }
        return String.valueOf(result);
    }

    private static String result(String s){
        s = ExpressionUtils.infixToPostfix(s);
        Stack<String> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (isOperator(c)){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(solve(a,b,c));
            }
            else
                stack.push(String.valueOf(c));
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(result(str));
    }
}
