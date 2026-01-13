import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m;
  private static int[][] map, dp;
  private static final int[] dys = {-1, 1, 0, 0}, dxs = {0, 0, -1, 1};

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    dp = new int[n][m];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

    map = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static void solve() {
    System.out.print(dfs(0, 0));
  }

  private static int dfs(int y, int x) {

    // 도착한 경우 -> return 1
    if (y == n - 1 && x == m - 1) {
      return 1;
    }

    // 이미 와 본 곳인 경우 -> 해당 경우의 수 return
    if (dp[y][x] != -1) {
      return dp[y][x];
    }

    int count = 0;

    for (int d = 0; d < 4; d++) {
      int ny = y + dys[d];
      int nx = x + dxs[d];

      // 범위를 넘지 않고, 내리막길인 경우 -> dfs 진행
      if (inRange(ny, nx) && map[y][x] > map[ny][nx]) {
        count += dfs(ny, nx);
      }
    }

    dp[y][x] = count;
    return count;
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < m;
  }
}