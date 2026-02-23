import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static String[] numbers;
  private static final Set<String> set = new HashSet<>();


  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    n = Integer.parseInt(br.readLine());
    numbers = new String[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = br.readLine();
    }

    br.close();
  }

  private static void solve() {

    int size = numbers[0].length();
    for (int i = size - 1; i >= 0; i--) {
      boolean flag = true;
      set.clear();
      for (int j = 0; j < n; j++) {
        String prefix = numbers[j].substring(i, size);
        if (!set.contains(prefix)) {
          set.add(prefix);
        } else {
          flag = false;
          break;
        }
      }

      if (flag) {
        System.out.print(size - i);
        return;
      }
    }
  }
}
