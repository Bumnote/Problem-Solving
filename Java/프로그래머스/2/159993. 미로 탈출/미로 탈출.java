import java.util.*;

class Solution {
    
    private int n, m;
    private int sy, sx;
    private int ly, lx;
    private int ey, ex;
    private final int[] dys = {0, 0, -1, 1}, dxs = {-1, 1, 0, 0};
    
    public int solution(String[] maps) {
        
        this.n = maps.length;
        this.m = maps[0].length();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = maps[i].charAt(j);
                if (ch == 'S') {
                    this.sy = i;
                    this.sx = j;
                } else if (ch == 'E') {
                    this.ey = i;
                    this.ex = j;
                } else if (ch == 'L') {
                    this.ly = i;
                    this.lx = j;
                }
            }
        }
        
        boolean[][][] visited = new boolean[n][m][2];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {sy, sx, 0, 0});
        visited[sy][sx][0] = true;
        
        int answer = -1;
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int cy = curr[0];
            int cx = curr[1];
            int dist = curr[2];
            int isKey = curr[3];
            if (maps[cy].charAt(cx) == 'L') {
                isKey = 1;
            }
            
            if (cy == ey && cx == ex && isKey == 1) {
                answer = dist;
                break;
            }
            
            for (int d = 0; d < 4; d++) {
                int ny = cy + dys[d];
                int nx = cx + dxs[d];
                
                if (inRange(ny, nx) && !visited[ny][nx][isKey] && maps[ny].charAt(nx) != 'X') {
                    visited[ny][nx][isKey] = true;
                    dq.offer(new int[] {ny, nx, dist + 1, isKey});
                }
            }
        }
        
        return answer;
    }
    
    private boolean inRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}