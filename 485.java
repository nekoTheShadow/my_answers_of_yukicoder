
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String[] tokens = stdin.nextLine().split(" ");
        int a = Integer.parseInt(tokens[0]), b = Integer.parseInt(tokens[1]);
        
        if (Math.abs(b) % Math.abs(a) == 0) {
            System.out.println(b / a);
        } else {
            System.out.println("NO");
        }
    }
}
