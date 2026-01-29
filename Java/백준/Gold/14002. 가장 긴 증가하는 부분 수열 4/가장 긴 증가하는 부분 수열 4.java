import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  public static void solve() {

    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    int longestSize = 1;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      longestSize = Math.max(longestSize, dp[i]);
    }

    Deque<Integer> dq = new ArrayDeque<>();
    for (int i = n - 1; i >= 0; i--) {
      if (dp[i] == longestSize) {
        dq.offer(arr[i]);
        longestSize--;
      }
    }

    sb.append(dq.size()).append("\n");
    while (!dq.isEmpty()) {
      sb.append(dq.pollLast()).append(" ");
    }

    System.out.print(sb);
  }
}