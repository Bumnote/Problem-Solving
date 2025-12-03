import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, leftHand, rightHand, waist, leftLeg, rightLeg;
  private static char[][] cookie;
  private static final int[] dys = {0, 0, -1, 1}, dxs = {-1, 1, 0, 0}; // 좌, 우, 상, 하
  private static final char COOKIE_MARK = '*';

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    n = Integer.parseInt(br.readLine());
    cookie = new char[n][n];

    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < n; j++) {
        cookie[i][j] = line.charAt(j);
      }
    }
    br.close();
  }

  private static void solve() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int cookieCount = 0;
        for (int k = 0; k < 4; k++) {
          int ny = i + dys[k];
          int nx = j + dxs[k];
          if (inRange(ny, nx) && cookie[ny][nx] == COOKIE_MARK) {
            cookieCount++;
          }
        }

        // 쿠키의 심장인 경우 -> 팔, 다리, 허리 길이 찾기
        if (cookieCount == 4) {
          sb.append(i + 1).append(" ").append(j + 1).append("\n");
          leftHand = calculateBodyLength(i, j, 0);
          rightHand = calculateBodyLength(i, j, 1);
          waist = calculateBodyLength(i, j, 3);
          leftLeg = calculateBodyLength(i + waist, j - 1, 3);
          rightLeg = calculateBodyLength(i + waist, j + 1, 3);
          sb.append(leftHand).append(" ")
              .append(rightHand).append(" ")
              .append(waist).append(" ")
              .append(leftLeg).append(" ")
              .append(rightLeg);

          System.out.print(sb);
          return;
        }
      }
    }
  }

  private static int calculateBodyLength(int y, int x, int direction) {
    int length = 0;
    while (true) {
      int ny = y + dys[direction];
      int nx = x + dxs[direction];
      if (inRange(ny, nx) && cookie[ny][nx] == COOKIE_MARK) {
        length++;
        y = ny;
        x = nx;
      } else {
        return length;
      }
    }
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }
}
