package _0052;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String s = stdin.nextLine();
        
        Deque<String> q1 = new ArrayDeque<>();
        Deque<String> q2 = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        
        q1.add(s);
        q2.add("");
        
        while (!q1.isEmpty()) {
            String s1 = q1.pollFirst(); // 残り
            String s2 = q2.pollFirst(); // 完成した文字列
            
            if (s1.isEmpty()) {
                set.add(s2);
            } else {
                q1.add(s1.substring(1));
                q2.add(s2 + s1.substring(0, 1));
                
                q1.add(s1.substring(0, s1.length() - 1));
                q2.add(s2 + s1.substring(s1.length() - 1));
            }
        }
        
        System.out.println(set.size());
    }
}
