import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[][] map;
  private static BigInteger[][] dp;
  private static final int[] dys = {0, 1}, dxs = {1, 0};

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    dp = new BigInteger[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static void solve() {

    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], BigInteger.valueOf(-1L));
    }

    System.out.print(dfs(0, 0));
  }

  private static BigInteger dfs(int y, int x) {

    if (y == n - 1 && x == n - 1) {
      return BigInteger.ONE;
    }

    if (!dp[y][x].equals(BigInteger.valueOf(-1L))) {
      return dp[y][x];
    }

    dp[y][x] = BigInteger.ZERO;
    int jump = map[y][x];
    if (jump == 0) {
      return dp[y][x];
    }
    for (int d = 0; d < 2; d++) {
      int ny = y + dys[d] * jump;
      int nx = x + dxs[d] * jump;
      if (inRange(ny, nx)) {
        dp[y][x] = dp[y][x].add(dfs(ny, nx));
      }
    }

    return dp[y][x];
  }

  private static boolean inRange(int y, int x) {
    return y >= 0 && y < n && x >= 0 && x < n;
  }
}