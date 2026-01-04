import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static final int[][] numbers = new int[5][5];
  private static final int[] dys = {-1, 1, 0, 0}, dxs = {0, 0, -1, 1};
  private static final Set<Integer> set = new HashSet<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    for (int i = 0; i < 5; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        numbers[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    br.close();
  }

  private static void solve() throws IOException {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        dfs(i, j, new ArrayList<>());
      }
    }

    System.out.print(set.size());
  }

  private static void dfs(int i, int j, ArrayList<Integer> lst) {
    lst.add(numbers[i][j]);
    if (lst.size() == 6) {
      int num = 0;
      for (int n : lst) {
        num = num * 10 + n;
      }
      set.add(num);
      return;
    }

    for (int d = 0; d < 4; d++) {
      int ny = i + dys[d];
      int nx = j + dxs[d];
      if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5) {
        continue;
      }
      dfs(ny, nx, new ArrayList<>(lst));
    }
  }
}
