import java.util.*;

class Solution {
    
    private final Deque<Integer> dq = new ArrayDeque<>();
    private final Map<Integer, Integer> cache = new HashMap<>();
    
    public long solution(int[] numbers, int target) {
        
        dq.offer(numbers[0]);
        dq.offer(-numbers[0]);
        
        for (int i = 1; i < numbers.length; i++) {
            int size = dq.size();
            for (int j = 0; j < size; j++) {
                int currNumber = dq.poll();
                
                dq.offer(currNumber + numbers[i]);
                dq.offer(currNumber - numbers[i]);
            }
        }
        
        for (Integer result : dq) {
            cache.put(result, cache.getOrDefault(result, 0) + 1);
        }
    
        return cache.getOrDefault(target, 0); 
    }
}