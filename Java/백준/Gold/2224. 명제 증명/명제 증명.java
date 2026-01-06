import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static final int LEN = 122;
  private static final int INF = 987_654_321;
  private static final int[][] MAT = new int[LEN + 1][LEN + 1];

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());

    for (int i = 65; i <= LEN; i++) {
      Arrays.fill(MAT[i], INF);
      MAT[i][i] = 0;
    }

    for (int i = 0; i < n; i++) {
      String[] words = br.readLine().split(" => ");
      int prev = words[0].charAt(0);
      int next = words[1].charAt(0);
      // prev -> next: 단방향
      MAT[prev][next] = 1;
    }
    br.close();
  }

  private static void solve() {

    floydWarshall();

    int count = 0;
    for (int i = 65; i <= LEN; i++) {
      for (int j = 65; j <= LEN; j++) {
        // P => P와 같은 형식 -> 출력 x
        if (i != j && MAT[i][j] == 1) {
          count++;
          sb.append((char) i).append(" => ").append((char) j).append('\n');
        }
      }
    }

    System.out.println(count);
    System.out.print(sb);
  }

  private static void floydWarshall() {
    for (int k = 65; k <= LEN; k++) {
      for (int i = 65; i <= LEN; i++) {
        for (int j = 65; j <= LEN; j++) {
          // i -> k -> j 이면 체크
          if (MAT[i][k] == 1 && MAT[k][j] == 1) {
            MAT[i][j] = 1;
          }
        }
      }
    }
  }
}