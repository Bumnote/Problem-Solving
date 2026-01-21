 import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[] dp;
  private static int width, height;
  private static List<int[]> papers = new ArrayList<>();
  private static List<List<Integer>> graph = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      width = Integer.parseInt(st.nextToken());
      height = Integer.parseInt(st.nextToken());

      papers.add(new int[]{width, height});
    }

    br.close();
  }

  public static void solve() {

    int[] inDegree = new int[n];
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }

        if (isIncludePaper(papers.get(i), papers.get(j))) {
          // i번 종이가 j번 종이를 포함하는 경우
          graph.get(i).add(j);
          inDegree[j]++;
        }
      }
    }

    Deque<Integer> dq = new ArrayDeque<>();
    dp = new int[n];
    for (int i = 0; i < n; i++) {
      if (inDegree[i] == 0) {
        dq.offer(i);
      }
    }

    while (!dq.isEmpty()) {
      Integer curr = dq.poll();

      for (Integer nxt : graph.get(curr)) {
        inDegree[nxt]--;

        dp[nxt] = Math.max(dp[nxt], dp[curr] + 1);
        if (inDegree[nxt] == 0) {
          dq.offer(nxt);
        }
      }
    }

    int answer = 0;
    for (int count : dp) {
      answer = Math.max(answer, count);
    }

    System.out.print(answer + 1);
  }

  private static boolean isIncludePaper(int[] curr, int[] nxt) {
    Arrays.sort(curr);
    Arrays.sort(nxt);

    return curr[0] >= nxt[0] && curr[1] >= nxt[1];
  }
}
