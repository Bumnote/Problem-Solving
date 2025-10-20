import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer st;

  private static int n, s;
  private static int[] numbers;
  private static final int INF = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());

    numbers = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void solve() {

    int sum, count, left, right;
    sum = left = right = 0;
    count = INF;

    for (int i = 0; i < n; i++) {
      // 연속 부분합이 S를 초과하는 경우
      if (sum + numbers[i] >= s) {
        while (sum + numbers[i] >= s) {
          sum -= numbers[left];
          left++;
        }
        right++;
        sum += numbers[i];
        count = Math.min(count, right - left + 1);
      }
      // 연속 부분합이 S보다 작은 경우
      else {
        right++;
        sum += numbers[i];
      }
    }

    System.out.print(count != INF ? count : 0);
  }
}