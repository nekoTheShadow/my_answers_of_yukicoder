package _0781;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int X = stdin.nextInt();
        int Y = stdin.nextInt();
        
        int[] counts = new int[Y + 1];
        for (int x = 1; x * x <= Y; x++) {
            for (int y = 0; y * y <= Y; y++) {
                int z = x * x + y * y;
                if (z <= Y) {
                    counts[z] += 1;
                }
            }
        }
        
        int ans = IntStream.rangeClosed(X, Y).map(i -> counts[i]).max().getAsInt();
        System.out.println(ans * 4);
    }
}
