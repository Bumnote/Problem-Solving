import java.io.*;
import java.util.*;

public class Main {

  static int N, M, SUM;
  static int[] A;
  static int[] C;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // N: 앱의 개수
    M = Integer.parseInt(st.nextToken()); // M: 필요한 메모리

    A = new int[N + 1];
    C = new int[N + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    SUM = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      C[i] = Integer.parseInt(st.nextToken());
      SUM += C[i];
    }

    // dp 초기화
    dp = new int[N + 1][SUM + 1];
    br.close();
  }

  private static void solve() {

    for (int i = 1; i <= N; i++) {
      for (int j = 0; j <= SUM; j++) {
        if (j >= C[i]) {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - C[i]] + A[i]);
        } else {
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
        }
      }
    }

    int ans = 0;
    for (int i = 0; i <= SUM; i++) {
      if (dp[N][i] >= M) {
        ans = i;
        break;
      }
    }

    System.out.print(ans);
  }
}