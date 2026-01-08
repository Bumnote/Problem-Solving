import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m, a, b, c;
  private static int[][] map;
  private static int[][] dist;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  private static void solve() throws IOException {

    floydWarshall();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      if (dist[a - 1][b - 1] <= c) {
        sb.append("Enjoy other party").append("\n");
      } else {
        sb.append("Stay here").append("\n");
      }
    }

    System.out.print(sb);
    br.close();
    sb.setLength(0);
  }

  private static void floydWarshall() {

    final int INF = 1_000_000_001;
    dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          dist[i][j] = 0;
        } else if (map[i][j] == 0) {
          dist[i][j] = INF;
        } else {
          dist[i][j] = map[i][j];
        }
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
  }
}