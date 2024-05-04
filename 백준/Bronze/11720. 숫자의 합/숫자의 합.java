import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String nums = scanner.next();
        int result = 0;

        for (int i = 0; i < N; i++) {
            result += nums.charAt(i) - '0';
        }

        System.out.println(result);
        scanner.close();
    }
}
