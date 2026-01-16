import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m;
  private static int[][] map;
  private static boolean[][] visited;
  private static final Map<Integer, Integer> cache = new HashMap<>();
  private static final List<int[]> walls = new ArrayList<>();
  private static final int[] dys = {-1, 1, 0, 0}, dxs = {0, 0, -1, 1};

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n][m];
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        map[i][j] = line.charAt(j) - '0';
        if (map[i][j] == 1) {
          walls.add(new int[]{i, j});
        }
      }
    }
    br.close();
  }

  private static void solve() {

    visited = new boolean[n][m];
    int id = 2;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j] && map[i][j] == 0) {
          bfs(i, j, id);
          id++;
        }
      }
    }

    int[][] answer = new int[n][m];
    for (int[] wall : walls) {
      Set<Integer> set = new HashSet<>();
      for (int d = 0; d < 4; d++) {
        int ny = wall[0] + dys[d];
        int nx = wall[1] + dxs[d];

        if (!inRange(ny, nx) || map[ny][nx] == 1) {
          continue;
        }

        set.add(map[ny][nx]);
      }

      int sum = 1;
      for (Integer areaId : set) {
        sum += cache.get(areaId);
      }
      answer[wall[0]][wall[1]] = sum % 10;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sb.append(answer[i][j]);
      }
      sb.append('\n');
    }

    System.out.print(sb);
  }

  private static void bfs(int y, int x, int id) {

    Deque<int[]> dq = new ArrayDeque<>();
    dq.offer(new int[]{y, x});

    visited[y][x] = true;

    int count = 0;
    while (!dq.isEmpty()) {
      int[] curr = dq.poll();
      map[curr[0]][curr[1]] = id;
      count++;

      for (int d = 0; d < 4; d++) {
        int ny = curr[0] + dys[d];
        int nx = curr[1] + dxs[d];

        // 범위를 넘거나, 방문한 적이 있거나, 벽인 경우 -> continue
        if (!inRange(ny, nx) || visited[ny][nx] || map[ny][nx] != 0) {
          continue;
        }

        visited[ny][nx] = true;
        dq.offer(new int[]{ny, nx});
      }
    }

    cache.put(id, count);
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < m;
  }
}
