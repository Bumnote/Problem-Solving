import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m, u, v, w, oneWalkNum, romaCityNum;
  private static int[] inDegree, outDegree;
  private static List<List<int[]>> graph = new ArrayList<>();
  private static List<List<int[]>> reverseGraph = new ArrayList<>();


  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
      reverseGraph.add(new ArrayList<>());
    }

    inDegree = new int[n + 1];
    outDegree = new int[n + 1];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      // u -> v: w
      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());
      w = Integer.parseInt(st.nextToken());

      graph.get(u).add(new int[]{v, w});
      reverseGraph.get(v).add(new int[]{u, w});
      inDegree[v]++;
      outDegree[u]++;
    }

    st = new StringTokenizer(br.readLine());
    oneWalkNum = Integer.parseInt(st.nextToken());
    romaCityNum = Integer.parseInt(st.nextToken());

    br.close();
  }

  public static void solve() {

    Deque<Integer> dq = new ArrayDeque<>();
    dq.offer(oneWalkNum);

    int[] inDp = new int[n + 1];
    while (!dq.isEmpty()) {

      Integer curr = dq.poll();

      for (int[] nxt : graph.get(curr)) {
        int nxtCityNum = nxt[0];
        int nxtTime = nxt[1];

        inDp[nxtCityNum] = Math.max(inDp[nxtCityNum], inDp[curr] + nxtTime);

        inDegree[nxtCityNum]--;
        if (inDegree[nxtCityNum] == 0) {
          dq.offer(nxtCityNum);
        }
      }
    }

    int goldLoadCount = 0;
    dq.offer(romaCityNum);

    boolean[] visited = new boolean[n + 1];
    visited[romaCityNum] = true;
    while (!dq.isEmpty()) {

      Integer curr = dq.poll();

      for (int[] nxt : reverseGraph.get(curr)) {
        int nxtCityNum = nxt[0];
        int nxtTime = nxt[1];

        if (inDp[curr] == inDp[nxtCityNum] + nxtTime) {
          goldLoadCount++;
          if (!visited[nxtCityNum]) {
            visited[nxtCityNum] = true;
            dq.offer(nxtCityNum);
          }
        }
      }
    }

    System.out.println(inDp[romaCityNum]);
    System.out.print(goldLoadCount);
  }
}
