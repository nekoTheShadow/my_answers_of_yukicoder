package _3022;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static int zero  = 'a' - 'a';
    static int one   = 'b' - 'a';
    static int three = 'd' - 'a';
    static int five  = 'f' - 'a';
    
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
       IntStream.rangeClosed(one, n).mapToObj(Main::fizzbuzz).forEach(System.out::println);
    }
    
    public static String fizzbuzz(int i) {
        if (i % three == zero && i % five == zero)  return "FizzBuzz";
        if (i % three == zero)  return "Fizz";
        if (i % five == zero)  return "Buzz";
        return String.valueOf(i);
    }
}
