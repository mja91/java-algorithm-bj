import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        System.out.println(solve(S, T));
        br.close();
    }

    private static Integer solve(String S, String T) {
        char[] sArr = S.toCharArray();
        char[] tArr = T.toCharArray();

        HashMap<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < tArr.length; i++) {
            countT.put(tArr[i], i);
        }

        int[] countS = new int[26];
        for (int i = 0; i < sArr.length; i++) {
            char sChar = sArr[i];
            if (!countT.containsKey(sChar) || !validate(countS, tArr, countT.get(sChar))) continue;
            countS[sChar - 'a']++;
        }

        return countS[tArr[tArr.length - 1] - 'a'];
    }

    private static boolean validate(int[] countS, char[] tArr, int tIndex) {
        if (tIndex == 0) return true;
        return countS[tArr[tIndex] - 'a'] < countS[tArr[tIndex - 1] - 'a'];
    }
}