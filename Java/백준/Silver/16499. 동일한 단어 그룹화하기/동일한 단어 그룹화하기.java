import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static final Set<String> set = new HashSet<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      String word = br.readLine();
      char[] chars = word.toCharArray();
      Arrays.sort(chars);
      set.add(String.valueOf(chars));
    }
  }

  private static void solve() {
    System.out.print(set.size());
  }
}