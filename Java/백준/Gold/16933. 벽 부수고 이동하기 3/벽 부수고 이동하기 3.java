import java.io.*;
import java.util.*;

class Main {

  static class Node {

    int y;
    int x;
    int dist;
    int destroyedWallCount;
    int flag;

    public Node(int y, int x, int dist, int destroyedWallCount, int flag) {
      this.y = y;
      this.x = x;
      this.dist = dist;
      this.destroyedWallCount = destroyedWallCount;
      this.flag = flag;
    }
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m, k;
  private static int[][] map;
  private static final int[] dys = {-1, 1, 0, 0}, dxs = {0, 0, -1, 1};

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    map = new int[n][m];
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }
    br.close();
  }

  private static void solve() {
    // (1, 1) -> (n, m)
    boolean[][][][] visited = new boolean[n][m][k + 1][2];
    visited[0][0][0][0] = true; // 처음 시작점 방문 처리

    Deque<Node> dq = new ArrayDeque<>();
    dq.offer(new Node(0, 0, 1, 0, 0));

    while (!dq.isEmpty()) {
      Node curr = dq.poll();

      if (curr.y == n - 1 && curr.x == m - 1) {
        System.out.print(curr.dist);
        return;
      }

      for (int d = 0; d < 4; d++) {
        int ny = curr.y + dys[d];
        int nx = curr.x + dxs[d];

        if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
          continue;
        }

        // 범위를 넘지 않고, 다음 위치, 벽을 부순 개수, 낮/밤 상태가 방문하지 않은 상태라면 -> 탐색
        if (!visited[ny][nx][curr.destroyedWallCount][curr.flag]) {
          // 다음 위치가 빈 칸이라면 -> 이동
          if (map[ny][nx] == 0) {
            visited[ny][nx][curr.destroyedWallCount][curr.flag] = true;
            dq.offer(new Node(ny, nx, curr.dist + 1, curr.destroyedWallCount, 1 - curr.flag));
          }
          // 다음 위치가 벽이라면 -> 벽을 부순 개수 판단
          else if (curr.destroyedWallCount < k && !visited[ny][nx][curr.destroyedWallCount + 1][1 - curr.flag]) {
            // 낮인 경우 -> 벽을 부수고 이동
            if (curr.flag == 0) {
              visited[ny][nx][curr.destroyedWallCount + 1][1 - curr.flag] = true;
              dq.offer(new Node(ny, nx, curr.dist + 1, curr.destroyedWallCount + 1, 1 - curr.flag));
            }
            // 밤인 경우 -> 벽을 부술 수 없으므로, 원래 자리 유지
            else {
              visited[curr.y][curr.x][curr.destroyedWallCount][1 - curr.flag] = true;
              dq.offer(new Node(curr.y, curr.x, curr.dist + 1, curr.destroyedWallCount, 1 - curr.flag));
            }
          }
        }
      }
    }

    System.out.print(-1);
  }
}
