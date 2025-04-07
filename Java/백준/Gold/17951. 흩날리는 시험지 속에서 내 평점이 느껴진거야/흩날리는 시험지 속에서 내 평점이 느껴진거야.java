import java.io.*;
import java.util.*;

public class Main {

  static int N, K, MIN;
  static int[] x;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // N: 시험지의 개수
    K = Integer.parseInt(st.nextToken()); // K: 나눌 그릅의 수

    x = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      x[i] = Integer.parseInt(st.nextToken()); // x[]: 각 시험지마다 맞은 문제 개수
    }

    br.close();
  }

  private static void solve() {

    int left = 0;
    int right = 100_000 * 20;
    int ans = 0;

    while (left <= right) {
      int mid = (left + right) / 2; // 각 그룹당 가능한 최소 점수
      int group = getGroupCnt(mid);

      // 그룹의 개수가 K개 이하인 경우 -> 점수를 낮춘다.
      if (group < K) {
        right = mid - 1;
      }
      // 그룹의 개수가 K개 초과한 경우 -> 점수를 높인다.
      else {
        left = mid + 1;
        if (group == K) {
          ans = mid;
        }
      }
    }

    System.out.print(ans);
  }

  private static int getGroupCnt(int score) {

    int sum = 0;
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      sum += x[i];
      if (sum >= score) {
        sum = 0;
        cnt++;
      }
    }

    return cnt;
  }
}