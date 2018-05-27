
import java.util.Scanner;


public class Main {
    public static long power(long x, long y, long z) {
        if (y == 0) return 1;
        return y % 2 == 0 ? power((x * x) % z, y / 2, z) : (power(x, y - 1, z) * x) % z;
    }
    
    
    
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        long m = Long.parseLong(stdin.nextLine());
        
        long answer = (2017 + power(2017 * 2017, 2017, m)) % m;
        System.out.println(answer);
    }
}
