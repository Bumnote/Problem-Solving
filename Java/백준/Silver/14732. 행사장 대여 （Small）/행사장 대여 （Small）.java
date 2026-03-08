import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int x1, y1, x2, y2;
  private static boolean[][] map;
  private static final int MAX = 500;


  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    map = new boolean[MAX + 1][MAX + 1];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      x1 = Integer.parseInt(st.nextToken());
      y1 = Integer.parseInt(st.nextToken());
      x2 = Integer.parseInt(st.nextToken());
      y2 = Integer.parseInt(st.nextToken());
      for (int j = x1; j < x2; j++) {
        for (int k = y1; k < y2; k++) {
          map[j][k] = true;
        }
      }
    }
    br.close();
  }

  private static void solve() {

    int count = 0;
    for (int i = 0; i <= MAX; i++) {
      for (int j = 0; j <= MAX; j++) {
        if (map[i][j]) {
          count++;
        }
      }
    }
    
    System.out.print(count);
  }
}