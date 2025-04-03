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

  static int N, M, a, b, c;
  static int[] time, uf;
  static ArrayList<Edge> edge;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 입력 부분
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // N: 방의 개수
    M = Integer.parseInt(st.nextToken()); // M: 워프의 개수

    edge = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      // a - b: 연결 비용 c
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      edge.add(new Edge(a, b, c));
    }

    time = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      time[i] = Integer.parseInt(st.nextToken()); // time[]: 비상탈출구 설치 시간
      edge.add(new Edge(0, i + 1, time[i]));
    }

    // union-find 배열 초기화
    uf = new int[N + 1];
    for (int i = 0; i <= N; i++) {
      uf[i] = i;
    }
  }

  private static void solve() {

    edge.sort(Comparator.naturalOrder());

    int cnt = 0;
    int total = 0;
    for (Edge e : edge) {
      if (find(e.x) != find(e.y)) {
        union(e.x, e.y);
        total += e.cost;
        cnt++;
        if (cnt == N) {
          break;
        }
      }
    }

    System.out.println(total);
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
