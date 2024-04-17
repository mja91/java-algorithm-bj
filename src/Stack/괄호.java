package Stack;

import java.util.Scanner;
import java.util.Stack;

public class 괄호 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i=0; i<num; i++) {
            String str = scanner.next();
            Stack stack = new Stack();
            for (int j=0; j<str.length(); j++) {
                char chr = str.charAt(j);
                if (chr == '(') {
                    stack.push(chr);
                } else if (stack.empty()) {
                    System.out.println("NO");
                    break;
                } else {
                    stack.pop();
                }
            }

            if (stack.empty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
