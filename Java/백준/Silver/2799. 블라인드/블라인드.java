import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m;
  private static char[][] map;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new char[5 * n + 1][5 * m + 1];
    for (int i = 0; i < 5 * n + 1; i++) {
      String line = br.readLine();
      for (int j = 0; j < 5 * m + 1; j++) {
        map[i][j] = line.charAt(j);
      }
    }

    br.close();
  }

  private static void solve() {

    int[] answer = new int[5];
    for (int i = 1; i < 5 * n + 1; i += 5) {
      for (int j = 1; j < 5 * m + 1; j += 5) {
        int lineCount = 0;
        for (int k = 0; k < 5; k++) {
          if (map[i + k][j] == '*') {
            lineCount++;
          } else {
            break;
          }
        }

        answer[lineCount]++;
      }
    }

    for (int i = 0; i < 5; i++) {
      sb.append(answer[i]).append(" ");
    }

    System.out.print(sb);
  }
}