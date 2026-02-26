import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[][] arr;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    arr = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void solve() {
    int[] prefixSum = new int[n];
    for (int i = 1; i < n; i++) {
      int dist = getManhattanDistance(arr[i - 1], arr[i]);
      prefixSum[i] = prefixSum[i - 1] + dist;
    }

    int answer = (int) 1e9;
    for (int i = 1; i < n - 1; i++) {
      int targetDist = getManhattanDistance(arr[i - 1], arr[i + 1]);
      int distWithoutTarget = prefixSum[i - 1] + targetDist + (prefixSum[n - 1] - prefixSum[i + 1]);
      answer = Math.min(answer, distWithoutTarget);
    }

    System.out.print(answer);
  }

  private static int getManhattanDistance(int[] p1, int[] p2) {
    return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
  }
}