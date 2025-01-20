import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) times[times.length - 1] * (long) n;
        
        while (left <= right) {
            
            long mid = (left + right) / 2;
            long sum = 0;
            
            for (int i = 0; i < times.length; i++) {
                sum += (mid / times[i]);
                
                if (sum >= n)
                    break;
            }
            
            if (sum >= n) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else 
                left = mid + 1;
        }
        
        
        return answer;
    }
}