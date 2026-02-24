import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    br.close();
  }

  private static void solve() {

    if (n <= 4) {
      System.out.print(4);
      return;
    }

    int answer = (int) 1e9;
    for (int col = 1; col <= (int) Math.sqrt(n); col++) {
      int row = n % (col + 1) == 0 ? n / (col + 1) : n / (col + 1) + 1;
      int square = 2 * (col + row - 1);
      answer = Math.min(answer, square);
    }

    System.out.print(answer);
  }
}
