import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static boolean flag;
  private static int n, m, r, c, d;
  private static int[][] map; // map[][] 0: 빈칸, 1: 벽, 2: 청소된 칸
  private static final int[] dys = {-1, 0, 1, 0}, dxs = {0, 1, 0, -1}; // 북, 동, 남, 서

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    map = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    br.close();
  }

  private static void solve() {

    int cleanedCount = 0;
    while (true) {
      // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
      if (map[r][c] == 0) {
        map[r][c] = 2;
        cleanedCount++;
      }

      flag = isExistEmptySpace();

      // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우ㅁ
      if (flag) {
        d = (d + 4 - 1) % 4; // 반시계 90도 회전
        int nr = r + dys[d];
        int nc = c + dxs[d];
        if (inRange(nr, nc) && map[nr][nc] == 0) {
          r = nr;
          c = nc;
        }
      }
      // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
      else {
        int nd = (d + 4 - 2) % 4; // 후진
        int nr = r + dys[nd];
        int nc = c + dxs[nd];
        // 후진이 가능한 경우 -> 1칸 방향을 유지한 상태로 후진
        if (inRange(nr, nc) && map[nr][nc] != 1) {
          r = nr;
          c = nc;
        }
        // 후진이 불가능한 경우 -> 작동을 멈춘다.
        else {
          break;
        }
      }
    }

    System.out.print(cleanedCount);
  }

  private static boolean isExistEmptySpace() {
    for (int i = 0; i < 4; i++) {
      int nr = r + dys[i];
      int nc = c + dxs[i];
      if (inRange(nr, nc) && map[nr][nc] == 0) {
        return true;
      }
    }
    return false;
  }

  private static boolean inRange(int cr, int cc) {
    return cr >= 0 && cr < n && cc >= 0 && cc < m;
  }
}