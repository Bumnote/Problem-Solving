import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static String number;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    number = br.readLine();
    br.close();
  }

  private static void solve() {

    int pt = 0;
    int base = 0;
    while (base++ <= 30_000) {
      String tmp = String.valueOf(base);
      for (int i = 0; i < tmp.length(); i++) {
        if (tmp.charAt(i) == number.charAt(pt)) {
          pt++;
        }
        if (pt == number.length()) {
          System.out.print(base);
          return;
        }
      }
    }
  }
}
