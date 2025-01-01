import java.io.*;
import java.util.*;

class Solution {

    static class Point {
        int cur_y;
        int cur_x;

        public Point(int y, int x) {
            this.cur_y = y;
            this.cur_x = x;
        }
    }

    static class Node {
        int cur_y;
        int cur_x;
        int cur_cnt;

        public Node(int y, int x, int cnt) {
            this.cur_y = y;
            this.cur_x = x;
            this.cur_cnt = cnt;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Point start, end;
    static ArrayDeque<Node> dq;

    static int T, N;
    static int[][] MAP;
    static boolean[][] visited;
    static int[] dys = {-1, 1, 0, 0};
    static int[] dxs = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());
            MAP = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    MAP[i][j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            sb.append("#").append(tc).append(" ").append(bfs(start, end)).append("\n");

        }

        System.out.println(sb.toString());

    }

    private static int bfs(Point start, Point end) {

        visited = new boolean[N][N];
        visited[start.cur_y][start.cur_x] = true; // 시작점 방문 처리

        dq = new ArrayDeque<>();
        dq.offer(new Node(start.cur_y, start.cur_x, 0));

        while (!dq.isEmpty()) {

            Node now = dq.poll();

            // 도착점에 도착하면 시간 반환
            if (now.cur_y == end.cur_y && now.cur_x == end.cur_x)
                return now.cur_cnt;

            for (int i = 0; i < 4; i++) {
                int nxt_y = now.cur_y + dys[i];
                int nxt_x = now.cur_x + dxs[i];
                // 범위를 넘지 않고, 방문이 불가능한 경우 -> 탐색 가능
                if (inRange(nxt_y, nxt_x) && !visited[nxt_y][nxt_x]) {
                    // 빈칸인 경우 -> 탐색 가능
                    if (MAP[nxt_y][nxt_x] == 0) {
                        visited[nxt_y][nxt_x] = true; // 방문 처리
                        dq.offer(new Node(nxt_y, nxt_x, now.cur_cnt + 1));
                    }
                    // 섬인 경우 -> 탐색 불가
                    else if (MAP[nxt_y][nxt_x] == 1)
                        continue;
                        // 소용돌이인 경우 -> 조건부 탐색 가능
                    else {
                        // 소용돌이가 멈추는 경우 -> 이동 가능
                        if (now.cur_cnt % 3 == 2) {
                            visited[nxt_y][nxt_x] = true; // 방문 처리
                            dq.offer(new Node(nxt_y, nxt_x, now.cur_cnt + 1));
                        }
                        // 소용돌이가 활동하는 경우 -> 현재 위치에서 시간만 증가하여 다시 offer
                        else {
                            dq.offer(new Node(now.cur_y, now.cur_x, now.cur_cnt + 1));
                        }
                    }
                }
            }
        }

        return -1;
    }

    private static boolean inRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < N;
    }

}