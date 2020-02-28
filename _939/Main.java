package _939;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class Main {
    public void solve(BufferedReader stdin, PrintWriter stdout) throws NumberFormatException, IOException {
        Pattern space = Pattern.compile(" ");
        String[] line = space.split(stdin.readLine());

        long a = Long.parseLong(line[0]);
        long b = Long.parseLong(line[1]);

        long n = 0;
        for (long i = 31; i >= 0; i--) {
            if ((a & (1 << i)) == 0) {
                if ((b & (1 << i)) != 0) {
                    n++;
                }
            } else {
                if ((b & (1 << i)) == 0) {
                    stdout.println(0);
                    return ;
                }
            }
        }

        long ans = 1;
        for (long i = 0; i < n - 1; i++) ans *= 2;
        stdout.println(ans);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter stdout = new PrintWriter(System.out, false);
        new Main().solve(stdin, stdout);
        stdout.flush();
    }
}
