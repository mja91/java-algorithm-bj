package String;

import java.util.Scanner;

public class 수_뒤집기 {

    /*
    문제
        수 124를 뒤집으면 421이 되고 이 두 수를 합하면 545가 된다. 124와 같이 원래 수와 뒤집은 수를 합한 수가 좌우 대칭이 되는지 테스트 하는 프로그램을 작성하시오.

    입력
        입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄에 하나의 정수 N(10 ≤ N ≤ 100000)이 주어진다.

    출력
        각 테스트 케이스에 대해서 원래 수와 뒤집은 수를 합한 수가 좌우 대칭이 되면 YES를 아니면 NO를 한 줄에 하나씩 출력한다.

    예제 입력 1
        4
        13
        58
        120
        5056
    예제 출력 1
        YES
        NO
        YES
        NO
     */

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
