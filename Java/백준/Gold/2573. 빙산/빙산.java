import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] map;
    static int[][] blank;
    static boolean[][] visited;
    static int[] dys = {-1, 1, 0, 0};
    static int[] dxs = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        setUp();

        int time = 0;
        while (true) {

            melting();
            time++;

            int iceberg = 0;
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && map[i][j] > 0) {
                        visited[i][j] = true;
                        dfs(i, j);
                        iceberg++;
                    }
                }
            }

            if (iceberg >= 2) {
                System.out.println(time);
                break;
            } else if (iceberg == 0) {
                System.out.println(0);
                break;
            }

        }


    }

    private static void setUp() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }


    private static void melting() {

        blank = new int[N][M];
        int cnt;
        // 빙하 개수 세기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nxtY = i + dys[k];
                        int nxtX = j + dxs[k];
                        if (map[nxtY][nxtX] == 0)
                            cnt++;
                    }
                    blank[i][j] = cnt;
                }
            }
        }

        // 빙하 제거
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                map[i][j] = Math.max(0, map[i][j] - blank[i][j]);
    }

    private static void dfs(int y, int x) {

        for (int i = 0; i < 4; i++) {
            int nxtY = y + dys[i];
            int nxtX = x + dxs[i];
            if (!visited[nxtY][nxtX] && map[nxtY][nxtX] > 0) {
                visited[nxtY][nxtX] = true;
                dfs(nxtY, nxtX);
            }
        }
    }

}

