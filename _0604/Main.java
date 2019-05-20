package _0604;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        long a = stdin.nextLong();
        long b = stdin.nextLong();
        long c = stdin.nextLong();
        BigInteger A = new BigInteger(String.valueOf(a));
        BigInteger B = new BigInteger(String.valueOf(b));
        BigInteger C = new BigInteger(String.valueOf(c));
        
        long left = -1;
        long right = c + 1;
        while (right - left > 1) {
            // long sum = b * (mid / a) + (mid - mid / a);
            long mid = left + (right - left) / 2;
            BigInteger MID = new BigInteger(String.valueOf(mid));
            BigInteger SUM = B.multiply(MID.divide(A)).add(MID.subtract(MID.divide(A)));
            if (SUM.compareTo(C) >= 0) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        System.out.println(right);
    }
}