import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[][] map;
  private static boolean[] visited;
  private static int MIN = Integer.MAX_VALUE;

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

    for (int i = 0; i < n; i++) {
      visited[i] = true;
      dfs(i, i, 1, 0);
      visited[i] = false;
    }

    System.out.print(MIN);
  }

  private static void dfs(int curr, int start, int cnt, int sum) {

    if (cnt == n) {
      if (map[curr][start] > 0) {
        MIN = Math.min(MIN, sum + map[curr][start]);
      }
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        if (map[curr][i] == 0) {
          continue;
        }
        visited[i] = true;
        dfs(i, start, cnt + 1, sum + map[curr][i]);
        visited[i] = false;
      }
    }
  }
}