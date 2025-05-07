import java.io.*;
import java.util.*;

class Main {

  static int n, m;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    String[] line = br.readLine().split(":");
    n = Integer.parseInt(line[0]);
    m = Integer.parseInt(line[1]);

    br.close();
  }

  private static void solve() {
    int a = n, b = m;
    int GCD = getGCD(a, b);
    System.out.printf("%d:%d", n / GCD, m / GCD);
  }

  private static int getGCD(int a, int b) {
    if (a < b) {
      int tmp = a;
      a = b;
      b = tmp;
    }

    while (b > 0) {
      int tmp = a;
      a = b;
      b = tmp % a;
    }
    return a;
  }
}
