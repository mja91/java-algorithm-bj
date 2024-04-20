package String;

import java.util.Scanner;

public class 수_뒤집기 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int firstNum = sc.nextInt();
            String reverseStr = new StringBuilder(Integer.toString(firstNum)).reverse().toString();
            int secondNum = Integer.parseInt(reverseStr);
            int resultNum = firstNum + secondNum;
            String resultStr = Integer.toString(resultNum);

            if (check(resultStr)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }

    public static boolean check(String str) {
        int left = 0;
        int right = str.length()-1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
