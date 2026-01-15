import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[] dp;
  private static int[] times;
  private static int[] inDegree;
  private static List<List<Integer>> graph = new ArrayList<>();


  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());

    times = new int[n + 1];
    inDegree = new int[n + 1];

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      times[i] = Integer.parseInt(st.nextToken());
      while (true) {
        int prev = Integer.parseInt(st.nextToken());
        if (prev == -1) {
          break;
        }
        graph.get(prev).add(i);
        inDegree[i]++;
      }
    }

    br.close();
  }

  private static void solve() {

    dp = new int[n + 1];
    Arrays.fill(dp, Integer.MIN_VALUE);
    Deque<Integer> dq = new ArrayDeque<>();

    for (int i = 1; i <= n; i++) {
      if (inDegree[i] == 0) {
        dq.offer(i);
        dp[i] = times[i];
      }
    }

    while (!dq.isEmpty()) {
      int curr = dq.poll();

      for (int nxt : graph.get(curr)) {
        inDegree[nxt]--;
        dp[nxt] = Math.max(dp[nxt], dp[curr] + times[nxt]);
        if (inDegree[nxt] == 0) {
          dq.offer(nxt);
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      sb.append(dp[i]).append('\n');
    }

    System.out.print(sb);
  }
}
