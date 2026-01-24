import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, a, b;
  private static int[][] lines;
  private static int[] inDegree, dp;
  private static List<List<Integer>> graph = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());

    lines = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      lines[i][0] = a;
      lines[i][1] = b;
    }

    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    inDegree = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        // i번째 전깃줄이 j번째 전깃줄보다 아래에 있는 경우
        if (i != j && lines[i][0] < lines[j][0] && lines[i][1] < lines[j][1]) {
          inDegree[j]++;
          graph.get(i).add(j);
        }
      }
    }

    br.close();
  }

  public static void solve() {
    Deque<Integer> dq = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (inDegree[i] == 0) {
        dq.offer(i);
      }
    }

    dp = new int[n];
    Arrays.fill(dp, 1); // 자기 자신 자체가 하나의 전깃줄
    int maxLine = 0;
    while (!dq.isEmpty()) {
      Integer curr = dq.poll();

      for (Integer nxt : graph.get(curr)) {
        dp[nxt] = Math.max(dp[nxt], dp[curr] + 1);
        maxLine = Math.max(maxLine, dp[nxt]);
        inDegree[nxt]--;
        if (inDegree[nxt] == 0) {
          dq.offer(nxt);
        }
      }
    }

    System.out.println(n - (maxLine));
  }
}
