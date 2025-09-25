import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer st;
  private static final int LEN = 1_001;
  private static int n, m;
  private static int[] arr = new int[LEN + 1];

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    if (m == 0) {
      return;
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int idx = Integer.parseInt(st.nextToken());
      arr[idx] = 1;
    }
  }

  private static void solve() {

    int MIN = Integer.MAX_VALUE;
    for (int i = 1; i <= LEN; i++) {
      if (arr[i] == 1) {
        continue;
      }
      for (int j = i; j <= LEN; j++) {
        if (arr[j] == 1) {
          continue;
        }
        for (int k = j; k <= LEN; k++) {
          if (arr[k] == 1) {
            continue;
          }
          MIN = Math.min(MIN, Math.abs(n - (i * j * k)));
        }
      }
    }
    System.out.print(MIN);
  }
}