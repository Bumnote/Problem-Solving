import java.io.*;
import java.util.*;

class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n, m, y, x, k;
    private static int[][] map;
    private static int[] commands;

    // 동, 서, 북, 남
    private static final int[] dys = {0, 0, -1, 1};
    private static final int[] dxs = {1, -1, 0, 0};

    // 0: 위, 1: 아래, 2: 북, 3: 남, 4: 서, 5: 동
    private static int[] dice = new int[6];

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void init() throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        commands = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            commands[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        br.close();
    }

    private static void solve() {

        for (int i = 0; i < k; i++) {

            int ny = y + dys[commands[i]];
            int nx = x + dxs[commands[i]];

            if (!inRange(ny, nx)) continue;

            roll(commands[i]);

            if (map[ny][nx] == 0) {
                map[ny][nx] = dice[1];
            } else {
                dice[1] = map[ny][nx];
                map[ny][nx] = 0;
            }

            y = ny;
            x = nx;

            sb.append(dice[0]).append("\n");
        }

        System.out.print(sb);
    }

    private static void roll(int dir) {

        int temp = dice[0];

        switch (dir) {

            case 0: // 동
                dice[0] = dice[4];
                dice[4] = dice[1];
                dice[1] = dice[5];
                dice[5] = temp;
                break;

            case 1: // 서
                dice[0] = dice[5];
                dice[5] = dice[1];
                dice[1] = dice[4];
                dice[4] = temp;
                break;

            case 2: // 북
                dice[0] = dice[3];
                dice[3] = dice[1];
                dice[1] = dice[2];
                dice[2] = temp;
                break;

            case 3: // 남
                dice[0] = dice[2];
                dice[2] = dice[1];
                dice[1] = dice[3];
                dice[3] = temp;
                break;
        }
    }

    private static boolean inRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}
