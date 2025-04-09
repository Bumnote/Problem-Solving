import java.io.*;
import java.util.*;

class Solution {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static final int INF = 987_654_321;
  static int T, N;
  static int[][] mat;

  public static void main(String[] args) throws IOException {

    T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      init();
      solve(tc);
    }
    // 정답 출력
    System.out.print(sb);
    br.close();
  }

  private static void init() throws IOException {

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());

    // mat 배열 초기화
    mat = new int[N][N];
    for (int i = 0; i < N; i++) {
      Arrays.fill(mat[i], INF);
      mat[i][i] = 0;
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int num = Integer.parseInt(st.nextToken());
        // 친구 관계 저장
        if (num != 0) {
          mat[i][j] = num;
        }
      }
    }
  }

  private static void solve(int tc) {

    // 플로이드 워셜 알고리즘 적용
    for (int k = 0; k < N; k++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
        }
      }
    }

    int MIN = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      int sum = 0;
      for (int j = 0; j < N; j++) {
        sum += mat[i][j] == INF ? 0 : mat[i][j];
      }

      if (MIN > sum) {
        MIN = sum;
      }
    }

    // 정답 양식 저장
    sb.append("#").append(tc).append(" ").append(MIN).append("\n");
  }
}
