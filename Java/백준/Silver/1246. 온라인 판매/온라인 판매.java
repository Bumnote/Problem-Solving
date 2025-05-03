import java.io.*;
import java.util.*;

class Main {

  static int N, M, P;
  static int[] arr, ans;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // N: 달걀의 개수
    M = Integer.parseInt(st.nextToken()); // M: 고객의 수

    arr = new int[M];
    for (int i = 0; i < M; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    br.close();
  }

  private static void solve() {

    Arrays.sort(arr);

    int MAX = 0;
    for (int i = 0; i < M; i++) {
      int profit = arr[i] * Math.min(N, M - i);
      if (MAX < profit) {
        MAX = profit;
        ans = new int[]{arr[i], profit};
      }
    }

    System.out.printf("%d %d", ans[0], ans[1]);
  }
}