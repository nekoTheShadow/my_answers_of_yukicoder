package _0583;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        String ans = (isOK()) ? "YES" : "NO";
        System.out.println(ans);
    }
    
    public static boolean isOK() {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int m = stdin.nextInt();
        
        UnionFind uf = new UnionFind(n);
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = stdin.nextInt();
            int b = stdin.nextInt();
            uf.union(a, b);
            counter.put(a, counter.getOrDefault(a, 0) + 1);
            counter.put(b, counter.getOrDefault(b, 0) + 1);
        }
        
        List<Integer> keys = counter.keySet().stream().collect(Collectors.toList());
        for (int i = 0; i < keys.size(); i++) {
            for (int j = 0; j < keys.size(); j++) {
                if (uf.find(keys.get(i)) != uf.find(keys.get(j))) {
                    return false;
                }
            }
        }
       
        // Wikipedia「一筆書き」より抜粋:
        // ある連結グラフが一筆書き可能な場合の必要十分条件は、以下の条件のいずれか一方が成り立つことである（オイラー路参照）。 
        // すべての頂点の次数（頂点につながっている辺の数）が偶数 →運筆が起点に戻る場合（閉路）
        // 次数が奇数である頂点の数が2で、残りの頂点の次数は全て偶数　→運筆が起点に戻らない場合（閉路でない路）
        
        // <<< 奇数の頂点数が0または2 >>>
        long odd = counter.values().stream().filter(v -> v % 2 != 0).count();
        return odd == 0 || odd == 2;
    }
    
    private static class UnionFind {
        private int[] parents;
        
        public UnionFind(int n) {
            parents = IntStream.range(0, n).toArray();
        }
        
        public int find(int x) {
            if (parents[x] == x) {
                return x;
            } else {
                parents[x] = find(parents[x]);
                return parents[x];
            }
        }
        
        public void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) {
                parents[y] = x; 
            }
        }
    }
}
