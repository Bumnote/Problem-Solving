import java.io.*;
import java.util.*;

class Main {

  static class Truck {

    int weight;
    int outTime;

    Truck(int weight, int outTime) {
      this.weight = weight;
      this.outTime = outTime;
    }
  }

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

    Deque<Truck> bridge = new ArrayDeque<>();
    int time = 0;
    int totalWeight = 0;
    int idx = 0;

    while (idx < n) {
      // 현재 시간에 나갈 트럭 제거
      if (!bridge.isEmpty() && bridge.peekFirst().outTime == time) {
        Truck t = bridge.pollFirst();
        totalWeight -= t.weight;
      }

      // 다음 트럭을 올릴 수 있는 경우
      if (totalWeight + a[idx] <= l && bridge.size() < w) {
        bridge.offerLast(new Truck(a[idx], time + w));
        totalWeight += a[idx];
        idx++;
      } else {
        // 못 올리면 시간 점프
        if (!bridge.isEmpty()) {
          time = bridge.peekFirst().outTime;
          continue;
        }
      }

      time++;
    }

    // 마지막 트럭이 빠지는 시간
    if (!bridge.isEmpty()) {
      time = bridge.peekLast().outTime;
    }

    System.out.print(time + 1);
  }
}