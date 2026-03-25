import java.io.*;
import java.util.*;

class Main {

  static class Node {

    int[] arr;
    int count;

    public Node(int[] arr, int count) {
      this.arr = arr;
      this.count = count;
    }
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, k;
  private static int[] arr;
  private static Set<String> set = new HashSet<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    arr = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
  }

  private static void solve() {

    Deque<Node> dq = new ArrayDeque<>();
    dq.offer(new Node(arr, 0));
    set.add(Arrays.toString(arr));

    while (!dq.isEmpty()) {

      Node curr = dq.poll();
      if (isSorted(curr.arr)) {
        System.out.print(curr.count);
        return;
      }

      for (int i = 0; i <= n - k; i++) {
        int[] tmp = swap(curr.arr.clone(), i);
        if (!set.contains(Arrays.toString(tmp))) {
          set.add(Arrays.toString(tmp));
          dq.offer(new Node(tmp, curr.count + 1));
        }
      }
    }

    System.out.print(-1);
  }

  private static int[] swap(int[] arr, int idx) {
    int end = idx + k - 1;

    for (int i = 0; i < k / 2; i++) {
      int tmp = arr[idx + i];
      arr[idx + i] = arr[end - i];
      arr[end - i] = tmp;
    }
    return arr;
  }

  private static boolean isSorted(int[] tmp) {
    for (int i = 0; i < n; i++) {
      if (tmp[i] != i + 1) {
        return false;
      }
    }
    return true;
  }
}