import java.io.*;
import java.util.*;

public class Main {

  static class Node {

    int idx;
    int cnt;

    Node(int idx, int cnt) {
      this.idx = idx;
      this.cnt = cnt;
    }
  }

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int T, N, K, X, Y, W, total;
  static int[] D, edgeCnt, dp;
  static ArrayList<ArrayList<Integer>> vertex;

  public static void main(String[] args) throws IOException {

    T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      init();
      solve();
    }

    System.out.println(sb);
    br.close();
  }

  private static void init() throws IOException {

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // N: 건물의 개수
    K = Integer.parseInt(st.nextToken()); // K: 규칙의 개수

    vertex = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      vertex.add(new ArrayList<>());
    }

    D = new int[N + 1]; // D: 시간 정보
    edgeCnt = new int[N + 1]; // 진입 차수
    dp = new int[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      D[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      X = Integer.parseInt(st.nextToken());
      Y = Integer.parseInt(st.nextToken());
      // X -> Y: 단방향 그래프
      vertex.get(X).add(Y);
      edgeCnt[Y]++;
    }

    W = Integer.parseInt(br.readLine()); // W: 지어야 하는 건물 번호
  }

  private static void solve() {

    total = D[W]; // 마지막 W 건물은 반드시 지어야 한다.
    Queue<Node> dq = new ArrayDeque<>();

    for (int i = 1; i <= N; i++) {
      if (edgeCnt[i] == 0) {
        dq.offer(new Node(i, 0));
        dp[i] = D[i];
      }
    }

    while (!dq.isEmpty()) {

      Node curr = dq.poll();

      for (Integer nxt : vertex.get(curr.idx)) {
        dp[nxt] = Math.max(dp[curr.idx] + D[nxt], dp[nxt]);
        edgeCnt[nxt]--;
        if (edgeCnt[nxt] == 0) {
          dq.offer(new Node(nxt, curr.cnt + 1));
        }
      }
    }

    sb.append(dp[W]).append("\n");
  }
}
