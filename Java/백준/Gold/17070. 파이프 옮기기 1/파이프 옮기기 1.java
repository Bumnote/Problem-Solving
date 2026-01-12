import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[][] map, dp;
  private static final int[] d = {0, 1, 2}; // 0: 가로, 1: 대각선, 2: 세로
  private static final int[] dys = {0, 1, 1}, dxs = {1, 1, 0};

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());

    map = new int[n][n];
    dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken()); // 0: 빈칸, 1: 벽
      }
    }
    br.close();
  }

  private static void solve() {

    dfs(0, 1, 0);

    System.out.print(dp[n - 1][n - 1]);
  }

  private static void dfs(int y, int x, int dir) {

    for (int i = 0; i < 3; i++) {
      if ((dir == 0 && i == 2) || (dir == 2 && i == 0)) {
        continue;
      }
      int ny = y + dys[i];
      int nx = x + dxs[i];
      // 범위를 넘지 않은 경우 -> 탐색 진행
      if (inRange(ny, nx)) {
        // 대각선인 경우
        if (i == 1) {
          if (map[ny][nx] == 0 && map[ny - 1][nx] == 0 && map[ny][nx - 1] == 0) {
            if (ny == n - 1 && nx == n - 1) {
              dp[ny][nx]++;
            } else {
              dfs(ny, nx, i);
            }
          }
        }
        // 가로 또는 세로인 경우
        else {
          if (map[ny][nx] == 0) {
            if (ny == n - 1 && nx == n - 1) {
              dp[ny][nx]++;
            } else {
              dfs(ny, nx, i);
            }
          }
        }
      }
    }
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }
}