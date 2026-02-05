import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
    dp = new int[n + 1][k + 1];

    // i를 1개의 수로 만드는 경우는 항상 1
    for (int i = 0; i <= n; i++) {
      dp[i][1] = 1;
    }

    for (int j = 2; j <= k; j++) {
      for (int i = 0; i <= n; i++) {
        if (i == 0) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
        }
      }
    }

    System.out.print(dp[n][k]);
  }
}
