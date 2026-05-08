import java.util.*;
import java.math.*;

class Solution {
    
    private final int[] dys = {0, 0, -1, 1}, dxs = {-1, 1, 0, 0};
    private int n, m;
    private boolean[][] visited;
    
    public int[] solution(String[] maps) {
        
        this.n = maps.length;
        this.m = maps[0].length();
        visited = new boolean[n][m];
        
        boolean flag = false; 
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    continue;
                }
                char ch = maps[i].charAt(j);
                if (Character.isDigit(ch) ) {
                    flag = true;
                    int result = bfs(i, j, maps);
                    results.add(result);
                }
            }
        }
        
        if (!flag) {
            return new int[] {-1};
        } 
        
        int[] answer = new int[results.size()];
        Collections.sort(results);
        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }
        
        return answer;
    }
    
    private int bfs(int y, int x, String[] maps) {
        
        Deque<int []> dq = new ArrayDeque<>();
        dq.offer(new int[] {y, x});
        visited[y][x] = true;
        
        int count = maps[y].charAt(x) - '0';
        while (!dq.isEmpty()) {
            
            int[] cur = dq.poll();
            int cy = cur[0];
            int cx = cur[1];
            
            for (int d = 0; d < 4; d++) {
                int ny = cy + dys[d];
                int nx = cx + dxs[d];
                
                if (inRange(ny, nx) && !visited[ny][nx] && Character.isDigit(maps[ny].charAt(nx))) {
                    visited[ny][nx] = true;
                    count += maps[ny].charAt(nx) - '0';
                    dq.offer(new int[] {ny, nx});
                }
            }
        }
        
        return count;
    }
    
    private boolean inRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}