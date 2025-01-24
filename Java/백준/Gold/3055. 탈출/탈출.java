import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int y, x, cnt;

        Point(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[][] time;
    static Point beaver;
    static int[] dys = {-1, 1, 0, 0};
    static int[] dxs = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        time = new int[R][C];
        ArrayDeque<Point> waters = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') beaver = new Point(i, j, 0);
                else if (map[i][j] == 'D') time[i][j] = Integer.MAX_VALUE;
                    // 시작점 저장
                else if (map[i][j] == '*') {
                    waters.offer(new Point(i, j, 0));
                    visited[i][j] = true; // 물의 위치 방문 처리
                }
            }
        }

        bfsW(waters); // 물을 먼저 이동

        int res = bfsD(beaver);
        System.out.println(res == -1 ? "KAKTUS" : res);
    }

    private static void bfsW(ArrayDeque<Point> waters) {

        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                time[i][j] = Integer.MAX_VALUE;

        while (!waters.isEmpty()) {
            Point curr = waters.poll();

            for (int i = 0; i < 4; i++) {
                int nxtY = curr.y + dys[i];
                int nxtX = curr.x + dxs[i];

                if (inRange(nxtY, nxtX) && !visited[nxtY][nxtX] && map[nxtY][nxtX] != 'X' && map[nxtY][nxtX] != 'D') {
                    visited[nxtY][nxtX] = true; // 방문 처리
                    time[nxtY][nxtX] = curr.cnt + 1;
                    waters.offer(new Point(nxtY, nxtX, curr.cnt + 1));
                }
            }
        }

    }

    private static int bfsD(Point beaver) {

        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                visited[i][j] = false; // 초기화

        ArrayDeque<Point> dq = new ArrayDeque<>();
        dq.offer(beaver);
        visited[beaver.y][beaver.x] = true; // 시작점 방문 처리
        while (!dq.isEmpty()) {

            Point curr = dq.poll();

            for (int i = 0; i < 4; i++) {
                int nxtY = curr.y + dys[i];
                int nxtX = curr.x + dxs[i];

                // 범위를 넘지 않고, 방문한 적이 없고, 물보다 더 빠르게 갈 수 있다면 -> 탐색
                if (inRange(nxtY, nxtX) && !visited[nxtY][nxtX] && curr.cnt + 1 < time[nxtY][nxtX]) {
                    // 다음 장소가 빈 공간이라면 -> 이동
                    if (map[nxtY][nxtX] == '.') {
                        visited[nxtY][nxtX] = true; // 방문 처리
                        dq.offer(new Point(nxtY, nxtX, curr.cnt + 1));
                    } else if (map[nxtY][nxtX] == 'D')
                        return curr.cnt + 1;
                }
            }

        }

        return -1;
    }


    private static boolean inRange(int y, int x) {
        return 0 <= y && y < R && 0 <= x && x < C;
    }
}

