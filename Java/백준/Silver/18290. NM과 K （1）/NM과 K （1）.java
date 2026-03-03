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
    bt(0, 0, 0);
    System.out.print(answer);
  }

  private static void bt(int start, int cnt, int sum) {
    if (cnt == k) {
      answer = Math.max(answer, sum);
      return;
    }

    for (int idx = start; idx < n * m; idx++) {
      int y = idx / m;
      int x = idx % m;

      // 해당 지점이 이미 방문한 곳이거나, 인접한 곳이라면 -> continue
      if (visited[y][x] || judgeAdjacent(y, x)) {
        continue;
      }

      visited[y][x] = true;
      bt(idx + 1, cnt + 1, sum + arr[y][x]);
      visited[y][x] = false;
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