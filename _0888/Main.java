package _0888;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        long n = stdin.nextLong();
        
        Set<Long> facts = new HashSet<>();
        for (long fact = 1; fact * fact <= n; fact++) {
            if (n % fact != 0) continue;
            facts.add(fact);
            facts.add(n / fact);
        }
        
        long ans = facts.stream().mapToLong(Long::longValue).sum();
        System.out.println(ans);
    }

}
