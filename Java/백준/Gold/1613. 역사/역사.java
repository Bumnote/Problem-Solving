import java.io.*;
import java.util.*;

class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static final int INF = 987_654_321;
  static int n, k, a, b, s;
  static int[][] mat;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken()); // n: 사건의 개수
    k = Integer.parseInt(st.nextToken()); // k: 관계의 개수

    mat = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      Arrays.fill(mat[i], INF); // mat 초기화 
      mat[i][i] = 0; // i -> i 초기화 
    }

    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      mat[a][b] = 1; // a -> b: 단방향 관계 
    }
  }

  private static void solve() throws IOException {

    // 플로이드 워셜 점화식
    for (int k = 1; k <= n; k++) 
      for (int i = 1; i <= n; i++) 
        for (int j = 1; j <= n; j++) 
          mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
     

    s = Integer.parseInt(br.readLine());
    for (int i = 0; i < s; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      // 사건 순서에 따라서 정답 값 저장
      if (mat[a][b] == INF && mat[b][a] == INF) {
        sb.append(0).append("\n");
      } else if (mat[a][b] < INF) {
        sb.append(-1).append("\n");
      } else {
        sb.append(1).append("\n");
      }
    }

    System.out.print(sb);
    br.close();
  }
}