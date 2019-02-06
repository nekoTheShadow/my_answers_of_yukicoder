package _0782;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        int b = stdin.nextInt();
        int[] n = new int[t];
        for (int i = 0; i < t; i++) {
            n[i] = stdin.nextInt();
        }
        
        for (int i = 0; i < t; i++) {
            List<Integer> v = new ArrayList<>();
            while (n[i] != 0) {
                int mod = (n[i] % b < 0) ? (n[i] % b + Math.abs(b)) : (n[i] % b);
                n[i] -= mod;
                v.add(mod);
                n[i] /= b;
            }
            
            if (v.isEmpty()) {
                v.add(0);
            }
            Collections.reverse(v);
            String answer = v.stream().map(String::valueOf).collect(Collectors.joining());
            System.out.println(answer);
        }
    }
}
