package _0090;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        int n = stdin.nextInt();
        int m = stdin.nextInt();
        
        int[][] score = new int[n][n];
        for (int i = 0; i < m; i++) {
            int a = stdin.nextInt();
            int b = stdin.nextInt();
            int c = stdin.nextInt();
            score[a][b] = c;
        }
        
        List<List<Integer>> permutations = new ArrayList<>();
        Deque<List<Integer>> queue = IntStream.range(0, n)
                                              .mapToObj(i -> Arrays.asList(i))
                                              .collect(Collectors.toCollection(ArrayDeque::new));
        while (!queue.isEmpty()) {
            List<Integer> permutation = queue.pollFirst();
            
            if (permutation.size() == n) {
                permutations.add(permutation);
            } else {
                for (int i = 0; i < n; i++) {
                    if (permutation.contains(i)) continue;
                    List<Integer> nextPermutation = new ArrayList<>(permutation);
                    nextPermutation.add(i);
                    queue.add(nextPermutation);
                }
            }
        }
        
        int ans = 0;
        for (List<Integer> permutation : permutations) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    sum += score[permutation.get(i)][permutation.get(j)];
                }
            }
            ans = Math.max(ans, sum);
        }
        
        System.out.println(ans);
    }
}
