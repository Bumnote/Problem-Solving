import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int ROW;
  private static int COL;
  private static char[][] map;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());

    ROW = n;
    COL = 1 + (n - 1) * 2;
    map = new char[ROW + 1][COL + 1];
    for (int i = 0; i <= ROW; i++) {
      Arrays.fill(map[i], ' ');
    }

    br.close();
  }

  private static void solve() {

    drawStar(0, n - 1, n);

    for (int i = 0; i <= ROW; i++) {
      for (int j = 0; j <= COL; j++) {
        sb.append(map[i][j]);
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }

  private static void drawStar(int y, int x, int n) {

    if (n == 3) {
      drawStar(y, x);
      return;
    }

    drawStar(y, x, n / 2);
    drawStar(y + n / 2, x - n / 2, n / 2);
    drawStar(y + n / 2, x + n / 2, n / 2);
  }

  private static void drawStar(int y, int x) {
    map[y][x] = '*';
    map[y + 1][x - 1] = '*';
    map[y + 1][x + 1] = '*';
    for (int i = 0; i < 5; i++) {
      map[y + 2][x - 2 + i] = '*';
    }
  }
}