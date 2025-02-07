import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int y, x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, dist, SUM, MIN;
    static int[][] map;
    static boolean[] visited;
    static ArrayList<Point> homes, chickens;
    static ArrayList<Integer> lst;
    static ArrayDeque<ArrayList<Point>> dq;

    public static void main(String[] args) throws IOException {

        input();

        solve();

    }

    private static void solve() {

        setUp(0, lst);

        MIN = Integer.MAX_VALUE;
        while (!dq.isEmpty()) {
            SUM = 0;
            ArrayList<Point> points = dq.poll();
            for (Point home : homes) {
                dist = Integer.MAX_VALUE;
                for (Point point : points) {
                    dist = Math.min(dist, getDist(home, point)); // 치킨 거리
                }
                SUM += dist; // 도시의 치킨 거리 
            }
            MIN = Math.min(MIN, SUM); // 도시의 치킨 거리 최솟값 갱신
        }

        System.out.println(MIN);
    }

    private static void setUp(int cnt, ArrayList<Integer> lst) {

        // M개의 치킨집을 선택할 수 있는 모든 조합 수 저장
        if (cnt == M) {
            ArrayList<Point> points = new ArrayList<>();
            for (Integer idx : lst) {
                Point point = new Point(chickens.get(idx).y, chickens.get(idx).x);
                points.add(point);
            }
            dq.offer(points);
            return;
        }

        for (int i = 0; i < chickens.size(); i++) {
            // 인덱스의 나열을 오름차순 정렬 -> 조합
            if (!lst.isEmpty() && lst.get(lst.size() - 1) > i)
                continue;

            // 해당 인덱스에 방문하지 않은 경우 -> 탐색
            if (!visited[i]) {
                visited[i] = true; // 방문 처리
                lst.add(i);
                setUp(cnt + 1, lst);
                lst.remove(lst.size() - 1);
                visited[i] = false; // 복원 처리
            }
        }

    }


    private static int getDist(Point p1, Point p2) {
        return Math.abs(p2.y - p1.y) + Math.abs(p2.x - p1.x);
    }

    private static void input() throws IOException {

        // 입력 부분
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시의 크기 N x N 배열
        M = Integer.parseInt(st.nextToken()); //

        map = new int[N][N];
        homes = new ArrayList<>();
        chickens = new ArrayList<>();
        lst = new ArrayList<>();
        dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 집인 경우
                if (map[i][j] == 1)
                    homes.add(new Point(i, j));
                // 치킨집인 경우
                else if (map[i][j] == 2)
                    chickens.add(new Point(i, j));
            }
        }

        visited = new boolean[chickens.size()];
        br.close();
    }
}
