import java.io.*;
import java.util.*;

class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  static boolean flag;
  static String command;
  static int M, n, d, dir, curY, curX, nxtY, nxtX;
  static int[] dys = {0, 1, 0, -1}, dxs = {1, 0, -1, 0}; // 동 -> 남 -> 서 -> 북

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
  }

  private static void solve() throws IOException {

    StringBuilder sb = new StringBuilder();

    curY = 0;
    curX = 0;
    dir = 0; // 동쪽 방향을 바라보고 시작
    flag = true;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      command = st.nextToken();
      d = Integer.parseInt(st.nextToken());
      switch (command) {
        case "TURN":
          // d == 0 :왼쪽으로 90도 회전 / d == 1 :오른쪽으로 90도 회전
          dir = d == 0 ? (4 + dir - 1) % 4 : (dir + 1) % 4;
          break;
        case "MOVE":
          // 동쪽을 바라보고 있는 경우
          if (dir == 0) {
            nxtX = curX + d;
            if (inRange(curY, nxtX)) {
              curX = nxtX;
            }
            // 명령어 열이 유효하지 않은 경우 -> flag = false
            else {
              flag = false;
            }
          }
          // 남쪽을 바라보고 있는 경우
          else if (dir == 1) {
            nxtY = curY - d;
            if (inRange(nxtY, curX)) {
              curY = nxtY;
            } else {
              flag = false;
            }
          }
          // 서쪽을 바라보고 있는 경우
          else if (dir == 2) {
            nxtX = curX - d;
            if (inRange(curY, nxtX)) {
              curX = nxtX;
            }
            // 명령어 열이 유효하지 않은 경우 -> flag = false
            else {
              flag = false;
            }
          }
          // 북쪽을 바라보고 있는 경우
          else {
            nxtY = curY + d;
            if (inRange(nxtY, curX)) {
              curY = nxtY;
            } else {
              flag = false;
            }
          }
          break;
      }
    }

    if (flag) {
      sb.append(String.format("%d %d", curX, curY));
    } else {
      sb.append("-1");
    }

    System.out.print(sb);
    br.close();
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < M && 0 <= x && x < M;
  }
}
