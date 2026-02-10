import java.io.*;
import java.util.*;

class Main {

  static class Node {

    int time;
    char dir;

    Node(int time, char dir) {
      this.time = time;
      this.dir = dir;
    }
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, k, l, x, c;
  private static final int[] dys = {0, 1, 0, -1}, dxs = {1, 0, -1, 0}; // 우, 하, 좌, 상
  private static int[][] arr;
  private static final Deque<Node> times = new ArrayDeque<>();
  private static final Deque<int[]> snake = new ArrayDeque<>();


  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    n = Integer.parseInt(br.readLine());
    arr = new int[n][n];
    arr[0][0] = 1; // 뱀의 초기 위치
    snake.offer(new int[]{0, 0});

    k = Integer.parseInt(br.readLine());
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken()) - 1;
      int x = Integer.parseInt(st.nextToken()) - 1;
      arr[y][x] = 2; // 사과 위치
    }

    l = Integer.parseInt(br.readLine());
    for (int i = 0; i < l; i++) {
      st = new StringTokenizer(br.readLine());
      int time = Integer.parseInt(st.nextToken());
      char dir = st.nextToken().charAt(0);
      times.offerLast(new Node(time, dir));
    }
    br.close();
  }

  private static void solve() {

    int dir = 0; // 초기방향
    int totalTime = 1;
    int y = 0;
    int x = 0;

    while (true) {
      // 1. 먼저 몸을 늘려 머리를 다음 칸으로 움직인다.
      int ny = y + dys[dir];
      int nx = x + dxs[dir];

      // 2. 만약 벽이나 자기 자신의 몸과 부딪히면 게임이 끝난다.
      if (!inRange(ny, nx) || arr[ny][nx] == 1) {
        sb.append(totalTime);
        break;
      }

      // 3. 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고, 꼬리는 움직이지 않는다.
      snake.offerLast(new int[]{ny, nx});
      if (arr[ny][nx] == 2) {
        arr[ny][nx] = 1;
      }
      // 4. 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다.
      else {
        arr[ny][nx] = 1;
        int[] tail = snake.pollFirst();
        arr[tail[0]][tail[1]] = 0; // 꼬리 위치 삭제
      }

      y = ny;
      x = nx;

      dir = checkDirection(totalTime, dir);
      totalTime++;
    }

    System.out.print(sb);
  }

  private static int checkDirection(int totalTime, int dir) {
    if (!times.isEmpty() && totalTime == times.peekFirst().time) {
      Node node = times.pollFirst();
      // 왼쪽 90도 회전
      if (node.dir == 'L') {
        dir = (dir + 4 - 1) % 4;
      }
      // 오른쪽 90도 회전
      else {
        dir = (dir + 1) % 4;
      }
    }

    return dir;
  }

  private static boolean inRange(int y, int x) {
    return y >= 0 && y < n && x >= 0 && x < n;
  }
}
