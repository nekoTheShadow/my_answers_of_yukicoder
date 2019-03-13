package _0333;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        long a = stdin.nextLong();
        long b = stdin.nextLong();
        
        if (a < b) { // b > c
            System.out.println(b - 2);
        } else { // a > b && b < c
            System.out.println(2000000000 - b - 1);
        }
    }
}
