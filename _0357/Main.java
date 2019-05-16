package _0357;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = Integer.parseInt(stdin.next());
        int m = Integer.parseInt(stdin.next());
        
        int[][] scores = new int[n][n];
        for (int i = 0; i < m; i++) {
            int item1 = Integer.parseInt(stdin.next());
            int item2 = Integer.parseInt(stdin.next());
            int score = Integer.parseInt(stdin.next());
            scores[item1][item2] = score;
        }
        
        int[] dp = new int[1 << n];
        for (int bit = 0; bit < dp.length; bit++) {
            for (int nxt = 0; nxt < n; nxt++) {
                if ((bit & (1 << nxt)) != 0) {
                    continue;
                }
                
                int score = dp[bit];
                for (int pre = 0; pre < n; pre++) {
                    if ((bit & (1 << pre)) != 0) {
                        score += scores[pre][nxt];
                    }
                }
                
                dp[bit | (1 << nxt)] = Math.max(dp[bit | (1 << nxt)], score);
            }
        }
        
        int ans = Arrays.stream(dp).max().getAsInt();
        System.out.println(ans);
    }
}
