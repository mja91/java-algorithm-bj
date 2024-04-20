package String;

import java.util.Scanner;

public class 단어_순서_뒤집기 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int count = 1;
        int num = Integer.parseInt(sc.nextLine());
        for (int i=0; i<num; i++) {
            String str = sc.nextLine();
            String[] arr = str.split(" ");
            StringBuilder result = new StringBuilder();
            for (int j = arr.length - 1; j >= 0; j--) {
                result.append(arr[j]).append(" ");
            }

            System.out.println("Case #" + count + ": " + result.substring(0, result.length() - 1));
            count++;
        }

        sc.close();
    }
}
