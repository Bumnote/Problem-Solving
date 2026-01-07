import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m;
  private static int[] arr;
  private static long[] prefixSum;
  private static int[] modPrefixSum;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[n];
    prefixSum = new long[n];
    modPrefixSum = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      if (i == 0) {
        prefixSum[i] = arr[i];
        modPrefixSum[i] = (int) (prefixSum[i] % m);
        continue;
      }
      prefixSum[i] = prefixSum[i - 1] + arr[i];
      modPrefixSum[i] = (int) (prefixSum[i] % m);
    }
    br.close();
  }

  // (S[i] - S[j - 1]) % m = 0
  // S[i] % m = S[j - 1] % m
  private static void solve() {
    Map<Integer, Long> countMap = new HashMap<>();

    for (int i = 0; i < n; i++) {
      int mod = modPrefixSum[i];
      countMap.put(mod, countMap.getOrDefault(mod, 0L) + 1);
    }

    long count = countMap.getOrDefault(0, 0L);
    for (Map.Entry<Integer, Long> entry : countMap.entrySet()) {
      long totalCount = entry.getValue();
      count += (totalCount * (totalCount - 1)) / 2;
    }

    System.out.print(count);
  }
}