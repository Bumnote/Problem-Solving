import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m;
  private static final Set<String> set = new HashSet<>();

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    for (int i = 0; i < n; i++) {
      set.add(br.readLine());
    }

    for (int j = 0; j < m; j++) {
      String[] keywords = br.readLine().split(",");
      for (String keyword : keywords) {
        if (set.contains(keyword)) {
          set.remove(keyword);
        }
      }
      sb.append(set.size()).append("\n");
    }
  }

  private static void solve() {
    System.out.print(sb);
  }
}