import java.io.*;
import java.util.*;

class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static Map<Integer, List<Integer>> map = new HashMap<>();
  static int n, removeNode, rootNode, leafNodeCount;
  static int[] tree;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    tree = new int[n];
    for (int i = 0; i < n; i++) {
      tree[i] = Integer.parseInt(st.nextToken());
      if (tree[i] == -1) {
        rootNode = i;
      }
    }

    removeNode = Integer.parseInt(br.readLine());
    br.close();
  }

  private static void solve() {

    if (removeNode == rootNode) {
      System.out.print(0);
      return;
    }

    for (int i = 0; i < n; i++) {
      if (i == removeNode) {
        continue;
      }
      map.put(i, new ArrayList<>());
    }

    for (int i = 0; i < n; i++) {
      if (tree[i] == -1 || tree[i] == removeNode || i == removeNode) {
        continue;
      }

      map.get(tree[i]).add(i); // parent -> child
    }

    leafNodeCount = 0;
    visited = new boolean[n];
    visited[rootNode] = true; // 방문 처리
    dfs(rootNode);

    System.out.print(leafNodeCount);
  }

  private static void dfs(int node) {
    if (map.get(node).isEmpty()) {
      leafNodeCount++;
      return;
    }

    for (Integer children : map.get(node)) {
      if (!visited[children]) {
        visited[children] = true;
        dfs(children);
      }
    }
  }
}