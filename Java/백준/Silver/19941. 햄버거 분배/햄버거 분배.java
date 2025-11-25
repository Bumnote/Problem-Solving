import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, k;
  private static String word;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    word = br.readLine();
    br.close();
  }

  private static void solve() {

    boolean[] visited = new boolean[n];
    int cnt = 0;

    for (int i = 0; i < n; i++) {
      if (word.charAt(i) == 'P') {
        for (int j = i - k; j <= i + k; j++) {
          // 범위를 넘지 않고, 먹지 않은 햄버거인 경우 -> 방문 처리
          if (inRange(j) && !visited[j] && word.charAt(j) == 'H') {
            cnt++;
            visited[j] = true;
            break;
          }
        }
      }
    }

    System.out.print(cnt);
  }

  private static boolean inRange(int idx) {
    return 0 <= idx && idx < n;
  }
}