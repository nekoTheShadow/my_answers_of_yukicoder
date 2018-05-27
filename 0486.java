
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String line = stdin.nextLine();
        
        int east = line.indexOf("OOO");
        int west = line.indexOf("XXX");
        
        String answer = (east == -1 && west == -1) ? "NA" :
                        (east == -1)  ? "West" :
                        (west == -1)  ? "East" :
                        (east < west) ? "East" : "West";
        System.out.println(answer);
    }
}
