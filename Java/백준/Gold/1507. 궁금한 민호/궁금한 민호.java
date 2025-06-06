import java.io.*;
import java.util.*;

public class Main {

  static final int INF = 987_654_321;
  static int N;
  static int[][] map;
  static int[][] dist;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 입력 부분
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    dist = new int[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        dist[i][j] = map[i][j];
      }
    }

    br.close();
  }

  private static void solve() {

    for (int k = 0; k < N; k++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (i == j || i == k || k == j) {
            continue;
          }

          // 이미 거리가 갱신이 되어있는데, 다시 갱신이 된다면 -> 최단 거리가 아니다.
          if (map[i][j] > map[i][k] + map[k][j]) {
            System.out.print(-1);
            return;
          }

          // 만약, 최단거리와 일치한다면 -> k를 거쳐간 것이므로, i -> j를 지운다.
          if (map[i][j] == map[i][k] + map[k][j]) {
            dist[i][j] = INF;
          }
        }
      }
    }

    int ans = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        // 갈 수 있는 거리이면서, 방문하지 않은 곳이라면 -> 해당 도로의 가중치를 더해준다.
        if (dist[i][j] != INF && i < j && !visited[i][j]) {
          ans += dist[i][j];
          visited[i][j] = visited[j][i] = true; // 방문 표시
        }
      }
    }

    System.out.print(ans);
  }
}
