import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int t, n;
  private static int[] dp;
  private static final int LEN = 2_000, MOD = 100_999;

  public static void main(String[] args) throws Exception {

    dp = new int[LEN + 1];
    dp[0] = 1;

    for (int k = 1; k <= LEN; k++) {
      for (int i = LEN; i >= k; i--) {
        dp[i] = (dp[i] + dp[i - k]) % MOD;
      }
    }

    t = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= t; tc++) {
      init();
      solve();
    }

    System.out.print(sb);
    br.close();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
  }

  private static void solve() {
    sb.append(dp[n]).append("\n");
  }
}