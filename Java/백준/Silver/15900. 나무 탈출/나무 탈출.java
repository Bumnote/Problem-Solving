import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, a, b;
  private static boolean[] visited;
  private static final List<List<Integer>> trees = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    n = Integer.parseInt(br.readLine());

    for (int i = 0; i <= n; i++) {
      trees.add(new ArrayList<>());
    }

    visited = new boolean[n + 1];
    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      trees.get(a).add(b);
      trees.get(b).add(a);
    }

    br.close();
  }

  private static void solve() {
    visited[0] = true;
    int oddLevelNodeLeafCount = dfs(1, 0);

    if (oddLevelNodeLeafCount % 2 == 1) {
      System.out.print("Yes");
    } else {
      System.out.print("No");
    }
  }

  private static int dfs(int root, int level) {

    if (trees.get(root).size() == 1 && level != 0) {
      if (level % 2 == 1) {
        return 1;
      }
      return 0;
    }

    int oddLevelLeafNodeCount = 0;
    for (Integer nxt : trees.get(root)) {
      if (visited[nxt]) {
        continue;
      }

      visited[nxt] = true;
      oddLevelLeafNodeCount += dfs(nxt, level + 1);
    }

    return oddLevelLeafNodeCount;
  }
}