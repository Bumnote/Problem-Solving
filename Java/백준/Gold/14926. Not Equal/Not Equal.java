import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[] idx;
  private static boolean[][] graph;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    br.close();
  }

  private static void solve() {
    graph = new boolean[n + 1][n + 1];
    idx = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      graph[i][i] = true;
    }

    graph[1][n] = graph[n][1] = true;
    sb.append("a1 ");
    dfs(1);
    sb.append("a1");
    System.out.print(sb);
  }

  private static void dfs(int curr) {

    int nxt = idx[curr] + 1;
    for (; nxt <= n; nxt++) {
      if (!graph[curr][nxt]) {
        idx[curr] = nxt;
        graph[curr][nxt] = graph[nxt][curr] = true;
        sb.append("a").append(nxt).append(" ");
        dfs(nxt);
      }
    }
  }
}