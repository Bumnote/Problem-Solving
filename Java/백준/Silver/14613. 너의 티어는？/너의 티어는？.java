import java.io.*;
import java.util.*;

class Main {

  static double W, L, D, bronze, silver, gold, platinum, diamond;
  static double dp[][] = new double[21][3_001];

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    W = Double.parseDouble(st.nextToken()); // W: 승리할 확률
    L = Double.parseDouble(st.nextToken()); // L: 질 확률
    D = Double.parseDouble(st.nextToken()); // D: 비길 확률

    br.close();
  }

  private static void solve() {

    dp[0][2000] = 1.0;

    for (int i = 1; i <= 20; i++) {
      for (int j = 1000; j <= 3000; j++) {
        // 해당 점수를 얻지 못한 경우 -> continue
        if (dp[i - 1][j] == 0) {
          continue;
        }
        dp[i][j + 50] += dp[i - 1][j] * W; // 이긴 경우
        dp[i][j - 50] += dp[i - 1][j] * L; // 진 경우
        dp[i][j] += dp[i - 1][j] * D;      // 비긴 경우
      }
    }

    bronze = silver = gold = platinum = diamond = 0.0;
    for (int score = 1_000; score <= 3_000; score++) {
      if (1_000 <= score && score < 1_500) bronze += dp[20][score];
      else if (1_500 <= score && score < 2_000) silver += dp[20][score];
      else if (2_000 <= score && score < 2_500) gold += dp[20][score];
      else if (2_500 <= score && score < 3_000) platinum += dp[20][score];
      else diamond += dp[20][score];
    }

    System.out.printf("%.8f\n", bronze);
    System.out.printf("%.8f\n", silver);
    System.out.printf("%.8f\n", gold);
    System.out.printf("%.8f\n", platinum);
    System.out.printf("%.8f\n", diamond);
  }
}
