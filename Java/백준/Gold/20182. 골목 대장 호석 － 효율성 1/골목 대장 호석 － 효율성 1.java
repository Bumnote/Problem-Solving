import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static final long INF = (long) 1e12;
  private static int n, m, a, b, c; // a <-> b: c 이하
  private static final List<List<long[]>> graph = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      // v1 <-> v2: cost
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      graph.get(v1).add(new long[]{v2, cost});
      graph.get(v2).add(new long[]{v1, cost});
    }

    br.close();
  }

  public static void solve() {
    long left = 1;
    long right = c;
    long answer = -1;
    while (left <= right) {
      long mid = (left + right) / 2;
      boolean result = dijkstra(mid);

      // 해당 금액으로 갈 수 있다면 더 적은 금액으로 검사
      if (result) {
        right = mid - 1;
        answer = mid; // 해당 금액으로는 가능하므로 정답 후보 저장
      } else {
        left = mid + 1;
      }
    }

    System.out.print(answer);
  }

  private static boolean dijkstra(long limit) {

    long[] dist = new long[n + 1];
    Arrays.fill(dist, INF);
    dist[a] = 0;

    PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1]));
    pq.offer(new long[]{a, 0});

    while (!pq.isEmpty()) {
      long[] curr = pq.poll();
      int currNode = (int) curr[0];
      long currCost = curr[1];

      if (dist[currNode] < currCost) {
        continue;
      }

      for (long[] nxt : graph.get(currNode)) {
        int nxtNode = (int) nxt[0];
        long nxtCost = nxt[1];
        long newCost = currCost + nxtCost;

        if (nxtCost <= limit && newCost <= c && newCost < dist[nxtNode]) {
          dist[nxtNode] = newCost;
          pq.offer(new long[]{nxtNode, newCost});
        }
      }
    }

    return dist[b] != INF;
  }
}
