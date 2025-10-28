import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer st;

  private static int h, w;
  private static int[][] matrix;

  private static final int[] dys = {-1, -1, -1, 0, 0, 1, 1, 1}, dxs = {-1, 0, 1, -1, 1, -1, 0, 1};
  private static Deque<int[]> dq;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());
    matrix = new int[h][w];
    for (int i = 0; i < h; i++) {
      String line = br.readLine();
      for (int j = 0; j < w; j++) {
        if (line.charAt(j) == '.') {
          matrix[i][j] = 0;
          continue;
        }
        matrix[i][j] = line.charAt(j) - '0';
      }
    }

    br.close();
  }

  private static void solve() {

    dq = new ArrayDeque<>();
    dqInit();

    int answer = -1;
    while (!dq.isEmpty()) {
      int size = dq.size();

      for (int i = 0; i < size; i++) {
        int[] curr = dq.poll();
        int y = curr[0];
        int x = curr[1];

        for (int d = 0; d < 8; d++) {
          int ny = y + dys[d];
          int nx = x + dxs[d];

          if (inRange(ny, nx) && matrix[ny][nx] > 0) {
            matrix[ny][nx]--;
            if (matrix[ny][nx] == 0) {
              dq.offer(new int[]{ny, nx});
            }
          }
        }
      }
      answer++;
    }

    System.out.print(answer);
  }

  private static void dqInit() {
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (matrix[i][j] == 0) {
          dq.offer(new int[]{i, j});
        }
      }
    }
  }

  private static boolean inRange(int y, int x) {
    return y >= 0 && y < h && x >= 0 && x < w;
  }
}