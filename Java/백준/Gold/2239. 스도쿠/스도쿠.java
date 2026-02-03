import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static final int SIZE = 9;
  private static boolean flag = false;
  private static final int[][] arr = new int[SIZE][SIZE];

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    for (int i = 0; i < SIZE; i++) {
      String line = br.readLine();
      for (int j = 0; j < SIZE; j++) {
        arr[i][j] = line.charAt(j) - '0';
      }
    }

    br.close();
  }

  private static void solve() {
    bt(0, 0);
    System.out.print(sb);
  }

  private static void bt(int y, int x) {

    // 기저 조건 1
    if (flag) {
      return;
    }

    // 기저 조건 2
    if (y == SIZE) {
      for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
          sb.append(arr[i][j]);
        }
        sb.append("\n");
      }
      flag = true;
      return;
    }

    int ny = y;
    int nx = x + 1;
    if (nx == SIZE) {
      ny = y + 1;
      nx = 0;
    }

    if (arr[y][x] != 0) {
      bt(ny, nx);
      return;
    }

    for (int num = 1; num <= SIZE; num++) {
      if (availableNumber(y, x, num)) {
        arr[y][x] = num;
        bt(ny, nx);
        arr[y][x] = 0;
      }
    }
  }

  private static boolean availableNumber(int y, int x, int num) {
    // row, col check
    for (int i = 0; i < SIZE; i++) {
      if (arr[y][i] == num || arr[i][x] == num) {
        return false;
      }
    }

    // box check
    int boxRowIndex = (y / 3) * 3;
    int boxColIndex = (x / 3) * 3;
    for (int i = boxRowIndex; i < boxRowIndex + 3; i++) {
      for (int j = boxColIndex; j < boxColIndex + 3; j++) {
        if (arr[i][j] == num) {
          return false;
        }
      }
    }

    return true;
  }
}
