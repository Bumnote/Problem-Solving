import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N = 20, SIZE = 5, cnt, nxtY, nxtX, stone;
    static int[][] map = new int[N][N];
    static int[] dys = {-1, 0, 1, 1}, dxs = {1, 1, 1, 0}; // 우상, 우, 우하, 하

    public static void main(String[] args) throws IOException {

        input();

        solve();

        System.out.println(sb.toString());

    }

    private static void solve() {

        // 완전 탐색 -> 20 * 20 * 6 * 8
        // 가장 왼쪽의 바둑알의 위치를 구하기 위해서 행 우선이 아닌, 열 우선 탐색 진행
        for (int x = 1; x < N; x++) {
            for (int y = 1; y < N; y++) {
                // 돌이 놓여있지 않은 경우 -> continue
                if (map[y][x] == 0)
                    continue;

                stone = map[y][x];
                for (int i = 0; i < 4; i++) {
                    cnt = 1; // 연속적인 돌의 개수
                    // 연속적인 우상, 우, 우하, 하 탐색 
                    for (int j = 1; j <= SIZE; j++) {
                        nxtY = y + dys[i] * j;
                        nxtX = x + dxs[i] * j;

                        if (inRange(nxtY, nxtX) && stone == map[nxtY][nxtX])
                            cnt++;
                        else break;
                    }

                    // 연속적인 좌하, 좌, 좌상, 좌 탐색
                    for (int j = -1; j >= -SIZE; j--) {
                        nxtY = y + dys[i] * j;
                        nxtX = x + dxs[i] * j;

                        if (inRange(nxtY, nxtX) && stone == map[nxtY][nxtX])
                            cnt++;
                        else break;
                    }

                    if (cnt == 5) {
                        sb.append(stone).append("\n").append(String.format("%d %d", y, x));
                        return;
                    }
                }
            }
        }

        sb.append(0);
    }

    private static void input() throws IOException {

        // 입력 부분
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
    }

    private static boolean inRange(int y, int x) {
        return 1 <= y && y < N && 1 <= x && x < N;
    }

}
