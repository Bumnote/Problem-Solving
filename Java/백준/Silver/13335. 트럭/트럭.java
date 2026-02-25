import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, w, l;
  private static int[] a;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());
    l = Integer.parseInt(st.nextToken());

    a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void solve() {

    Deque<Integer> dq = new ArrayDeque<>();

    for (int i = 0; i < w; i++) {
      dq.offer(0);
    }

    int idx = 0;
    int time = 0;
    int totalWeight = 0;

    while (idx < n) {
      time++;

      totalWeight -= dq.pollFirst();
      // 트럭이 다리에 올라갈 수 있다면 -> 다리에 트럭을 올린다.
      if (totalWeight + a[idx] <= l) {
        dq.offerLast(a[idx]);
        totalWeight += a[idx];
        idx++;
      }
      // 트럭이 다리에 올라갈 수 없다면 -> 다리에 0을 올린다.
      else {
        dq.offerLast(0);
      }
    }

    int answer = time + w;
    System.out.print(answer);
  }
}