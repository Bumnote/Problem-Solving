import java.io.*;
import java.util.*;

public class Main {

  static int k, w, h;
  static int[][] MAP;
  static final int[] dhys = {-2, -1, 1, 2, 2, 1, -1, -2};
  static final int[] dhxs = {1, 2, 2, 1, -1, -2, -2, -1};
  static final int[] dmys = {-1, 1, 0, 0};
  static final int[] dmxs = {0, 0, -1, 1};

  // 지도 범위 체크 함수
  static boolean inRange(int y, int x) {
    return 0 <= y && y < h && 0 <= x && x < w;
  }

  // BFS 함수
  static int bfs() {
    // visited 배열을 방문처리 할 때, 장애물(1)도 체크해야 하기 때문에 3차원 배열 사용
    boolean[][][] visited = new boolean[h][w][k + 1];
    visited[0][0][0] = true; // 출발점 방문 처리
    Queue<int[]> dq = new LinkedList<>();
    dq.add(new int[]{0, 0, 0, 0}); // (y, x, dist, k_cnt)

    while (!dq.isEmpty()) {
      int[] cur = dq.poll();
      int curY = cur[0], curX = cur[1], dist = cur[2], kCnt = cur[3];

      // 목표 지점에 도달한 경우
      if (curY == h - 1 && curX == w - 1) {
        return dist;
      }

      // 원숭이가 말을 탈 수 있는 경우 (k_cnt < k)
      if (kCnt < k) {
        for (int i = 0; i < dhys.length; i++) {
          int nxtY = curY + dhys[i], nxtX = curX + dhxs[i];
          // 방문 가능하고 장애물이 아닌 경우
          if (inRange(nxtY, nxtX) && !visited[nxtY][nxtX][kCnt + 1] && MAP[nxtY][nxtX] != 1) {
            visited[nxtY][nxtX][kCnt + 1] = true; // 방문 처리
            dq.add(new int[]{nxtY, nxtX, dist + 1, kCnt + 1});
          }
        }
      }

      // 원숭이가 원숭이처럼 이동할 수 있는 경우
      for (int i = 0; i < dmys.length; i++) {
        int nxtY = curY + dmys[i], nxtX = curX + dmxs[i];
        // 방문 가능하고 장애물이 아닌 경우
        if (inRange(nxtY, nxtX) && !visited[nxtY][nxtX][kCnt] && MAP[nxtY][nxtX] != 1) {
          visited[nxtY][nxtX][kCnt] = true; // 방문 처리
          dq.add(new int[]{nxtY, nxtX, dist + 1, kCnt});
        }
      }
    }

    return -1; // 목표 지점에 도달할 수 없는 경우
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    k = Integer.parseInt(br.readLine()); // 말처럼 이동할 수 있는 횟수

    // 첫 번째 줄 입력 처리: 말처럼 이동할 수 있는 횟수, 가로, 세로
    st = new StringTokenizer(br.readLine());
    w = Integer.parseInt(st.nextToken()); // 가로 길이
    h = Integer.parseInt(st.nextToken()); // 세로 길이

    // 지도 정보 입력
    MAP = new int[h][w];
    for (int i = 0; i < h; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < w; j++) {
        MAP[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // BFS 실행
    int ans = bfs();
    System.out.println(ans);
  }
}
