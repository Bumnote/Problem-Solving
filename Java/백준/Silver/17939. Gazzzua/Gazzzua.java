import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;
  private static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      pq.offer(new int[]{arr[i], i});
    }

    br.close();
  }

  private static void solve() {

    int idx = 0;
    int answer = 0;
    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int value = curr[0];
      int pos = curr[1];
      if (idx < pos) {
        for (int i = idx; i < pos; i++) {
          answer += (value - arr[i]);
        }
        idx = pos + 1;
      } else if (idx == pos) {
        idx++;
      }
    }

    System.out.print(answer);
  }
}
