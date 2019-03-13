package _0304;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        for (int i = 0; i < 1000; i++) {
            String password = String.format("%03d", i);
            System.out.println(password);
            System.out.flush();
            
            String answer = stdin.nextLine();
            if (answer.equals("unlocked")) {
                System.exit(0);
            }
        }
    }
}
