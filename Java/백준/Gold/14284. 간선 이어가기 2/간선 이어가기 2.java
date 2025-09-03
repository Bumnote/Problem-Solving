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
  static StringTokenizer st;

  static final List<List<Node>> vertex = new ArrayList<>();
  static int n, m, a, b, c, s, t;

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

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      vertex.get(a).add(new Node(b, c));
      vertex.get(b).add(new Node(a, c));
    }

    st = new StringTokenizer(br.readLine());
    s = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());
    br.close();
  }

  private static void solve() {
    int minDist = dijkstra();
    System.out.print(minDist);
  }

  private static int dijkstra() {

    final int INF = 987_654_321;
    int[] dist = new int[n + 1];
    Arrays.fill(dist, INF);
    dist[s] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(s, 0));

    while (!pq.isEmpty()) {
      Node curr = pq.poll();

      if (dist[curr.idx] != curr.cost) {
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

    return dist[t];
  }
}