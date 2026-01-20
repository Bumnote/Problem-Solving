import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, k;
  private static int[][] dp;
  private static int[] coins;
  private static final int INF = 987_654_321;


  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    coins = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static void solve() {
    dp = new int[n + 1][k + 1];
    dp[0][0] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= k; j++) {
        // i번째 동전을 사용하는 경우
        if (j - coins[i] >= 0) {
          dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
        }
        // i번째 동전을 사용하지 않는 경우
        else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    System.out.print(dp[n][k]);
  }
}
