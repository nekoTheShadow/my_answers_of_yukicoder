package _0008;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        int p = stdin.nextInt();
        for (int time = 0; time < p; time++) {
            int n = stdin.nextInt();
            int k = stdin.nextInt();
            String answer = (n - 1) % (k + 1) == 0 ? "Lose" : "Win";
            System.out.println(answer);
        }
    }

}
