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

  private static int n, m, x, y, k;
  private static int[][] dp;
  private static int[] inDegree;
  private static List<Integer> basicParts = new ArrayList<>();
  private static Map<Integer, Integer> basicPartCount = new HashMap<>();
  private static final List<List<int[]>> graph = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    n = Integer.parseInt(br.readLine());
    inDegree = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      // x를 만드는 데, y개의 부품이 k개 필요하다.
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      graph.get(y).add(new int[]{x, k});
      inDegree[x] += k;
    }

    br.close();
  }

  private static void solve() {

    findBasicParts();

    topologicalSort();

    for (int basicPart : basicParts) {
      sb.append(basicPart).append(" ").append(dp[n][basicPart]).append("\n");
    }

    System.out.print(sb);
  }

  private static void topologicalSort() {

    dp = new int[n + 1][n + 1];
    for (int basicPart : basicParts) {
      dp[basicPart][basicPart] = 1;
    }

    Deque<Integer> dq = new ArrayDeque<>();
    for (int basicPart : basicParts) {
      dq.offer(basicPart);
    }

    while (!dq.isEmpty()) {
      int currPart = dq.poll();

      for (int[] nxtPart : graph.get(currPart)) {
        int nxtPartNum = nxtPart[0];
        int neededCount = nxtPart[1];

        inDegree[nxtPartNum] -= neededCount;
        for (int basicPart : basicParts) {
          dp[nxtPartNum][basicPart] += dp[currPart][basicPart] * neededCount;
        }

        if (inDegree[nxtPartNum] == 0) {
          dq.offer(nxtPartNum);
        }
      }
    }
  }

  private static void findBasicParts() {

    for (int i = 1; i <= n; i++) {
      if (inDegree[i] == 0) {
        basicPartCount.put(i, 1);
        basicParts.add(i);
      }
    }
  }

}
