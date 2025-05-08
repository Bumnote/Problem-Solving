import java.io.*;
import java.util.*;

class Main {

  static int N, K;
  static int[] A;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    // 입력 부분
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // N: 애플파이의 개수
    K = Integer.parseInt(st.nextToken()); // K: 먹으려는 개수

    // 애플파이 초기화
    A = new int[2 * N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int pie = Integer.parseInt(st.nextToken());
      A[i] = A[N + i] = pie;
    }
    br.close();
  }

  private static void solve() {

    int MAX = 0;

    // total 초기화
    int total = 0;
    for (int i = 0; i < K; i++) {
      total += A[i];
    }

    for (int i = 1; i <= (2 * N) - K; i++) {
      total -= A[i - 1];
      total += A[i + K - 1];
      MAX = Math.max(MAX, total); // 최댓값 갱신
    }

    System.out.print(MAX);
  }
}
