import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m;
  private static int[][] graph;
  private static final int INF = (int) 1e9;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    graph = new int[n][n];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      graph[a][b] = 1;
    }
    br.close();
  }

  private static void solve() {

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (graph[i][k] == 1 && graph[k][j] == 1) {
            graph[i][j] = 1;
          }
        }
      }
    }

    int answer = 0;
    for (int i = 0; i < n; i++) {
      int left = 0;
      int right = 0;
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }
        if (graph[i][j] == 1) {
          right++;
        } else if (graph[j][i] == 1) {
          left++;
        }
      }
      if (left > n / 2 || right > n / 2) {
        answer++;
      }
    }

    System.out.print(answer);
  }

}