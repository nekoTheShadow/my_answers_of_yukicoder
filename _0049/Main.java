package _0049;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String s = stdin.nextLine();
        
        List<String> tokens = new ArrayList<>();
        StringBuilder token = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '+' || ch == '*') {
                tokens.add(token.toString());
                tokens.add(Character.toString(ch));
                token = new StringBuilder();
            } else {
                token.append(ch);
            }
        }
        tokens.add(token.toString());
        
        List<Integer> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        for (int i = 1; i < tokens.size(); i++) {
            if (i % 2 == 0) {
                numbers.add(Integer.parseInt(tokens.get(i)));
            } else {
                operators.add(tokens.get(i));
            }
        }
        
        int ans = Integer.parseInt(tokens.get(0));
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            String operator = operators.get(i);
            
            if (operator.equals("*")) {
                ans = ans + number;
            } else { 
             // operator.equals("+")
                ans = ans * number;
            }
        }
        
        System.out.println(ans);
    }
}
