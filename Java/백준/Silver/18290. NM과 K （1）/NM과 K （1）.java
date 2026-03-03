import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m, k, answer;
  private static boolean[][] visited;
  private static int[][] arr;
  private static final int[] dys = {-1, 0, 1, 0}, dxs = {0, 1, 0, -1};

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new int[n][m];
    visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static void solve() {
    answer = Integer.MIN_VALUE;
    bt(0, 0);

    System.out.print(answer);
  }

  private static void bt(int cnt, int sum) {
    if (cnt == k) {
      answer = Math.max(answer, sum);
      return;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // 해당 지점을 방문한 경우 -> continue
        if (visited[i][j]) {
          continue;
        }

        boolean isAdjacent = judgeAdjacent(i, j);
        // 인접한 지점이 없는 경우 -> back tracking 진행
        if (!isAdjacent) {
          visited[i][j] = true;
          bt(cnt + 1, sum + arr[i][j]);
          visited[i][j] = false;
        }
      }
    }
  }

  private static boolean judgeAdjacent(int currY, int currX) {

    for (int i = 0; i < 4; i++) {
      int nxtY = currY + dys[i];
      int nxtX = currX + dxs[i];

      if (inRange(nxtY, nxtX) && visited[nxtY][nxtX]) {
        return true;
      }
    }

    return false;
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < m;
  }
}