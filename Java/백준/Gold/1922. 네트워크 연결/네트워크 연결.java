import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

  static class Edge implements Comparable<Edge> {

    int cost;
    int prev;
    int next;

    Edge(int cost, int prev, int next) {
      this.cost = cost;
      this.prev = prev;
      this.next = next;
    }

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(this.cost, o.cost);
    }
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m, a, b, c;
  private static int[] parent;
  private static final List<Edge> edges = new ArrayList<>();


  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  // MST -> Prim, Kruskal
  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());
    parent = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      // a -> b: 단방향 c
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      edges.add(new Edge(c, a, b));
    }

    br.close();
  }

  private static void solve() {
    Collections.sort(edges); // 비용 기준 오름차순 정렬

    int totalCost = 0;
    for (Edge edge : edges) {
      // 두 노드가 서로 다른 집합에 속해있으면 -> union
      if (find(edge.prev) != find(edge.next)) {
        union(edge.prev, edge.next);
        totalCost += edge.cost;
      }
    }

    System.out.print(totalCost);
  }

  private static void union(int nodeA, int nodeB) {
    int rootA = find(nodeA);
    int rootB = find(nodeB);

    if (rootA == rootB) {
      return;
    }

    if (rootA > rootB) {
      int tmp = rootA;
      rootA = rootB;
      rootB = tmp;
    }

    parent[rootB] = rootA;
  }

  private static int find(int node) {
    if (parent[node] != node) {
      parent[node] = find(parent[node]);
    }
    return parent[node];
  }
}