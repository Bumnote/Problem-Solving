import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;
  private static final int MOD = (int) (1e9 + 7);

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    arr = new int[n - 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n - 1; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void solve() {

    long res = 0;
    long prev = 0;
    for (int i = 0; i < n - 1; i++) {
      prev = ((prev + 1) * arr[i]) % MOD;
      res = (res + prev) % MOD;
    }

    System.out.print(res);
  }
}