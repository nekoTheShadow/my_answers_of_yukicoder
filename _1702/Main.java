package _1702;
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
import java.util.Arrays;
import java.util.Deque;
import java.util.regex.Pattern;

public class Main {
    int n;
    String s;
    String t;
    long[][] memo;
    long mod = 1000000000 + 7;
    
    public void exec() {
        n = stdin.nextInt();
        s = stdin.nextString();
        
        long ans = 0;
        String yuki = "yukicoder";
        
        t = "yukicoder";
        newMemo();
        ans += f(0, 0);
        ans %= mod;
        
        for (int i = 0; i < t.length(); i++) {
            t = yuki.substring(0, i) + "?" + yuki.substring(i+1);
            newMemo();
            ans += f(0, 0);
            ans %= mod;
        }
        
        stdout.println(ans);
    }
    
    private long f(int p, int q) {
        if (q == t.length()) return 1;
        if (p == s.length()) return 0;
        
        if (memo[p][q]!=-1) return memo[p][q];
        
        long ans = 0;
        if (s.charAt(p) == t.charAt(q)) {
            ans += f(p+1, q+1);
            ans %= mod;
        }
        ans += f(p+1, q);
        ans %= mod;
        
        memo[p][q] = ans;
        return ans;
    }
    
    private void newMemo() {
        memo = new long[s.length()][t.length()];
        for (long[] row : memo) Arrays.fill(row, -1);
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