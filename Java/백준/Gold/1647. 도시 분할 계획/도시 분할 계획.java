import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m, a, b, c;
  private static List<List<int[]>> graph = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());

      graph.get(a).add(new int[]{b, c});
      graph.get(b).add(new int[]{a, c});
    }

    br.close();
  }

  private static void solve() {
    System.out.print(prim());
  }

  private static int prim() {

    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
    pq.offer(new int[]{1, 0}); // (start vertex, cost)

    boolean[] visited = new boolean[n + 1];

    int totalCost = 0;
    int vertexCount = 0;
    int maxDist = 0;
    while (vertexCount < n) {
      int[] curr = pq.poll();

      if (visited[curr[0]]) {
        continue;
      }

      totalCost += curr[1];
      vertexCount++;
      visited[curr[0]] = true;
      maxDist = Math.max(maxDist, curr[1]);

      for (int[] nxt : graph.get(curr[0])) {
        if (!visited[nxt[0]]) {
          pq.offer(new int[]{nxt[0], nxt[1]});
        }
      }
    }

    return totalCost - maxDist;
  }
}
