import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static final Set<Integer> set = new HashSet<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      set.add(Integer.parseInt(st.nextToken()));
    }
    br.close();
  }


  private static void solve() throws IOException {

    ArrayList<Integer> lst = new ArrayList<>(set);
    Collections.sort(lst);

    for (Integer integer : lst) {
      sb.append(integer).append(" ");
    }

    System.out.print(sb);
  }
}