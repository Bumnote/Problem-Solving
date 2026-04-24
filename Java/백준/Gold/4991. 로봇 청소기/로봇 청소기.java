import java.io.*;
import java.util.*;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int x, y, sx, sy;
  private static char[][] map;
  private static List<int[]> dirties = new ArrayList<>();
  private static int[][] dist;
  private static int[][] dp;
  private static int size;
  private static final int INF = (int) 1e9;
  private static int bitmap;
  private static final int[] dys = {0, 0, -1, 1}, dxs = {-1, 1, 0, 0};

  public static void main(String[] args) throws Exception {

    while (true) {
      st = new StringTokenizer(br.readLine());
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      if (x == 0 && y == 0) {
        break;
      }
      init();
      solve();
    }

    System.out.print(sb);
  }

  private static void init() throws Exception {

    map = new char[y][x];
    dirties.clear();
    for (int i = 0; i < y; i++) {
      String line = br.readLine();
      for (int j = 0; j < x; j++) {
        map[i][j] = line.charAt(j);
        if (map[i][j] == 'o') {
          sy = i;
          sx = j;
        } else if (map[i][j] == '*') {
          dirties.add(new int[]{i, j});
        }
      }
    }

    dirties.add(new int[]{sy, sx});
  }

  private static void solve() {

    size = dirties.size();
    dist = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = i + 1; j < size; j++) {
        int result = bfs(dirties.get(i)[0], dirties.get(i)[1], dirties.get(j)[0], dirties.get(j)[1]);
        if (result == -1) {
          sb.append(-1).append("\n");
          return;
        }
        dist[i][j] = result;
        dist[j][i] = result;
      }
    }

    bitmap = (1 << size) - 1;
    dp = new int[size][bitmap];
    for (int i = 0; i < size; i++) {
      Arrays.fill(dp[i], -1);
    }

    sb.append(tsp(size - 1, 1 << (size - 1))).append("\n");
  }

  private static int tsp(int cur, int curState) {

    if (curState == bitmap) {
      return 0;
    }

    if (dp[cur][curState] != -1) {
      return dp[cur][curState];
    }

    dp[cur][curState] = INF;

    for (int nxt = 0; nxt < size; nxt++) {
      int nxtState = curState | (1 << nxt);
      if (dist[cur][nxt] == INF || (curState & (1 << nxt)) != 0) {
        continue;
      }

      dp[cur][curState] = Math.min(dp[cur][curState], tsp(nxt, nxtState) + dist[cur][nxt]);
    }

    return dp[cur][curState];
  }

  private static int bfs(int sy, int sx, int ey, int ex) {

    Deque<int[]> dq = new ArrayDeque<>();
    dq.offer(new int[]{sy, sx, 0});
    boolean[][] visited = new boolean[y][x];
    visited[sy][sx] = true;

    int dist = -1;
    while (!dq.isEmpty()) {
      int[] curr = dq.poll();
      int cy = curr[0];
      int cx = curr[1];
      int cnt = curr[2];

      if (cy == ey && cx == ex) {
        dist = cnt;
        break;
      }

      for (int d = 0; d < 4; d++) {
        int ny = cy + dys[d];
        int nx = cx + dxs[d];

        if (inRange(ny, nx) && !visited[ny][nx] && map[ny][nx] != 'x') {
          visited[ny][nx] = true;
          dq.offer(new int[]{ny, nx, cnt + 1});
        }
      }
    }

    return dist;
  }

  private static boolean inRange(int h, int w) {
    return 0 <= h && h < y && 0 <= w && w < x;
  }
}
