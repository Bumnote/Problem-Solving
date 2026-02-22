import java.io.*;
import java.util.*;

class Main {

  static class Node {

    int left, right;

    Node(int left, int right) {
      this.left = left;
      this.right = right;
    }
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, a, b, c;
  private static final int ROOT = 1;
  private static Node[] tree;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    n = Integer.parseInt(br.readLine());
    tree = new Node[n + 1];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());

      tree[a] = new Node(b, c);
    }

    br.close();
  }

  private static void solve() {

    int depth = 0;
    int curr = ROOT;

    while (tree[curr].right != -1) {
      curr = tree[curr].right;
      depth++;
    }

    int answer = 2 * (n - 1) - depth; // 간선의 수 - 깊이
    System.out.print(answer);

  }
}
