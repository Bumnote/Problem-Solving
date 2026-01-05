import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  public static Map<Integer, List<Integer>> tree = new HashMap<>();
  public static int n, k;

  public static void main(String[] args) throws Exception {
    while (true) {
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      if (n == 0 && k == 0) {
        break;
      }
      init();
      solve();
    }

    System.out.print(sb);
  }

  private static void init() throws Exception {

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[st.countTokens()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    initTree(arr);
  }

  private static void solve() {

    // k 부모 찾기
    int parentNode = -1;
    for (Map.Entry<Integer, List<Integer>> entry : tree.entrySet()) {
      if (entry.getValue().contains(k)) {
        parentNode = entry.getKey();
        break;
      }
    }

    // 부모가 없으면 -> 사촌 없다
    if (parentNode == -1) {
      sb.append(0).append("\n");
      return;
    }

    // 조부모 찾기
    int grandParent = -1;
    for (Map.Entry<Integer, List<Integer>> entry : tree.entrySet()) {
      if (entry.getValue().contains(parentNode)) {
        grandParent = entry.getKey();
        break;
      }
    }

    // 조부모가 없으면 -> 사촌이 없다.
    if (grandParent == -1) {
      sb.append(0).append("\n");
      return;
    }

    // 3. 사촌 계산
    int cousinCount = 0;
    for (int uncle : tree.get(grandParent)) {
      if (uncle == parentNode) {
        continue;
      }
      cousinCount += tree.getOrDefault(uncle, new ArrayList<>()).size();
    }

    sb.append(cousinCount).append("\n");
  }

  private static void initTree(int[] arr) {
    tree.clear();

    int ROOT = arr[0];
    tree.put(ROOT, new ArrayList<>());

    int idx = 0;
    List<Integer> lst = new ArrayList<>();
    for (int i = 1; i < arr.length; i++) {
      lst.add(arr[i]);
      // 마지막 원소인 경우
      if (i == arr.length - 1) {
        tree.put(arr[idx], new ArrayList<>(lst));
        lst.clear();
        break;
      }
      // 마지막 원소가 아니면서 같은 묶음이 깨지는 경우
      if (Math.abs(arr[i] - arr[i + 1]) > 1) {
        tree.put(arr[idx++], new ArrayList<>(lst));
        lst.clear();
      }
    }
  }
}
