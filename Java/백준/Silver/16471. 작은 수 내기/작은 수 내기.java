import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[] A, B; // A: 주언, B: 사장님

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    A = new int[n];
    B = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      B[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void solve() {
    Arrays.sort(A);
    Arrays.sort(B);

    int count = 0;
    int idx = 0;
    for (int i = 0; i < n; i++) {
      if (A[0] < B[i]) {
        idx = i;
        break;
      }
    }

    int s = 0;
    for (int i = idx; i < n; i++) {
      if (A[s] < B[i]) {
        count++;
        s++;
      }
    }

    System.out.print(count >= (n + 1) / 2 ? "YES" : "NO");
  }
}