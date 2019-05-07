package _0826;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int p = stdin.nextInt();
        Main main = new Main(n, p);
        System.out.println(main.solve());
    }
    
    private int n;
    private int p;
    
    public Main(int n, int p) {
        this.n = n;
        this.p = p;
    }
    
    public int solve() {
        UnionFind uf = new UnionFind(n);
        for (int x = 2; x <= n; x++) {
            for (int y = x + x; y <= n; y += x) {
                uf.union(x - 1, y - 1);
            }
        }
        return uf.size(p - 1);
    }
}

class UnionFind {
    
    private int[] parents;
    private int[] sizes;
    
    public UnionFind(int n) {
        parents = IntStream.range(0, n).toArray();
        sizes = new int[n];
        Arrays.fill(sizes, 1);
    }
    
    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x != y) {
            sizes[y] += sizes[x];
            parents[x] = y;
        }
    }
    
    public int find(int x) {
        if (parents[x] == x) {
            return x;
        } else {
            parents[x] = find(parents[x]);
            return parents[x];
        }
    }
    
    public int size(int x) {
        return sizes[find(x)];
    }
}
