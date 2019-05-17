package _0424;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int h = stdin.nextInt();
        int w = stdin.nextInt();
        int sx = stdin.nextInt() - 1;
        int sy = stdin.nextInt() - 1;
        int gx = stdin.nextInt() - 1;
        int gy = stdin.nextInt() - 1;
        
        int[][] b = new int[h][w];
        for (int x = 0; x < h; x++) {
            String s = stdin.next();
            for (int y = 0; y < w; y++) {
                b[x][y] = (int)(s.charAt(y) - '0');
            }
        }
        
        boolean[][] visited = new boolean[h][w];
        visited[sx][sy] = true;
        
        Tuple[] diffs = new Tuple[] {new Tuple(0, 2), new Tuple(0, -2), new Tuple(2, 0), new Tuple(-2, 0)};
        
        ArrayDeque<Tuple> stack = new ArrayDeque<>();
        stack.add(new Tuple(sx, sy));
        while (!stack.isEmpty()) {
            Tuple tuple = stack.pop();
            int x1 = tuple.x;
            int y1 = tuple.y;
            
            for (Tuple diff : diffs) {                
                int x2 = x1 + diff.x / 2;
                int y2 = y1 + diff.y / 2;
                int x3 = x1 + diff.x;
                int y3 = y1 + diff.y;
                
                if (0 <= x2 && x2 < h 
                        && 0 <= y2 && y2 < w
                        && 0 <= x3 && x3 < h 
                        && 0 <= y3 && y3 < w
                        && b[x1][y1] == b[x3][y3]
                        && b[x2][y2] < b[x1][y1]
                        && !visited[x3][y3]) {
                    stack.push(new Tuple(x3, y3));
                    visited[x3][y3] = true;
                }
                
                if (0 <= x2 && x2 < h 
                        && 0 <= y2 && y2 < w
                        && Math.abs(b[x1][y1] - b[x2][y2]) <= 1
                        && !visited[x2][y2]) {
                    stack.push(new Tuple(x2, y2));
                    visited[x2][y2] = true;
                }
            }
        }
        
        System.out.println(visited[gx][gy] ? "YES" : "NO");
    }
    
    private static class Tuple {
        private int x;
        private int y;
        
        public Tuple(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
}
