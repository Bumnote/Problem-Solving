import java.io.*;
import java.util.*;

class Main {

  static final int LEN = 1_000_000;
  static int N;
  static long[] sum;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    br.close();
  }

  private static void solve() {

    sum = new long[LEN + 1];
    Arrays.fill(sum, 1); // 모든 수는 1을 약수로 가진다.

    long total = 1;
    // 에라토스테네스의 체 활용
    for (int i = 2; i <= LEN; i++) {
      for (int j = i; j <= LEN; j += i) {
        sum[j] += i;
      }
      if (i <= N) {
        total += sum[i];
      }
    }

    System.out.print(total);
  }
}
