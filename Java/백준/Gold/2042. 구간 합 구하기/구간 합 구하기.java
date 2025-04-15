import java.io.*;
import java.util.*;

class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int N, M, K, SIZE, k, start;
  static long a, b, c;
  static long tree[];

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    SIZE = getTreeSize();
    tree = new long[SIZE];
    start = (int) Math.pow(2, k);

    for (int i = start; i < start + N; i++) {
      tree[i] = Long.parseLong(br.readLine());
    }

    treeInit();
  }

  private static void solve() throws IOException {

    for (int i = 0; i < M + K; i++) {
      st = new StringTokenizer(br.readLine());
      a = Long.parseLong(st.nextToken());
      b = Long.parseLong(st.nextToken());
      c = Long.parseLong(st.nextToken());

      // b번째 수를 c로 바꾸는 경우
      if (a == 1) {
        b = b + (1 << k) - 1;
        updateQuery(b, c);
      }
      // [b, c] 합 저장
      else {
        b = b + (1 << k) - 1;
        c = c + (1 << k) - 1;
        long res = sumQuery(b, c);
        sb.append(res).append("\n");
      }
    }

    System.out.print(sb);
    br.close();
  }

  private static int getTreeSize() {

    k = 0;
    int LEN = 1;

    while (LEN < N) {
      LEN *= 2;
      k += 1;
    }

    return LEN * 2;
  }

  private static void treeInit() {
    for (int i = start - 1; i >= 1; i--) {
      tree[i] = tree[i * 2] + tree[(i * 2) + 1];
    }
  }

  private static void updateQuery(long b, long c) {

    tree[(int) b] = c;
    while (b > 1) {
      b /= 2;
      tree[(int) b] = tree[(int) b * 2] + tree[(int) (b * 2) + 1];
    }
  }

  private static long sumQuery(long b, long c) {

    long total = 0;
    while (b <= c) {
      // 오른쪽 자식인 경우
      if (b % 2 == 1) {
        total += tree[(int) b];
        b++;
      }

      if (c % 2 == 0) {
        total += tree[(int) c];
        c--;
      }

      b /= 2;
      c /= 2;
    }

    return total;
  }
}