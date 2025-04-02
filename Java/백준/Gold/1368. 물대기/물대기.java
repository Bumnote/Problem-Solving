import java.io.*;
import java.util.*;

public class Main {

  static class Edge implements Comparable<Edge> {

    int x, y, cost;

    Edge(int x, int y, int cost) {
      this.x = x;
      this.y = y;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
      return this.cost - e.cost;
    }
  }

  static int N, W;
  static int[] weight, uf;
  static int[][] mat;
  static ArrayList<Edge> edges;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 입력 부분
    N = Integer.parseInt(br.readLine()); // N: 논의 수

    edges = new ArrayList<>();

    weight = new int[N];
    for (int i = 0; i < N; i++) {
      weight[i] = Integer.parseInt(br.readLine()); // weight[]: 우물을 팔 때, 드는 비용
      edges.add(new Edge(0, i + 1, weight[i]));
    }

    mat = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        mat[i][j] = Integer.parseInt(st.nextToken()); // mat[][]: 논을 연결할 때, 드는 비용
        if (i >= j) {
          continue;
        }
        edges.add(new Edge(i + 1, j + 1, mat[i][j]));
      }
    }

    br.close();
  }

  private static void solve() {

    // union-find 배열 초기화
    uf = new int[N + 1];
    for (int i = 0; i <= N; i++) {
      uf[i] = i;
    }

    edges.sort(Comparator.naturalOrder()); // Kruskal 알고리즘을 위한 오름차순 정렬

    int cnt = 0;
    int total = 0;
    // Kruskal 알고리즘 구현
    for (Edge e : edges) {
      if (find(e.x) != find(e.y)) {
        union(e.x, e.y);
        total += e.cost;
        cnt++;
        if (cnt == N) {
          break;
        }
      }
    }

    // 정답 출력
    System.out.print(total);
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
