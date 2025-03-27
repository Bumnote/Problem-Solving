import java.io.*;
import java.util.*;

class Solution {

  static class Node implements Comparable<Node> {

    int cnt, number;

    Node(int cnt, int number) {
      this.cnt = cnt;
      this.number = number;
    }

    @Override
    public int compareTo(Node o) {
      if (o.cnt != this.cnt) {
        return o.cnt - this.cnt; // 횟수를 기준으로 내림차순
      }
      return o.number - this.number; // 정점 번호를 기준으로 내림차순
    }
  }

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static final int MAX = 100;
  static int N, S, v1, v2;
  static ArrayList<ArrayList<Integer>> vertex;
  static ArrayDeque<int[]> dq;
  static boolean[] visited;
  static PriorityQueue<Node> pq;

  public static void main(String[] args) throws IOException {

    for (int tc = 1; tc <= 10; tc++) {
      init();
      solve(tc);
    }

    System.out.println(sb);
    br.close();
  }

  private static void init() throws IOException {

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    vertex = new ArrayList<>();
    for (int i = 0; i <= MAX; i++) {
      vertex.add(new ArrayList<>());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i += 2) {
      v1 = Integer.parseInt(st.nextToken());
      v2 = Integer.parseInt(st.nextToken());
      // v1 -> v2: 단방향 그래프
      vertex.get(v1).add(v2);
    }
  }

  private static void solve(int tc) {
    sb.append("#").append(tc).append(" ").append(bfs(S)).append("\n");
  }

  private static int bfs(int x) {

    visited = new boolean[MAX + 1];
    dq = new ArrayDeque<>();
    dq.offer(new int[]{x, 0}); // {정점, 횟수}
    visited[x] = true; // 시작점 방문 처리

    pq = new PriorityQueue<>();

    while (!dq.isEmpty()) {
      int[] curr = dq.poll();

      pq.offer(new Node(curr[1], curr[0]));
      for (Integer nxt : vertex.get(curr[0])) {
        if (visited[nxt]) {
          continue;
        }

        visited[nxt] = true; // 방문 처리
        dq.offer(new int[]{nxt, curr[1] + 1});
      }
    }

    return pq.peek().number;
  }
}