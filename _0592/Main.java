package _0592;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        String s = stdin.next();
        
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.addFirst(i);
            } else {
                int j = stack.removeFirst();
                ans[i] = j;
                ans[j] = i;
            }
        }
        
        Arrays.stream(ans).map(i -> i + 1).forEach(System.out::println);
    }
}
