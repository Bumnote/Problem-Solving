import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static PriorityQueue<Integer> pq = new PriorityQueue<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      pq.offer(Integer.parseInt(br.readLine()));
    }

    br.close();
  }

  private static void solve() {

    while (!pq.isEmpty()) {
      sb.append(pq.poll()).append("\n");
    }

    System.out.print(sb);
  }
}
