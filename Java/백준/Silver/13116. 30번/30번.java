import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int t, a, b;
  private static int[] tree;
  private static final Set<Integer> set = new HashSet<>();

  public static void main(String[] args) throws Exception {
    treeInit();
    t = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < t; tc++) {
      init();
      solve();
    }
    System.out.print(sb);
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    set.clear();
  }

  private static void solve() {

    int start = a;
    while (start > 0) {
      set.add(tree[start]);
      start /= 2;
    }

    int end = b;
    while (end > 0) {
      if (set.contains(tree[end])) {
        sb.append(tree[end] * 10).append("\n");
        break;
      }
      end /= 2;
    }
  }

  private static void treeInit() {
    tree = new int[1024];
    for (int i = 0; i < 1024; i++) {
      tree[i] = i;
    }
  }
}