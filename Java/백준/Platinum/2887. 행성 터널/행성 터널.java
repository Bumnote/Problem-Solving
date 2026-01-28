import java.io.*;
import java.util.*;

class Main {

  static class Edge implements Comparable<Edge> {

    int v1, v2, dist;

    Edge(int v1, int v2, int dist) {
      this.v1 = v1;
      this.v2 = v2;
      this.dist = dist;
    }

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(this.dist, o.dist);
    }
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, x, y, z;
  private static int[] rank;
  private static int[] parent;
  private static final List<int[]> xList = new ArrayList<>();
  private static final List<int[]> yList = new ArrayList<>();
  private static final List<int[]> zList = new ArrayList<>();


  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      z = Integer.parseInt(st.nextToken());
      // [0]: index, [1]: value
      xList.add(new int[]{i, x});
      yList.add(new int[]{i, y});
      zList.add(new int[]{i, z});
    }

    br.close();
  }

  public static void solve() {

    xList.sort((a, b) -> Integer.compare(a[1], b[1]));
    yList.sort((a, b) -> Integer.compare(a[1], b[1]));
    zList.sort((a, b) -> Integer.compare(a[1], b[1]));

    PriorityQueue<Edge> pq = new PriorityQueue<>();
    for (int i = 1; i < n; i++) {
      pq.offer(new Edge(xList.get(i - 1)[0], xList.get(i)[0], Math.abs(xList.get(i)[1] - xList.get(i - 1)[1])));
      pq.offer(new Edge(yList.get(i - 1)[0], yList.get(i)[0], Math.abs(yList.get(i)[1] - yList.get(i - 1)[1])));
      pq.offer(new Edge(zList.get(i - 1)[0], zList.get(i)[0], Math.abs(zList.get(i)[1] - zList.get(i - 1)[1])));
    }

    rank = new int[n];
    parent = new int[n];

    for (int i = 0; i < n; i++) {
      parent[i] = i;
      rank[i] = 1;
    }

    long totalSum = 0;
    int edgeCount = 0; 
    while (!pq.isEmpty()) {
      Edge e = pq.poll();

      if (edgeCount == n - 1) {
        break;
      }
      
      if (find(e.v1) == find(e.v2)) {
        continue;
      }

      union(e.v1, e.v2);
      edgeCount++;
      totalSum += e.dist;
    }

    System.out.print(totalSum);
  }

  private static void union(int x, int y) {

    int xRoot = find(x);
    int yRoot = find(y);

    if (xRoot == yRoot) {
      return;
    }

    if (rank[xRoot] < rank[yRoot]) {
      parent[xRoot] = yRoot;
    } else if (rank[xRoot] > rank[yRoot]) {
      parent[yRoot] = xRoot;
    } else {
      parent[yRoot] = xRoot;
      rank[xRoot]++;
    }
  }

  private static int find(int x) {
    if (parent[x] != x) {
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }
}