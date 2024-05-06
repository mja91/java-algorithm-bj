import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] board = new int[s1.length() + 1][s2.length() + 1];
        int maxLength = 0;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    board[i][j] = board[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, board[i][j]);
                }
            }
        }

        System.out.println(maxLength);
    }
}