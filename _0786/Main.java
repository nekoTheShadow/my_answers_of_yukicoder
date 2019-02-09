package _0786;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        
        long[] dp = new long[n + 2];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            dp[i + 1] += dp[i];
            dp[i + 2] += dp[i];
        }
        
        System.out.println(dp[n]);
    }
}
