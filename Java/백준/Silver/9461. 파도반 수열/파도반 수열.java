import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T, N;
    static final int MAX = 100;
    static long[] dp = new long[MAX + 1];

    public static void main(String[] args) throws IOException {

        setUp();

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());
            sb.append(dp[N - 1]).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void setUp() {

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        for (int i = 5; i <= MAX; i++) {
            dp[i] = dp[i - 5] + dp[i - 4] + dp[i - 3];
        }

    }
}
