import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        Deque<Long> dq1 = new ArrayDeque<>();
        Deque<Long> dq2 = new ArrayDeque<>();
        
        long total = 0;
        long left = 0;
        long right = 0; 
        for (int num : queue1) {
            dq1.offer((long) num);
            total += num;
            left += num;
        }
        
        for (int num : queue2) {
            dq2.offer((long) num);
            total += num;
            right += num;
        }
        
        int count = 0;
        int executeCount = 0;
        while (left != right) {
            
            if (left < right) {
                Long num = dq2.poll();
                dq1.offer(num);
                left += num;
                right -= num;
            } else if (left > right) {
                Long num = dq1.poll();
                dq2.offer(num);
                left -= num;
                right += num;
            }
            
            count++;
            executeCount++;
            
            if (dq1.isEmpty() || dq2.isEmpty() || executeCount > 2 * 300_000) {
                count = -1;
                break;
            }
        }
        
        return count;
    }
}