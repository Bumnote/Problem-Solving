import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int a, b, c, n;
  private static int[][] arr;
  private static boolean[] mustTrue;
  private static boolean[] mustFalse;
  private static List<int[]> failureList = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    n = Integer.parseInt(br.readLine());
    mustTrue = new boolean[a + b + c + 1];
    mustFalse = new boolean[a + b + c + 1];
    arr = new int[n][4];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 4; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
      if (arr[i][3] == 1) {
        mustTrue[arr[i][0]] = true;
        mustTrue[arr[i][1]] = true;
        mustTrue[arr[i][2]] = true;
      } else {
        failureList.add(new int[]{arr[i][0], arr[i][1], arr[i][2]});
      }
    }

    br.close();
  }

  private static void solve() {
    for (int[] failure : failureList) {
      int x = failure[0];
      int y = failure[1];
      int z = failure[2];

      if (mustTrue[x] && mustTrue[y]) {
        mustFalse[z] = true;
      }
      if (mustTrue[y] && mustTrue[z]) {
        mustFalse[x] = true;
      }
      if (mustTrue[z] && mustTrue[x]) {
        mustFalse[y] = true;
      }
    }

    for (int i = 1; i <= a + b + c; i++) {
      if (mustTrue[i]) {
        sb.append(1).append("\n");
      } else if (mustFalse[i]) {
        sb.append(0).append("\n");
      } else {
        sb.append(2).append("\n");
      }
    }

    System.out.print(sb);
  }
}