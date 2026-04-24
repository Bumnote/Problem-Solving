import java.io.*;
import java.util.*;

public class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, x, y;
  private static int bitmap;
  private static double INF = 1e9;
  private static double[][] map, dp;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    n = Integer.parseInt(br.readLine());
    bitmap = (1 << n) - 1;
    map = new double[n][n];

    int[][] points = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      points[i][0] = x;
      points[i][1] = y;
    }

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        double dist = getDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
        map[i][j] = dist;
        map[j][i] = dist;
      }
    }

    dp = new double[n][bitmap];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

    br.close();
  }

  private static void solve() {
    System.out.print(tsp(0, 1));
  }

  private static double tsp(int curr, int check) {

    if (check == bitmap) {
      return map[curr][0] == 0.0 ? INF : map[curr][0];
    }

    if (dp[curr][check] != -1) {
      return dp[curr][check];
    }

    dp[curr][check] = INF;

    for (int i = 0; i < n; i++) {
      int nxt = check | (1 << i); // 다음 상태

      // 다음으로 가지 못하는 경우 또는 이미 방문한 경우 -> continue
      if (map[curr][i] == 0.0 || (check & (1 << i)) != 0) {
        continue;
      }

      dp[curr][check] = Math.min(dp[curr][check], tsp(i, nxt) + map[curr][i]);
    }

    return dp[curr][check];
  }

  private static double getDistance(int x1, int y1, int x2, int y2) {
    return Math.sqrt(Math.pow((double) x1 - x2, 2) + Math.pow((double) y1 - y2, 2));
  }
}
