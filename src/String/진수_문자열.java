package String;

import java.util.Scanner;

public class 진수_문자열 {

    /*
    문제
        정수 X가 주어진다. 정수 X는 항상 8진수, 10진수, 16진수 중에 하나이다.
        8진수인 경우에는 수의 앞에 0이 주어지고, 16진수인 경우에는 0x가 주어진다.
        X를 10진수로 바꿔서 출력하는 프로그램을 작성하시오.

    입력
        첫째 줄에 X가 주어진다. X는 10진수로 바꿨을 때, 1,000,000보다 작거나 같은 자연수이다. 16진수인 경우 알파벳은 소문자로만 이루어져 있다.

    출력
        첫째 줄에 입력받은 X를 10진수로 바꿔서 출력한다.

    예제 입력 1
        10
    예제 출력 1
        10

    예제 입력 2
        010
    예제 출력 2
        8

    예제 입력 3
        0x10
    예제 출력 3
        16

    예제 입력 4
        0x3f6
    예제 출력 4
        1014
     */

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

        sc.close();
    }
}
