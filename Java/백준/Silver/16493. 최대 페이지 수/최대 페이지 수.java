import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] days;
    static int[] pages;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        days = new int[M + 1];
        pages = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            pages[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                int day = days[i];
                int page = pages[i];
                dp[i][j] = (j < day) ? dp[i - 1][j] : Math.max(dp[i - 1][j], dp[i - 1][j - day] + page);
            }
        }

        System.out.println(dp[M][N]);
    }
}