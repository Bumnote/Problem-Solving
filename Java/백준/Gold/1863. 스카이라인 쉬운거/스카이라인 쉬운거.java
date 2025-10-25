import java.io.*;
import java.util.*;

class Main {

  private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer st;

  private static int n, x, y;
  private static final Deque<Integer> dq = new ArrayDeque<>();

  public static void main(String[] args) throws IOException {
    solve();
  }

  private static void solve() throws IOException {

    n = Integer.parseInt(br.readLine());

    int buildingCount = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());

      while (!dq.isEmpty() && dq.peekLast() > y) {
        dq.pollLast();
        buildingCount++;
      }

      if (!dq.isEmpty() && dq.peekLast() == y) {
        continue;
      }

      dq.offer(y);
    }

    while (!dq.isEmpty()) {
      Integer height = dq.pollLast();
      if (height > 0) {
        buildingCount++;
      }
    }

    System.out.print(buildingCount);
    br.close();
  }
}