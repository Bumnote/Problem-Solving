import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int t;
  private static long n;

  public static void main(String[] args) throws Exception {
    t = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < t; tc++) {
      init();
      solve();
    }
    System.out.print(sb);
    br.close();
  }

  private static void init() throws Exception {
    n = Long.parseLong(br.readLine());
  }

  private static void solve() {

    Deque<Long> dq = new ArrayDeque<>();
    while (n > 0) {
      dq.offerFirst(n % 2);
      n /= 2;
    }

    int power = 0;
    long answer = 0;
    while (!dq.isEmpty()) {
      long num = dq.pollLast();
      if (num == 1) {
        long tmp = 1;
        for (int i = 1; i <= power; i++) {
          tmp *= 3;
        }
        answer += tmp;
      }
      power++;
    }
    sb.append(answer).append("\n");
  }
}
