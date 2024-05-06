import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");
        int R = Integer.parseInt(nums[0]);
        int C = Integer.parseInt(nums[1]);

        String[] columns = new String[C];
        for (int i=0; i<columns.length; i++) {
            columns[i] = "";
        }

        for (int i=0; i<R; i++) {
            String text = br.readLine();
            for (int j=0; j<C; j++) {
                columns[j] += text.charAt(j);
            }
        }

        int removeCount = 0;
        while (true) {
            HashSet<String> set = new HashSet<>();
            boolean isDuplicate = false;

            for (int i=0; i<C; i++) {
                columns[i] = columns[i].substring(1);
                if (!set.add(columns[i])) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                break;
            }

            removeCount++;

            if (removeCount == R - 1) {
                break;
            }
        }

        System.out.println(removeCount);
    }
}