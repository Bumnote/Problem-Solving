import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m, a, b;
  private static int[] inDegree;
  private static int[] semester;
  private static List<List<Integer>> graph = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    inDegree = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      graph.get(a).add(b);
      inDegree[b]++;
    }

    br.close();
  }

  private static void solve() {

    semester = new int[n + 1];
    Deque<Integer> dq = new ArrayDeque<>();

    for (int i = 1; i <= n; i++) {
      if (inDegree[i] == 0) {
        dq.offer(i);
        semester[i] = 1;
      }
    }

    while (!dq.isEmpty()) {
      int curr = dq.poll();

      for (int nxt : graph.get(curr)) {
        inDegree[nxt]--;
        if (inDegree[nxt] == 0) {
          dq.offer(nxt);
          semester[nxt] = semester[curr] + 1;
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      System.out.print(semester[i] + " ");
    }
  }
}