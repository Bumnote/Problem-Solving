import java.io.*;
import java.util.*;

public class Main {

  static int N, T, cnt, v;
  static ArrayList<ArrayList<Integer>> vertex;
  static int[] indegree, time, dp;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    dp = new int[N + 1];
    time = new int[N + 1]; // 작업 시간 리스트
    indegree = new int[N + 1]; // 간선 개수 리스트

    vertex = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      vertex.add(new ArrayList<>());
    }

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      T = Integer.parseInt(st.nextToken());
      time[i] = T;
      cnt = Integer.parseInt(st.nextToken());
      for (int j = 0; j < cnt; j++) {
        v = Integer.parseInt(st.nextToken());
        indegree[i]++;
        // v -> i: 순서 발생, 단방향 그래프
        vertex.get(v).add(i);
      }
    }

    br.close();
  }

  private static void solve() {

    ArrayDeque<Integer> dq = new ArrayDeque<>();
    for (int i = 1; i <= N; i++) {
      // 선행 차수가 없는 노드 -> dq 추가
      if (indegree[i] == 0) {
        dq.offer(i);
        dp[i] = time[i];
      }
    }

    while (!dq.isEmpty()) {
      int curr = dq.poll();

      for (Integer nxt : vertex.get(curr)) {
        dp[nxt] = Math.max(dp[curr] + time[nxt], dp[nxt]);

        indegree[nxt]--; // 차수 감소
        if (indegree[nxt] == 0) {
          dq.offer(nxt);
        }
      }
    }

    int total = 0;
    for (int i = 1; i <= N; i++) {
      total = Math.max(total, dp[i]);
    }
    System.out.print(total);
  }

}