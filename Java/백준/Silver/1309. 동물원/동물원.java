import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static long[][] dp;
  private static final long MOD = 9_901L;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    n = Integer.parseInt(br.readLine());
    br.close();
  }

  private static void solve() {

    dp = new long[n + 1][3];
    dp[1][0] = dp[1][1] = dp[1][2] = 1L;
    for (int i = 2; i <= n; i++) {
      dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
      dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
      dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
    }

    System.out.print((dp[n][0] + dp[n][1] + dp[n][2]) % MOD);
  }
}