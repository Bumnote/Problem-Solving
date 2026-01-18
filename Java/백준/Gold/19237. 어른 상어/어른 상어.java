import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m, k;
  private static int[][] map;
  private static int[][][] smellMap; // 상어 냄새 정보
  private static int[] sharkDir; // 상어 방향 정보
  private static int[][][] priorityDir; // 상어별 우선순위 방향 정보
  private static final Map<Integer, int[]> sharkPos = new HashMap<>(); // 상어별 위치 정보

  private static final int LIMIT_TIME = 1_000, BLANK = 0;
  private static final int[] dys = {-1, 1, 0, 0}, dxs = {0, 0, -1, 1}; // 위, 아래, 왼쪽, 오른쪽

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken()); // m: 상어의 수
    k = Integer.parseInt(st.nextToken()); // k: 냄새가 사라지는 시간

    map = new int[n][n];
    smellMap = new int[n][n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] != 0) {
          sharkPos.put(map[i][j], new int[]{i, j});
          smellMap[i][j][0] = map[i][j];
          smellMap[i][j][1] = k;
        }
      }
    }

    sharkDir = new int[m + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= m; i++) {
      sharkDir[i] = Integer.parseInt(st.nextToken()) - 1;
    }

    priorityDir = new int[m + 1][4][4];
    for (int i = 1; i <= m; i++) {
      for (int y = 0; y < 4; y++) {
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < 4; x++) {
          priorityDir[i][y][x] = Integer.parseInt(st.nextToken()) - 1;
        }
      }
    }

    br.close();
  }

  private static void solve() {

    int time = 0;
    while (time < LIMIT_TIME + 1) {
      time++;

      sharkMove(); // 상어 이동

      sharkRemove(); // 겹친 상어 제거

      smellDown(); // 상어 이동 후, 냄새를 해당 칸에 뿌린다.

      if (sharkPos.size() == 1 && sharkPos.containsKey(1)) {
        break;
      }
    }

    System.out.print(time == LIMIT_TIME + 1 ? -1 : time);
  }

  private static void sharkMove() {

    for (Map.Entry<Integer, int[]> entry : sharkPos.entrySet()) {
      int sharkNum = entry.getKey();
      int[] pos = entry.getValue();
      int y = pos[0];
      int x = pos[1];
      int dir = sharkDir[sharkNum];
      boolean moved = false;

      for (int nxtDir : priorityDir[sharkNum][dir]) {
        int ny = y + dys[nxtDir];
        int nx = x + dxs[nxtDir];

        // 범위를 넘지 않고, 빈칸인 경우 -> 해당 방향으로 이동
        if (inRange(ny, nx) && smellMap[ny][nx][0] == BLANK) {
          sharkDir[sharkNum] = nxtDir;
          entry.setValue(new int[]{ny, nx});
          moved = true;
          break;
        }
      }

      // 빈칸이 없는 경우 -> 자신의 냄새가 있는 칸으로 이동
      if (!moved) {
        for (int nxtDir : priorityDir[sharkNum][dir]) {
          int ny = y + dys[nxtDir];
          int nx = x + dxs[nxtDir];

          // 범위를 넘지 않고, 자신의 냄새가 있는 칸이 있는 경우 -> 해당 방향으로 이동
          if (inRange(ny, nx) && smellMap[ny][nx][0] == sharkNum) {
            sharkDir[sharkNum] = nxtDir;
            entry.setValue(new int[]{ny, nx});
            break;
          }
        }
      }
    }
  }

  private static void sharkRemove() {

    int[][] newMap = new int[n][n];

    List<Integer> willRemoveSharkNums = new ArrayList<>();
    for (Map.Entry<Integer, int[]> entry : sharkPos.entrySet()) {
      int sharkNum = entry.getKey();
      int[] pos = entry.getValue();
      int y = pos[0];
      int x = pos[1];

      // 아무 상어도 존재하지 않는 경우 -> 해당 상어가 점령
      if (newMap[y][x] == 0) {
        newMap[y][x] = sharkNum;
      }
      // 이미 상어가 점령하고 있는 경우 -> sharkNum 비교
      else {
        // 기존에 있는 sharkNum이 더 작은 경우 -> 현재 상어 제거
        if (newMap[y][x] < sharkNum) {
          willRemoveSharkNums.add(sharkNum);
        }
        // 현재 상어가 더 작은 경우 -> 기존 상어 제거
        else {
          int existingSharkNum = newMap[y][x];
          willRemoveSharkNums.add(existingSharkNum);
          newMap[y][x] = sharkNum;
        }
      }
    }

    // 상어 제거
    for (int sharkNum : willRemoveSharkNums) {
      sharkPos.remove(sharkNum);
    }

    // 상어 정보 업데이트
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        map[i][j] = newMap[i][j];
      }
    }
  }

  private static void smellDown() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        // 냄새가 존재하는 경우 -> 시간 감소
        if (smellMap[i][j][1] > 0) {
          smellMap[i][j][1]--;
          // k 시간이 다 된 경우 -> 냄새 제거
          if (smellMap[i][j][1] == 0) {
            smellMap[i][j][0] = BLANK;
          }
        }
        // 상어가 존재하는 경우 -> 냄새 뿌리기
        if (map[i][j] != 0) {
          smellMap[i][j][0] = map[i][j];
          smellMap[i][j][1] = k;
        }
      }
    }
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }
}
