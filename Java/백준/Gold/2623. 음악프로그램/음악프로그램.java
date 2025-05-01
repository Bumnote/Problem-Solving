import java.io.*;
import java.util.*;

class Main {

  static StringBuilder sb = new StringBuilder();

  static int N, M;
  static ArrayList<ArrayList<Integer>> lst;
  static int[] degree;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 입력 부분
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // N: 가수의 수
    M = Integer.parseInt(st.nextToken()); // M: 보조 PD의 수

    degree = new int[N + 1];
    lst = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      lst.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int cnt = Integer.parseInt(st.nextToken());
      int[] arr = new int[cnt];
      for (int j = 0; j < cnt; j++) {
        arr[j] = Integer.parseInt(st.nextToken());
      }

      for (int j = 0; j < cnt - 1; j++) {
        int curr = arr[j];
        int nxt = arr[j + 1];
        lst.get(curr).add(nxt);
        degree[nxt]++;
      }
    }

    br.close();
  }

  private static void solve() {

    ArrayDeque<Integer> dq = new ArrayDeque<>();
    // 이전 순서가 없는 요소인 경우 -> dq 추가
    for (int i = 1; i <= N; i++) {
      if (degree[i] == 0) {
        dq.offer(i);
        sb.append(i).append("\n");
      }
    }

    while (!dq.isEmpty()) {
      int curr = dq.poll();

      for (Integer nxt : lst.get(curr)) {
        degree[nxt]--;
        // 이전 작업이 모두 완료된 경우 -> dq 추가
        if (degree[nxt] == 0) {
          dq.offer(nxt);
          sb.append(nxt).append("\n");
        }
      }
    }

    for (int i = 1; i <= N; i++) {
      // 작업 순서가 남아있는 경우 -> 순서를 정할 수 없다.
      if (degree[i] != 0) {
        System.out.print(0);
        return;
      }
    }
    // 작업 순서가 없는 경우 -> 결과 출력
    System.out.print(sb);
  }
}