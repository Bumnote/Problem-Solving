import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int idx, cnt;

        Point(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    static Scanner sc = new Scanner(System.in);
    static int N, K, MAX = 100_000;

    public static void main(String[] args) {

        N = sc.nextInt();
        K = sc.nextInt();

        int cnt = search();
        System.out.println(cnt);
    }

    private static int search() {

        ArrayDeque<Point> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX + 1];
        visited[N] = true; // 시작 지점 방문 처리
        dq.offer(new Point(N, 0));

        while (!dq.isEmpty()) {

            Point curr = dq.poll();

            if (curr.idx == K)
                return curr.cnt;

            for (int nxt : new int[]{curr.idx - 1, curr.idx + 1, curr.idx * 2}) {
                // 방문하지 않은 경우
                if (inRange(nxt) && !visited[nxt]) {
                    visited[nxt] = true; // 방문 처리
                    dq.offer(new Point(nxt, curr.cnt + 1));
                }
            }
        }

        return -1;
    }

    private static boolean inRange(int x) {
        return 0 <= x && x <= MAX;
    }

}