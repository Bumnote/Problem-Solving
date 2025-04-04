import java.io.*;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int T, N, M;
  static long[][] dp = new long[31][31];

  public static void main(String[] args) throws IOException {

    T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      init();
      solve();
    }
    // 정답 출력
    System.out.println(sb);
    br.close();
  }

  private static void init() throws IOException {

    // dp 초기화
    for (int i = 1; i <= 30; i++) {
      dp[1][i] = i;
      dp[i][i] = 1;
    }

    // dp[i][j]: 서쪽 i개 게이트 <-> 동쪽 j개 게이트 연결하는 경우의 수
    for (int i = 2; i <= 30; i++) {
      for (int j = i + 1; j <= 30; j++) {
        dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
      }
    }

  }

  private static void solve() throws IOException {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    sb.append(dp[N][M]).append("\n");
  }
}
