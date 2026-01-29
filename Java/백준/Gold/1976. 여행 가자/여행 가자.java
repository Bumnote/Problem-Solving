import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m;
  private static int[] arr, parent, rank;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    rank = new int[n + 1];
    parent = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
      rank[i] = 1;
    }

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        int isConnected = Integer.parseInt(st.nextToken());
        if (isConnected == 1 && find(i) != find(j)) {
          union(i, j);
        }
      }
    }

    arr = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  public static void solve() {

    for (int i = 1; i < m; i++) {
      // 두 도시가 연결되어 있지 않다면 -> 여행 불가능
      if (find(arr[i - 1]) != find(arr[i])) {
        System.out.print("NO");
        return;
      }
    }

    System.out.print("YES");
  }

  private static void union(int x, int y) {

    int xRoot = find(x);
    int yRoot = find(y);

    if (xRoot == yRoot) {
      return;
    }

    if (rank[xRoot] > rank[yRoot]) {
      parent[yRoot] = xRoot;
    } else if (rank[xRoot] < rank[yRoot]) {
      parent[xRoot] = yRoot;
    } else {
      parent[yRoot] = xRoot;
      rank[xRoot]++;
    }
  }

  private static int find(int x) {
    if (parent[x] != x) {
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }
}