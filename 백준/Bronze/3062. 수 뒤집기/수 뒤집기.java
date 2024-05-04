import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Integer t = sc.nextInt();
        for (int i=0; i<t; i++) {
            Integer firstNum = sc.nextInt();
            String numStr = firstNum.toString();
            char[] arr = numStr.toCharArray();
            String reverseStr = "";
            int index = arr.length-1;
            while (index >= 0) {
                reverseStr += Character.toString(arr[index]);
                index--;
            }
            int secondNum = Integer.parseInt(reverseStr);
            Integer resultNum = firstNum + secondNum;
            String resultStr = resultNum.toString();
            boolean result = check(resultStr);

            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    
    private static boolean check(String str) {
        int left = 0;
        int right = str.length()-1;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}