import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int m, n, s; // m개의 n면체 주사위의 총합 s
  private static long X = 1_000_000_007;
  private static List<long[]> arr = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    m = Integer.parseInt(br.readLine());

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      s = Integer.parseInt(st.nextToken());
      arr.add(new long[]{n, s});
    }

    br.close();
  }

  private static void solve() {

    long gcd = -1, lcm = -1;
    long child = -1, parent = -1;
    for (long[] dice : arr) {
      long s = dice[1]; // 모든 면의 합
      long n = dice[0]; // n면체

      if (child == -1 && parent == -1) {
        child = s;
        parent = n;
        continue;
      }

      child = ((child * n % X) + (s * parent % X)) % X;
      parent = (parent * n) % X;
    }

    long answer = modularCalculation(child, parent);
    System.out.print(answer);
  }

  private static long modularCalculation(long child, long parent) {
    // 기약 분수가 아닌, 정수인 경우 -> 그대로 기댓값을 반환한다.
    if (parent == 1) {
      return child;
    }

    return (child * modularPow(parent, X - 2)) % X;
  }

  private static long modularPow(long base, long exp) {
    long result = 1;
    base %= X;

    while (exp > 0) {
      if ((exp & 1) == 1) {
        result = (result * base) % X;
      }
      base = (base * base) % X;
      exp >>= 1;
    }
    return result;
  }
}