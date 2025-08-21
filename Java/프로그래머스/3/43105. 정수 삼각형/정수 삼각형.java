import java.math.*;

class Solution {
    
    private int[][] dp; 
    private int N; 
    
    public int solution(int[][] triangle) {
    
        init(triangle);
        
        for (int i = 2; i < N; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }
        
        
        int MAX = 0;
        for (int i = 0; i < N; i++) {
            MAX = Math.max(MAX, dp[N - 1][i]);
        }
        
        return MAX;
    }
    
    private void init(int[][] triangle) {
        N = triangle.length;
        dp = new int[N][N];
        
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }
    }
}