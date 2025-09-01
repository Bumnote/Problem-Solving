import static java.util.Arrays.fill;

import java.io.*;
import java.util.*;

class Main {

  static class Node implements Comparable<Node> {

    int idx;
    int cost;

    public Node(int idx, int cost) {
      this.idx = idx;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.cost, o.cost);
    }
  }

  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static final StringBuilder sb = new StringBuilder();
  static StringTokenizer st;
  static List<List<Node>> vertex = new ArrayList<>();
  static int n, m, a, b, c, x, y;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= n; i++) {
      vertex.add(new ArrayList<>());
    }

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      vertex.get(a).add(new Node(b, c));
      vertex.get(b).add(new Node(a, c));
    }
  }

  private static void solve() throws IOException {

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      sb.append(dijkstra(x, y)).append('\n');
    }
    System.out.print(sb);
    sb.setLength(0);
    br.close();
  }

  private static int dijkstra(int start, int end) {

    final int INF = 987_654_321;
    int[] dist = new int[n + 1];
    fill(dist, INF);
    dist[start] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0));

    while (!pq.isEmpty()) {

      Node curr = pq.poll();
      if (curr.cost != dist[curr.idx]) {
        continue;
      }

      for (Node nxt : vertex.get(curr.idx)) {
        int newDist = dist[curr.idx] + nxt.cost;
        if (newDist < dist[nxt.idx]) {
          dist[nxt.idx] = newDist;
          pq.offer(new Node(nxt.idx, newDist));
        }
      }
    }

    return dist[end];
  }
}