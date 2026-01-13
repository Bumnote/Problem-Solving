import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m, t;
  private static int[][] map;
  private static boolean[][] visited;
  private static final int[] dys = {-1, 1, 0, 0}, dxs = {0, 0, -1, 1};

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken()); // t: 제한 시간

    map = new int[n][m];
    visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static void solve() {

    Deque<int[]> dq = new ArrayDeque<>();
    dq.offer(new int[]{0, 0, 0});

    visited[0][0] = true; // 방문 처리 (0: 그람이 없는 경우 / 1: 그람이 있는 경우)
    int hasNotGramDistance = Integer.MAX_VALUE;
    int hasGramDistance = Integer.MAX_VALUE;
    boolean flag = false;
    while (!dq.isEmpty()) {
      int[] curr = dq.poll();
      int y = curr[0];
      int x = curr[1];
      int time = curr[2];

      if (time > t) {
        break;
      }

      if (y == n - 1 && x == m - 1) {
        hasNotGramDistance = Math.min(hasNotGramDistance, time);
        flag = true;
        break;
      }

      for (int d = 0; d < 4; d++) {
        int ny = y + dys[d];
        int nx = x + dxs[d];

        // 범위를 넘지 않고, 아직 방문하지 않은 경우 -> dq 추가
        if (inRange(ny, nx) && !visited[ny][nx] && map[ny][nx] != 1) {
          // 그람을 획득한 경우 -> 최단 거리 계산
          if (map[ny][nx] == 2) {
            hasGramDistance = Math.min(hasGramDistance, time + getDistance(ny, nx));
            if (hasGramDistance <= t) {
              flag = true;
            }
          }
          visited[ny][nx] = true; // 방문 처리
          dq.offer(new int[]{ny, nx, time + 1});
        }
      }
    }

    System.out.print(flag ? Math.min(hasNotGramDistance, hasGramDistance) : "Fail");
  }

  private static int getDistance(int ny, int nx) {
    int targetY = n - 1;
    int targetX = m - 1;
    return Math.abs(targetY - ny) + Math.abs(targetX - nx) + 1;
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < m;
  }
}
