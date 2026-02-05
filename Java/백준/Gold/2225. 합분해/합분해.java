import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, k;
  private static int[][] dp;
  private static final int MOD = 1_000_000_000;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    br.close();
  }

  private static void solve() {
    // 0 ~ n 까지의 정수를 k개 더해서 합이 n이 되는 경우의 수
    dp = new int[n + 1][k + 1]; // dp[i][j] : i를 j개의 수로 만드는 경우의 수
    for (int i = 0; i <= n; i++) {
      dp[i][1] = 1;
    }

    for (int i = 0; i <= n; i++) {
      for (int j = 2; j <= k; j++) {
        for (int k = 0; k <= i; k++) {
          dp[i][j] += dp[i - k][j - 1];
          dp[i][j] %= MOD;
        }
      }
    }
      
    System.out.print(dp[n][k]);
  }
}
