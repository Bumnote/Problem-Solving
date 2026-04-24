import java.io.*;
import java.util.*;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, k;
  private static int[][] map;
  private static boolean[] visited;
  private static int[][] dist;
  private static int INF = (int) 1e9;
  private static int MIN = (int) 1e9;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], INF);
      dist[i][i] = 0;
    }

    map = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        dist[i][j] = map[i][j];
      }
    }

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (dist[i][j] > dist[i][k] + dist[k][j]) {
            dist[i][j] = dist[i][k] + dist[k][j];
          }
        }
      }
    }

    br.close();
  }

  private static void solve() {

    visited = new boolean[n];
    visited[k] = true; // 출발지 k 방문 처리
    dfs(k, 1, 0);

    System.out.print(MIN);
  }

  private static void dfs(int curr, int cnt, int total) {

    if (cnt == n) {
      MIN = Math.min(MIN, total);
      return;
    }

    for (int nxt = 0; nxt < n; nxt++) {
      if (!visited[nxt] && dist[curr][nxt] != INF) {
        visited[nxt] = true;
        dfs(nxt, cnt + 1, total + dist[curr][nxt]);
        visited[nxt] = false;
      }
    }
  }
}
