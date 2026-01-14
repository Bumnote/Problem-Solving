import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

    int idx = 0;
    int sum = 0;
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) == '*') {
        idx = i;
        continue;
      }
      if (i % 2 == 0) {
        sum += (word.charAt(i) - '0');
      } else {
        sum += (word.charAt(i) - '0') * 3;
      }
    }

    for (int i = 0; i <= 9; i++) {
      if (idx % 2 == 0) {
        if ((sum + i) % 10 == 0) {
          System.out.print(i);
          return;
        }
      } else {
        if ((sum + i * 3) % 10 == 0) {
          System.out.print(i);
          return;
        }
      }
    }
  }
}
