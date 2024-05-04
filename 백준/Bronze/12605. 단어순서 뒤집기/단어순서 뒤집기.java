import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int count = 1;
        int num = Integer.parseInt(sc.nextLine());
        for (int i=0; i<num; i++) {
            String str = sc.nextLine();
            String[] arr = str.split(" ");
            String result = "";
            int index = arr.length - 1;
            while (index >= 0) {
                result += arr[index] + " ";
                index--;
            }

            System.out.println("Case #" + count + ": " + result.substring(0, result.length() - 1));
            count++;
        }
    }
}