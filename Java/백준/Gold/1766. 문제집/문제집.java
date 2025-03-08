import java.io.*;
import java.util.*;

public class Main {

  static int N, M, A, B;
  static int[] edgeCnt;
  static ArrayList<ArrayList<Integer>> vertex;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }


  private static void init() throws IOException {

    // 입력 부분
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    vertex = new ArrayList<>();
    edgeCnt = new int[N + 1]; // 진입차수 배열
    for (int i = 0; i <= N; i++) {
      vertex.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());
      // A -> B: 단방향 그래프
      vertex.get(A).add(B);
      edgeCnt[B]++;
    }

    br.close();
  }

  private static void solve() {

    StringBuilder sb = new StringBuilder();

    Queue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder()); // min Heap

    for (int i = 1; i <= N; i++) {
      // 진입 차수가 0인 요소 추가
      if (edgeCnt[i] == 0) {
        pq.offer(i);
      }
    }

    while (!pq.isEmpty()) {

      int curr = pq.poll();

      // 정답 양식 저장
      sb.append(curr).append(" ");

      for (Integer nxt : vertex.get(curr)) {
        edgeCnt[nxt]--;
        // 진입차수가 0이 된 경우 -> pq 추가
        if (edgeCnt[nxt] == 0) {
          pq.offer(nxt);
        }
      }
    }

    // 정답 출력
    System.out.println(sb);
  }

}