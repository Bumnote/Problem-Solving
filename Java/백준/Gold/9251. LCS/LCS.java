import java.io.*;
import java.util.*;

public class Main {
    
    static int n, m;
    static int[][] dp;
    static String str1, str2;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        str1 = br.readLine();
        str2 = br.readLine();

        n = str1.length();
        m = str2.length();
        
        dp = new int[n + 1][m + 1]; // DP 테이블

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) { 
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[n][m]); // LCS 길이 출력 
        br.close();
    }
}
