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

    int time = 0;         // 현재 시각(초)
    int totalWeight = 0;  // 다리 위 총 무게
    int idx = 0;          // 다음에 올릴 트럭 인덱스

    while (idx < n || !bridge.isEmpty()) {

      // 1) 현재 시각에 나갈 트럭들 제거 (점프 때문에 <= 로 안전하게)
      while (!bridge.isEmpty() && bridge.peekFirst().outTime <= time) {
        totalWeight -= bridge.pollFirst().weight;
      }

      // 2) 올릴 수 있으면 올리고, "진입은 1초에 1대"이므로 time++ 해야 함
      if (idx < n && totalWeight + a[idx] <= l && bridge.size() < w) {
        bridge.offerLast(new Truck(a[idx], time + w));
        totalWeight += a[idx];
        idx++;
        time++;
        continue;
      }

      // 3) 못 올리면 다음 이벤트(맨 앞 트럭이 나가는 시각)로 점프
      if (!bridge.isEmpty()) {
        time = bridge.peekFirst().outTime;
      } else {
        // 다리가 비었는데 트럭이 남아있으면 다음 초로
        time++;
      }
    }

    System.out.print(time);
  }
}