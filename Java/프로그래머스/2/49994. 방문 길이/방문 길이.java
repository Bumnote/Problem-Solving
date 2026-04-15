import java.util.*;

class Solution {
    
    private final int[] dys = {-1, 0, 1, 0}, dxs = {0, 1, 0, -1};
    
    public int solution(String dirs) {
        
        int cy = 5;
        int cx = 5; 
        boolean[][][] visited = new boolean[11][11][4];
        int answer = 0; 
        for (char ch : dirs.toCharArray()) {
            int d; 
            if (ch == 'U') d = 0;
            else if (ch == 'R') d = 1;
            else if (ch == 'D') d = 2;
            else d = 3;
            
            int ny = cy + dys[d];
            int nx = cx + dxs[d];
            
            if (!inRange(ny, nx)) {
                continue;
            }
            
            if (!visited[ny][nx][d]) {
                visited[ny][nx][d] = true;
                visited[cy][cx][(d + 2) % 4] = true;
                answer++;
            }
            cy = ny;
            cx = nx;
        }
        
        return answer;
    }
    
    private boolean inRange(int y, int x) {
        return 0 <= y && y <= 10 && 0 <= x && x <= 10;
    }
}