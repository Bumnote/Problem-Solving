import java.io.*;
import java.util.*;

class Main {

  static class Edge implements Comparable<Edge> {

    int a, b;
    long cost;

    Edge(int a, int b, long cost) {
      this.a = a;
      this.b = b;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
      return Long.compare(this.cost, o.cost);
    }
  }

  static long total;
  static int N, M, a, b, c;
  static ArrayList<Edge> edges;
  static int[] uf;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 입력 부분
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    edges = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());

      total += c;
      edges.add(new Edge(a, b, c));
    }

    edges.sort(Comparator.naturalOrder());
    br.close();
  }

  private static void solve() {

    uf = new int[N + 1];
    for (int i = 0; i < N + 1; i++) {
      uf[i] = i;
    }

    int cnt = 0;
    long ans = 0;
    for (Edge edge : edges) {
      int v1 = edge.a;
      int v2 = edge.b;
      if (find(v1) != find(v2)) {
        union(v1, v2);
        ans += edge.cost;
        cnt++;
        if (cnt == N - 1) {
          break;
        }
      }
    }

    System.out.print(cnt == N - 1 ? total - ans : -1);
  }

  private static void union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x == y) {
      return;
    }

    if (x > y) {
      int tmp = x;
      x = y;
      y = tmp;
    }

    uf[y] = x;
  }

  private static int find(int x) {
    if (uf[x] != x) {
      uf[x] = find(uf[x]);
    }
    return uf[x];
  }
}