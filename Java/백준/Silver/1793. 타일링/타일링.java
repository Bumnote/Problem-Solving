import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int MAX = 250;

    public static void main(String[] args) throws IOException {

        BigInteger[] dp = new BigInteger[MAX + 1];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        dp[2] = new BigInteger("3");

        // dp 점화식: d[i] = 2 * dp[i - 2] + dp[i - 1]
        for (int i = 3; i <= MAX; i++)
            dp[i] = dp[i - 2].multiply(BigInteger.valueOf(2)).add(dp[i - 1]);

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            N = Integer.parseInt(line);
            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb.toString());
        br.close();
    }

}
