import java.io.*;
import java.util.*;

class Main {

  static class Node implements Comparable<Node> {

    int value;
    int count;
    int index;

    Node(int value, int count, int index) {
      this.value = value;
      this.count = count;
      this.index = index;
    }

    @Override
    public int compareTo(Node o) {
      if (this.count != o.count) {
        return Integer.compare(o.count, this.count);
      }
      return Integer.compare(this.index, o.index);
    }
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, c;
  private static int[] arr;
  private static Map<Integer, Integer> indexMap = new HashMap<>();
  private static Map<Integer, Integer> countMap = new HashMap<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      if (!indexMap.containsKey(arr[i])) {
        indexMap.put(arr[i], i);
      }
      countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
    }

    br.close();
  }

  private static void solve() {

    Node[] nodes = new Node[countMap.size()];
    int idx = 0;
    for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
      nodes[idx++] = new Node(entry.getKey(), entry.getValue(), indexMap.get(entry.getKey()));
    }

    Arrays.sort(nodes);

    for (Node node : nodes) {
      for (int i = 0; i < node.count; i++) {
        sb.append(node.value).append(" ");
      }
    }

    System.out.print(sb.toString().trim());
  }
}