import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static String n;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = br.readLine();
    br.close();
  }

  private static void solve() {

    int length = n.length();
    int leftSum = 0;
    int rightSum = 0;
    for (int i = 0; i < length; i++) {
      if (i < length / 2) {
        leftSum += n.charAt(i) - '0';
      } else {
        rightSum += n.charAt(i) - '0';
      }
    }

    if (leftSum == rightSum) {
      System.out.print("LUCKY");
    } else {
      System.out.print("READY");
    }
  }
}
