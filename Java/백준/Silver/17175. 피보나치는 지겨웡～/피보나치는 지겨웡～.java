import java.io.*;
import java.util.*;

class Main {

  static final long MOD = 1_000_000_007;
  static int n;
  static long[] dp;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    dp = new long[51];
    dp[0] = dp[1] = 1;

    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    sc.close();
  }

  private static void solve() {
    long cnt = fibonacci(n);
    System.out.print(cnt % MOD);
  }

  private static long fibonacci(int n) {
    if (dp[n] != 0) return dp[n] % MOD;

    long sum = (1 + fibonacci(n - 2) % MOD + fibonacci(n - 1) % MOD) % MOD;
    dp[n] = sum;
    return dp[n];
  }
}
