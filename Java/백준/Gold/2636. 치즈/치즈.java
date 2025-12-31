import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m;
  private static int[][] map;
  private static int remainCheese, lastCheese;
  private static final int[] dys = {0, 0, -1, 1}, dxs = {-1, 1, 0, 0};

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    remainCheese = 0;
    map = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 1) {
          remainCheese++;
        }
      }
    }

    br.close();
  }

  private static void solve() throws IOException {

    int time = 0;

    while (remainCheese > 0) {
      lastCheese = remainCheese;
      bfs();
      time++;
    }

    System.out.printf("%d\n%d", time, lastCheese);
  }

  private static void bfs() {
    boolean[][] visited = new boolean[n][m];
    visited[0][0] = true;
    Deque<int[]> dq = new ArrayDeque<>();
    Deque<int[]> meltingCheese = new ArrayDeque<>();
    dq.offer(new int[]{0, 0});

    while (!dq.isEmpty()) {
      int[] curr = dq.poll();
      int currY = curr[0];
      int currX = curr[1];

      for (int d = 0; d < 4; d++) {
        int nxtY = currY + dys[d];
        int nxtX = currX + dxs[d];

        // 범위를 넘지 않고, 아직 방문하지 않은 곳이라면 -> 탐색
        if (inRange(nxtY, nxtX) && !visited[nxtY][nxtX]) {
          visited[nxtY][nxtX] = true; // 방문 처리
          if (map[nxtY][nxtX] == 0) {
            dq.offer(new int[]{nxtY, nxtX}); // 다음 방문할 위치 저장
          } else {
            meltingCheese.offer(new int[]{nxtY, nxtX}); // 녹을 치즈 위치 저장
          }
        }
      }
      melting(meltingCheese);
    }
  }

  private static void melting(Deque<int[]> meltingCheese) {
    remainCheese -= meltingCheese.size();
    while (!meltingCheese.isEmpty()) {
      int[] cheese = meltingCheese.poll();
      map[cheese[0]][cheese[1]] = 0;
    }
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < m;
  }

}