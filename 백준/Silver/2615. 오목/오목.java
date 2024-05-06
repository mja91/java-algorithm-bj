import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[19][19];
        int [][] direction = {{0,1}, {1,0}, {1,1}, {-1,1}};

        // 바둑판 초기화&입력
        for (int i = 0; i < 19; i++) {
            String input = br.readLine();
            for (int j = 0, index = 0; j < 19; index += 2, j++) {
                board[i][j] = input.charAt(index);
            }
        }


        // 모든 칸에 대해 완성된 오목 찾기
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (board[i][j] == '1' || board[i][j] == '2') {
                    for (int k = 0; k < 4; k++) {
                        int ax = i; // x 좌표
                        int ay = j; // y 좌표
                        int cnt = 1; // 일치하는 바둑알 개수

                        while (true) {
                            ax += direction[k][0];
                            ay += direction[k][1];
                            if ( 0 <= ax && ax < 19 && 0 <= ay && ay < 19) {
                                if(board[i][j] == board[ax][ay])cnt ++;
                                else {
                                    break;
                                }
                            } else break;
                        }
                        ax = i;
                        ay = j;

                        // 증가하는 방향의 반대방향 탐색
                        while( true) {
                            ax -= direction[k][0];
                            ay -= direction[k][1];
                            if ( 0 <= ax && ax < 19 && 0 <= ay && ay < 19) {
                                if(board[i][j] == board[ax][ay])cnt ++;
                                else break;

                            } else break;
                        }

                        // 같은 오목눈이 5개일 경우
                        if (cnt == 5) {
                            System.out.println(board[i][j]);
                            System.out.println((i+1) + " " + (j+1));
                            return;
                        }

                    }
                }
            }
        }

//		아무도 이기지 않았을 경우
        System.out.println(0);
    }
}