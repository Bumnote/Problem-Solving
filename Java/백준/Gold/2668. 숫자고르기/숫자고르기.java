import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, number;
  private static boolean[] visited;
  private static List<Integer> nodes = new ArrayList<>();
  private static final Set<Integer> set = new HashSet<>();
  private static final Map<Integer, List<Integer>> graph = new HashMap<>();

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    n = Integer.parseInt(br.readLine());

    graphInit();
    for (int i = 1; i <= n; i++) {
      number = Integer.parseInt(br.readLine());
      graph.get(i).add(number);
    }

    br.close();
  }

  private static void solve() {

    visited = new boolean[n + 1];
    for (int i = 1; i <= n; i++) {
      visited[i] = true; // 방문 처리
      nodes = new ArrayList<>();
      nodes.add(i);
      dfs(i, i);
      visited[i] = false; // 복원 처리
    }

    sb.append(set.size()).append("\n");
    new ArrayList<>(set).stream().sorted().forEach(value -> sb.append(value).append("\n"));
    System.out.print(sb);
  }

  private static void graphInit() {
    for (int i = 1; i <= n; i++) {
      graph.put(i, new ArrayList<>());
    }
  }


  private static void dfs(int root, int curr) {

    for (int nxt : graph.get(curr)) {
      // 이미 방문한 경우
      if (visited[nxt]) {
        // 방문했던 지점이 시작점인 경우 -> 사이클 발생
        if (nxt == root) {
          set.addAll(nodes);
          return;
        }
      }
      // 아직 방문하지 않은 경우
      else {
        visited[nxt] = true; // 방문 처리
        nodes.add(nxt);
        dfs(root, nxt);
        visited[nxt] = false; // 복원 처리
        nodes.remove(nodes.size() - 1);
      }
    }
  }
}