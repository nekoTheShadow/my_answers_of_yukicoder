package _0044;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            if (i + 1 <= n) dp[i + 1] += dp[i];
            if (i + 2 <= n) dp[i + 2] += dp[i];
        }
        
        System.out.println(dp[n]);
    }
}
