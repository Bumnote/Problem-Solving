import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, r, a, b, d;
  private static final List<List<int[]>> edges = new ArrayList<>();
  private static boolean[] visited;
  private static int longestBranchLength;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken()); // root node number

    for (int i = 0; i <= n; i++) {
      edges.add(new ArrayList<>());
    }

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      // a <-> b: 양방향 d
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      d = Integer.parseInt(st.nextToken());
      edges.get(a).add(new int[]{b, d});
      edges.get(b).add(new int[]{a, d});
    }
    br.close();
  }

  private static void solve() {

    if (n == 1) {
      System.out.printf("0 0");
      return;
    }

    visited = new boolean[n + 1];
    int[] info = calculatePillarLength(r);
    int pillarLength = info[0];
    int gigaNode = info[1];
    int longestBranchLength = calculateLongestBranchLength(gigaNode);

    System.out.printf("%d %d", pillarLength, longestBranchLength);
  }

  private static int[] calculatePillarLength(int r) {

    // 루트 노드가 곧 기가 노드인 경우 -> return 0
    if (edges.get(r).size() > 1) {
      return new int[]{0, r};
    }

    visited[r] = true; // root node 방문 처리
    int pillarLength = 0;
    int gigaNode = r;
    boolean flag = true;

    while (flag) {

      for (int[] edge : edges.get(r)) {
        int nxtNode = edge[0];
        int length = edge[1];

        // 방문한 적이 없다면 -> pillar 갱신
        if (!visited[nxtNode]) {
          pillarLength += length;
          if (edges.get(nxtNode).size() > 2 || edges.get(nxtNode).size() == 1) {
            gigaNode = nxtNode;
            flag = false;
            break;
          }
          visited[nxtNode] = true;
          r = nxtNode;
        }
      }
    }

    return new int[]{pillarLength, gigaNode};
  }

  private static int calculateLongestBranchLength(int gigaNode) {
    // gigaNode가 leaf node인 경우 -> return 0
    if (visited[gigaNode]) {
      return 0;
    }

    longestBranchLength = 0;
    dfs(gigaNode, 0);
    return longestBranchLength;
  }

  private static void dfs(int node, int totalLength) {

    longestBranchLength = Math.max(longestBranchLength, totalLength);
    visited[node] = true; // 방문 처리

    for (int[] edge : edges.get(node)) {
      int nxtNode = edge[0];
      int length = edge[1];

      // 방문한 적이 없다면 -> dfs
      if (!visited[nxtNode]) {
        dfs(nxtNode, totalLength + length);
      }
    }
  }
}