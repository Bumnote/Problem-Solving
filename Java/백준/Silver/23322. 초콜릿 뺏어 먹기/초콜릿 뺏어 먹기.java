import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, k, minCount;
  private static int[] arr;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void solve() {

    Arrays.sort(arr);

    int day = 0;
    int cnt = 0;
    minCount = arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i - 1] <= arr[i] && minCount < arr[i]) {
        while (arr[i] > arr[i - 1]) {
          arr[i] -= 1;
          cnt++;
        }
        day++;
      }
    }

    System.out.print(cnt + " " + day);
  }
}