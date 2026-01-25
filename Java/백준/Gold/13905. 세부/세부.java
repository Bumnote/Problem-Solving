import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m, s, e, h1, h2, k;
  private static int[] dp;
  private static final int INF = 987_654_321;
  private static List<List<int[]>> graph = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken()); // n: 집의 개수
    m = Integer.parseInt(st.nextToken()); // m: 다리의 개수

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    st = new StringTokenizer(br.readLine());
    s = Integer.parseInt(st.nextToken()); // s: 숭이 출발 위치
    e = Integer.parseInt(st.nextToken()); // e: 혜빈이 위치

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      // h1 <-> h2: 무게 제한 k
      h1 = Integer.parseInt(st.nextToken());
      h2 = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      graph.get(h1).add(new int[]{h2, k});
      graph.get(h2).add(new int[]{h1, k});
    }

    br.close();
  }

  public static void solve() {
    // 출발지와 도착지가 존재 -> 다익스트라 또는 Prim
    // 최솟값들 중에서 최댓값을 구해야 한다.
    prim();

    System.out.print(sb);
  }

  private static void prim() {
    dp = new int[n + 1];
    Arrays.fill(dp, 0);
    boolean[] visited = new boolean[n + 1];
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

    dp[s] = INF;
    pq.offer(new int[]{s, dp[s]});
    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int curNode = curr[0];
      int curLimit = curr[1];

      if (curNode == e) {
        break;
      }

      if (visited[curNode]) {
        continue;
      }

      visited[curNode] = true; // 방문 처리

      for (int[] nxt : graph.get(curNode)) {
        int nxtNode = nxt[0];
        int nxtLimit = nxt[1];

        int newLimit = Math.min(curLimit, nxtLimit);

        if (!visited[nxtNode] && dp[nxtNode] < newLimit) {
          dp[nxtNode] = newLimit;
          pq.offer(new int[]{nxtNode, newLimit});
        }
      }
    }

    sb.append(dp[e]);
  }
}
