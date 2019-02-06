package _0780;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int a = stdin.nextInt();
        int b = stdin.nextInt();
        
        String answer = a + 1 <= b ? "YES" : "NO";
        int c = Math.abs(a - b + 1);
        
        System.out.println(answer);
        System.out.println(c);
    }
}
