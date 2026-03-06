import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static String word, target;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    word = br.readLine();
    target = br.readLine();
    br.close();
  }

  private static void solve() {
    int n = word.length();
    int m = target.length();

    int answer = 0;
    for (int i = 0; i <= n - m; i++) {
      int idx = i;
      int count = 0;
      while (idx <= n - m) {
        String tmp = word.substring(idx, idx + m);
        if (tmp.equals(target)) {
          count++;
          idx += m;
        } else {
          idx++;
        }
      }

      answer = Math.max(answer, count);
    }

    System.out.print(answer);
  }
}