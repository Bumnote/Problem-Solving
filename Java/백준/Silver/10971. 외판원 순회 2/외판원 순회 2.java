import java.io.*;
import java.util.*;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[][] map;
  private static int MIN = (int) 1e9;
  private static boolean[] visited;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static void solve() {
    visited[0] = true;
    dfs(0, 0, 1, 0);
    System.out.print(MIN);
  }

  private static void dfs(int curr, int start, int cnt, int sum) {

    if (sum > MIN) {
      return;
    }

    if (cnt == n) {
      if (map[curr][start] == 0) {
        return;
      } else {
        MIN = Math.min(MIN, sum + map[curr][start]);
        return;
      }
    }

    for (int nxt = 0; nxt < n; nxt++) {
      if (!visited[nxt] && map[curr][nxt] > 0) {
        visited[nxt] = true;
        dfs(nxt, start, cnt + 1, sum + map[curr][nxt]);
        visited[nxt] = false;
      }
    }
  }
}
