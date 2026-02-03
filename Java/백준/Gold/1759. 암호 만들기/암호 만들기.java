import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int l, c;
  private static char[] arr;
  private static Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    l = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    arr = new char[c];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < c; i++) {
      arr[i] = st.nextToken().charAt(0);
    }

    Arrays.sort(arr);
    br.close();
  }

  private static void solve() {
    bt(0, 0, "");
    System.out.print(sb);
  }

  private static void bt(int cnt, int idx, String password) {

    // 기저 조건
    if (cnt == l) {
      int vowelCount = 0;
      for (int i = 0; i < l; i++) {
        if (vowels.contains(password.charAt(i))) {
          vowelCount++;
        }
      }

      if (vowelCount >= 1 && (l - vowelCount) >= 2) {
        sb.append(password).append('\n');
      }
      return;
    }

    for (int i = idx; i < c; i++) {
      bt(cnt + 1, i + 1, password + arr[i]);
    }
  }
}
