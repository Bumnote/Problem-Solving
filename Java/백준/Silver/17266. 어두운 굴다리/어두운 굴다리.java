import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m;
  private static int[] pos;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());
    pos = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      pos[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
  }

  private static void solve() {
    int left = 1;
    int right = 2 * n;
    int answer = right;
    while (left < right) {
      int height = (left + right) / 2;
      if (isWholeLighted(height)) {
        answer = Math.min(answer, height);
        right = height;
      } else {
        left = height + 1;
      }
    }

    System.out.print(answer);
  }

  private static boolean isWholeLighted(int height) {
    int firstPosition = Math.max(0, pos[0] - height);
    int lastPosition = Math.min(n, pos[m - 1] + height);
    if (firstPosition != 0 || lastPosition != n) {
      return false;
    }

    for (int i = 1; i < m - 1; i++) {
      if (pos[i] + height < pos[i + 1] - height) {
        return false;
      }
    }

    return true;
  }
}
