import java.math.*;
import java.util.*;

class Solution {
    
    private long answer; 
    private final PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    
    public long solution(int n, int[] works) {

        for (int work : works) {
            pq.add(work);
        }
        
        while (n-- > 0) {
            pq.add(Math.max(pq.poll() - 1, 0));
        }
        
        answer = 0;
        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}