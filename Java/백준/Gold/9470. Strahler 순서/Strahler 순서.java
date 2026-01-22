import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int t, k, m, p, a, b;
  private static int[] inDegree, dp;
  private static List<List<Integer>> graph = new ArrayList<>();

  public static void main(String[] args) throws Exception {

    t = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= t; tc++) {
      init();
      solve();
    }

    br.close();
    System.out.print(sb);
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    k = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    p = Integer.parseInt(st.nextToken());

    graph.clear();
    for (int i = 0; i <= m; i++) {
      graph.add(new ArrayList<>());
    }

    inDegree = new int[m + 1];

    for (int i = 0; i < p; i++) {
      st = new StringTokenizer(br.readLine());
      // a -> b : DAG
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b);
      inDegree[b]++;
    }
  }

  public static void solve() {

    dp = new int[m + 1];

    Map<Integer, Integer> strahler = new HashMap<>();

    Deque<Integer> dq = new ArrayDeque<>();
    for (int i = 1; i <= m; i++) {
      if (inDegree[i] == 0) {
        dq.offer(i);
        strahler.put(i, 1);
        dp[i] = 1;
      }
    }

    while (!dq.isEmpty()) {

      Integer curr = dq.poll();

      for (int nxt : graph.get(curr)) {

        if (dp[nxt] < dp[curr]) {
          strahler.put(nxt, dp[curr]);
          dp[nxt] = dp[curr];
        } else if (dp[nxt] == dp[curr]) {
          dp[nxt] = dp[curr] + 1;
        }

        if (strahler.get(nxt) < dp[curr]) {
          strahler.put(nxt, dp[curr]);
          dp[nxt] = strahler.get(nxt);
        }

        inDegree[nxt]--;
        if (inDegree[nxt] == 0) {
          dq.offer(nxt);
        }
      }
    }

    sb.append(k).append(" ").append(dp[m]).append("\n");
  }
}
