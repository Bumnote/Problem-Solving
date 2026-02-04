import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[][] arr;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    n = Integer.parseInt(br.readLine());

    arr = new int[n + 1][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      arr[i][0] = y;
      arr[i][1] = x;
    }
    arr[n][0] = arr[0][0];
    arr[n][1] = arr[0][1];
    br.close();
  }

  private static void solve() {

    long answer = 0;
    for (int i = 0; i < n; i++) {
      answer += (long) arr[i][0] * arr[i + 1][1] - (long) arr[i][1] * arr[i + 1][0];
    }

    System.out.printf("%.1f", Math.abs(answer) / 2.0);
  }
}
