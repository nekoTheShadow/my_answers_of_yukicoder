package _0157;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int w = stdin.nextInt();
        int h = stdin.nextInt();
        
        char[][] matrix = new char[h][w];
        for (int i = 0; i < h; i++) {
            matrix[i] = stdin.next().toCharArray();
        }
        
        Set<Tuple> blanks1 = new HashSet<>();
        Set<Tuple> blanks2 = new HashSet<>();
        ArrayDeque<Tuple> stack = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] != '.') {
                    continue;
                }
                
                if (blanks1.isEmpty()) {
                    blanks1.add(new Tuple(i, j));
                    stack.addFirst(new Tuple(i, j));
                } else {
                    blanks2.add(new Tuple(i, j));
                }
            }
        }
        
        List<Tuple> diffs = new ArrayList<>();
        diffs.add(new Tuple( 1,  0));
        diffs.add(new Tuple(-1,  0));
        diffs.add(new Tuple( 0,  1));
        diffs.add(new Tuple( 0, -1));
        
        while (!stack.isEmpty()) {
            Tuple t = stack.removeFirst();
            for (Tuple d : diffs) {
                int x = t.x + d.x;
                int y = t.y + d.y;
                Tuple n = new Tuple(x, y);
                if (0 <= x && x < h && 0 <= y && y < w && blanks2.contains(n)) {
                    stack.add(n);
                    blanks1.add(n);
                    blanks2.remove(n);
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (Tuple blank1 : blanks1) {
            for (Tuple blank2 : blanks2) {
                int len = Math.abs(blank1.x - blank2.x) + Math.abs(blank1.y - blank2.y);
                ans = Math.min(ans, len);
            }
        }
        System.out.println(ans - 1);
    }
    
    private static class Tuple {
        private int x;
        private int y;
        
        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if ((obj == null) || !(obj instanceof Tuple)) {
                return false;
            }
            
            Tuple other = (Tuple) obj;
            return this.x == other.x && this.y == other.y;
        }
    }
}
