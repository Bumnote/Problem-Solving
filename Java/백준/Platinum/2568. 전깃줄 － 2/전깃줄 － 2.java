import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[][] lines;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());

    lines = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      lines[i][0] = Integer.parseInt(st.nextToken());
      lines[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void solve() {

    Arrays.sort(lines, (a, b) -> Integer.compare(a[1], b[1]));

    List<Integer> numbers = new ArrayList<>();
    List<int[]> lis = new ArrayList<>(); // [index, value]
    TreeSet<Integer> treeSet = new TreeSet<>();

    for (int i = 0; i < n; i++) {
      int value = lines[i][0];
      if (numbers.isEmpty() || numbers.get(numbers.size() - 1) < value) {
        numbers.add(value);
        lis.add(new int[]{numbers.size() - 1, value});
      } else {
        int idx = binarySearch(numbers, value);
        numbers.set(idx, value);
        lis.add(new int[]{idx, value});
      }
    }

    sb.append(n - numbers.size()).append("\n");

    int lisSize = numbers.size() - 1;
    for (int i = lis.size() - 1; i >= 0; i--) {
      if (lis.get(i)[0] == lisSize) {
        lisSize--;
      } else {
        treeSet.add(lis.get(i)[1]);
      }
    }

    for (Integer removeLineNumber : treeSet) {
      sb.append(removeLineNumber).append("\n");
    }

    System.out.print(sb);
  }

  private static int binarySearch(List<Integer> numbers, int target) {
    int left = 0;
    int right = numbers.size() - 1;

    int idx = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (numbers.get(mid) >= target) {
        idx = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return idx;
  }
}