import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static final int MAX = 1_000_000;
  private static int[] arr = new int[MAX + 1];
  private static boolean[] visited = new boolean[10];

  public static void main(String[] args) throws Exception {

    init();
    while (true) {
      n = Integer.parseInt(br.readLine());
      if (n == 0) {
        break;
      }
      solve();
    }

    System.out.print(sb);
    br.close();
  }

  private static void init() throws Exception {

    int num = 1;
    int idx = 1;
    while (idx <= MAX) {
      if (isNonRepeatableNumber(num)) {
        arr[idx++] = num;
      }
      num++;
    }
  }

  private static boolean isNonRepeatableNumber(int num) {

    Arrays.fill(visited, false);

    for (int i = num; i > 0; i /= 10) {
      int digit = i % 10;
      if (visited[digit]) {
        return false;
      }
      visited[digit] = true;
    }

    return true;
  }

  private static void solve() {
    sb.append(arr[n]).append("\n");
  }
}