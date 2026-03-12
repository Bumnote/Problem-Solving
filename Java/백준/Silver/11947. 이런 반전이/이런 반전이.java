import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int t;
  private static String n;

  public static void main(String[] args) throws Exception {
    t = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < t; tc++) {
      init();
      solve();
    }
    System.out.print(sb);
    br.close();
  }

  private static void init() throws Exception {
    n = br.readLine();
  }


  private static void solve() {

    int len = (int) Math.pow(10, n.length()) / 2;
    if (Integer.parseInt(n) > len) {
      sb.append(calculateLovelyNumber(String.valueOf(len))).append("\n");
    } else {
      sb.append(calculateLovelyNumber(n)).append("\n");
    }

  }

  private static long calculateLovelyNumber(String num) {
    String lovely = "";
    for (char c : num.toCharArray()) {
      lovely += ('9' - c);
    }

    return Long.parseLong(lovely) * Long.parseLong(num);
  }
}