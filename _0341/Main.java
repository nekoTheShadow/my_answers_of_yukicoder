package _0341;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String s = stdin.nextLine();
        
        OptionalInt ans = Arrays.stream(s.split("[^\\…]+")).mapToInt(String::length).max();
        System.out.println(ans.orElse(0));
    }
}
