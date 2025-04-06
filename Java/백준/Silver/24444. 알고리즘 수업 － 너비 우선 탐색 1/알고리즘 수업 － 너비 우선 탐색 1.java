import java.io.*;
import java.util.*;

public class Main {

  static int N, M, R, cnt;
  static int[] visited;
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
    R = Integer.parseInt(st.nextToken());

    vertex = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      vertex.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      vertex.get(a).add(b);
      vertex.get(b).add(a);
    }

    for (int i = 1; i <= N; i++) {
      vertex.get(i).sort(Comparator.naturalOrder()); // 오름차순 정렬
    }

    br.close();
  }

  private static void solve() {

    bfs(R);

    for (int i = 1; i <= N; i++) {
      System.out.println(visited[i]);
    }
  }

  private static void bfs(int s) {

    ArrayDeque<Integer> dq = new ArrayDeque<>();
    visited = new int[N + 1];

    cnt = 1;
    visited[s] = cnt++; // 시작점 방문 처리
    dq.offer(s);

    while (!dq.isEmpty()) {
      int curr = dq.poll();
      for (int nxt : vertex.get(curr)) {
        if (visited[nxt] == 0) {
          visited[nxt] = cnt++;
          dq.offer(nxt);
        }
      }
    }
  }

}