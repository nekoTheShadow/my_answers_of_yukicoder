package _0390;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        int n = stdin.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = stdin.nextInt();
        }
        
        Arrays.sort(x);
        Map<Integer, Integer> indexes  = IntStream.range(0, n).boxed().collect(Collectors.toMap(i -> x[i], Function.identity()));
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = x[i] * 2; j <= x[n - 1]; j += x[i]) {
                if (indexes.containsKey(j)) {
                    dp[indexes.get(j)] = Math.max(dp[indexes.get(j)], dp[i] + 1);
                }
            }
        }
        
        int ans = Arrays.stream(dp).max().getAsInt();
        System.out.println(ans);
    }
}
