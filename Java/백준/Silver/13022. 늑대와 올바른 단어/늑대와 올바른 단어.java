import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static String word;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    word = br.readLine();
    br.close();
  }

  private static void solve() {

    char[] arr = word.toCharArray();
    char[] ans = new char[]{'w', 'o', 'l', 'f'};

    int idx = 0;
    boolean flag = true;
    while (idx < arr.length) {
      int cnt = 0;
      for (int i = idx; i < arr.length; i++) {
        if (arr[i] == 'w') {
          cnt++;
        } else {
          break;
        }
      }

      if (cnt == 0) {
        flag = false;
        break;
      }

      String tmp = "";
      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < cnt; j++) {
          tmp += String.valueOf(ans[i]);
        }
      }

      if (idx + 4 * cnt <= word.length() && word.substring(idx, idx + 4 * cnt).equals(tmp)) {
        idx = idx + 4 * cnt;
      } else {
        flag = false;
        break;
      }
    }

    System.out.print(flag ? 1 : 0);
  }
}