import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[] dp;
  private static int[] numbers;
  private static final int LEN = 10_000;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    n = Integer.parseInt(br.readLine());
    numbers = new int[n];

    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(br.readLine());
    }
    br.close();
  }

  private static void solve() {
    dp = new int[LEN + 1];
    Arrays.fill(dp, 1);

    for (int i = 2; i <= LEN; i++) {
      dp[i] += dp[i - 2];
    }

    for (int i = 3; i <= LEN; i++) {
      dp[i] += dp[i - 3];
    }

    for (int num : numbers) {
      sb.append(dp[num]).append('\n');
    }

    System.out.print(sb);
  }
}