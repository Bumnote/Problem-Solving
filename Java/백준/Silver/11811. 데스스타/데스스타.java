import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static final int MAX = (int) 1e9;
  private static int[][] arr;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    n = Integer.parseInt(br.readLine());

    arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static void solve() {

    int[] answer = new int[n];
    for (int i = 0; i < n; i++) {
      int result = arr[i][0];
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }
        result |= arr[i][j];
      }
      answer[i] = result;
      sb.append(answer[i]).append(" ");
    }

    System.out.print(sb);
  }
}