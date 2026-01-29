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

  public static void solve() {

    List<Integer> numbers = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (numbers.isEmpty() || numbers.get(numbers.size() - 1) < arr[i]) {
        numbers.add(arr[i]);
      } else {
        int idx = binarySearch(numbers, arr[i]);
        numbers.set(idx, arr[i]);
      }
    }

    System.out.print(numbers.size());
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