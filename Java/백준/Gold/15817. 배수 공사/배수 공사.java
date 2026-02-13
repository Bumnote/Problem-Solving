import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, x;
  private static int[] L, C;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken()); // n: 파이프 종류
    x = Integer.parseInt(st.nextToken()); // x: 목표 길이

    L = new int[n];
    C = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int length = Integer.parseInt(st.nextToken()); // length: 파이프의 길이
      int count = Integer.parseInt(st.nextToken()); // count: 파이프의 수량
      L[i] = length;
      C[i] = count;
    }

    br.close();
  }

  private static void solve() {
    // 여러 개의 파이프를 모아서 길이 x를 만들 수 있는 경우의 수
    int[] dp = new int[x + 1];
    dp[0] = 1; // 길이 0을 만드는 방법 = 1

    for (int i = 0; i < n; i++) {
      int length = L[i];
      int count = C[i];

      for (int j = x; j >= 0; j--) {
        for (int k = 1; k <= count; k++) {
          if (j - k * length < 0) {
            break;
          }
          dp[j] += dp[j - k * length];
        }
      }
    }

    System.out.print(dp[x]);
  }
}
