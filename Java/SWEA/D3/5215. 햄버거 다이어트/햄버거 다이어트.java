import java.io.*;
import java.util.*;

class Solution {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int T, N, L;
  static int[] score, kcal;
  static int[] dp;

  public static void main(String[] args) throws IOException {

    T = Integer.parseInt(br.readLine()); // T: 테스트 케이스
    for (int tc = 1; tc <= T; tc++) {
      init();
      solve(tc);
    }
    // 정답 출력
    System.out.println(sb);
    br.close();
  }

  private static void init() throws IOException {

    // 입력 부분
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // N: 재료의 수
    L = Integer.parseInt(st.nextToken()); // L: 제한 칼로리

    score = new int[N + 1];
    kcal = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      score[i] = Integer.parseInt(st.nextToken()); // score[]: 맛에 대한 점수
      kcal[i] = Integer.parseInt(st.nextToken()); // kcal[]: 칼로리
    }

    // dp 초기화
    dp = new int[L + 1];
  }

  private static void solve(int tc) {

    for (int i = 1; i <= N; i++) {
      for (int j = L; j >= 0; j--) {
        if (j >= kcal[i]) {
          dp[j] = Math.max(dp[j], dp[j - kcal[i]] + score[i]);
        }
      }
    }

    sb.append("#").append(tc).append(" ").append(dp[L]).append("\n");
  }
}