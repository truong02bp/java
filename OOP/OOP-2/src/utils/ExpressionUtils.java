package utils;

import stack.StackOfChars;

public class ExpressionUtils {
    private static int priority(char c) {
        if (c == '-' || c == '+')
            return 1;
        if (c == '*' || c == '/')
            return 2;
        return 0;
    }
    public static String infixToPostfix(String s) {
        StackOfChars stack = new StackOfChars(s.length());
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9')
                result.append(c);
            else if (c == '(')
                stack.push(c);
            else {
                if (c == ')') {
                    while (!stack.isEmpty() && stack.peak() != '(')
                        result.append(stack.pop());
                    if (!stack.isEmpty() && stack.peak() == '(')
                        c = stack.pop();
                } else {
                    while (!stack.isEmpty() && priority(c) <= priority(stack.peak()))
                        result.append(stack.pop());
                    if (c !='\0')
                        stack.push(c);
                }
            }
        }
        while (!stack.isEmpty() && stack.peak() != '(')
            result.append(stack.pop());
        return result.toString();
    }
}
