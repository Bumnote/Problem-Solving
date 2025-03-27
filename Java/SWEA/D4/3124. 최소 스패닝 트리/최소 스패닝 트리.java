import java.io.*;
import java.util.*;

public class Solution {

  static class Edge implements Comparable<Edge> {

    int v;
    long cost;

    Edge(int v, long cost) {
      this.v = v;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
      return Long.compare(this.cost, o.cost);
    }
  }

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int T, V, E, A, B, C;
  static boolean[] visited;
  static ArrayList<ArrayList<Edge>> vertex;
  static PriorityQueue<Edge> pq;

  public static void main(String[] args) throws IOException {

    T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      init();
      solve(tc);
    }

    System.out.println(sb);
    br.close();
  }

  private static void init() throws IOException {

    st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    vertex = new ArrayList<>();
    for (int i = 0; i <= V; i++) {
      vertex.add(new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());

      vertex.get(A).add(new Edge(B, C));
      vertex.get(B).add(new Edge(A, C));
    }
  }

  private static void solve(int tc) {

    long total = prim();

    sb.append("#").append(tc).append(" ").append(total).append("\n");
  }

  private static long prim() {

    visited = new boolean[V + 1];
    pq = new PriorityQueue<>();
    pq.offer(new Edge(1, 0));

    long total = 0;
    while (!pq.isEmpty()) {
      Edge edge = pq.poll();
      int v = edge.v;
      long cost = edge.cost;

      // 이미 방문한 정점이라면 -> continue
      if (visited[v]) {
        continue;
      }

      visited[v] = true; // 해당 정점 방문 처리
      total += cost;

      for (Edge e : vertex.get(v)) {
        if (!visited[e.v]) {
          pq.offer(e);
        }
      }
    }

    return total;
  }
}

