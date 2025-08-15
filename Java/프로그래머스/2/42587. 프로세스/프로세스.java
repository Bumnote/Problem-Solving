import java.util.*;

class Solution {
    
    private final Deque<Integer> dq = new ArrayDeque<>();
    private final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    private final Map<Integer, Integer> cache = new HashMap<>();
    
    public int solution(int[] priorities, int location) {

        for (int i = 0; i < priorities.length; i++) {
            cache.put(i, priorities[i]);
            dq.offer(i);
            pq.offer(priorities[i]);
        }
        
        int ans = 0; 
        while (!pq.isEmpty()) {
            int highestPrior = pq.poll();
            while (true) {
                int idx = dq.poll();
                int prior = cache.get(idx);
                if (prior == highestPrior) {
                    ans++;
                    if (location == idx) {
                        return ans; 
                    } else {
                        cache.remove(idx);
                        break;
                    }
                } else {
                    dq.offer(idx);
                }
            }
        }
        
        return ans; 
    }
}