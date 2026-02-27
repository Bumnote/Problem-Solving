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
    long two = count2(n) - count2(m) - count2(n - m);
    long five = count5(n) - count5(m) - count5(n - m);

    System.out.print(Math.min(two, five));
  }

  static long count2(long x) {
    long cnt = 0;
    while (x > 0) {
      x /= 2;
      cnt += x;
    }
    return cnt;
  }

  static long count5(long x) {
    long cnt = 0;
    while (x > 0) {
      x /= 5;
      cnt += x;
    }
    return cnt;
  }
}