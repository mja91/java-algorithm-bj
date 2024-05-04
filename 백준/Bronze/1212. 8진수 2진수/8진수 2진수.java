import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String args[]) {
        String octNum = sc.nextLine();

        BigInteger decimal = new BigInteger(octNum, 8);

        String binary = decimal.toString(2);

        System.out.println(binary);

        sc.close();
    }
}