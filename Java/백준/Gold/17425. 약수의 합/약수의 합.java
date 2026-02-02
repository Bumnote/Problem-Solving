import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int t, n;
  private static long[] primes;
  private static long[] prefixSum;
  private static final int LEN = 1_000_000;

  public static void main(String[] args) throws Exception {

    primes = new long[LEN + 1];

    for (int i = 1; i <= LEN; i++) {
      for (int j = i; j <= LEN; j += i) {
        primes[j] += i;
      }
    }

    prefixSum = new long[LEN + 1];
    for (int i = 1; i <= LEN; i++) {
      prefixSum[i] = prefixSum[i - 1] + primes[i];
    }

    t = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= t; tc++) {
      init();
      solve();
    }
    System.out.print(sb);
    sb.setLength(0);
    br.close();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
  }

  private static void solve() {
    sb.append(prefixSum[n]).append("\n");
  }
}
