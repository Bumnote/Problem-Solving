import java.io.*;
import java.util.*;

public class Main {

  static boolean flag;
  static int N, M, a, b;
  static boolean[] visited;
  static ArrayList<ArrayList<Integer>> vertex;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    vertex = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      vertex.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      // a <-> b: 양방향 관계
      vertex.get(a).add(b);
      vertex.get(b).add(a);
    }

    br.close();
  }

  private static void solve() {

    flag = false;
    for (int i = 0; i < N; i++) {
      visited = new boolean[N];
      visited[i] = true; // 방문 처리
      dfs(i, 1);
      if (flag) {
        break;
      }
    }

    System.out.println(flag ? 1 : 0);
  }

  private static void dfs(int v, int cnt) {
    if (cnt == 5) {
      flag = true;
      return;
    }
    for (Integer nxt : vertex.get(v)) {
      // 이미 방문한 적이 있다면 탐색하지 않는다.
      if (visited[nxt]) {
        continue;
      }
      visited[nxt] = true; // 방문 처리
      dfs(nxt, cnt + 1);
      visited[nxt] = false; // 복원 처리
    }
  }
}
