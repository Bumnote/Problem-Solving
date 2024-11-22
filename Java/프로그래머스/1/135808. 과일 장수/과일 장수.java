import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        
        int ans = 0, cnt = 0;
        
        Arrays.sort(score);
        for (int i = score.length - m; i >= 0; i -= m)
            ans += (score[i] * m) ;
        
        return ans; 
    }
}