import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m, a, b;
  private static List<List<Integer>> graph = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    br.close();
  }

  private static void solve() {
    boolean[] visited = new boolean[n + 1];
    visited[1] = true; // 방문 처리

    Deque<int[]> dq = new ArrayDeque<>();
    dq.offer(new int[]{1, 0});

    Set<Integer> set = new HashSet<>();
    while (!dq.isEmpty()) {
      int[] curr = dq.poll();
      int currNode = curr[0];
      int currDepth = curr[1];
      if (currDepth > 2) {
        break;
      }

      for (int nxt : graph.get(currNode)) {
        if (!visited[nxt] && currDepth < 2) {
          visited[nxt] = true;
          set.add(nxt);
          dq.offer(new int[]{nxt, currDepth + 1});
        }
      }
    }

    System.out.print(set.size());
  }
}
