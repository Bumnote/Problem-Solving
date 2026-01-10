import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[] A;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());

    A = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
  }

  private static void solve() {

    Arrays.sort(A);
    int maxLength = n <= 2 ? 1 : 2;

    for (int left = 0; left < n - 1; left++) {
      for (int right = n - 1; left + 1 <= right; right--) {
        if (isTriRelation(A[left], A[left + 1], A[right])) {
          maxLength = Math.max(maxLength, right - left + 1);
          break;
        }
      }
    }

    System.out.print(maxLength);
  }

  private static boolean isTriRelation(int x, int y, int z) {
    return (x + y > z) && (y + z > x) && (z + x > y);
  }
}