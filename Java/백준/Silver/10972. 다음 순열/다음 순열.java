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

    if (nextPermutation(arr)) {
      for (int num : arr) {
        sb.append(num).append(" ");
      }
    } else {
      sb.append(-1);
    }

    System.out.print(sb);
  }

  private static boolean nextPermutation(int[] nums) {

    int i = n - 1;
    while (i > 0 && nums[i - 1] >= nums[i]) {
      i--;
    }

    if (i == 0) {
      return false;
    }

    int j = n - 1;
    while (nums[i - 1] >= nums[j]) {
      j--;
    }

    swap(nums, i - 1, j);

    int k = n - 1;
    while (i < k) {
      swap(nums, i, k);
      i++;
      k--;
    }

    return true;
  }

  private static void swap(int[] nums, int a, int b) {
    int tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }
}