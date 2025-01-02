import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] L;
    static int[] J;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        L = new int[N + 1];
        J = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            L[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            J[i] = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][101];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < 100; j++) {
                int weight = L[i];
                int value = J[i];
                if (j < weight)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
            }
        }

        System.out.println(dp[N][99]);
    }
}