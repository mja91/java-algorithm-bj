import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> uniqueWords = new HashSet<>();
        for (int i=0; i<n; i++) {
            uniqueWords.add(br.readLine());
        }

        String[] sortedWords = solve(uniqueWords);

        for (String word : sortedWords) {
            System.out.println(word);
        }
    }

    private static String[] solve(Set<String> uniqueWords) {
        String[] words = uniqueWords.toArray(new String[0]);

        Arrays.sort(words, (word1, word2) -> {
            if (word1.length() != word2.length()) {
                return word1.length() - word2.length();
            } else {
                return word1.compareTo(word2);
            }
        });

        return words;
    }
}