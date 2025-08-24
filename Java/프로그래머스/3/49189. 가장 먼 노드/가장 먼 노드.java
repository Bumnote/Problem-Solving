import java.util.*;

class Solution {
    
    private final List<List<Integer>> vertex = new ArrayList<>();
    private final int start = 1;
    private int[] edgeCounts;
    
    public int solution(int n, int[][] edge) {

        init(n, edge);
        
        bfs(n);
        
        return getMaximumEdgeCount();
    }
    
    private void init(int size, int[][] edges) {
        
        for (int i = 0; i <= size; i++) {
            vertex.add(new ArrayList<Integer>());
        }
        
        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];   
            vertex.get(s).add(e);
            vertex.get(e).add(s);
        }
    }
    
    private void bfs(int size) {
    
        edgeCounts = new int[size + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(start);
        
        boolean[] visited = new boolean[size + 1];
        visited[start] = true; // 방문 처리
        
        while (!dq.isEmpty()) {
            
            int curr = dq.poll();
            
            for (Integer nxt : vertex.get(curr)) {
                if (!visited[nxt]) {
                    visited[nxt] = true; // 방문 처리 
                    edgeCounts[nxt] = edgeCounts[curr] + 1;
                    dq.offer(nxt);
                }
            }
        }
    }
    
    private int getMaximumEdgeCount() {
        int count = 0;
        int MAX = 0;
        for (int edgeCount : edgeCounts) {
            if (MAX < edgeCount) {
                MAX = edgeCount;
                count = 1;
            } else if (MAX == edgeCount) {
                count++;
            }
        }
        
        return count;
    }
}