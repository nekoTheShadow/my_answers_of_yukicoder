package _938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class Main {
    public void solve(BufferedReader stdin, PrintWriter stdout) throws NumberFormatException, IOException {
        Pattern space = Pattern.compile(" ");

        int n = Integer.parseInt(stdin.readLine());
        String[] a = new String[n];
        String[] b = new String[n];
        for (int i = 0; i < n; i++) {
            String[] line = space.split(stdin.readLine());
            a[i] = line[0];
            b[i] = line[1];
        }

        Map<String, String> d = new HashMap<>();
        for (int i = 0; i < n; i++) {
            d.put(a[i], b[i]);
        }

        Set<String> answers = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            if (d.get(b[i]) == null) {
                answers.add(b[i]);
            }
        }

        answers.forEach(stdout::println);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter stdout = new PrintWriter(System.out, false);
        new Main().solve(stdin, stdout);
        stdout.flush();
    }
}
