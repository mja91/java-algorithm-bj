import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
* <순서>
* 1. 모든 가능한 벽 3개의 조합 찾기 : 연구소에서 벽을 세울 수 있는 모든 가능한 위치의 조합(3개씩)을 찾기
* 2. 바이러스 확산 시뮬레이션 실행 : 각 조합마다 벽을 세운 후, 바이러스를 확산시키는 시뮬레이션 실행
* 3. 안전 영역 계산 : 바이러스 확산 후, 남아있는 안전 영역(바이러스가 없는 영역)의 크기를 계산
* 4. 최대 안전 영역 찾기 : 모든 조합에 대해 계산된 안전 영역의 크기 중 최대값 찾기
*/

public class Main {
    static int n, m;
    static int[][] lab;
    static List<int[]> viruses = new ArrayList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int maxSafeArea = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lab = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }

        placeWallsAndSimulate(0, 0, 0);
        System.out.println(maxSafeArea);
    }

    static void placeWallsAndSimulate(int start, int depth, int count) {
        if (count == 3) {
            simulateVirus();
            return;
        }

        for (int i = start; i < n * m; i++) {
            int x = i / m;
            int y = i % m;

            if (lab[x][y] == 0) {
                lab[x][y] = 1;
                placeWallsAndSimulate(i + 1, depth + 1, count + 1);
                lab[x][y] = 0;
            }
        }
    }

    static void simulateVirus() {
        int[][] tempLab = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(lab[i], 0, tempLab[i], 0, m);
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int[] virus : viruses) {
            queue.offer(new int[]{virus[0], virus[1]});
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && tempLab[nx][ny] == 0) {
                    tempLab[nx][ny] = 2;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        maxSafeArea = Math.max(maxSafeArea, calculateSafeArea(tempLab));
    }

    static int calculateSafeArea(int[][] lab) {
        int safeArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lab[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        return safeArea;
    }
}
