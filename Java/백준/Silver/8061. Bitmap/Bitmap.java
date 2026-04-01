import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m;
  private static int[][] map;
  private static int[][] grid;
  private static Deque<int[]> dq = new ArrayDeque<>();
  private static final int[] dys = {-1, 0, 1, 0}, dxs = {0, 1, 0, -1};
  private static final int MAX = (int) 1e9;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n][m];
    grid = new int[n][m];
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        map[i][j] = line.charAt(j) - '0';
        if (map[i][j] == 0) {
          grid[i][j] = MAX;
        }
      }
    }

    br.close();
  }

  private static void solve() {

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == 1) {
          bfs(i, j);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sb.append(grid[i][j]).append(' ');
      }
      sb.append('\n');
    }

    System.out.print(sb);
  }

  private static void bfs(int i, int j) {

    dq.clear();
    dq.offer(new int[]{i, j, 0});

    while (!dq.isEmpty()) {
      int[] curr = dq.poll();
      int y = curr[0];
      int x = curr[1];
      int count = curr[2];

      for (int d = 0; d < 4; d++) {
        int ny = y + dys[d];
        int nx = x + dxs[d];

        if (inRange(ny, nx) && grid[ny][nx] > count + 1) {
          grid[ny][nx] = count + 1;
          dq.offer(new int[]{ny, nx, count + 1});
        }
      }
    }
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < m;
  }
}