import java.util.*;

class Solution {
    
    final int MAX = 1_000_000;
    public int solution(int x, int y, int n) {
        
        Deque<int []> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX + 1];
        
        
        dq.offer(new int[] {x, 0});
        visited[x] = true;
        while (!dq.isEmpty()) {
            
            int[] curr = dq.poll();
            int num = curr[0];
            int count = curr[1];
            
            if (num == y) {
                return count;
            }
            
            int nxt;
            nxt = num + n;
            if (nxt <= MAX && !visited[nxt])  {
                visited[nxt] = true;
                dq.offer(new int[] {nxt, count + 1});
            }
            
            for (int i = 2; i <= 3; i++) {
                nxt = num * i;
                if (nxt <= MAX && !visited[nxt]) {
                    visited[nxt] = true;
                    dq.offer(new int[] {nxt, count + 1});
                }
            }   
        }
        
        return -1;
    }
}