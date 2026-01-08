import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m, a, b, c;
  private static int[][] map;
  private static final int INF = 1_000_000_000;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    map = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(map[i], INF);
      map[i][i] = 0;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      // a -> b: 단방향 c
      map[a - 1][b - 1] = Math.min(map[a - 1][b - 1], c);
    }
    br.close();
  }

  private static void solve() {

    floydWarshall();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == INF) {
          sb.append(0).append(' ');
        } else {
          sb.append(map[i][j]).append(' ');
        }
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }

  private static void floydWarshall() {
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (map[i][k] != INF && map[k][j] != INF) {
            map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
          }
        }
      }
    }
  }
}