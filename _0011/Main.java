package _0011;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        Set<Integer> c1 = new HashSet<>();
        Set<Integer> c2 = new HashSet<>();
        
        int w = stdin.nextInt();
        int h = stdin.nextInt();
        int n = stdin.nextInt();
        for (int time = 0; time < n; time++) {
            int s = stdin.nextInt();
            int k = stdin.nextInt();
            c1.add(s);
            c2.add(k);
        }
        
        int ans = (c1.size() * h) + (c2.size() * w) - (c1.size() * c2.size()) - n;
        System.out.println(ans);
    }

}
