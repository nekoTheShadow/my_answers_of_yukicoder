package _0652;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int a = stdin.nextInt();
        int b = stdin.nextInt();
        String s = stdin.next();

        char op = s.charAt(3);
        BigDecimal hour = new BigDecimal(s.substring(4));
        
        long minute = hour.multiply(BigDecimal.valueOf(60)).longValue();
        if (op == '-') {
            minute *= -1;
        }
        LocalTime ans = LocalTime.of(a, b).plusMinutes(minute).minusHours(9);
        System.out.println(ans);
    }
}