import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static boolean flag;
  private static String S, T;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    S = br.readLine().trim();
    T = br.readLine().trim();
    br.close();
  }

  private static void solve() {
    String tempT = T;
    dfs(tempT);
    System.out.print(flag ? 1 : 0);
  }

  private static void dfs(String tempT) {

    if (flag || tempT.length() < S.length()) {
      return;
    }

    if (S.length() == tempT.length()) {
      if (S.equals(tempT)) {
        flag = true;
        return;
      }
    }

    if (tempT.charAt(0) == 'B') {
      String substr = tempT.substring(1);
      StringBuilder reversed = new StringBuilder(substr).reverse();
      String nextStr = reversed.toString();
      dfs(nextStr);
    }

    if (tempT.charAt(tempT.length() - 1) == 'A') {
      String nextStr = tempT.substring(0, tempT.length() - 1);
      dfs(nextStr);
    }
  }
}