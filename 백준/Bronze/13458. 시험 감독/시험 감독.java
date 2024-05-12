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
        long superViewerQuota = Integer.parseInt(viewers[0]);
        long semiViewerQuota = Integer.parseInt(viewers[1]);

        long minCount = 0;
        for (int i=0; i<N; i++) {
            long studentCount = Integer.parseInt(students[i]);
            minCount++;

            if (studentCount > superViewerQuota) {
                long remainingStudentCount = studentCount - superViewerQuota;
                minCount += remainingStudentCount / semiViewerQuota;
                if (remainingStudentCount % semiViewerQuota != 0) {
                    minCount++;
                }
            }
        }

        return minCount;
    }
}