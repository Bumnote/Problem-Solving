import java.io.*;
import java.util.*;

public class Main {

  static StringBuilder sb = new StringBuilder();

  static final int INF = 987_654_321;
  static int N, a, b;
  static int[][] mat;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 입력 부분
    N = Integer.parseInt(br.readLine()); // N: 회원의 수

    mat = new int[N + 1][N + 1];
    for (int i = 0; i <= N; i++) {
      Arrays.fill(mat[i], INF);
      mat[i][i] = 0;
    }

    while (true) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      if (a == -1 && b == -1) {
        break;
      }
      mat[a][b] = 1;
      mat[b][a] = 1;
    }

    br.close();
  }

  private static void solve() {

    // Floyd-Warshall
    for (int k = 1; k <= N; k++) {
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          // i -> k -> j 거리가 i -> j 보다 더 짧은 경우 -> 거리 갱신
          if (mat[i][k] + mat[k][j] < mat[i][j]) {
            mat[i][j] = mat[i][k] + mat[k][j];
          }
        }
      }
    }

    int MIN = INF;
    int cnt = 0;
    ArrayList<Integer> lst = new ArrayList<>();
    for (int i = 1; i <= N; i++) {
      int MAX = 0;
      for (int j = 1; j <= N; j++) {
        MAX = Math.max(MAX, mat[i][j] != INF ? mat[i][j] : 0);
      }
      if (MIN > MAX) {
        MIN = MAX;
        lst.clear();
        lst.add(i);
        cnt = 1;
      } else if (MIN == MAX) {
        lst.add(i);
        cnt++;
      }
    }

    // 정답 출력
    sb.append(MIN).append(" ").append(cnt).append("\n");
    lst.sort(Comparator.naturalOrder());
    for (Integer idx : lst) {
      sb.append(idx).append(" ");
    }
    System.out.println(sb);
  }
}