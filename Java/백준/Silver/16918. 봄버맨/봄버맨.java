import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int r, c, n;
  private static char[][] map;
  private static final int[] dys = {-1, 0, 1, 0}, dxs = {0, 1, 0, -1};
  private static Deque<int[]> dq = new ArrayDeque<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    map = new char[r][c];
    for (int i = 0; i < r; i++) {
      String line = br.readLine();
      for (int j = 0; j < c; j++) {
        map[i][j] = line.charAt(j);
        if (map[i][j] == 'O') {
          dq.offer(new int[]{i, j});
        }
      }
    }
    br.close();
  }

  private static void solve() {

    int time = 0;
    boolean flag = true;
    while (true) {
      time++;
      if (time == n + 1) {
        break;
      }

      if (flag) {
        flag = false;
        continue;
      }
      if (time % 2 == 0) {
        setBomb();
      } else {
        while (!dq.isEmpty()) {
          int[] pos = dq.poll();
          int y = pos[0];
          int x = pos[1];
          map[y][x] = '.';
          for (int d = 0; d < 4; d++) {
            int ny = y + dys[d];
            int nx = x + dxs[d];
            if (inRange(ny, nx) && map[ny][nx] == 'O') {
              map[ny][nx] = '.';
            }
          }
        }
        insertBomb();
      }
    }

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        sb.append(map[i][j]);
      }
      sb.append('\n');
    }

    System.out.print(sb);
  }

  private static void setBomb() {
    for (int i = 0; i < r; i++) {
      Arrays.fill(map[i], 'O');
    }
  }

  private static void insertBomb() {
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (map[i][j] == 'O') {
          dq.offer(new int[]{i, j});
        }
      }
    }
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < r && 0 <= x && x < c;
  }
}