import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());

            solve(num);
            System.out.println();
        }
    }

    private static void solve(int num) {
        List<String> results = new ArrayList<>();
        dfs(1, num, "1", 1, 1, results);
        Collections.sort(results);

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static void dfs(int current, int num, String expr, long eval, long last, List<String> results) {
        if (current == num) {
            if (eval == 0) {
                results.add(expr);
            }
            return;
        }

        int next = current + 1;

        // 숫자 연결 (예: "1" + "2" -> "1 2")
        dfs(next, num, expr + " " + next, eval - last + last * 10 + (last >= 0 ? next : -next), last * 10 + (last >= 0 ? next : -next), results);

        // + 추가 (예: "1+2")
        dfs(next, num, expr + "+" + next, eval + next, next, results);

        // - 추가 (예: "1-2")
        dfs(next, num, expr + "-" + next, eval - next, -next, results);
    }
}