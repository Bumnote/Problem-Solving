import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, t;
  private static int[] w;
  private static int[] v;
  private static int[][] dp;


  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());

    w = new int[n + 1];
    v = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      w[i] = Integer.parseInt(st.nextToken());
      v[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void solve() {

    dp = new int[n + 1][t + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= t; j++) {
        // i번째 시험 범위를 공부할 수 있는 경우
        if (j - w[i] >= 0) {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
        }
        // i번째 시험 범위를 공부할 수 없는 경우
        else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    System.out.print(dp[n][t]);
  }
}
