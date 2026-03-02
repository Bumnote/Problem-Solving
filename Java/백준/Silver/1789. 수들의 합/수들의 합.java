import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static long s;


  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    s = Long.parseLong(br.readLine());
    br.close();
  }

  private static void solve() {

    long sum = 0;
    long num = 0;
    while (sum <= s) {
      num++;
      sum = num * (num + 1) / 2;
    }

    System.out.print(s == 1 ? 1 : num - 1);
  }
}