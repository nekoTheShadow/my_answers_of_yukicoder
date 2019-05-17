package _0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String[] first = stdin.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);
        
        Map<Integer, Map<Integer, Long>> costs = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] line = stdin.readLine().split(" ");
            int a = Integer.parseInt(line[0]) - 1;
            int b = Integer.parseInt(line[1]) - 1;
            long c = Long.parseLong(line[2]);
            
            costs.computeIfAbsent(a, unused -> new HashMap<>()).put(b, c);
            costs.computeIfAbsent(b, unused -> new HashMap<>()).put(a, c);
        }

        
        long[] d1 = new long[n];
        long[] d2 = new long[n];
        PriorityQueue<Tuple> q = new PriorityQueue<>();
        Arrays.fill(d1, Long.MAX_VALUE);
        Arrays.fill(d2, Long.MAX_VALUE);
        d1[0] = 0;
        d2[0] = 0;
        q.add(new Tuple(0, 0, false));
        q.add(new Tuple(0, 0, true));
        
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            int u = t.ptr;
            if (!costs.containsKey(u)) {
                continue;
            }
            
            if (t.skipped) {
                for (Entry<Integer, Long> e : costs.get(u).entrySet()) {
                    int v = e.getKey();
                    long d = e.getValue();
                    if (d2[u] + d < d2[v]) {
                        d2[v] = d2[u] + d;
                        q.add(new Tuple(d2[v], v, true));
                    }
                }
            } else {
                for (Entry<Integer, Long> e : costs.get(u).entrySet()) {
                    int v = e.getKey();
                    long d = e.getValue();
                    
                    if (d1[u] + d < d1[v]) {
                        d1[v] = d1[u] + d;
                        q.add(new Tuple(d1[v], v, false));
                    }
                    
                    if (d1[u] < d2[v]) {
                        d2[v] = d1[u];
                        q.add(new Tuple(d2[v], v, true));
                    }
                }
            }
        }
        
        PrintWriter stdout = new PrintWriter(System.out);
        IntStream.range(0, n).mapToLong(i -> d1[i] + d2[i]).forEach(stdout::println);
        stdout.flush();
    }
    
    private static class Tuple implements Comparable<Tuple>{
        private long d;
        private int ptr;
        private boolean skipped;
        
        
        public Tuple(long d, int ptr, boolean skipped) {
            super();
            this.d = d;
            this.ptr = ptr;
            this.skipped = skipped;
        }

        @Override
        public int compareTo(Tuple other) {
            return Long.compare(this.d, other.d);
        }
    }
}