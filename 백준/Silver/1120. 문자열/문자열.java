import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        String A = arr[0];
        String B = arr[1];

        int minDiff = Integer.MAX_VALUE;
        for (int start = 0; start <= B.length() - A.length(); start++) {
            int diff = 0;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(start + i)) {
                    diff++;
                }
            }

            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        System.out.println(minDiff);

        br.close();
    }
}