package _0237;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        long a = stdin.nextInt();
        
        int count = 0;
        long[] primes = new long[] {3, 5, 17, 257, 65537}; // フェルマー素数
        for (long bit = 0, len = primes.length; bit < (1 << len); bit++) {
            long x = 1;
            for (int i = 0; i < len; i++) {
                if ((bit & (1 << i)) != 0) {
                    x *= primes[i];
                }
            }
            while (x <= a) {
                if (x >= 3) {
                    count++;
                }
                x *= 2;
            }
        }
        
        System.out.println(count);
    }
}
