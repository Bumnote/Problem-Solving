import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m, l, k; // n: 가로, m: 세로, l: 길이, k: 별똥별 수
  private static int x, y; // (x, y) 별똥별 좌표
  private static final List<int[]> stars = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    l = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      stars.add(new int[]{x, y});
    }

    br.close();
  }

  private static void solve() {

    int boundStarCount = 0;
    for (int[] starA : stars) {
      for (int[] starB : stars) {
        int count = 0;
        for (int[] starX : stars) {
          if (inRange(starA, starB, starX)) {
            count++;
          }
        }

        boundStarCount = Math.max(boundStarCount, count);
      }
    }

    System.out.print(k - boundStarCount);
  }

  private static boolean inRange(int[] starA, int[] starB, int[] starX) {
    return starA[0] <= starX[0] && starX[0] <= starA[0] + l &&
           starB[1] <= starX[1] && starX[1] <= starB[1] + l;
  }
}