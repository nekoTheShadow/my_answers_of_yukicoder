package _0007;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        
        // エラトステネスの篩: n以下の素数をすべて求める。
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 0; i * i <= n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i + i; j <= n; j += i) isPrime[j] = false;
        }
        TreeSet<Integer> primes = IntStream.range(0, n + 1)
                                            .filter(i -> isPrime[i])
                                            .boxed()
                                            .collect(Collectors.toCollection(TreeSet::new));
        
        boolean[] dp = new boolean[n + 1];
        dp[0] = dp[1] = true; // n=0またはn=1ならば先行勝利
        for (int i = 2; i <= n; i++) {
            // 遷移前が負け(=後攻が負け)の場合は選考が勝利
            for (int prime : primes.subSet(0, i + 1)) {
                dp[i] = dp[i] | !dp[i - prime];
            }
        }
        
        String ans = dp[n] ? "Win" : "Lose";
        System.out.println(ans);
    }
}
