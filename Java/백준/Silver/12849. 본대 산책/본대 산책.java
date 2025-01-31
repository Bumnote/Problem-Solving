import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int D;
    static int MOD = 1_000_000_007;
    static ArrayList<ArrayList<Integer>> vertex = new ArrayList<>();
    static long[] dp, tmp;

    public static void main(String[] args) {

        setUp();

        solve();

    }

    private static void solve() {

        dp = new long[9];
        tmp = new long[9];

        dp[1] = 1; // dp 초기화
        for (int i = 0; i < D; i++) {
            tmp[1] = dp[2] + dp[3];
            tmp[2] = dp[1] + dp[3] + dp[4];
            tmp[3] = dp[1] + dp[2] + dp[4] + dp[5];
            tmp[4] = dp[2] + dp[3] + dp[5] + dp[6];
            tmp[5] = dp[3] + dp[4] + dp[6] + dp[7];
            tmp[6] = dp[4] + dp[5] + dp[8];
            tmp[7] = dp[5] + dp[8];
            tmp[8] = dp[6] + dp[7];

            for (int j = 1; j <= 8; j++)
                dp[j] = tmp[j] % MOD;
        }

        System.out.println(dp[1]);
    }

    private static void setUp() {
        D = sc.nextInt();
    }
}

