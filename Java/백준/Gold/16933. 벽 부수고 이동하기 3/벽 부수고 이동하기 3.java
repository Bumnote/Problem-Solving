import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

  static class Node {

    int y, x, dist, crush, day;

    Node(int y, int x, int dist, int crush, int day) {
      this.y = y;
      this.x = x;
      this.dist = dist;
      this.crush = crush;
      this.day = day;
    }
  }

  static int n, m, k;
  static int[][] map;
  static boolean[][][][] visited;
  static final int[] dys = {-1, 1, 0, 0};
  static final int[] dxs = {0, 0, -1, 1};

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    map = new int[n][m];
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    System.out.print(bfs());
  }

  static int bfs() {
    visited = new boolean[n][m][k + 1][2];
    Deque<Node> q = new ArrayDeque<>();

    q.offer(new Node(0, 0, 1, 0, 0));
    visited[0][0][0][0] = true;

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (cur.y == n - 1 && cur.x == m - 1) {
        return cur.dist;
      }

      int nextDay = 1 - cur.day;

      for (int d = 0; d < 4; d++) {
        int ny = cur.y + dys[d];
        int nx = cur.x + dxs[d];

        if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
          continue;
        }

        if (map[ny][nx] == 0) {
          if (!visited[ny][nx][cur.crush][nextDay]) {
            visited[ny][nx][cur.crush][nextDay] = true;
            q.offer(new Node(ny, nx, cur.dist + 1, cur.crush, nextDay));
          }
        } else if (map[ny][nx] == 1 && cur.day == 0 && cur.crush < k) {
          if (!visited[ny][nx][cur.crush + 1][nextDay]) {
            visited[ny][nx][cur.crush + 1][nextDay] = true;
            q.offer(new Node(ny, nx, cur.dist + 1, cur.crush + 1, nextDay));
          }
        }
      }

      if (!visited[cur.y][cur.x][cur.crush][nextDay]) {
        visited[cur.y][cur.x][cur.crush][nextDay] = true;
        q.offer(new Node(cur.y, cur.x, cur.dist + 1, cur.crush, nextDay));
      }
    }

    return -1;
  }
}
