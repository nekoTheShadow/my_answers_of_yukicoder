package _0825;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int a = stdin.nextInt(); // 1G
        int b = stdin.nextInt(); // 10G
        int c = stdin.nextInt();
        
        // x: 1Gの枚数
        // y: 10Gの枚数
        // z: 購入する商品の価格
        int ans = Integer.MAX_VALUE;
        for (int x = 0; x <= a; x++) {
            for (int y = 0; y <= b; y++) {
                for (int z = 1; z <= a + b * 10; z++) {
                    if (x + y * 10 < z) continue; // 購入不能
                    int p = (x + y * 10 - z) / 10; // おつりの1Gの枚数
                    int q = (x + y * 10 - z) % 10; // おつりの10Gの枚数
                    if (a + b - (x + y) + (p + q) == c) {
                        ans = Math.min(ans, z);
                    }
                }
            }
        }
        
        if (ans == Integer.MAX_VALUE) {
            System.out.println("Impossible");
        } else {
            System.out.println(ans);
        }
        
    }
}
