import java.io.*;
import java.util.*;

public class Main {

  static int N, d, k, c;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 입력 부분
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // N: 접시의 수
    d = Integer.parseInt(st.nextToken()); // d: 초밥의 가짓 수
    k = Integer.parseInt(st.nextToken()); // k: 연속해서 먹는 접시의 수
    c = Integer.parseInt(st.nextToken()); // c: 쿠폰 번호

    arr = new int[2 * N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      arr[N + i] = arr[i];
    }

    br.close();
  }

  private static void solve() {

    Map<Integer, Integer> cache = new HashMap<>();
    for (int i = 0; i < k; i++) {
      cache.put(arr[i], cache.getOrDefault(arr[i], 0) + 1);
    }

    int ans = (!cache.containsKey(c)) ? cache.size() + 1 : cache.size();
    for (int right = k; right < N + k; right++) {

      int remain = cache.get(arr[right - k]);
      if (remain == 1) {
        cache.remove(arr[right - k]);
      } else {
        cache.put(arr[right - k], remain - 1);
      }

      cache.put(arr[right], cache.getOrDefault(arr[right], 0) + 1);

      if (!cache.containsKey(c)) {
        ans = Math.max(ans, cache.size() + 1);
      } else {
        ans = Math.max(ans, cache.size());
      }
    }

    System.out.println(ans);
  }
}
