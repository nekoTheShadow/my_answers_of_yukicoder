package _0556;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int m = stdin.nextInt();
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = stdin.nextInt() - 1;
            b[i] = stdin.nextInt() - 1;
        }
        
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < m; i++) {
            uf.union(a[i], b[i]);
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println(uf.find(i) + 1);
        }
    }
    
    private static class UnionFind {
        private int[] parents;
        private int[] sizes;
        
        public UnionFind(int n) {
            parents = IntStream.range(0, n).toArray();
            sizes = new int[n];
            Arrays.fill(sizes, 1);
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
            if (x == y) return ;
            
            
            int w, l;
            if (sizes[x] < sizes[y]) {
                w = y;
                l = x;
            } else if (sizes[x] == sizes[y]) {
                w = Math.min(x, y);
                l = Math.max(x, y);
            } else {
                w = x;
                l = y;
            }
            
            sizes[w] += sizes[l];
            parents[l] = w;
        }
    }
}
