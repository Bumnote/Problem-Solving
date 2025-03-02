import java.io.*;
import java.util.*;

public class Main {

  static final int ROOT = 1;
  static int N, u, v;
  static ArrayList<ArrayList<Integer>> vertex;
  static boolean[] visited;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    // 입력 부분
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine()); // N: 정점의 개수

    vertex = new ArrayList<>();
    dp = new int[N + 1][2];
    visited = new boolean[N + 1];
    for (int i = 0; i <= N; i++) {
      vertex.add(new ArrayList<>());
    }

    // 그래프 입력 -> 트리이므로, N - 1 개의 간선 존재
    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());

      vertex.get(u).add(v);
      vertex.get(v).add(u);
    }

    br.close();
  }

  private static void solve() {

    visited[ROOT] = true; // 루트 노드 방문처리
    getEarlyAdapter(ROOT);

    System.out.println(Math.min(dp[1][0], dp[1][1]));
  }

  private static void getEarlyAdapter(int curr) {

    dp[curr][0] = 1;

    for (Integer nxt : vertex.get(curr)) {
      if (visited[nxt]) {
        continue;
      }

      visited[nxt] = true; // 방문 처리
      getEarlyAdapter(nxt);
      dp[curr][1] += dp[nxt][0];
      dp[curr][0] += Math.min(dp[nxt][1], dp[nxt][0]);
    }

  }

}
