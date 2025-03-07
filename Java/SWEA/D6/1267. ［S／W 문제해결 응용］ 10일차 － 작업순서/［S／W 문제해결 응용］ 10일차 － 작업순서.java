import java.io.*;
import java.util.*;

public class Solution {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int V, E, v1, v2;
  static ArrayList<ArrayList<Integer>> vertex;
  static ArrayDeque<Integer> dq;
  static int[] edgeCnt;

  public static void main(String[] args) throws IOException {

    for (int tc = 1; tc <= 10; tc++) {
      init();
      solve(tc);
    }

    // 정답 출력
    System.out.println(sb);
    br.close();
  }

  private static void init() throws IOException {
    st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken()); // V: 작업(정점)의 개수
    E = Integer.parseInt(st.nextToken()); // E: 간선의 개수

    edgeCnt = new int[V + 1];
    vertex = new ArrayList<>();
    dq = new ArrayDeque<>();
    for (int i = 0; i < V + 1; i++) {
      vertex.add(new ArrayList<>());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < E; i++) {
      v1 = Integer.parseInt(st.nextToken());
      v2 = Integer.parseInt(st.nextToken());
      // v1 <- v2: 단방향 그래프
      vertex.get(v1).add(v2);
      // 진입차수 증가
      edgeCnt[v2]++;
    }
  }

  private static void solve(int tc) {

    // 진입차수 0인 노드 저장
    for (int i = 1; i <= V; i++) {
      if (edgeCnt[i] == 0) {
        dq.offer(i);
      }
    }

    // 위상정렬
    sb.append("#").append(tc).append(" ");
    while (!dq.isEmpty()) {

      int curr = dq.poll();
      sb.append(curr).append(" ");

      for (Integer nxt : vertex.get(curr)) {
        edgeCnt[nxt]--;
        if (edgeCnt[nxt] == 0) {
          dq.offer(nxt);
        }
      }
    }

    sb.append("\n");
  }

}