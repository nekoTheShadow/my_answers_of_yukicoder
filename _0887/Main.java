package _0887;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n0 = stdin.nextInt();
        
        Deque<Integer> digits = new ArrayDeque<>();
        digits.addLast(n0);
        int n;
        while ((n = digits.getLast()) > 1) {
            if (n % 2 == 0) {
                digits.addLast(n / 2);
            } else {
                digits.addLast(n * 3 + 1);
            }
        }
        
        System.out.println(digits.size() - 1);
        System.out.println(Collections.max(digits));
    }

}
