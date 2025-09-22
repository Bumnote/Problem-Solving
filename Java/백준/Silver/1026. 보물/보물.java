import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer st;
  private static int n;
  private static int[] A, B;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

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

    int answer = 0;
    for (int i = 0; i < n; i++) {
      answer += A[i] * B[n - 1 - i];
    }

    System.out.print(answer);
  }
}