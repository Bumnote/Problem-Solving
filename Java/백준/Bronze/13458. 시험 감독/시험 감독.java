import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, b, c;
  private static int[] arr;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine()); // n: 응시자 수

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    b = Integer.parseInt(st.nextToken()); // b: 총감독관이 감시할 수 있는 응시자 수
    c = Integer.parseInt(st.nextToken()); // c: 부감독관이 감시할 수 있는 응시자 수

    br.close();
  }

  private static void solve() {

    long answer = 0;
    for (int i = 0; i < n; i++) {
      arr[i] = Math.max(arr[i] - b, 0);
      if (arr[i] == 0) {
        answer += 1;
        continue;
      }

      int count = arr[i] % c == 0 ? arr[i] / c : arr[i] / c + 1;
      answer += count + 1;
    }

    System.out.print(answer);
  }
}
