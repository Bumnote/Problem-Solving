import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    arr = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    br.close();
  }

  private static void solve() throws IOException {

    if (n == 1) {
      System.out.print(1);
      return;
    }

    for (int i = 1; i <= n; i++) {
      // 시작 지점인 경우
      if (i == 1) {
        if (arr[i] >= arr[i + 1]) {
          sb.append(i).append("\n");
        }
      }
      // 끝 지점인 경우
      else if (i == n) {
        if (arr[i - 1] <= arr[i]) {
          sb.append(i).append("\n");
        }
      }
      // 중간 지점인 경우
      else {
        if (arr[i - 1] <= arr[i] && arr[i] >= arr[i + 1]) {
          sb.append(i).append("\n");
        }
      }
    }

    System.out.print(sb);
  }
}
