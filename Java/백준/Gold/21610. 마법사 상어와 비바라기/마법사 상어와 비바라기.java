import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m;
  private static int[][] A, commands;
  private static final int[] dys = {0, -1, -1, -1, 0, 1, 1, 1}, dxs = {-1, -1, 0, 1, 1, 1, 0, -1};
  private static Deque<int[]> currCloud = new ArrayDeque<>();
  private static Deque<int[]> prevCloud = new ArrayDeque<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    A = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    commands = new int[m][2];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      commands[i][0] = Integer.parseInt(st.nextToken()) - 1;
      commands[i][1] = Integer.parseInt(st.nextToken());
    }

    cloudInit();

    br.close();
  }

  private static void solve() {

    for (int[] command : commands) {
      int d = command[0]; // 방향
      int s = command[1]; // 이동 칸 수

      cloudMove(d, s);

      waterCopyBug();

      generateCloud();
    }

    int answer = getWaterCount();
    System.out.print(answer);
  }

  private static void cloudMove(int d, int s) {
    int size = currCloud.size();

    for (int i = 0; i < size; i++) {
      int[] cloud = currCloud.poll();
      int y = cloud[0];
      int x = cloud[1];

      int ny = (100 * n + y + dys[d] * s) % n;
      int nx = (100 * n + x + dxs[d] * s) % n;
      currCloud.offer(new int[]{ny, nx});
      A[ny][nx]++; // 이동 후, 물의 양 1 증가
    }

    prevCloud.addAll(currCloud);
  }

  private static void waterCopyBug() {

    while (!currCloud.isEmpty()) {
      int[] cloud = currCloud.poll();
      int y = cloud[0];
      int x = cloud[1];

      for (int i = 1; i < 8; i += 2) {
        int ny = y + dys[i];
        int nx = x + dxs[i];

        if (inRange(ny, nx) && A[ny][nx] > 0) {
          A[y][x]++;
        }
      }
    }
  }

  private static void generateCloud() {

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (A[i][j] >= 2) {
          boolean flag = false;
          for (int[] cloud : prevCloud) {
            if (cloud[0] == i && cloud[1] == j) {
              flag = true;
              break;
            }
          }
          if (flag) {
            continue;
          }
          currCloud.offer(new int[]{i, j});
          A[i][j] -= 2;
        }
      }
    }

    prevCloud.clear();
  }

  private static void cloudInit() {
    currCloud.offer(new int[]{n - 1, 0});
    currCloud.offer(new int[]{n - 1, 1});
    currCloud.offer(new int[]{n - 2, 0});
    currCloud.offer(new int[]{n - 2, 1});
  }

  private static int getWaterCount() {
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        count += A[i][j];
      }
    }

    return count;
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }
}
