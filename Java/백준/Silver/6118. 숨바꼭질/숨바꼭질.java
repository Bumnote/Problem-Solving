import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static final int START = 1;
  private static int n, m, a, b, distance;
  private static final Map<Integer, ArrayList<Integer>> graph = new HashMap<>();


  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= n; i++) {
      graph.put(i, new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      // 양방향
      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    br.close();
  }


  private static void solve() throws IOException {
    ArrayList<Integer> result = bfs(START);
    System.out.print(String.format("%d %d %d", result.get(0), distance, result.size()));
  }

  private static ArrayList<Integer> bfs(int start) {

    Deque<int[]> dq = new ArrayDeque<>();
    boolean[] visited = new boolean[n + 1];

    visited[start] = true; // 시작 노드 방문 처리
    dq.offer(new int[]{start, 0});

    ArrayList<Integer> dist = new ArrayList<>();
    distance = 0;
    while (!dq.isEmpty()) {
      int[] curr = dq.poll();
      int currNode = curr[0];
      int currDist = curr[1];
      if (distance < currDist) {
        distance = currDist;
        dist.clear();
        dist.add(currNode);
      } else if (distance == currDist) {
        dist.add(currNode);
      }

      for (Integer nxtNode : graph.get(currNode)) {
        if (!visited[nxtNode]) {
          visited[nxtNode] = true;
          dq.offer(new int[]{nxtNode, currDist + 1});
        }
      }
    }

    Collections.sort(dist);
    return dist;
  }
}