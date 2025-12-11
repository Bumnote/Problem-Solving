import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[] dist;
  private static int[] cost;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    dist = new int[n - 1];
    cost = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n - 1; i++) {
      dist[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      cost[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void solve() {

    long sum = 0;
    long minCost = Long.MAX_VALUE;
    for (int i = 0; i < n - 1; i++) {
      if (minCost > cost[i]) {
        minCost = (long) cost[i];
      }
      sum += (long) minCost * dist[i];
    }

    System.out.print(sum);
  }
}
