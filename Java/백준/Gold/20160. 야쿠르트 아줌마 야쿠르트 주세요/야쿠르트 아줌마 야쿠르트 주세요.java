import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int v, e, a, b, w, startNode;
  private static final long LONG_INF = (int) 1e15;
  private static final int INF = (int) 1e9;
  private static int[] arr = new int[10];
  private static long[] arrived = new long[10];
  private static List<List<int[]>> graph = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    v = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= v; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      w = Integer.parseInt(st.nextToken());
      graph.get(a).add(new int[]{b, w});
      graph.get(b).add(new int[]{a, w});
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 10; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    startNode = Integer.parseInt(br.readLine());
    br.close();
  }

  private static void solve() {

    int start = arr[0];
    int idx = 0;
    for (int i = 1; i < 10; i++) {
      long dist = dijkstra(start, arr[i]);
      // i -> i + 1로 갈 수 없는 경우
      if (dist == LONG_INF) {
        arrived[i] = -1;
      }
      // i -> i + 1로 갈 수 있는 경우
      else {
        arrived[i] = arrived[idx] + dist;
        start = arr[i];
        idx = i;
      }
    }

    int[] dists = dijkstra(startNode);

    int answer = INF;
    for (int i = 0; i < 10; i++) {
      // 야쿠르트 아줌마가 도달하지 못하는 경우 -> continue
      if (arrived[i] == -1 || dists[arr[i]] == INF) {
        continue;
      }

      long womanDist = arrived[i];
      int meDist = dists[arr[i]];
      if (meDist <= womanDist) {
        answer = Math.min(answer, arr[i]);
      }
    }

    System.out.print(answer == INF ? -1 : answer);
  }

  private static long dijkstra(int start, int end) {

    long[] dist = new long[v + 1];
    Arrays.fill(dist, LONG_INF);
    dist[start] = 0;

    PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1]));
    pq.offer(new long[]{start, 0});

    while (!pq.isEmpty()) {
      long[] curr = pq.poll();
      int currNode = (int) curr[0];
      long currDist = curr[1];

      if (dist[currNode] < currDist) {
        continue;
      }

      for (int[] nxt : graph.get(currNode)) {
        int nxtNode = nxt[0];
        int nxtDist = nxt[1];
        long newDist = currDist + nxtDist;

        if (newDist < dist[nxtNode]) {
          dist[nxtNode] = newDist;
          pq.offer(new long[]{nxtNode, newDist});
        }
      }
    }

    return dist[end];
  }

  private static int[] dijkstra(int start) {

    int[] dist = new int[v + 1];
    Arrays.fill(dist, INF);
    dist[start] = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
    pq.offer(new int[]{start, 0});

    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int currNode = curr[0];
      int currDist = curr[1];

      if (dist[currNode] < currDist) {
        continue;
      }

      for (int[] nxt : graph.get(currNode)) {
        int nxtNode = nxt[0];
        int nxtDist = nxt[1];
        int newDist = currDist + nxtDist;

        if (newDist < dist[nxtNode]) {
          dist[nxtNode] = newDist;
          pq.offer(new int[]{nxtNode, newDist});
        }
      }
    }

    return dist;
  }
}