import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m, min;
  private static int[][] map, copyMap;
  private static int[] output;
  private static final List<int[]> cctvs = new ArrayList<>();
  private static final int[] dys = {-1, 0, 1, 0}, dxs = {0, 1, 0, -1}; // 상, 우, 하, 좌

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n][m];
    min = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] != 0 && map[i][j] != 6) {
          cctvs.add(new int[]{i, j, map[i][j]});
        } else if (map[i][j] == 0) {
          min++;
        }
      }
    }
    output = new int[cctvs.size()];
    br.close();
  }

  private static void solve() {
    dfs(0, cctvs.size());
    System.out.print(min);
  }

  private static void dfs(int depth, int r) {
    if (depth == r) {
      copyMap = new int[n][m];
      for (int i = 0; i < n; i++) {
        System.arraycopy(map[i], 0, copyMap[i], 0, m);
      }

      for (int i = 0; i < cctvs.size(); i++) {
        direction(cctvs.get(i), output[i]);
      }

      getBlindSpot();
      return;
    }

    for (int i = 0; i < 4; i++) {
      output[depth] = i;
      dfs(depth + 1, r);
    }
  }

  private static void direction(int[] cctv, int d) {
    int cctvNum = cctv[2];

    switch (cctvNum) {
      case 1:
        if (d == 0) {
          watch(cctv, 0);
        } else if (d == 1) {
          watch(cctv, 1);
        } else if (d == 2) {
          watch(cctv, 2);
        } else if (d == 3) {
          watch(cctv, 3);
        }
        break;
      case 2:
        if (d == 0 || d == 2) {
          watch(cctv, 0);
          watch(cctv, 2);
        } else if (d == 1 || d == 3) {
          watch(cctv, 1);
          watch(cctv, 3);
        }
        break;
      case 3:
        if (d == 0) {
          watch(cctv, 0);
          watch(cctv, 1);
        } else if (d == 1) {
          watch(cctv, 1);
          watch(cctv, 2);
        } else if (d == 2) {
          watch(cctv, 2);
          watch(cctv, 3);
        } else if (d == 3) {
          watch(cctv, 0);
          watch(cctv, 3);
        }
        break;
      case 4:
        if (d == 0) {
          watch(cctv, 0);
          watch(cctv, 1);
          watch(cctv, 3);
        } else if (d == 1) {
          watch(cctv, 0);
          watch(cctv, 1);
          watch(cctv, 2);
        } else if (d == 2) {
          watch(cctv, 1);
          watch(cctv, 2);
          watch(cctv, 3);
        } else if (d == 3) {
          watch(cctv, 0);
          watch(cctv, 2);
          watch(cctv, 3);
        }
        break;
      case 5:
        watch(cctv, 0);
        watch(cctv, 1);
        watch(cctv, 2);
        watch(cctv, 3);
        break;
      default:
        break;
    }
  }

  private static void watch(int[] cctv, int d) {
    Deque<int[]> dq = new ArrayDeque<>();
    dq.add(cctv);

    while (!dq.isEmpty()) {
      int[] curr = dq.poll();
      int ny = curr[0] + dys[d];
      int nx = curr[1] + dxs[d];

      // 범위 내에 있고, 벽이 아닌 경우 -> 감시 진행
      if (inRange(ny, nx) && copyMap[ny][nx] != 6) {
        // 빈 칸인 경우에만 감시 처리
        if (copyMap[ny][nx] == 0) {
          copyMap[ny][nx] = -1; // 감시 처리
        }
        dq.add(new int[]{ny, nx});
      }
    }
  }

  private static void getBlindSpot() {
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (copyMap[i][j] == 0) {
          count++;
        }
      }
    }

    min = Math.min(min, count);
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < m;
  }
}
