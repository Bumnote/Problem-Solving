import java.io.*;
import java.util.*;

class Main {

  static final int LEN = (int) Math.pow(2, 6);
  static int N, M, my, mx;
  static char[][] map;
  static boolean[][][] visited;
  static int[] dys = {-1, 1, 0, 0}, dxs = {0, 0, -1, 1};
  static Map<Character, Integer> cache;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 입력 부분
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // N: 미로의 세로 크기
    M = Integer.parseInt(st.nextToken()); // M: 미로의 가로 크기

    map = new char[N][M];
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        // .: 빈칸, #: 벽
        // 'a, b, c, d, e, f': 열쇠
        // 'A, B, C, D, E, F': 문
        // '0': 민식이의 현재 위치
        // '1': 출구
        map[i][j] = line.charAt(j);
        // 민식이 위치 저장 후, 빈칸으로 변경
        if (map[i][j] == '0') {
          my = i;
          mx = j;
          map[i][j] = '.';
        }
      }
    }
    cacheInit();
    br.close();
  }

  private static void cacheInit() {
    cache = new HashMap<>();
    cache.put('a', 1 << 5);
    cache.put('b', 1 << 4);
    cache.put('c', 1 << 3);
    cache.put('d', 1 << 2);
    cache.put('e', 1 << 1);
    cache.put('f', 1);
  }

  private static void solve() {
    // [a, b, c, d, e, f]
    // [0, 0, 0, 0, 0, 0]
    boolean[][][] visited = new boolean[N][M][LEN];
    visited[my][mx][0] = true; // 민식이 시작점 방문 처리
    ArrayDeque<int[]> dq = new ArrayDeque<>();
    dq.add(new int[]{my, mx, 0, 0}); // y, x, cnt, key

    int ans = -1;
    while (!dq.isEmpty()) {
      int[] curr = dq.poll();
      // 탈출이 가능하다면 -> 움직인 거리 저장 후 break
      if (map[curr[0]][curr[1]] == '1') {
        ans = curr[2];
        break;
      }

      for (int i = 0; i < 4; i++) {
        int nxtY = curr[0] + dys[i];
        int nxtX = curr[1] + dxs[i];
        
        // 범위를 넘지 않고, 벽이 아닌 경우 -> 탐색 가능
        if (inRange(nxtY, nxtX) && map[nxtY][nxtX] != '#') {
          // 다음 위치가 열쇠인 경우 ->
          if ('a' <= map[nxtY][nxtX] && map[nxtY][nxtX] <= 'f') {
            int currKey = curr[3];
            int newKey = cache.get(map[nxtY][nxtX]);
            int nxtKey = currKey | newKey; // 해당 키를 비트마스킹으로 더한다.
            if (!visited[nxtY][nxtX][nxtKey]) {
              visited[nxtY][nxtX][nxtKey] = true; // 방문처리
              dq.add(new int[]{nxtY, nxtX, curr[2] + 1, nxtKey});
            }
          }
          // 다음 위치가 문인 경우 -> 열쇠가 있는 경우에만 이동 가능
          else if ('A' <= map[nxtY][nxtX] && map[nxtY][nxtX] <= 'F') {
            int door = cache.get((char) (map[nxtY][nxtX] + 32));
            int isKeyExist = curr[3] & door; // 키가 있다면 존재한다면 -> 0이 아니다.
            if (isKeyExist > 0 && !visited[nxtY][nxtX][curr[3]]) {
              visited[nxtY][nxtX][curr[3]] = true; // 방문 처리
              dq.add(new int[]{nxtY, nxtX, curr[2] + 1, curr[3]});
            }
          }
          // 열쇠와 문이 아닌 경우 -> 빈칸, 출구인 경우 -> 이동 가능
          else {
            // 해당 위치를 방문하지 않은 경우 -> 이동 가능
            if (!visited[nxtY][nxtX][curr[3]]) {
              visited[nxtY][nxtX][curr[3]] = true; // 방문 처리
              dq.add(new int[]{nxtY, nxtX, curr[2] + 1, curr[3]});
            }
          }
        }
      }
    }

    System.out.print(ans);
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < N && 0 <= x && x < M;
  }
}