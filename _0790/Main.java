package _0790;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int ans = 0;
        loop: for (int bit = 0; bit < (1 << (2 * n)); bit++) {
            if (Integer.bitCount(bit) != n) continue;
            
            int x = 0;
            int y = 0;
            for (int i = 0; i < 2 * n; i++) {
                if ((bit & (1 << i)) == 0) {
                    x++;
                } else {
                    y++;
                }
                
                if (y < x) continue loop;
            }
            
            ans++;
        }
        
        System.out.println(ans);
    }
}
