import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int y, x, cnt;

        Point(int curY, int curX, int cnt) {
            this.y = curY;
            this.x = curX;
            this.cnt = cnt;
        }

    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, MAX = 1;
    static char[][] map;
    static int[] dys = {-1, 1, 0, 0};
    static int[] dxs = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    int dist = bfs(i, j);
                    ans = Math.max(ans, dist);
                }
            }
        }

        System.out.println(ans);
    }

    private static int bfs(int y, int x) {

        boolean[][] visited = new boolean[N][M];
        visited[y][x] = true; // 시작점 방문 처리
        ArrayDeque<Point> dq = new ArrayDeque<>();
        dq.offer(new Point(y, x, 0));

        int dist = 0;
        while (!dq.isEmpty()) {

            Point cur = dq.poll();

            dist = Math.max(dist, cur.cnt);

            for (int i = 0; i < 4; i++) {
                int nxtY = cur.y + dys[i];
                int nxtX = cur.x + dxs[i];

                if (inRange(nxtY, nxtX) && !visited[nxtY][nxtX] && map[nxtY][nxtX] == 'L') {
                    visited[nxtY][nxtX] = true;
                    dq.offer(new Point(nxtY, nxtX, cur.cnt + 1));
                }
            }

        }

        return dist;
    }

    private static boolean inRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }

}