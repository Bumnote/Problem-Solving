import java.util.*;

class Solution {
    
    class Edge {

        int y;
        int x;
        int cnt;

        Edge(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
    
    private final Deque<Edge> dq = new ArrayDeque<>();
    private final int[] dys = {-1, 1, 0, 0};
    private final int[] dxs = {0, 0, -1, 1};
    private final int WALL = 0;
    private int n, m;
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    private int bfs(int[][] maps) {
                
        n = maps.length;
        m = maps[0].length;
        
        System.out.printf("n = %d / m = %d\n", n, m);
        
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        dq.offer(new Edge(0, 0, 1));
        
        while (!dq.isEmpty()) {
            
            Edge curr = dq.poll();
            if (curr.y == n - 1 && curr.x == m - 1) {
                return curr.cnt;
            }
            
            for (int i = 0; i < 4; i++) {
                int nxtY = curr.y + dys[i];
                int nxtX = curr.x + dxs[i];
                
                if (inRange(nxtY, nxtX) && !visited[nxtY][nxtX] && maps[nxtY][nxtX] != WALL) {
                    visited[nxtY][nxtX] = true;
                    dq.offer(new Edge(nxtY, nxtX, curr.cnt + 1));                    
                }
            }
        }
        
        return -1;
    }
    
    private boolean inRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}