import static java.util.Arrays.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, l;
  private static int[] arr;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    l = Integer.parseInt(st.nextToken());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
  }

  private static void solve() throws IOException {

    sort(arr);
    int count = 0;
    l -= 1;

    int start = arr[0];
    for (int i = 1; i < n; i++) {
      if (start + l < arr[i]) {
        count++;
        start = arr[i];
      }

      if (i == n - 1 && start + l >= arr[i]) {
        count += 1;
      }
    }

    System.out.print(n == 1 ? 1 : count);
  }
}
