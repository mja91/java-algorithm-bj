import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] students = br.readLine().split(" ");
        String[] viewers = br.readLine().split(" ");

        long minCount = solve(N, students, viewers);

        System.out.println(minCount);

        br.close();
    }

    private static long solve(int N, String[] students, String[] viewers) {
        int superViewerQuota = Integer.parseInt(viewers[0]);
        int semiViewerQuota = Integer.parseInt(viewers[1]);

        long totalViewerCount = 0;
        for (int i = 0; i < N; i++) {
            int studentCount = Integer.parseInt(students[i]);
            totalViewerCount++;

            if (studentCount > superViewerQuota) {
                int remainingStudents = studentCount - superViewerQuota;
                totalViewerCount += (remainingStudents + semiViewerQuota - 1) / semiViewerQuota;
            }
        }

        return totalViewerCount;
    }
}