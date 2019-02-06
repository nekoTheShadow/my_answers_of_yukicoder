package _0779;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LocalDate from = LocalDate.of(1989, 1, 8);
        LocalDate to = LocalDate.of(2019, 4, 30);
        
        Scanner stdin = new Scanner(System.in);
        int y = stdin.nextInt();
        int m = stdin.nextInt();
        int d = stdin.nextInt();
        LocalDate date = LocalDate.of(y, m, d);
        
        String answer = (from.isEqual(date) || from.isBefore(date)) && (to.isEqual(date) || to.isAfter(date)) ? "Yes" : "No";
        System.out.println(answer);
    }
}
