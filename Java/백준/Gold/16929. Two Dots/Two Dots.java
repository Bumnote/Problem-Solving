import java.io.*;
import java.util.*;

public class Main {

  static int N, M;
  static boolean cycle;
  static char[][] map;
  static boolean[][] visited;
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

    map = new char[N][M];
    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      map[i] = br.readLine().toCharArray();
    }
      
    br.close();
  }

  private static void solve() {

    cycle = false;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        visited[i][j] = true; // 방문 처리
        dfs(i, j, i, j, 1);
        visited[i][j] = false; // 복원 처리
        if (cycle) {
          System.out.println("Yes");
          return;
        }
      }
    }

    System.out.println("No");
  }

  private static void dfs(int y, int x, int originY, int originX, int cnt) {

    for (int i = 0; i < 4; i++) {
      int nxtY = y + dys[i];
      int nxtX = x + dxs[i];

      // 범위를 넘지 않거나, 현재의 색깔과 다음 점의 색깔이 같은 경우
      if (inRange(nxtY, nxtX) && map[y][x] == map[nxtY][nxtX]) {
        // 이미 방문을 했던 점인 경우 -> cycle 판단
        if (visited[nxtY][nxtX]) {
          if (nxtY == originY && nxtX == originX && cnt >= 4) {
            cycle = true;
            return;
          }
        } else {
          visited[nxtY][nxtX] = true; // 방문 처리
          dfs(nxtY, nxtX, originY, originX, cnt + 1);
          visited[nxtY][nxtX] = false; // 복원 처리
        }
      }

    }
  }


  private static boolean inRange(int y, int x) {
    return 0 <= y && y < N && 0 <= x && x < M;
  }
}
