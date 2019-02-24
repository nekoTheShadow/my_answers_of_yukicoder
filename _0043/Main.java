package _0043;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        int n = Integer.parseInt(stdin.nextLine());
        char[] s = new char[n * n];
        for (int i = 0; i < n; i++) {
            String t = stdin.nextLine();
            for (int j = 0; j < n; j++) s[i * n + j] = t.charAt(j);
        }
        
        List<Integer> games = new ArrayList<>();
        for (int i = 0; i < n * n; i++) {
            int x = i / n;
            int y = i % n;
            if (x < y && s[i] == '-') games.add(i);
        }

        
        int ans = Integer.MAX_VALUE;
        
        for (int bit = 0, len = games.size(); bit < (1 << len); bit++) {
            for (int i = 0; i < len; i++) {
                int x = games.get(i) / n;
                int y = games.get(i) % n;
                if ((bit & (1 << i)) == 0) {
                    s[n * x + y] = 'o';
                    s[n * y + x] = 'x';
                } else {
                    s[n * x + y] = 'x';
                    s[n * y + x] = 'o';                    
                }
            }
            
            int[] counter = new int[n];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (x >= y) continue;
                    if (s[n * x + y] == 'o') {
                        counter[x]++;
                    } else {
                        counter[y]++;
                    }
                }
            }
            
            List<List<Integer>> standings = IntStream.range(0, n)
                                                     .boxed()
                                                     .collect(Collectors.groupingBy(i -> counter[i]))
                                                     .entrySet()
                                                     .stream()
                                                     .sorted(Comparator.comparing(Entry::getKey, Comparator.reverseOrder()))
                                                     .map(Entry::getValue)
                                                     .collect(Collectors.toList());
            OptionalInt rank = IntStream.range(0, n) 
                                        .filter(i -> standings.get(i).contains(0))
                                        .findFirst();
            if (rank.isPresent()) ans = Math.min(ans, rank.getAsInt() + 1);
        }

        System.out.println(ans);
    }
}
