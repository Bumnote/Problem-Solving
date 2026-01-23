import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m;
  private static String name, x, y;
  private static final Map<String, Integer> nameId = new HashMap<>();
  private static final Map<Integer, String> idName = new HashMap<>();
  private static final PriorityQueue<String> pq = new PriorityQueue<>();
  private static int[] parent, rank, inDegree, outDegree, outDp;
  private static List<List<Integer>> graph = new ArrayList<>();
  private static List<List<Integer>> reverseGraph = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
      reverseGraph.add(new ArrayList<>());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      name = st.nextToken();
      nameId.put(name, i);
      idName.put(i, name);
      pq.offer(name);
    }

    inDegree = new int[n + 1];
    outDegree = new int[n + 1];

    parent = new int[n + 1];
    rank = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
      rank[i] = 0;
    }

    m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      // x -> y
      x = st.nextToken();
      y = st.nextToken();

      union(nameId.get(x), nameId.get(y));
      int xId = nameId.get(x);
      int yId = nameId.get(y);

      graph.get(xId).add(yId);
      reverseGraph.get(yId).add(xId);
      inDegree[yId]++;
      outDegree[xId]++;
    }

    br.close();
  }

  public static void solve() {
    // union-find -> 가문의 개수 구하기
    Set<Integer> roots = new HashSet<>();
    for (int i = 1; i <= n; i++) {
      roots.add(find(i));
    }
    sb.append(roots.size()).append("\n");

    // 역방향 위상정렬 -> 조상 및 자식 수 구하기
    Deque<Integer> dq = new ArrayDeque<>();
    List<String> lst = new ArrayList<>();
    while (!pq.isEmpty()) {
      String name = pq.poll();
      lst.add(name);
      Integer id = nameId.get(name);
      if (outDegree[id] == 0) {
        dq.offer(id);
        sb.append(name).append(" ");
      }
    }

    sb.append("\n");
    outDp = new int[n + 1];
    int maxDepth = 0;
    while (!dq.isEmpty()) {
      Integer curr = dq.poll();

      for (int nxt : reverseGraph.get(curr)) {
        outDp[nxt] = Math.max(outDp[nxt], outDp[curr] + 1);
        maxDepth = Math.max(maxDepth, outDp[nxt]);

        outDegree[nxt]--;
        if (outDegree[nxt] == 0) {
          dq.offer(nxt);
        }
      }
    }

    for (String name : lst) {
      Integer id = nameId.get(name);
      // 최대 깊이인 경우 -> 자식 0
      if (outDp[id] == maxDepth) {
        sb.append(name).append(" ").append(0).append("\n");
        continue;
      }

      int count = 0;
      PriorityQueue<String> childrenNames = new PriorityQueue<>();
      for (int child : reverseGraph.get(id)) {
        if (outDp[child] == outDp[id] + 1) {
          childrenNames.offer(idName.get(child));
          count++;
        }
      }

      sb.append(name).append(" ").append(count).append(" ");
      if (count > 0) {
        while (!childrenNames.isEmpty()) {
          sb.append(childrenNames.poll()).append(" ");
        }
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }

  private static void union(int x, int y) {

    int xRoot = find(x);
    int yRoot = find(y);

    if (xRoot == yRoot) {
      return;
    }

    if (rank[xRoot] < rank[yRoot]) {
      parent[xRoot] = yRoot;
    } else if (rank[xRoot] > rank[yRoot]) {
      parent[yRoot] = xRoot;
    } else {
      parent[yRoot] = xRoot;
      rank[xRoot]++;
    }
  }

  private static int find(int x) {
    if (parent[x] != x) {
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }
}
