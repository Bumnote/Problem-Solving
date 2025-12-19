import static java.util.Arrays.fill;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m;
  private static int[][] map;
  private static final int[] dys = {-1, -1, -1}, dxs = {-1, 0, 1};
  private static final int INF = 987_654_321;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

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

    int[][][] dp = new int[n][m][3];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        fill(dp[i][j], INF);
      }
    }

    for (int j = 0; j < m; j++) {
      for (int d = 0; d < 3; d++) {
        dp[0][j][d] = map[0][j];
      }
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < m; j++) {
        for (int curDir = 0; curDir < 3; curDir++) {

          int prevY = i + dys[curDir];
          int prevX = j + dxs[curDir];

          if (prevY < 0 || prevY >= n || prevX < 0 || prevX >= m) {
            continue;
          }

          for (int prevDir = 0; prevDir < 3; prevDir++) {
            if (curDir == prevDir) {
              continue;
            }

            dp[i][j][curDir] = Math.min(
                dp[i][j][curDir],
                dp[prevY][prevX][prevDir] + map[i][j]
            );
          }
        }
      }
    }

    int answer = INF;
    for (int j = 0; j < m; j++) {
      for (int d = 0; d < 3; d++) {
        answer = Math.min(answer, dp[n - 1][j][d]);
      }
    }

    System.out.print(answer);
  }
}
