import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

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

    Deque<int[]> dq = new ArrayDeque<>();
    dq.offer(new int[]{0, 0, 1, 0, 0}); // [4] -> 0: 낮, 1: 밤

    while (!dq.isEmpty()) {
      int[] curr = dq.poll();
      int dist = curr[2];
      int destroyedWallCount = curr[3];
      int flag = curr[4];

      if (discover(curr, dist)) {
        return;
      }

      for (int d = 0; d < 4; d++) {
        int ny = curr[0] + dys[d];
        int nx = curr[1] + dxs[d];

        if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
          continue;
        }

        // 범위를 넘지 않고, 다음 위치, 벽을 부순 개수, 낮/밤 상태가 방문하지 않은 상태라면 -> 탐색
        if (!visited[ny][nx][destroyedWallCount][flag]) {
          // 다음 위치가 빈 칸이라면 -> 이동
          if (map[ny][nx] == 0) {
            visited[ny][nx][destroyedWallCount][flag] = true; // 방문 처리
            dq.offer(new int[]{ny, nx, dist + 1, destroyedWallCount, 1 - flag});
          }
          // 다음 위치가 벽이라면 -> 벽을 부순 개수 판단
          else if (destroyedWallCount < k && !visited[ny][nx][destroyedWallCount + 1][1 - flag]) {
            // 낮인 경우 -> 벽을 부수고 이동
            if (flag == 0) {
              visited[ny][nx][destroyedWallCount + 1][1 - flag] = true; // 방문 처리
              dq.offer(new int[]{ny, nx, dist + 1, destroyedWallCount + 1, 1 - flag});
            }
            // 밤인 경우 -> 벽을 부술 수 없으므로, 원래 자리 유지
            else {
              visited[curr[0]][curr[1]][destroyedWallCount][1 - flag] = true; // 방문 처리
              dq.offer(new int[]{curr[0], curr[1], dist + 1, destroyedWallCount, 1 - flag});
            }
          }
        }
      }
    }

    System.out.print(-1);
  }

  private static boolean discover(int[] curr, int dist) {
    if (curr[0] == n - 1 && curr[1] == m - 1) {
      System.out.print(dist);
      return true;
    }
    return false;
  }
}
