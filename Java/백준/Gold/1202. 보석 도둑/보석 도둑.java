import java.io.*;
import java.util.*;

public class Main {

  static class Jewel implements Comparable<Jewel> {

    long w, v;

    Jewel(int w, int v) {
      this.w = w;
      this.v = v;
    }

    @Override
    public int compareTo(Jewel o) {
      if (this.w != o.w) {
        return Long.compare(this.w, o.w); // 우선, 무게를 기준으로 오름차순 정렬
      }
      return Long.compare(this.v, o.v); // 가치를 기준으로 오름차순 정렬
    }
  }

  static int N, K, M, V, C;
  static PriorityQueue<Jewel> jewels;
  static PriorityQueue<Long> price;
  static int[] backpack;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 입력 부분
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // N: 보석의 개수
    K = Integer.parseInt(st.nextToken()); // K: 가방의 개수

    jewels = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken()); // M: 보석의 무게
      V = Integer.parseInt(st.nextToken()); // V: 보석의 가격
      jewels.add(new Jewel(M, V));
    }

    backpack = new int[K];
    for (int i = 0; i < K; i++) {
      C = Integer.parseInt(br.readLine()); // C: 가방의 최대 무게
      backpack[i] = C;
    }

    // 오름차순 정렬
    Arrays.sort(backpack);
    price = new PriorityQueue<>(Comparator.reverseOrder());
    br.close();
  }

  private static void solve() {

    long total = 0;

    for (int bp : backpack) {
      // 보석이 존재하고, 해당 가방으로 훔칠 수 있을때까지 탐색
      while (!jewels.isEmpty() && jewels.peek().w <= bp) {
        Jewel jewel = jewels.poll();
        price.offer(jewel.v);
      }

      if (!price.isEmpty()) {
        total += price.poll(); // 현재까지 담을 수 있는 보석 중 가장 높은 가치를 더한다.
      }
    }

    System.out.print(total);
  }
}