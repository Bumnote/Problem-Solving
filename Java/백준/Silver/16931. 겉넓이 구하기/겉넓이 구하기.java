import java.io.*;
import java.util.*;

class Main {

  static int N, M;
  static int[][] map;
  static int[] dys = {-1, 1, 0, 0}, dxs = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static void solve() {

    int total = 0;
    // 위, 아래에서 봤을 때 -> 2(N x M) 더한다.
    total += (2 * (N * M));

    // 그 외 나머지 상황
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        for (int k = 0; k < 4; k++) {
          int nxtY = i + dys[k];
          int nxtX = j + dxs[k];
          // 범위를 넘어서지 않는 경우 -> 현재 위치가 더 높은 경우에 그 차이만큼 더한다.
          if (inRange(nxtY, nxtX)) {
            total += Math.max(map[i][j] - map[nxtY][nxtX], 0);
          }
          // 범위를 넘어선 경우 -> 해당 높이만큼 더한다.
          else {
            total += map[i][j];
          }
        }
      }
    }

    System.out.print(total);
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < N && 0 <= x && x < M;
  }
}
