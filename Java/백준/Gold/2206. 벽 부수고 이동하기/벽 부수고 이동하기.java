import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m;
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
    boolean[][][] visited = new boolean[n][m][2];
    visited[0][0][0] = true; // 처음 시작점 방문 처리

    Deque<int[]> dq = new ArrayDeque<>();
    dq.offer(new int[]{0, 0, 1, 0});

    while (!dq.isEmpty()) {
      int[] curr = dq.poll();
      int dist = curr[2];
      int destroyedWallCount = curr[3];

      if (curr[0] == n - 1 && curr[1] == m - 1) {
        System.out.print(dist);
        return;
      }

      for (int d = 0; d < 4; d++) {
        int ny = curr[0] + dys[d];
        int nx = curr[1] + dxs[d];
        // 범위를 넘지 않으면서, 방문한 적이 없는 경우 -> 탐색
        if (inRange(ny, nx) && !visited[ny][nx][destroyedWallCount]) {
          // 벽이면서, 아직 벽을 부수지 않은 경우 -> 벽을 부수고 이동
          if (map[ny][nx] == 1 && destroyedWallCount == 0) {
            visited[ny][nx][1] = true;
            dq.offer(new int[]{ny, nx, dist + 1, 1});
          }
          // 벽이 아닌 경우 -> 그냥 이동
          else if (map[ny][nx] == 0) {
            visited[ny][nx][destroyedWallCount] = true;
            dq.offer(new int[]{ny, nx, dist + 1, destroyedWallCount});
          }
        }
      }
    }

    System.out.print(-1);
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < m;
  }
}
