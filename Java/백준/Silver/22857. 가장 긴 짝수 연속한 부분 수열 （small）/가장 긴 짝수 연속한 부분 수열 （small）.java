import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, k;
  private static boolean[] arr;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new boolean[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      arr[i] = num % 2 == 0;
    }

    br.close();
  }

  private static void solve() {
    int left = 0;
    int right = 0;
    int count = 0;
    int maxLength = 0;
    while (right < n) {
      // 오른쪽이 짝수인 경우 -> right++
      if (arr[right]) {
        right++;
      }
      // 오른쪽이 홀수인 경우 -> 삭제 여부 판단
      else {
        // 홀수를 삭제할 수 있는 경우
        if (count < k) {
          count++;
          right++;
        }
        // 홀수를 삭제할 수 없는 경우
        else {
          // 왼쪽이 짝수인 경우
          if (arr[left]) {
            left++;
          }
          // 왼쪽이 홀수인 경우
          else {
            count--;
            left++;
          }
        }
      }

      maxLength = Math.max(maxLength, right - left - count);
    }

    System.out.print(maxLength);
  }
}