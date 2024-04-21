package Stack;

import java.util.Scanner;
import java.util.Stack;

public class 괄호 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int num = sc.nextInt();
        boolean checker = true;

        for (int i=0; i<num; i++) {
            String str = sc.next();
            Stack stack = new Stack();
            for (int j=0; j<str.length(); j++) {
                char chr = str.charAt(j);
                if (chr == '(') {
                    stack.push(chr);
                } else if (stack.empty()) {
                    checker = false;
                } else {
                    stack.pop();
                }
            }

            if (checker && stack.empty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
