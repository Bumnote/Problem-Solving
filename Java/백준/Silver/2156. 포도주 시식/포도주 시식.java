import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int n;
  private static int[] arr;
  private static int[][] dp;


  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    n = Integer.parseInt(br.readLine());
    dp = new int[n + 1][3];
    arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static void solve() throws IOException {

    for (int i = 1; i <= n; i++) {
      dp[i][0] = Arrays.stream(dp[i - 1]).max().getAsInt();
      dp[i][1] = Math.max(dp[i - 1][0] + arr[i - 1], dp[i - 1][1]);
      dp[i][2] = Math.max(dp[i - 1][1] + arr[i - 1], dp[i - 1][2]);
    }

    int answer = Arrays.stream(dp[n]).max().getAsInt();
    System.out.print(answer);
  }
}