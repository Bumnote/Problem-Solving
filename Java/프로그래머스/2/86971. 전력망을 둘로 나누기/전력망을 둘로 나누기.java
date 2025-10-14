import java.math.*;
import java.util.*;

class Solution {
    
    private List<List<Integer>> tree;
    private boolean[] visited;
    private int LEN; 
    
    public int solution(int n, int[][] wires) {
    
        int diff = 1_000;
        LEN = wires.length;
        for (int i = 0; i < LEN; i++) {
            
            tree = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                tree.add(new ArrayList<>());
            }
            
            for (int j = 0; j < LEN; j++) {
                if (i == j) {
                    continue;
                }
                
                int v1 = wires[j][0];
                int v2 = wires[j][1];
                
                tree.get(v1).add(v2);
                tree.get(v2).add(v1);
            }
            
            diff = Math.min(diff, calculateDiff());
        }
        
        return diff;
    }
    
    private int calculateDiff() {
        
        int NODE_COUNT = tree.size();
        List<Integer> lst = new ArrayList<>();
        visited = new boolean[NODE_COUNT];
        
        for (int i = 1; i < NODE_COUNT; i++) {
            // 방문하지 않은 경우 -> 방문 
            if (!visited[i]) {
                int count = bfs(i);
                lst.add(count);
            }
        }
        
        return Math.abs(lst.get(0) - lst.get(1)); 
    }
    
    private int bfs(int start) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        visited[start] = true; // 방문 처리
        dq.offer(start);
        
        int count = 1; 
        while(!dq.isEmpty()) {
            
            int curr = dq.poll();
            
            for (Integer nxt : tree.get(curr)) {
                // 방문하지 않았다면 -> 방문 
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    dq.offer(nxt);
                    count++;
                }
            }
        }
        
        return count;
    }
}