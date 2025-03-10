import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

  static class Node {

    int y, x, dist;

    Node(int y, int x, int dist) {
      this.y = y;
      this.x = x;
      this.dist = dist;
    }
  }

  static int N, M, R, C, a, b, p, c, d, MIN;
  static int[][] map;
  static boolean[][] visited;
  static ArrayDeque<Node> dq;
  static int[] dys = {-1, 1, 0, 0}, dxs = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // N: 지도의 크기
    M = Integer.parseInt(st.nextToken()); // M: 지도의 크기
    R = Integer.parseInt(st.nextToken()); // R: 방의 개수
    C = Integer.parseInt(st.nextToken()); // C: 편의점의 개수

    map = new int[N + 1][M + 1];
    visited = new boolean[N + 1][M + 1];
    dq = new ArrayDeque<>();
    for (int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine());
      // 방 위치: (a, b) / 월세: p
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      p = Integer.parseInt(st.nextToken());
      map[a][b] = p;
    }

    for (int i = 0; i < C; i++) {
      st = new StringTokenizer(br.readLine());
      // 편의점 위치: (c, d)
      c = Integer.parseInt(st.nextToken());
      d = Integer.parseInt(st.nextToken());
      dq.offer(new Node(c, d, 0));
      visited[c][d] = true; // 방문 처리
    }

    br.close();
  }

  private static void solve() {
    MIN = 987_654_321;
    bfs();
    System.out.println(MIN);
  }

  private static void bfs() {

    while (!dq.isEmpty()) {

      Node curr = dq.poll();

      if (map[curr.y][curr.x] > 0) {
        MIN = Math.min(MIN, map[curr.y][curr.x] * curr.dist);
      }

      for (int i = 0; i < 4; i++) {
        int ny = curr.y + dys[i];
        int nx = curr.x + dxs[i];
        // 범위를 넘지 않고, 방문한 적이 없는 경우 -> 탐색 진행
        if (inRange(ny, nx) && !visited[ny][nx]) {
          visited[ny][nx] = true; // 방문 처리
          dq.offer(new Node(ny, nx, curr.dist + 1));
        }
      }
    }
  }

  private static boolean inRange(int y, int x) {
    return y >= 1 && y <= N && x >= 1 && x <= M;
  }

}
