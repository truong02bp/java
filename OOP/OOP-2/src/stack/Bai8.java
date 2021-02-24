package stack;

import utils.ExpressionUtils;

import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(ExpressionUtils.infixToPostfix(s));
    }
}
