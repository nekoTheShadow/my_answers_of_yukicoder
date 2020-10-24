package yukicoder._0807;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public void exec() {
        int n = stdin.nextInt();
        int m = stdin.nextInt();
        Dijkstra2 dijkstra2 = new Dijkstra2(n);
        for (int i = 0; i < m; i++) {
            int a = stdin.nextInt() - 1;
            int b = stdin.nextInt() - 1;
            long c = stdin.nextLong();
            dijkstra2.add(a, b, c);
            dijkstra2.add(b, a, c);
        }
        long[] result = dijkstra2.run(0);
        for (int i = 0; i < n; i++) {
            stdout.println(result[i]);
        }
    }

    public class Dijkstra2 {
        private int n;
        private Map<Integer, List<Edge>> edges;

        public Dijkstra2(int n) {
            this.n = n;
            this.edges = new HashMap<>();
        }

        public void add(int from, int to, long cost) {
            this.edges.computeIfAbsent(from, unused -> new ArrayList<>()).add(new Edge(to, cost));
        }

        public long[] run(int start) {
            long[] score1 = new long[n];
            long[] score2 = new long[n];
            Arrays.fill(score1, Long.MAX_VALUE);
            Arrays.fill(score2, Long.MAX_VALUE);
            score1[start] = 0;
            score2[start] = 0;

            PriorityQueue<Tuple> q = new PriorityQueue<>();
            q.add(new Tuple(start, 0, false));
            q.add(new Tuple(start, 0, true));
            while (!q.isEmpty()) {
                Tuple t = q.remove();
                if (!edges.containsKey(t.current)) continue;
                if (!t.used && score1[t.current] < t.cost) continue;
                if (t.used && score2[t.current] < t.cost) continue;

                for (Edge edge : edges.get(t.current)) {
                    if (t.used) {
                        if (t.cost + edge.cost < score2[edge.next]) {
                            score2[edge.next] = t.cost + edge.cost;
                            q.add(new Tuple(edge.next, score2[edge.next], true));
                        }
                    } else {
                        if (t.cost + edge.cost < score1[edge.next]) {
                            score1[edge.next] = t.cost + edge.cost;
                            q.add(new Tuple(edge.next, score1[edge.next], false));
                        }
                        if (t.cost < score2[edge.next]) {
                            score2[edge.next] = t.cost;
                            q.add(new Tuple(edge.next, score2[edge.next], true));
                        }
                    }
                }
            }

            return IntStream.range(0, n).mapToLong(i -> score1[i]+score2[i]).toArray();
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
            private boolean used;

            public Tuple(int current, long cost, boolean used) {
                this.current = current;
                this.cost = cost;
                this.used = used;
            }

            @Override
            public int compareTo(Tuple other) {
                return Long.compare(this.cost, other.cost);
            }
        }
    }

    private static Stdin stdin = new Stdin(System.in);
    private static Stdout stdout = new Stdout();

    public static void main(String[] args) {
        try {
            new Main().exec();
        } finally {
            stdout.flush();
        }
    }

    public static class Stdin {
        private InputStream in;
        private byte[] buf;
        private int ptr;
        private int len;

        public Stdin(InputStream in) {
            this.in = in;
            this.buf = new byte[1024];
            this.ptr = 0;
            this.len = 0;
        }

        public String nextString() {
            StringBuilder sb = new StringBuilder();
            byte b;
            while ((b = read()) != -1) {
                sb.appendCodePoint(b);
            }
            return sb.toString();
        }

        public int nextInt() {
            return (int)nextLong();
        }

        public double nextDouble() {
            return Double.parseDouble(nextString());
        }

        public long nextLong() {
            boolean negative = false;
            int x = 0;

            byte b = read();
            if (b == '-') {
                negative = true;
            } else {
                x += b-'0';
            }

            while ((b=read()) != -1) {
                x *= 10;
                x += b-'0';
            }

            return negative ? -x : x;
        }

        private byte read() {
            byte b = readByte();
            if (b == '\r') {
                readByte(); // LFを読み飛ばす
                return -1;
            } else if (b == '\n' || b == ' ') {
                return -1;
            } else {
                return b;
            }
        }

        private byte readByte(){
            if (len == ptr) {
                try {
                    ptr = 0;
                    len = in.read(buf);
                    if (len == -1) return -1;
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            }
            return buf[ptr++];
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
    }

    public static class Stdout {
        private PrintWriter stdout;

        public Stdout() {
            stdout =  new PrintWriter(System.out, false);
        }

        public void printf(String format, Object ... args) {
            String line = String.format(format, args);
            if (line.endsWith(System.lineSeparator())) {
                stdout.print(line);
            } else {
                stdout.println(line);
            }
        }

        public void println(Object ... objs) {
            String line = Arrays.stream(objs).map(Objects::toString).collect(Collectors.joining(" "));
            stdout.println(line);
        }

        public void printDebug(Object ... objs) {
            String line = Arrays.stream(objs).map(this::deepToString).collect(Collectors.joining(" "));
            stdout.printf("DEBUG: %s%n", line);
            stdout.flush();
        }

        private String deepToString(Object o) {
            if (o == null) {
                return "null";
            }

            // 配列の場合
            if (o.getClass().isArray()) {
                int len = Array.getLength(o);
                String[] tokens = new String[len];
                for (int i = 0; i < len; i++) {
                    tokens[i] = deepToString(Array.get(o, i));
                }
                return "{" + String.join(",", tokens) + "}";
            }

            return Objects.toString(o);
        }

        private void flush() {
            stdout.flush();
        }
    }
}
