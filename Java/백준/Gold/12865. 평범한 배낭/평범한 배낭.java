import java.io.*;
import java.util.*;

class Main {

  static int N, K;
  static int[] W, V;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // N: 물건의 개수
    K = Integer.parseInt(st.nextToken()); // K: 최대 담을 있는 무게

    W = new int[N + 1];
    V = new int[N + 1];
    dp = new int[K + 1];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      W[i] = Integer.parseInt(st.nextToken()); // W: 무게
      V[i] = Integer.parseInt(st.nextToken()); // V: 가치
    }

    br.close();
  }

  private static void solve() {

    for (int i = 1; i <= N; i++) {
      for (int j = K; j > 0; j--) {
        if (j >= W[i]) {
          dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
        } else {
          dp[j] = dp[j];
        }
      }
    }

    System.out.print(dp[K]);
  }
}