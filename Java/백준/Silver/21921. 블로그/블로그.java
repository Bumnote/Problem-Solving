import java.io.*;
import java.util.*;

class Main {

  static int n, x;
  static int[] arr;
  static int[] prefix;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken()); // n: 지난 일수
    x = Integer.parseInt(st.nextToken()); // x: 누적 일수

    arr = new int[n];
    prefix = new int[n + 1]; // 누적합 배열

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      prefix[i + 1] = prefix[i] + arr[i];
    }
    br.close();
  }

  private static void solve() {

    int max = prefix[x];
    int cnt = 1;
    for (int i = x + 1; i <= n; i++) {
      int sum = prefix[i] - prefix[i - x];
      if (max < sum) {
        max = sum;
        cnt = 1;
      } else if (max == sum) {
        cnt++;
      }
    }

    if (max == 0) System.out.print("SAD");
    else System.out.printf("%d\n%d", max, cnt);
  }
}
