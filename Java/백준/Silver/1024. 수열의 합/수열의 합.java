import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, l;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    l = Integer.parseInt(st.nextToken());
    br.close();
  }

  private static void solve() {
    boolean found = false;
    for (int i = l; i <= 100; i++) {
      int num = 2 * n - i * (i - 1);
      int denom = 2 * i;
      if (num % denom == 0) {
        int tmp = num / denom;
        if (tmp >= 0) {
          found = true;
          for (int j = 0; j < i; j++) {
            sb.append(tmp + j).append(" ");
          }
          break;
        }
      }
    }

    if (!found) {
      sb.append(-1);
    }

    System.out.print(sb);
  }
}
