import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n; // 1 ≤ n ≤ 2_000
  private static int[] numbers; // |numbers[i]| ≤ 1_000_000_000

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    n = Integer.parseInt(br.readLine());
    numbers = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
  }

  private static void solve() {

    Arrays.sort(numbers);

    int goodNumCount = 0;
    for (int i = 0; i < n; i++) {
      int targetNum = numbers[i];
      int left = 0;
      int right = n - 1;
      while (left < right) {
        if (numbers[left] + numbers[right] == targetNum) {
          if (left == i) {
            left++;
          } else if (right == i) {
            right--;
          } else {
            goodNumCount++;
            break;
          }
        } else if (numbers[left] + numbers[right] > targetNum) {
          right--;
        } else {
          left++;
        }
      }
    }

    System.out.print(goodNumCount);
  }
}