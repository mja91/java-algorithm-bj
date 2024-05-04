import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        solve(text);
        br.close();
    }

    private static void solve(String text) {
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean inTag = false;
        for (int i=0; i<text.length(); i++) { // O(n)

            char ch = text.charAt(i);

            if (ch == '<') {
                if (word.length() > 0) {
                    result.append(word.reverse());
                    word.setLength(0);
                }
                inTag = true;
                result.append(ch);
            } else if (ch == '>') {
                inTag = false;
                result.append(ch);
            } else if (inTag) {
                result.append(ch);
            } else {
                if (ch == ' ') {
                    if (word.length() > 0) {
                        result.append(word.reverse());
                        word.setLength(0);
                    }
                    result.append(ch);
                } else {
                    word.append(ch);
                }
            }
        }

        if (word.length() > 0) {
            result.append(word.reverse());
        }

        System.out.println(result.toString());
    }
}