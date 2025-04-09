import java.io.*;
import java.util.*;

class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static final long MOD = 1_000_000_007;
  static int N, M, K, a, b, c, k, SIZE;
  static long[] tree;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    // 입력 부분
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    SIZE = getTreeSize();
    tree = new long[SIZE];
    Arrays.fill(tree, 1);

    int start = (1 << k);
    for (int i = start; i < start + N; i++) {
      tree[i] = Integer.parseInt(br.readLine());
    }

    for (int i = start - 1; i > 0; i--) {
      tree[i] = (tree[i * 2] * tree[(i * 2) + 1]) % MOD; // 자식의 곱을 구한다.
    }
  }

  private static int getTreeSize() {
    int cnt = 0;
    int len = 1;
    while (len < N) {
      len *= 2;
      cnt++;
    }
    // 2^k >= N
    k = cnt;
    return len * 2;
  }

  private static void solve() throws IOException {

    for (int i = 0; i < M + K; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      // 리프 노드 인덱스로 변환
      b = Integer.parseInt(st.nextToken()) + (1 << k) - 1;

      // b번째 수를 c로 바꾼다.
      if (a == 1) {
        c = Integer.parseInt(st.nextToken());
        update(b, c);
      }
      // b부터 c까지 곱을 구한다.
      else {
        c = Integer.parseInt(st.nextToken()) + (1 << k) - 1;
        sb.append(queryValue(b, c)).append("\n");
      }
    }
    // 정답 출력
    System.out.print(sb);
    br.close();
  }

  private static void update(int idx, int val) {
    tree[idx] = val;
    while (idx > 1) {
      idx /= 2;
      tree[idx] = (tree[idx * 2] * tree[(idx * 2) + 1]) % MOD; // 구간합 갱신
    }
  }

  private static long queryValue(int l, int r) {
    long res = 1;
    while (l <= r) {
      // 오른쪽 자식인 경우 -> 독립 노드이므로 선택한다.
      if (l % 2 == 1) {
        res = (res * tree[l]) % MOD;
        l++;
      }

      // 왼쪽 자식인 경우 -> 독립 노드이므로 선택한다.
      if (r % 2 == 0) {
        res = (res * tree[r]) % MOD;
        r--;
      }

      l /= 2;
      r /= 2;
    }
    return res % MOD;
  }
}