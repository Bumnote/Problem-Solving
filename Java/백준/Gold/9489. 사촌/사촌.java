import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  public static int[] arr, parent;
  public static int n, k, targetParent, targetIdx;

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
    arr = new int[n + 1];
    parent = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      if (arr[i] == k) {
        targetIdx = i;
      }
    }

    initParentInfo(arr);
  }

  private static void solve() {

    int uncleCount = 0;
    for (int i = 1; i <= n; i++) {
      // 부모가 같지 않으면서, 조상이 같은 경우(즉, 형제인 경우) -> 사촌이다.
      if (parent[i] != parent[targetIdx] && parent[parent[i]] == parent[targetParent]) {
        uncleCount++;
      }
    }

    sb.append(uncleCount).append('\n');
  }

  private static void initParentInfo(int[] arr) {

    arr[0] = -1;
    parent[0] = -1;

    int idx = 0;
    targetParent = -1;
    for (int i = 1; i <= n; i++) {
      parent[i] = idx;
      if (arr[i] == k) {
        targetParent = parent[i];
      }

      // 마지막 원소가 아니면서, 연속된 숫자가 아니라면 -> 새로운 부모 설정
      if (i != n && arr[i + 1] - arr[i] > 1) {
        idx++;
      }
    }
  }
}
