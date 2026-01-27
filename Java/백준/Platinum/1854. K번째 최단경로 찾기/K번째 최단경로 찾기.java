import java.io.*;
import java.util.*;

class Main {

  static class Node implements Comparable<Node> {

    int n;
    int dist;

    Node(int n, int dist) {
      this.n = n;
      this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.dist, o.dist);
    }
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m, k, a, b, c;
  private static final int INF = 987_654_321;
  private static List<List<int[]>> graph = new ArrayList<>();


  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken()); // n: 도시의 개수
    m = Integer.parseInt(st.nextToken()); // m: 도시 간 도로의 개수
    k = Integer.parseInt(st.nextToken()); // k: 최단 경로 순위

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      // a -> b: c
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      graph.get(a).add(new int[]{b, c});
    }

    br.close();
  }

  public static void solve() {
    dijkstra();
    System.out.print(sb);
  }

  private static void dijkstra() {

    List<PriorityQueue<Integer>> dist = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      dist.add(new PriorityQueue<>(Collections.reverseOrder()));
    }
    dist.get(1).offer(0);

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(1, 0));

    while (!pq.isEmpty()) {
      Node node = pq.poll();

      for (int[] nxt : graph.get(node.n)) {
        int nxtNode = nxt[0];
        int nxtDist = nxt[1];
        int newDist = node.dist + nxtDist;

        if (dist.get(nxtNode).size() < k) {
          dist.get(nxtNode).add(newDist);
          pq.offer(new Node(nxtNode, newDist));
        } else if (dist.get(nxtNode).peek() > newDist) {
          dist.get(nxtNode).poll();
          dist.get(nxtNode).offer(newDist);
          pq.offer(new Node(nxtNode, newDist));
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      if (dist.get(i).size() < k) {
        sb.append(-1).append("\n");
      } else if (dist.get(i).size() == k) {
        sb.append(dist.get(i).peek()).append("\n");
      }
    }
  }
}
