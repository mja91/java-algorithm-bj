package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어_나누기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String result = solve(input);
        System.out.println(result);
        br.close();
    }

    private static String solve(String input) {
        int length = input.length();
        String minWord = null;

        for (int i=1; i<length; i++) {
            for (int j=i+1; j<length; j++) {
                String part1 = new StringBuilder(input.substring(0, i)).reverse().toString();
                String part2 = new StringBuilder(input.substring(i, j)).reverse().toString();
                String part3 = new StringBuilder(input.substring(j)).reverse().toString();

                String combined = part1 + part2 + part3;

                if (minWord == null || combined.compareTo(minWord) < 0) {
                    minWord = combined;
                }
            }
        }

        return minWord;
    }
}