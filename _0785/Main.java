package _0785;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int r = readline(stdin);
        int g = readline(stdin);
        int b = readline(stdin);
        int ans = (16 - r) * (16 - r) * (16 - g) * (16 - g) * (16 - b) * (16 - b);
        System.out.println(ans);
    }
    
    public static int readline(Scanner stdin) {
        String line = stdin.nextLine();
        return line.equals("NONE") ? 0 : line.split(",").length;
    }
}
