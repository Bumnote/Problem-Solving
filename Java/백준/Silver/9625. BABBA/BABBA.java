import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static final int MAX = 45;
    static int[][] dp = new int[MAX + 1][2];

    public static void main(String[] args) throws IOException {

        int k = Integer.parseInt(br.readLine());
        // dp 초기화
        dp[0][0] = 1;
        dp[0][1] = 0;

        for (int i = 1; i <= MAX; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }

        System.out.printf("%d %d\n", dp[k][0], dp[k][1]);
    }
}