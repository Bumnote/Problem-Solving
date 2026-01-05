import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, k;
  private static long count;
  private static int[] arr;
  private static int[] prefixSum;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    initPrefixSum();
    br.close();
  }

  private static void solve() {
    Map<Integer, Long> map = new HashMap<>();

    count = 0L;
    for (int i = 0; i < n; i++) {
      int target = prefixSum[i] - k; // prefixSum[i] = prefixSum[j] + k 인 j 찾기

      if (target == 0) {
        count++;
      }

      if (map.containsKey(target)) {
        count += map.get(target);
      }

      map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0L) + 1);
    }

    System.out.print(count);
  }

  private static void initPrefixSum() {
    prefixSum = new int[n];
    prefixSum[0] = arr[0];
    for (int i = 1; i < n; i++) {
      prefixSum[i] = prefixSum[i - 1] + arr[i];
    }
  }
}
