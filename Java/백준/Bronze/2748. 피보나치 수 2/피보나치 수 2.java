import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static final int MAX = 100;
    static int n;
    static long[] dp = new long[MAX];

    public static void main(String[] args) {

        n = sc.nextInt();
        dp[1] = 1;
        for (int i = 2; i < MAX; i++)
            dp[i] = dp[i - 2] + dp[i - 1];

        System.out.println(dp[n]);
    }
}

