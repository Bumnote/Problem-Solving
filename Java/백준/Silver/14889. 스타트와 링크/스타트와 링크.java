import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n; // even number
  private static int minDiff;
  private static int[][] arr;
  private static Set<Integer> combination = new HashSet<>();

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
    minDiff = Integer.MAX_VALUE;
    bt(0, 0);
    System.out.print(minDiff);
  }

  private static void bt(int idx, int cnt) {
    if (cnt == n / 2) {
      int start = 0;
      int link = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (combination.contains(i) && combination.contains(j)) {
            start += arr[i][j];
          } else if (!combination.contains(i) && !combination.contains(j)) {
            link += arr[i][j];
          }
        }
      }
      minDiff = Math.min(minDiff, Math.abs(start - link));
      return;
    }

    for (int i = idx; i < n; i++) {
      combination.add(i);
      bt(i + 1, cnt + 1);
      combination.remove(i);
    }
  }

}