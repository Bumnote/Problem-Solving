import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static final int MAX = 100_000;
    static final int INF = Integer.MAX_VALUE;
    static int[] dp = new int[MAX + 1];

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= MAX; i++) {
            dp[i] = INF;
        }

        // dp 초기화
        dp[0] = 0;
        dp[2] = 1;
        dp[5] = 1;

        for (int i = 3; i <= MAX; i++) {
            if (i < 5) {
                if (dp[i - 2] != INF)
                    dp[i] = dp[i - 2] + 1;
            } else {
                dp[i] = Math.min(dp[i - 2], dp[i - 5]);
                if (dp[i] != INF)
                    dp[i]++;
            }
        }

        System.out.println(dp[n] != INF ? dp[n] : -1);
    }
}