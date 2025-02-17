import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T, N;
    static long[][] dp;

    public static void main(String[] args) throws IOException {

        setUp();

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }

        // 입력 종료 및 출력
        br.close();
        System.out.println(sb.toString());
    }

    private static void setUp() {

        dp = new long[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i < 41; i++) {
            dp[i][0] = dp[i - 2][0] + dp[i - 1][0];
            dp[i][1] = dp[i - 2][1] + dp[i - 1][1];
        }
    }
}