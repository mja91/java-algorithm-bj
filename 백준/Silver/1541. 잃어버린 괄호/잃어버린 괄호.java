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
        String[] arr = text.split("-");

        int minResult = 0;

        for (int i = 0; i < arr.length; i++) {
            for (String num : arr[i].split("\\+")) {
                if (i == 0) {
                    minResult += Integer.parseInt(num);
                } else {
                    minResult -= Integer.parseInt(num);
                }
            }
        }

        System.out.println(minResult);
    }
}