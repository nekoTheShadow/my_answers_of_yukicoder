package _1170;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public void exec() {
        int n = stdin.nextInt();
        long a = stdin.nextLong();
        long b = stdin.nextLong();
        long[] x = stdin.nextLongArray(n);

        UnionFind uf = new UnionFind(n);
        int[] imos = new int[n];
        for (int i = 0; i < n; i++) {
            int p = ArrayUtils.bisectLeft(x, x[i]+a);
            int q = ArrayUtils.bisectRight(x, x[i]+b);
            if (p < q) {
                uf.union(i, p);
                imos[p]++;
                imos[q-1]--;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            imos[i+1] += imos[i];
        }
        for (int i = 0; i < n - 1; i++) {
            if (imos[i] > 0) {
                uf.union(i, i+1);
            }
        }

        for (int i = 0; i < n; i++) {
            stdout.println(uf.size(i));
        }
    }

    public static class ArrayUtils {
        private ArrayUtils() {}

        public static void reverse(int[] a) {
            for (int i = 0, n = a.length; i < n/2; i++) {
                int t = a[i];
                a[i] = a[n-i-1];
                a[n-i-1] = t;
            }
        }

        public static void reverse(long[] a) {
            for (int i = 0, n = a.length; i < n/2; i++) {
                long t = a[i];
                a[i] = a[n-i-1];
                a[n-i-1] = t;
            }
        }

        public static <T> void reverse(T[] a) {
            for (int i = 0, n = a.length; i < n/2; i++) {
                T t = a[i];
                a[i] = a[n-i-1];
                a[n-i-1] = t;
            }
        }

        public static int bisectLeft(int[] a, int x) {
            int ng = -1;
            int ok = a.length;
            while (Math.abs(ok-ng) > 1) {
                int mi = (ok+ng)/2;
                if (a[mi] >= x) {
                    ok = mi;
                } else {
                    ng = mi;
                }
            }
            return ok;
        }

        public static int bisectRight(int[] a, int x) {
            int ng = -1;
            int ok = a.length;
            while (Math.abs(ok-ng) > 1) {
                int mi = (ok+ng)/2;
                if (a[mi] > x) {
                    ok = mi;
                } else {
                    ng = mi;
                }
            }
            return ok;
        }

        public static int bisectLeft(long[] a, long x) {
            int ng = -1;
            int ok = a.length;
            while (Math.abs(ok-ng) > 1) {
                int mi = (ok+ng)/2;
                if (a[mi] >= x) {
                    ok = mi;
                } else {
                    ng = mi;
                }
            }
            return ok;
        }

        public static int bisectRight(long[] a, long x) {
            int ng = -1;
            int ok = a.length;
            while (Math.abs(ok-ng) > 1) {
                int mi = (ok+ng)/2;
                if (a[mi] > x) {
                    ok = mi;
                } else {
                    ng = mi;
                }
            }
            return ok;
        }

        public static <T> int bisectLeft(List<? extends Comparable<? super T>> a, T x) {
            int ng = -1;
            int ok = a.size();
            while (Math.abs(ok-ng) > 1) {
                int mi = (ok+ng)/2;
                if (a.get(mi).compareTo(x) >= 0) {
                    ok = mi;
                } else {
                    ng = mi;
                }
            }
            return ok;
        }

        public static <T> int bisectRight(List<? extends Comparable<? super T>> a, T x) {
            int ng = -1;
            int ok = a.size();
            while (Math.abs(ok-ng) > 1) {
                int mi = (ok+ng)/2;
                if (a.get(mi).compareTo(x) > 0) {
                    ok = mi;
                } else {
                    ng = mi;
                }
            }
            return ok;
        }
    }


    public class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            this.parent = IntStream.range(0, n).toArray();
            this.size = new int[n];
            Arrays.fill(this.size, 1);
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean same(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) {
                return ;
            }

            if (size[x] < size[y]) {
                parent[x] = y;
                size[y] += size[x];
            } else {
                parent[y] = x;
                size[x] += size[y];
            }

        }

        public int size(int x) {
            return size[find(x)];
        }
    }


    private static final Stdin stdin = new Stdin();
    private static final Stdout stdout = new Stdout();

    public static void main(String[] args) {
        try {
            new Main().exec();
        } finally {
            stdout.flush();
        }
    }

    public static class Stdin {
        private BufferedReader stdin;
        private Deque<String> tokens;
        private Pattern delim;

        public Stdin() {
            stdin = new BufferedReader(new InputStreamReader(System.in));
            tokens = new ArrayDeque<>();
            delim = Pattern.compile(" ");
        }

        public String nextString() {
            try {
                if (tokens.isEmpty()) {
                    String line = stdin.readLine();
                    if (line == null) {
                        throw new UncheckedIOException(new EOFException());
                    }
                    delim.splitAsStream(line).forEach(tokens::addLast);
                }
                return tokens.pollFirst();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
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

        public void println(Object ... o) {
            String line = Arrays.stream(o).map(Objects::toString).collect(Collectors.joining(" "));
            stdout.println(line);
        }

        public void debug(Object ... objs) {
            String line = Arrays.stream(objs).map(this::deepToString).collect(Collectors.joining(" "));
            stdout.printf("DEBUG: %s%n", line);
        }

        private String deepToString(Object o) {
            if (o == null) {
                return "null";
            }

            Class<?> clazz = o.getClass();

            // 配列の場合
            if (clazz.isArray()) {
                int len = Array.getLength(o);
                String[] tokens = new String[len];
                for (int i = 0; i < len; i++) {
                    tokens[i] = deepToString(Array.get(o, i));
                }
                return "{" + String.join(",", tokens) + "}";
            }

            // toStringがOverrideされている場合
            if (Arrays.stream(clazz.getDeclaredMethods()).anyMatch(method -> method.getName().equals("toString") && method.getParameterCount() == 0)) {
                return Objects.toString(o);
            }

            // Tupleの場合 (フィールドがすべてpublicのJava Beans)
            try {
                List<String> tokens = new ArrayList<>();
                for (Field field : clazz.getFields()) {
                    String token = String.format("%s=%s", field.getName(), deepToString(field.get(o)));
                    tokens.add(token);
                }
                return String.format("%s:[%s]", clazz.getName(), String.join(",", tokens));
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public void flush() {
            stdout.flush();
        }
    }
}