import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int n;
        n = Integer.parseInt(br.readLine());

        int[][] MAP = new int[n][n];
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1)
                    break;

                int k = MAP[i][j];
                // 오른쪽으로 이동 가능한 경우
                if (j + k < n) {
                    dp[i][j + k] += dp[i][j];
                }

                // 아래로 이동 가능한 경우
                if (i + k < n) {
                    dp[i + k][j] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}