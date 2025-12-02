import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, targetScore, p;
  private static Integer[] scores;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    targetScore = Integer.parseInt(st.nextToken());
    p = Integer.parseInt(st.nextToken());

    // n이 0인 경우 -> 점수를 입력받지 않는다.
    if (n == 0) {
      return;
    }

    scores = new Integer[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      scores[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void solve() {
    int answer = -1;

    if (n != 0) {
      Arrays.sort(scores, Collections.reverseOrder());
      if (n == p && targetScore <= scores[scores.length - 1]) {
        System.out.print(answer);
      } else {
        answer = 1;
        for (int i = 0; i < scores.length; i++) {
          if (targetScore < scores[i]) {
            answer++;
          } else {
            break;
          }
        }

        System.out.println(answer);
      }
    } else {
      System.out.println(1);
    }
  }
}
