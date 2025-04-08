import java.io.*;
import java.util.*;

class Solution {


  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int T, N;
  static int[] arr, dp;

  public static void main(String[] args) throws IOException {

    T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      init();
      solve(tc);
    }

    System.out.println(sb);
    br.close();
  }

  private static void init() throws IOException {

    N = Integer.parseInt(br.readLine());

    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

  }

  private static void solve(int tc) {

    dp = new int[N];
    int maxLength = 1;

    // 모든 요소의 LIS 길이를 1로 초기화
    for (int i = 0; i < N; i++) {
      dp[i] = 1;
    }

    // 각 요소에 대해 이전 요소들과 비교하여 LIS 길이 갱신
    for (int i = 1; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      maxLength = Math.max(maxLength, dp[i]);
    }

    sb.append("#").append(tc).append(" ").append(maxLength).append("\n");
  }
}
