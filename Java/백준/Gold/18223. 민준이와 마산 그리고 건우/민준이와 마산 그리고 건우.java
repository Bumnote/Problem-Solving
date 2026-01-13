import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

  static class Node {

    int nxt;
    int dist;

    Node(int nxt, int dist) {
      this.nxt = nxt;
      this.dist = dist;
    }
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int v, e, p, a, b, c;
  private static final int INF = 987_654_321;
  private static final List<List<Node>> graph = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    v = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());
    p = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= v; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      // a <-> b: 양방향 c
      graph.get(a).add(new Node(b, c));
      graph.get(b).add(new Node(a, c));
    }

    br.close();
  }

  private static void solve() {

    int startToMasan = dijkstra(1, v);
    int startToP = dijkstra(1, p);
    int pToMasan = dijkstra(p, v);

    System.out.print(startToMasan == startToP + pToMasan ? "SAVE HIM" : "GOOD BYE");
  }

  private static int dijkstra(int s, int e) {

    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
    int[] dist = new int[v + 1];
    Arrays.fill(dist, INF);

    dist[s] = 0;
    pq.offer(new int[]{s, 0});

    while (!pq.isEmpty()) {

      int[] curr = pq.poll();
      int node = curr[0];
      int cost = curr[1];
      // 갱신이 이루어지지 않은 경우 -> continue
      if (dist[curr[0]] != cost) {
        continue;
      }

      for (Node nxtNode : graph.get(node)) {
        int newDist = dist[node] + nxtNode.dist;
        if (newDist < dist[nxtNode.nxt]) {
          dist[nxtNode.nxt] = newDist;
          pq.offer(new int[]{nxtNode.nxt, newDist});
        }
      }
    }

    return dist[e];
  }
}