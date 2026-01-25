import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m, a, b, c, p, q;
  private static final long INF = Integer.MAX_VALUE;
  private static int[] houses, stores;
  private static List<List<int[]>> graph = new ArrayList<>();


  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      // a <-> b: c
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      graph.get(a).add(new int[]{b, c});
      graph.get(b).add(new int[]{a, c});
    }

    st = new StringTokenizer(br.readLine());
    p = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());

    houses = new int[p];
    stores = new int[q];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < p; i++) {
      houses[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < q; i++) {
      stores[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  public static void solve() {
    long[] result = dijkstra(); // {houseNum, dist}
    System.out.print(result[0]);
  }

  private static long[] dijkstra() {

    long[] dist = new long[n + 1];
    Arrays.fill(dist, INF);

    PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1]));
    for (int store : stores) {
      dist[store] = 0;
      pq.offer(new long[]{store, 0});
    }

    while (!pq.isEmpty()) {
      long[] curr = pq.poll();
      int curNode = (int) curr[0];
      int curDist = (int) curr[1];

      if (dist[curNode] != curDist) {
        continue;
      }

      for (int[] nxt : graph.get(curNode)) {
        int nxtNode = nxt[0];
        int nxtDist = nxt[1];

        long newDist = (long) curDist + nxtDist;
        if (newDist < dist[nxtNode]) {
          dist[nxtNode] = newDist;
          pq.offer(new long[]{nxtNode, newDist});
        }
      }
    }

    int idx = 0;
    long d = INF;
    Arrays.sort(houses);
    for (int house : houses) {
      if (dist[house] < d) {
        d = dist[house];
        idx = house;
      }
    }

    return new long[]{idx, d};
  }
}
