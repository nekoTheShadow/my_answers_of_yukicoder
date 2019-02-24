package _0016;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        BigInteger x = stdin.nextBigInteger();
        int n = stdin.nextInt();
        
        BigInteger answer = BigInteger.ZERO;
        BigInteger divisor = new BigInteger("1000003");
        for (int i = 0; i < n; i++) {
            BigInteger a = stdin.nextBigInteger();
            answer = answer.add(x.modPow(a, divisor));
        }
        
        System.out.println(answer.mod(divisor));
    }
}
