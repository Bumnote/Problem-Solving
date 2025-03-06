import java.io.*;
import java.util.*;

public class Solution {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int T, H, W, N, cy, cx, ny, nx, d;
  static char[][] map;
  static String line;
  static char[] command;
  static Map<Character, Integer> dir;
  static int[] dys = {0, 0, 1, -1}, dxs = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {

    T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      init();
      solve(tc);
    }

    System.out.println(sb);
    br.close();
  }

  private static void init() throws IOException {

    st = new StringTokenizer(br.readLine());
    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());

    // 방향 저장
    dir = new HashMap<>();
    dir.put('<', 0);
    dir.put('>', 1);
    dir.put('v', 2);
    dir.put('^', 3);

    map = new char[H][W];
    for (int i = 0; i < H; i++) {
      line = br.readLine();
      for (int j = 0; j < W; j++) {
        map[i][j] = line.charAt(j);
        // 전차의 위치와 방향 저장
        if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == 'v' || map[i][j] == '^') {
          cy = i;
          cx = j;
          d = dir.get(map[i][j]);
          map[i][j] = '.'; // 평지로 mapping 한다.
        }
      }
    }

    N = Integer.parseInt(br.readLine());
    command = new char[N];
    command = br.readLine().toCharArray();
  }

  private static void solve(int tc) {

    // 0: L,  1: R,  2: D,  3: U
    for (char c : command) {
      // 전차가 바라보는 방향을 위쪽으로 바꾸고, 앞이 평지라면 전진
      if (c == 'U') {
        d = 3;
        ny = cy + dys[d];
        nx = cx + dxs[d];
        if (inRange(ny, nx) && map[ny][nx] == '.') {
          cy = ny;
          cx = nx;
        }
      }
      // 전차가 바라보는 방향을 아래쪽으로 바꾸고, 앞이 평지라면 전진
      else if (c == 'D') {
        d = 2;
        ny = cy + dys[d];
        nx = cx + dxs[d];
        if (inRange(ny, nx) && map[ny][nx] == '.') {
          cy = ny;
          cx = nx;
        }
      }
      // 전차가 바라보는 방향을 왼쪽으로 바꾸고, 앞이 평지라면 전진
      else if (c == 'L') {
        d = 0;
        ny = cy + dys[d];
        nx = cx + dxs[d];
        if (inRange(ny, nx) && map[ny][nx] == '.') {
          cy = ny;
          cx = nx;
        }
      }
      // 전차가 바라보는 방향을 오른쪽으로 바꾸고, 앞이 평지라면 전진
      else if (c == 'R') {
        d = 1;
        ny = cy + dys[d];
        nx = cx + dxs[d];
        if (inRange(ny, nx) && map[ny][nx] == '.') {
          cy = ny;
          cx = nx;
        }
      }
      // 전차가 현재 바라보고 있는 방향으로 포탄 발사
      else {
        shoot();
      }
    }

    // 정답 양식 저장
    sb.append("#").append(tc).append(" ");
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        // 전차인 경우 -> 전차의 상태 저장
        if (i == cy && j == cx) {
          for (Map.Entry<Character, Integer> entry : dir.entrySet()) {
            if (entry.getValue() == d) {
              sb.append(entry.getKey());
            }
          }
        }
        // 전차의 위치가 아닌 경우 -> 맵 정보 저장
        else {
          sb.append(map[i][j]);
        }
      }
      sb.append("\n");
    }
  }

  private static boolean inRange(int y, int x) {
    return y >= 0 && y < H && x >= 0 && x < W;
  }

  private static void shoot() {

    int y = cy;
    int x = cx;

    while (true) {
      ny = y + dys[d];
      nx = x + dxs[d];

      if (inRange(ny, nx)) {

        // 벽돌로 만들어진 벽인 경우 -> 포탄은 소멸하고, 평지가 된다.
        if (map[ny][nx] == '*') {
          map[ny][nx] = '.';
          break;
        }
        // 강철로 만들어진 벽인 경우 -> 포탄은 소멸하고, 아무 일도 일어나지 않는다.
        else if (map[ny][nx] == '#') {
          break;
        }
        y = ny;
        x = nx;
      }
      // 범위를 넘는다면 -> 아무 일도 일어나지 않는다.
      else {
        break;
      }
    }

  }
}
