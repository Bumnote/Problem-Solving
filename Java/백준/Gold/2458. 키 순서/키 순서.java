import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static final int INF = 987_654_321;
  private static int n, m, a, b;
  private static int[][] mat;


  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    mat = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      Arrays.fill(mat[i], INF);
      mat[i][i] = 0;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      // a -> b: 상대적 순서
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      mat[a][b] = 1;
    }
    br.close();
  }

  public static void solve() {

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (mat[i][k] == 1 && mat[k][j] == 1) {
            mat[i][j] = 1;
          }
        }
      }
    }

    int studentCount = 0;
    for (int i = 1; i <= n; i++) {
      int count = 0;
      for (int j = 1; j <= n; j++) {
        if (i != j && (mat[i][j] == 1 || mat[j][i] == 1)) {
          count++;
        }
      }

      if (count == n - 1) {
        studentCount++;
      }
    }

    System.out.print(studentCount);
  }
}
