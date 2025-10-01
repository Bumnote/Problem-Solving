import java.math.*;
import java.util.*;

class Solution {
    
    private int LEN;
    private final Deque<Integer> dq = new ArrayDeque<>();
    private final Deque<Integer> tmp = new ArrayDeque<>();
    
    public int solution(int[] order) {
        
        LEN = order.length;
        for (int i = 1; i <= LEN; i++) {
            dq.offer(i);
        }
        
        int idx = 0; 
        while (idx < LEN) {
            int num = order[idx];
            // 순서가 맞는 경우 
            if (!dq.isEmpty() && num == dq.peekFirst()) {
                dq.pollFirst();
                idx++;
            } 
            // 순서가 틀린 경우 
            else {
                // tmp가 비어있지 않고, 마지막 원소와 같은 경우 
                if (!tmp.isEmpty() && num == tmp.peekLast()) {
                    tmp.pollLast();
                    idx++;
                } else {
                    if (dq.isEmpty()) {
                        break;
                    }
                    tmp.offer(dq.pollFirst());
                }
            }
        }
        
        return idx; 
    }
}