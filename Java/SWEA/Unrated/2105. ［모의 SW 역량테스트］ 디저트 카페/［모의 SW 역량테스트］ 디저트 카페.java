import java.io.*;
import java.util.*;

public class Solution {

  static class Point {

    int y;
    int x;

    Point(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int T, N, MAX;
  static int[][] map;
  static int[] dys = {-1, -1, 1, 1}, dxs = {-1, 1, 1, -1}; // 좌상, 우상, 우하, 좌하
  static boolean[][] visited;
  static Set<Integer> cache;
  static ArrayList<Integer> dir;

  public static void main(String[] args) throws IOException {

    T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      init();
      solve(tc);
    }

    // 정답 출력 부분
    System.out.println(sb);
    br.close();
  }

  private static void init() throws IOException {

    // 입력 부분
    N = Integer.parseInt(br.readLine());

    map = new int[N][N];
    visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  private static void solve(int tc) {

    MAX = -1;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        // 사각형의 모서리는 탐색하지 않는다.
        if ((i + j) == 0 || (i == N - 1 && j == 0) || (i == 0 && j == N - 1) || (i + j) == 2 * N) {
          continue;
        }
        visited[i][j] = true; // 방문 처리
        cache = new HashSet<Integer>();
        dir = new ArrayList<Integer>();
        cache.add(map[i][j]);
        dfs(new Point(i, j), new Point(i, j), 1, 0);
        visited[i][j] = false; // 복원 처리
      }
    }

    sb.append(String.format("#%d %d", tc, MAX)).append("\n");
  }

  private static void dfs(Point curr, Point origin, int total, int cnt) {

    // 방향이 3개 초과한다면 -> 유망하지 않으므로 return
    if (cnt > 4) {
      return;
    }

    for (int i = 0; i < 4; i++) {
      int ny = curr.y + dys[i];
      int nx = curr.x + dxs[i];

      // 범위를 넘지 않는 경우 -> 최소 조건 만족
      if (inRange(ny, nx)) {
        // 사각형은 방향이 4번 꺾여야 한다.
        if (cache.size() >= 4 && (ny == origin.y && nx == origin.x) && cnt >= 3) {
          int tmp = cnt;
          dir.add(i); // 방향 추가
          if (!Objects.equals(dir.get(dir.size() - 1), dir.get(dir.size() - 2))) {
            tmp++;
          }

          if (tmp == 4) {
            MAX = Math.max(MAX, total);
          }
          dir.remove(dir.size() - 1); // 방향 삭제
        }
        // 방문한 적이 있거나, 캐시에 이미 있는 디저트 번호이거나, 시계 방향이 아니라면 -> 탐색하지 않는다.
        if (visited[ny][nx] || cache.contains(map[ny][nx]) || (!dir.isEmpty()
            && dir.get(dir.size() - 1) > i)) {
          continue;
        }

        visited[ny][nx] = true; // 방문 처리
        cache.add(map[ny][nx]); // 캐시 저장
        dir.add(i); // 방향 저장
        // 방향이 처음 들어온 경우 -> 방향 개수 1 증가
        if (dir.size() <= 1) {
          dfs(new Point(ny, nx), origin, total + 1, cnt + 1);
        }
        // 방향이 2개 이상이고, 이전 방향과 현재 방향이 다르다면 -> 방향 개수 1 증가
        else if (!Objects.equals(dir.get(dir.size() - 1), dir.get(dir.size() - 2))) {
          dfs(new Point(ny, nx), origin, total + 1, cnt + 1);
        }
        // 방향이 2개 이상이고, 이전 방향과 현재 방향이 같다면 -> 방향 개수 증가 x
        else {
          dfs(new Point(ny, nx), origin, total + 1, cnt);
        }
        cache.remove(map[ny][nx]); // 캐시 삭제
        dir.remove(dir.size() - 1); // 방향 삭제
        visited[ny][nx] = false; // 복원 처리
      }
    }
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < N && 0 <= x && x < N;
  }
}