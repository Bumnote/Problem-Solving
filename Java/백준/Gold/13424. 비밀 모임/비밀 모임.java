import java.util.*;
import java.io.*;

class Main {

  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static final StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int t, n, m, a, b, c, k;
  static List<List<int[]>> vertex;
  static int[] rooms, dist;

  public static void main(String[] args) throws IOException {

    t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      init();
      solve();
    }
    System.out.print(sb);
    sb.setLength(0);
    br.close();
  }

  private static void init() throws IOException {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    vertex = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      vertex.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      vertex.get(a).add(new int[]{b, c});
      vertex.get(b).add(new int[]{a, c});
    }

    k = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    rooms = new int[k];
    for (int i = 0; i < k; i++) {
      rooms[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void solve() {

    dist = new int[n + 1];

    for (int room : rooms) {
      int[] result = dijkstra(room);
      for (int i = 1; i <= n; i++) {
        dist[i] += result[i];
      }
    }

    int ans = 1;
    int MIN = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
      if (dist[i] < MIN) {
        MIN = dist[i];
        ans = i;
      }
    }
    sb.append(ans).append('\n');
  }

  private static int[] dijkstra(int room) {

    int INF = 987_654_321;
    int[] dist = new int[n + 1];
    Arrays.fill(dist, INF);
    dist[room] = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
      return a[1] - b[1];
    });

    pq.offer(new int[]{room, 0});
    while (!pq.isEmpty()) {
      int[] curr = pq.poll();

      if (dist[curr[0]] != curr[1]) {
        continue;
      }

      for (int[] nxt : vertex.get(curr[0])) {
        int newDist = curr[1] + nxt[1];
        if (newDist < dist[nxt[0]]) {
          dist[nxt[0]] = newDist;
          pq.offer(new int[]{nxt[0], newDist});
        }
      }
    }

    return dist;
  }
}