import java.io.*;
import java.util.*;

class Main {

    static int n, y, x, nxtY, nxtX;
    static final int MAX = 100;
    static int[][] map = new int[MAX + 1][MAX + 1];
    static boolean[][] visited;
    static int[] dys = {-1, 1, 0, 0}, dxs = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        init();

        solve();

    }

    private static void solve() {

        int length = 0;
        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; j <= MAX; j++) {
                if (map[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        nxtY = i + dys[k];
                        nxtX = j + dxs[k];
                        // 범위를 넘지 않는 경우 -> 탐색
                        if (inRange(nxtY, nxtX) && map[nxtY][nxtX] == 1)
                            cnt++;
                    }

                    // 주변의 1이 3개라면, 변 영역에 속한다.
                    if (cnt == 3) length++;
                        // 주변의 1이 2개라면, 모서리 영역에 속한다.
                    else if (cnt == 2) length += 2;
                }
            }
        }

        System.out.println(length); // 전체 둘레
    }


    private static boolean inRange(int y, int x) {
        return 0 <= y && y <= MAX && 0 <= x && x <= MAX;
    }


    private static void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            for (int a = y; a < y + 10; a++)
                for (int b = x; b < x + 10; b++)
                    map[a][b] = 1;
        }

        br.close();
    }
}
