import java.util.*;
import java.io.*;

class Main {

    static class Point {

        int idx, dist;

        Point(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

    }

    static Scanner sc = new Scanner(System.in);
    static int N, K;
    static final int MAX = 100_000;
    static boolean[] visited = new boolean[MAX + 1];

    public static void main(String[] args) {

        N = sc.nextInt();
        K = sc.nextInt();

        int minDist = Integer.MAX_VALUE;
        int cnt = 0;
        ArrayDeque<Point> dq = new ArrayDeque<>();
        dq.offer(new Point(N, 0));

        while (!dq.isEmpty()) {

            Point p = dq.poll();
            if (p.idx == K) {
                // 처음으로 최단거리로 도착하는 경우 -> 거리 갱신 및 cnt++
                if (minDist == Integer.MAX_VALUE) {
                    cnt++;
                    minDist = p.dist;
                // 같은 최단거리로 도착한 경우 -> cnt++
                } else if (minDist == p.dist) cnt++;
                // 동생을 찾았지만, 최단거리가 아닌 경우 -> break
                else break;
            }

            visited[p.idx] = true; // 방문 처리 먼저

            for (int nxt : new int[]{p.idx - 1, p.idx + 1, p.idx * 2}) {
                if (inRange(nxt) && !visited[nxt]) {
                    dq.offer(new Point(nxt, p.dist + 1));
                }
            }
        }

        System.out.println(minDist);
        System.out.println(cnt);
    }

    private static boolean inRange(int x) {
        return 0 <= x && x <= MAX;
    }

}