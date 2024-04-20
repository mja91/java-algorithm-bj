package String;

import java.util.Scanner;

public class 단어_공부 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[26];

        String input = sc.next();

        for (int i=0; i<input.length(); i++) {
            char s = input.charAt(i);
            if ('A' <= s && s <= 'Z') {
                arr[s - 'A']++;
            } else {
                arr[s - 'a']++;
            }
        }

        int max = -1;
        char chr = '?';
        for (int i=0; i<26; i++) {
            if (max < arr[i]) {
                max = arr[i];
                chr = (char) (i + 'A');
            } else if (max == arr[i]) {
                chr = '?';
            }
        }
        System.out.println(chr);

        sc.close();
    }
}
