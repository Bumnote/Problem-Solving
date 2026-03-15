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

    int ans = 1;
    int all = n;
    int odd = n % 2 == 0 ? n / 2 : n / 2 + 1;

    int even = n / 2;
    int k3 = n / 3 + (n % 3 >= 1 ? 1 : 0);

    if (m >= all) {
      ans++;
    }
    if (m >= odd && n > 1) {
      ans++;
    }
    if (m >= even && n > 1) {
      ans++;
    }
    if (m >= k3 && n > 2) {
      ans++;
    }
    if (m >= k3 + odd && n > 2) {
      ans++;
    }
    if (m >= k3 + even && n > 2) {
      ans++;
    }
    if (m >= k3 + all && n > 2) {
      ans++;
    }

    System.out.print(ans);
  }
}