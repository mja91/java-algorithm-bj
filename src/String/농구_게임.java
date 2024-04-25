package String;

import java.util.Scanner;

public class 농구_게임 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int num = Integer.parseInt(sc.nextLine());
        int[] arr = new int[26];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            String name = sc.nextLine();
            char fc = name.charAt(0);
            int fcn = fc - 'a';
            arr[fcn]++;
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] >= 5) {
                sb.append((char) (j + 'a'));
            }
        }

        if (!"".equals(sb.toString())) {
            System.out.println(sb);
        } else {
            System.out.println("PREDAJA");
        }

        sc.close();
    }
}