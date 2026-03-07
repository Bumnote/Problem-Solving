import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    br.close();
  }

  private static void solve() {

    if (n == 1) {
      System.out.print(1);
    } else if (n == 2) {
      System.out.print(Math.min(4, (m + 1) / 2));
    } else if (m < 7) {
      System.out.print(Math.min(4, m));
    } else {
      System.out.print(m - 2);
    }
  }
}