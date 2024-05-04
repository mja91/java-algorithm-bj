import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String str = sc.next();
        if (str.startsWith("0x")) {
            System.out.println(Integer.parseInt(str.substring(2), 16));
        } else if (str.startsWith("0")) {
            System.out.println(Integer.parseInt(str, 8));
        } else {
            System.out.println(str);
        }
    }
}