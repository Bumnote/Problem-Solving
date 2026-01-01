import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int a, b, d;
  private static final int LEN = 4_000_0000;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    br.close();
  }

  private static void solve() throws IOException {

    boolean[] sieve = new boolean[LEN + 1];
    sieve[0] = sieve[1] = true;
    for (int i = 2; i <= Math.sqrt(LEN); i++) {
      if (!sieve[i]) {
        for (int j = i * i; j <= LEN; j += i) {
          sieve[j] = true;
        }
      }
    }

    int count = 0;
    for (int i = a; i <= b; i++) {
      // 소수인 경우
      if (!sieve[i]) {
        String numStr = String.valueOf(i);
        if (numStr.contains(String.valueOf(d))) {
          count++;
        }
      }
    }

    System.out.print(count);
  }
}