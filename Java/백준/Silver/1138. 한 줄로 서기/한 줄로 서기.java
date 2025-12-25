import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    Arrays.fill(arr, Integer.MIN_VALUE);
  }

  private static void solve() throws IOException {

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int cnt = 0;
      int num = Integer.parseInt(st.nextToken());
      for (int j = 0; j < n; j++) {
        if (cnt == num && arr[j] == Integer.MIN_VALUE) {
          arr[j] = i + 1;
          break;
        }
        if (arr[j] == Integer.MIN_VALUE) {
          cnt++;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }

  }
}