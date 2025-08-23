import java.io.*;
import java.util.*;
import java.math.*;

class Main {

  static class Node {

    int y;
    int x;

    Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer st;
  private static int n, l, r;
  private static int[][] persons;
  private static boolean isMoved;
  private static boolean[][] visited;
  private static int[] dys = {0, 0, -1, 1}, dxs = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken()); // n: 각 나라의 인구 수
    l = Integer.parseInt(st.nextToken()); // l: 인구 차이의 최솟값
    r = Integer.parseInt(st.nextToken()); // r: 인구 차이의 최댓값
    persons = new int[n][n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        persons[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static void solve() {

    int days = 0;
    while (true) {

      isMoved = false;
      visited = new boolean[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          // 아직 방문하지 않았다면 -> bfs 진행
          if (!visited[i][j]) {
            visited[i][j] = true; // 방문 처리
            personMove(i, j);
          }
        }
      }

      if (!isMoved) {
        break;
      }
      days++;
    }

    System.out.print(days);
  }

  private static void personMove(int y, int x) {

    Deque<Node> dq = new ArrayDeque<>();
    Deque<Node> unions = new ArrayDeque<>();
    dq.offer(new Node(y, x));
    unions.offer(new Node(y, x));
    int totalPerson = persons[y][x];
    int totalCount = 1;

    while (!dq.isEmpty()) {

      Node curr = dq.poll();

      for (int i = 0; i < 4; i++) {
        int nxtY = curr.y + dys[i];
        int nxtX = curr.x + dxs[i];
        // 범위를 넘지 않고, 방문하지 않고, 인구 차이가 l명 이상 r명 이하인 경우 -> bfs 탐색 진행
        if (inRange(nxtY, nxtX) && !visited[nxtY][nxtX] && personDiffJudge(curr.y, curr.x, nxtY, nxtX)) {
          visited[nxtY][nxtX] = true; // 방문 처리
          dq.offer(new Node(nxtY, nxtX));
          unions.offer(new Node(nxtY, nxtX));
          totalCount++;
          totalPerson += persons[nxtY][nxtX];
          isMoved = true; // 인구의 이동 가능
        }
      }
    }

    if (totalCount > 1) {
      for (Node union : unions) {
        persons[union.y][union.x] = totalPerson / totalCount;
      }
    }
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }

  private static boolean personDiffJudge(int curY, int curX, int nxtY, int nxtX) {

    int diff = Math.abs(persons[curY][curX] - persons[nxtY][nxtX]);
    if (l <= diff && diff <= r) {
      return true;
    }

    return false;
  }
}