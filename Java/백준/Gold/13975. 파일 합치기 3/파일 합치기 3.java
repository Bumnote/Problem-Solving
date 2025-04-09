import java.io.*;
import java.util.*;

class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int T, N;
  static PriorityQueue<Long> pq;

  public static void main(String[] args) throws IOException {

    T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      init();
      solve();
    }
    System.out.print(sb);
    br.close();
  }

  private static void init() throws IOException {

    N = Integer.parseInt(br.readLine());

    pq = new PriorityQueue<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      pq.offer(Long.parseLong(st.nextToken()));
    }
  }

  private static void solve() {

    long total = 0;
    while (true) {
      long sum = 0;
      long a = pq.poll();
      long b = pq.poll();

      total += (a + b);
      sum += (a + b);
      if (pq.isEmpty()) {
        break;
      }
      pq.offer(sum);
    }

    sb.append(total).append("\n");
  }
}