import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static final int N = 4, SHARK = -1, BLANK = 0;
  private static int[][][] MAP = new int[N][N][2];
  private static final int[] dys = {-1, -1, 0, 1, 1, 1, 0, -1}, dxs = {0, -1, -1, -1, 0, 1, 1, 1};

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int fishNum = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken()) - 1;
        MAP[i][j][0] = fishNum;
        MAP[i][j][1] = dir;
      }
    }

    br.close();
  }

  private static void solve() {

    int sharkY = 0, sharkX = 0, sharkDir = MAP[0][0][1];
    int fishCount = MAP[0][0][0];
    MAP[0][0][0] = SHARK;

    System.out.print(dfs(sharkY, sharkX, sharkDir, fishCount, MAP));
  }

  private static int dfs(int y, int x, int dir, int fishCount, int[][][] currMap) {

    int maxCount = fishCount;
    for (int d = 1; d <= 3; d++) {
      int ny = y + (dys[dir] * d);
      int nx = x + (dxs[dir] * d);

      // 맵 복사
      int[][][] newMap = copyMap(currMap);

      // 물고기 이동
      fishMoveAndRotation(newMap);

      // 범위를 넘지 않고, 물고기가 있는 곳으로 갈 수 있다면 -> dfs 이동
      if (!inRange(ny, nx) || newMap[ny][nx][0] <= 0) {
        continue;
      }

      // 상어 이동
      int nxtFishCount = newMap[ny][nx][0];
      int nxtDir = newMap[ny][nx][1];
      sharkMove(y, x, ny, nx, newMap);

      maxCount = Math.max(maxCount, dfs(ny, nx, nxtDir, fishCount + nxtFishCount, newMap));
    }

    return maxCount;
  }

  private static void sharkMove(int y, int x, int ny, int nx, int[][][] newMap) {
    newMap[y][x][0] = BLANK;
    newMap[ny][nx][0] = SHARK;
  }

  private static int[][][] copyMap(int[][][] currMap) {
    int[][][] newMap = new int[N][N][2];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        newMap[i][j][0] = currMap[i][j][0];
        newMap[i][j][1] = currMap[i][j][1];
      }
    }
    return newMap;
  }

  private static void fishMoveAndRotation(int[][][] newMap) {

    Map<Integer, int[]> fishInfo = new HashMap<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int fishNum = newMap[i][j][0];
        int fishDir = newMap[i][j][1];
        if (fishNum > 0) {
          fishInfo.put(fishNum, new int[]{i, j, fishDir});
        }
      }
    }

    for (int fishNum = 1; fishNum <= 16; fishNum++) {
      if (!fishInfo.containsKey(fishNum)) {
        continue;
      }

      int[] fish = fishInfo.get(fishNum);
      boolean flag = true;
      for (int d = 0; d < 8; d++) {
        int dir = (fish[2] + d) % 8;
        int ny = fish[0] + dys[dir];
        int nx = fish[1] + dxs[dir];

        // 이동할 수 없는 경우
        if (!inRange(ny, nx) || newMap[ny][nx][0] == SHARK) {
          continue;
        }
        flag = false;
        // 다음 칸이 빈칸인 경우 -> 현재 물고기만 이동 후 break
        if (newMap[ny][nx][0] == 0) {
          fishInfo.put(fishNum, new int[]{ny, nx, dir});

          newMap[fish[0]][fish[1]][0] = BLANK;
          newMap[fish[0]][fish[1]][1] = BLANK;
          newMap[ny][nx][0] = fishNum;
          newMap[ny][nx][1] = dir;
        }
        // 다음 칸이 물고기인 경우 -> 물고기끼리 위치 교환 후 break
        else {
          int nxtFishNum = newMap[ny][nx][0];
          int nxtFishDir = newMap[ny][nx][1];

          fishInfo.put(fishNum, new int[]{ny, nx, dir});
          fishInfo.put(nxtFishNum, new int[]{fish[0], fish[1], nxtFishDir});

          newMap[fish[0]][fish[1]][0] = nxtFishNum;
          newMap[fish[0]][fish[1]][1] = nxtFishDir;
          newMap[ny][nx][0] = fishNum;
          newMap[ny][nx][1] = dir;
        }
        break;
      }

      // 8 방향 모두 이동할 수 없는 경우 -> 시계 방향으로 45도 회전된 상태 유지
      if (flag) {
        int updateDir = (fish[2] + 8 - 1) % 8;
        newMap[fish[0]][fish[1]][1] = updateDir;
        fishInfo.put(fishNum, new int[]{fish[0], fish[1], updateDir});
      }
    }
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < N && 0 <= x && x < N;
  }
}
