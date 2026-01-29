import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void solve() {

    List<Integer> numbers = new ArrayList<>();
    List<int[]> dp = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (numbers.isEmpty() || numbers.get(numbers.size() - 1) < arr[i]) {
        numbers.add(arr[i]);
        dp.add(new int[]{numbers.size() - 1, arr[i]});
      } else {
        int idx = binarySearch(numbers, arr[i]);
        numbers.set(idx, arr[i]);
        dp.add(new int[]{idx, arr[i]});
      }
    }

    int lisSize = numbers.size();
    sb.append(lisSize).append("\n");

    Deque<Integer> dq = new ArrayDeque<>();
    for (int i = dp.size() - 1; i >= 0; i--) {
      if (dp.get(i)[0] == lisSize - 1) {
        dq.offerFirst(dp.get(i)[1]);
        lisSize--;
      }
    }

    while (!dq.isEmpty()) {
      sb.append(dq.pollFirst()).append(" ");
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