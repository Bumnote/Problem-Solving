import java.io.*;
import java.util.*;

class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer st;

  private static final int[] dys = {0, 0, -1, 1}, dxs = {-1, 1, 0, 0};
  private static int r, c, t, sy, sx, ey, ex;
  private static int[][] A;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());

    A = new int[r][c];
    for (int i = 0; i < r; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < c; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    findMachine();
    br.close();
  }

  private static void solve() {

    for (int time = 1; time <= t; time++) {
      spread();
      rotate();
    }

    int answer = calculateMicroDust();
    System.out.print(answer);
  }

  private static void spread() {
    Deque<int[]> dq = new ArrayDeque<>();
    for (int y = 0; y < r; y++) {
      for (int x = 0; x < c; x++) {
        if (A[y][x] > 0) {
          dq.offer(new int[]{y, x});
        }
      }
    }

    Deque<int[]> calculateDq = new ArrayDeque<>();
    while (!dq.isEmpty()) {
      int[] curr = dq.poll();
      int y = curr[0];
      int x = curr[1];

      int spreadAmount = A[y][x] / 5; // 확산되는 미세먼지 양
      int spreadCount = 0; // 확산된 방향의 개수
      for (int d = 0; d < 4; d++) {
        int ny = y + dys[d];
        int nx = x + dxs[d];
        if (inRange(ny, nx) && A[ny][nx] != -1) {
          spreadCount++;
          calculateDq.offer(new int[]{ny, nx, spreadAmount});
        }
      }
      A[y][x] -= spreadAmount * spreadCount;
    }

    while (!calculateDq.isEmpty()) {
      int[] curr = calculateDq.poll();
      int y = curr[0];
      int x = curr[1];
      int amount = curr[2];
      A[y][x] += amount;
    }
  }

  private static void rotate() {

    // 위쪽 공기청정기 (반시계 방향)
    for (int y = sy - 1; y >= 1; y--) {
      A[y][0] = A[y - 1][0];
    }

    for (int x = 0; x <= c - 2; x++) {
      A[0][x] = A[0][x + 1];
    }

    for (int y = 0; y <= sy - 1; y++) {
      A[y][c - 1] = A[y + 1][c - 1];
    }

    for (int x = c - 1; x >= 2; x--) {
      A[sy][x] = A[sy][x - 1];
    }
    A[sy][1] = 0;

    // 아래쪽 공기청정기 (시계 방향)
    for (int y = ey + 1; y <= r - 2; y++) {
      A[y][0] = A[y + 1][0];
    }

    for (int x = 0; x < c - 1; x++) {
      A[r - 1][x] = A[r - 1][x + 1];
    }

    for (int y = r - 1; y > ey; y--) {
      A[y][c - 1] = A[y - 1][c - 1];
    }

    for (int x = c - 1; x >= 2; x--) {
      A[ey][x] = A[ey][x - 1];
    }
    A[ey][1] = 0;
  }

  private static void findMachine() {
    for (int y = 0; y < r; y++) {
      if (A[y][0] == -1) {
        sy = y;
        sx = 0;
        ey = y + 1;
        ex = 0;
        break;
      }
    }
  }

  private static int calculateMicroDust() {

    int totalDust = 0;
    for (int y = 0; y < r; y++) {
      for (int x = 0; x < c; x++) {
        totalDust += Math.max(0, A[y][x]);
      }
    }

    return totalDust;
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < r && 0 <= x && x < c;
  }
}