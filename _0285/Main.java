package _0285;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        long d = stdin.nextLong();
        
        long x = d * 108;
        long y = x / 100;
        long z = x % 100;
        System.out.printf("%d.%02d", y, z);
    }
}
