import java.io.*;
import java.util.*;

class Main {

  static class Edge {

    int from, to, cost;

    Edge(int from, int to, int cost) {
      this.from = from;
      this.to = to;
      this.cost = cost;
    }
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m, k, u, v, c;
  private static List<List<Edge>> graph = new ArrayList<>();
  private static int[] cities;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());

      graph.get(v).add(new Edge(v, u, c));
    }

    cities = new int[k];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++) {
      cities[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void solve() {

    PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1]));
    long[] dist = new long[n + 1];
    final long INF = (long) 1e15;
    Arrays.fill(dist, INF);

    for (int city : cities) {
      pq.offer(new long[]{city, 0});
      dist[city] = 0;
    }

    while (!pq.isEmpty()) {
      long[] cur = pq.poll();
      int from = (int) cur[0];
      long cost = cur[1];

      if (dist[from] < cost) {
        continue;
      }

      for (Edge edge : graph.get(from)) {
        int to = edge.to;
        long nextCost = cost + edge.cost;

        if (dist[to] > nextCost) {
          dist[to] = nextCost;
          pq.offer(new long[]{to, nextCost});
        }
      }
    }

    long maxCost = -1;
    int city = -1;
    for (int i = 1; i <= n; i++) {
      if (dist[i] > maxCost && dist[i] != INF) {
        maxCost = dist[i];
        city = i;
      }
    }

    sb.append(city).append("\n").append(maxCost);
    System.out.print(sb);
  }
}
