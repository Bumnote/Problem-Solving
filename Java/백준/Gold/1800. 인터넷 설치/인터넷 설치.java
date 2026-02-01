import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, p, k, a, b, c;
  private static final int INF = (int) 1e9 + 1;
  private static int left, right;
  private static List<List<int[]>> graph = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    p = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    left = 0;
    right = -1;
    for (int i = 0; i < p; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      right = Math.max(right, c);

      graph.get(a).add(new int[]{b, c});
      graph.get(b).add(new int[]{a, c});
    }

    br.close();
  }

  private static void solve() {

    int answer = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      boolean flag = dijkstra(mid);

      if (flag) {
        answer = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    System.out.print(answer);
  }

  private static boolean dijkstra(int limit) {

    // 1 -> N
    int[] trace = new int[n + 1];
    Arrays.fill(trace, INF);
    trace[1] = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
    pq.offer(new int[]{1, 0}); // {index, traceCount}

    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int currNode = curr[0];
      int currTrace = curr[1];

      if (trace[currNode] < currTrace) {
        continue;
      }

      for (int[] nxt : graph.get(currNode)) {
        int nxtNode = nxt[0];
        int nxtTrace = nxt[1] > limit ? 1 : 0;

        if (trace[nxtNode] > currTrace + nxtTrace) {
          trace[nxtNode] = currTrace + nxtTrace;
          pq.offer(new int[]{nxtNode, trace[nxtNode]});
        }
      }
    }

    return trace[n] <= k;
  }
}