import java.io.*;
import java.util.*;

class Main {

  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static StringTokenizer st;
  public static int n, m;
  public static int y1, x1, y2, x2;
  public static char[][] map;
  public static boolean[][] visited;
  public static int[] dys = {-1, 1, 0, 0}, dxs = {0, 0, -1, 1};
  public static final Deque<int[]> dq = new ArrayDeque<>();

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new char[n + 1][m + 1];

    st = new StringTokenizer(br.readLine());
    y1 = Integer.parseInt(st.nextToken());
    x1 = Integer.parseInt(st.nextToken());
    y2 = Integer.parseInt(st.nextToken());
    x2 = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        map[i][j + 1] = line.charAt(j);
      }
    }
    br.close();
  }

  private static void solve() {

    int cnt = 0;
    boolean flag = true;
    while (flag) {
      cnt++;
      flag = bfs();
    }

    System.out.print(cnt);
  }

  private static boolean bfs() {

    dq.offer(new int[]{y1, x1});
    visited = new boolean[n + 1][m + 1];
    visited[y1][x1] = true;

    while (!dq.isEmpty()) {

      int[] curr = dq.poll();

      if (map[curr[0]][curr[1]] == '1') {
        map[curr[0]][curr[1]] = '0';
        continue;
      }

      for (int i = 0; i < 4; i++) {
        int nxtY = curr[0] + dys[i];
        int nxtX = curr[1] + dxs[i];
        if (inRange(nxtY, nxtX) && !visited[nxtY][nxtX]) {
          visited[nxtY][nxtX] = true;
          // 1인 경우 -> offer
          if (map[nxtY][nxtX] == '1') {
            dq.offer(new int[]{nxtY, nxtX});
          }
          // 0인 경우 -> offerFirst
          else if (map[nxtY][nxtX] == '0') {
            dq.offerFirst(new int[]{nxtY, nxtX});
          }
          // #인 경우 -> return
          else {
            return false;
          }
        }
      }
    }

    return true;
  }

  private static boolean inRange(int y, int x) {
    return 1 <= y && y <= n && 1 <= x && x <= m;
  }
}