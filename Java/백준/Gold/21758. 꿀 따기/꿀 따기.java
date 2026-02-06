import java.io.*;
import java.util.*;

class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer st;

  private static int n;
  private static long[] arr;
  private static long[] prefixSum;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    n = Integer.parseInt(br.readLine());
    arr = new long[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }

    prefixSum = new long[n];
    prefixSum[0] = arr[0];
    for (int i = 1; i < n; i++) {
      prefixSum[i] = prefixSum[i - 1] + arr[i];
    }

    br.close();
  }

  private static void solve() {

    long honey;
    long MAX_HONEY = 0;

    // Case 1: 벌-벌-꿀
    for (int i = 1; i < n - 1; i++) {
      honey = (prefixSum[i - 1] - arr[0])
            + (prefixSum[n - 1] - prefixSum[i]) * 2;
      MAX_HONEY = Math.max(MAX_HONEY, honey);
    }

    // Case 2: 꿀-벌-벌
    for (int i = n - 2; i > 0; i--) {
      honey = (prefixSum[n - 2] - prefixSum[i])
            + (prefixSum[i - 1]) * 2;
      MAX_HONEY = Math.max(MAX_HONEY, honey);
    }

    // Case 3: 벌-꿀-벌
    for (int i = 1; i < n - 1; i++) {
      honey = prefixSum[n - 2] - arr[0] + arr[i];
      MAX_HONEY = Math.max(MAX_HONEY, honey);
    }

    System.out.print(MAX_HONEY);
  }
}
