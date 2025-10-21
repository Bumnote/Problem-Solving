import java.io.*;
import java.util.*;

class Main {

  private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer st;
  private static int n;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void solve() {

    int maxCount = 0;

    for (int i = 0; i < n; i++) {
      int leftCount = 0;
      int rightCount = 0;
      // 왼쪽 검색
      double leftSlope = -1_000_000_000;
      for (int j = i - 1; j >= 0; j--) {
        double currentSlope = (double) (arr[j] - arr[i]) / (i - j);
        if (currentSlope > leftSlope) {
          leftSlope = currentSlope;
          leftCount++;
        }
      }

      // 오른쪽 검색
      double rightSlope = -1_000_000_000;
      for (int j = i + 1; j < n; j++) {
        double currentSlope = (double) (arr[j] - arr[i]) / (j - i);
        if (currentSlope > rightSlope) {
          rightSlope = currentSlope;
          rightCount++;
        }
      }

      maxCount = Math.max(maxCount, leftCount + rightCount);
    }

    System.out.print(maxCount);
  }
}