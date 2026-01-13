import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[][] map;
  private static long[][] dp;
  private static final int[] dys = {-1, 0, 1, 0}, dxs = {0, 1, 0, -1};

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());

    dp = new long[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

    map = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static void solve() {
    long answer = 1;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        answer = Math.max(answer, dfs(i, j));
      }
    }

    System.out.print(answer);
  }

  private static long dfs(int y, int x) {

    // 메모이제이션 활용
    if (dp[y][x] != -1) {
      return dp[y][x];
    }

    dp[y][x] = 1;
    for (int d = 0; d < 4; d++) {
      int ny = y + dys[d];
      int nx = x + dxs[d];

      // 범위를 넘지 않고, 현재 지역보다 많은 대나무가 있는 경우 -> dfs 진행
      if (inRange(ny, nx) && map[y][x] < map[ny][nx]) {
        long count = 1;
        count += dfs(ny, nx);
        dp[y][x] = Math.max(dp[y][x], count);
      }
    }

    return dp[y][x];
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }
}
