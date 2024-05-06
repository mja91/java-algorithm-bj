import java.util.*;

public class Main {
    static char[][] grid = new char[5][5];
    static boolean[] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            grid[i] = scanner.next().toCharArray();
        }

        visited = new boolean[25];
        count = 0;

        combine(0, 0, 0);

        System.out.println(count);
    }

    static void combine(int start, int depth, int countS) {
        if (depth == 7) {
            if (countS >= 4 && isConnected()) {
                count++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            visited[i] = true;
            combine(i + 1, depth + 1, countS + (grid[i / 5][i % 5] == 'S' ? 1 : 0));
            visited[i] = false;
        }
    }

    static boolean isConnected() {
        boolean[] tempVisited = new boolean[25];
        int start = -1;
        for (int i = 0; i < 25; i++) {
            if (visited[i]) {
                start = i;
                break;
            }
        }

        if (start == -1) return false;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        tempVisited[start] = true;
        int connectedCount = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int x = current / 5;
            int y = current % 5;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                int next = nx * 5 + ny;
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !tempVisited[next] && visited[next]) {
                    queue.offer(next);
                    tempVisited[next] = true;
                    connectedCount++;
                }
            }
        }

        return connectedCount == 7;
    }
}