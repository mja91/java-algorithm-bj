import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] times = new int[N];
        int[] prices = new int[N];
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            times[i] = Integer.parseInt(input[0]);
            prices[i] = Integer.parseInt(input[1]);
        }

        for (int i=0; i<N; i++) {
            int next = i + times[i];
            if (next <= N) {
                dp[next] = Math.max(dp[next], dp[i] + prices[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[N]);
    }
}