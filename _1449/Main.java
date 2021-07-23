package _1449;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class Main {
    public void exec() {
        int n = stdin.nextInt();
        int m = stdin.nextInt();
        int[] a = new int[m];
        int[] b = new int[m];
        long[] c = new long[m];
        for (int i = 0; i < m; i++) {
            a[i] = stdin.nextInt()-1;
            b[i] = stdin.nextInt()-1;
            c[i] = stdin.nextLong();
        }
        long[] t = stdin.nextLongArray(n);
        
        Dijkstra dijk = new Dijkstra(n, t);
        for (int i = 0; i < m; i++) {
            dijk.add(a[i], b[i], c[i]);
            dijk.add(b[i], a[i], c[i]);
        }
        dijk.run(0);
    }
    
    public class Dijkstra {
        private int n;
        private long m;
        private Map<Integer, List<Edge>> edges;
        private long[] T;

        public Dijkstra(int n, long[] T) {
            this.n = n;
            this.edges = new HashMap<>();
            this.T = T;
            this.m = 0;
        }

        public void add(int from, int to, long cost) {
            this.edges.computeIfAbsent(from, unused -> new ArrayList<>()).add(new Edge(to, cost));
            this.m = Math.max(m, cost);
        }

        public void run(int start) {
            long[][] score = new long[n][(int)m+2];
            for (long[] row : score) Arrays.fill(row, Long.MAX_VALUE);
            score[start][0] = 0;

            PriorityQueue<Tuple> q = new PriorityQueue<>();
            q.add(new Tuple(start, 0, 0));
            while (!q.isEmpty()) {
                Tuple t = q.remove();
                if (!edges.containsKey(t.current)) continue; // 次がない場合
                if (score[t.current][(int)t.sum] < t.cost) continue; // cost情報が古い場合
                
                long nxt = Math.min(T[t.current] + t.sum, m+1);
                for (Edge e : edges.get(t.current)) {
                    if (t.cost + T[t.current] + e.cost/(T[t.current]+t.sum) < score[e.next][(int)nxt]) {
                        score[e.next][(int)nxt] = t.cost + T[t.current] + e.cost/(T[t.current]+t.sum);
                        q.add(new Tuple(e.next, score[e.next][(int)nxt], nxt));
                    }
                }
            }
           
            
            long ans = Arrays.stream(score[n-1]).min().getAsLong();
            stdout.println(ans);
        }

        private class Edge {
            private int next;
            private long cost;

            public Edge(int next, long cost) {
                this.next = next;
                this.cost = cost;
            }
        }

        private class Tuple implements Comparable<Tuple>{
            private int current;
            private long cost;
            private long sum;

            public Tuple(int current, long cost, long sum) {
                this.current = current;
                this.cost = cost;
                this.sum = sum;
            }

            @Override
            public int compareTo(Tuple other) {
                return Long.compare(this.cost, other.cost);
            }
        }
    }


    private static final Stdin stdin = new Stdin(System.in);
    private static final Stdout stdout = new Stdout(System.out);

    public static void main(String[] args) {
        try {
            new Main().exec();
        } finally {
            stdout.flush();
        }
    }

    public static class Stdin {
        private Deque<String> queue;
        private BufferedReader in;
        private Pattern space;

        public Stdin(InputStream in) {
            this.queue = new ArrayDeque<>();
            this.in = new BufferedReader(new InputStreamReader(in));
            this.space = Pattern.compile(" ");
        }

        public String nextString() {
            if (queue.isEmpty()) {
                try {
                    String line = in.readLine();
                    if (line == null) {
                        throw new EOFException();
                    }
                    space.splitAsStream(line).forEach(this.queue::addLast);
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            }
            return queue.removeFirst();
        }

        public int nextInt() {
            return Integer.parseInt(nextString());
        }

        public double nextDouble() {
            return Double.parseDouble(nextString());
        }

        public long nextLong() {
            return Long.parseLong(nextString());
        }
        
        public BigInteger nextBigInteger() {
            return new BigInteger(nextString());
        }

        public String[] nextStringArray(int n) {
            String[] a = new String[n];
            for (int i = 0; i < n; i++) a[i] = nextString();
            return a;
        }

        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        public double[] nextDoubleArray(int n) {
            double[] a = new double[n];
            for (int i = 0; i < n; i++) a[i] = nextDouble();
            return a;
        }

        public long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }
        
        public BigInteger[] nexBigIntegerArray(int n) {
            BigInteger[] a = new BigInteger[n];
            for (int i = 0; i < n; i++) a[i] = nextBigInteger();
            return a;
        }
        
        public List<Integer> nextIntegerList(int n) {
            return nextList(n, this::nextInt);
        }
        
        public List<Long> nextLongList(int n) {
            return nextList(n, this::nextLong);
        }
        
        public List<Double> nextDoubleList(int n) {
            return nextList(n, this::nextDouble);
        }
        
        public List<String> nextStringList(int n) {
            return nextList(n, this::nextString);
        }
        
        public List<BigInteger> nextBigIntegerList(int n) {
            return nextList(n, this::nextBigInteger);
        }
        
        private <T> List<T> nextList(int n, Supplier<T> supplier) {
            List<T> a = new ArrayList<>();
            for (int i = 0; i < n; i++) a.add(supplier.get());
            return a;
        }
    }

    public static class Stdout {
        private PrintWriter stdout;

        public Stdout(PrintStream stdout) {
            this.stdout =  new PrintWriter(stdout, false);
        }

        public void println(Object ... objs) {
            for (int i = 0, len = objs.length; i < len; i++) {
                stdout.print(objs[i]);
                if (i != len-1) stdout.print(' ');
            }
            stdout.println();
        }

        public void flush() {
            stdout.flush();
        }
    }
}